#! /bin/bash
# This script is used to load data for the crontab
# This script will relate to the history_loader.sh script


BASE_LOCATION=$(pwd)
DATA_LOCATION="/home/shanghuang"
FOLDER_FORMAT="SMM_STO_*"
MEDICINE_FOLDER_FORMAT="MO"
DISPLAY_ENV="DISPLAY=:0"
CRONFILE="/tmp/today_crontab.txt"

# cd to the folder with the format SMM_STO_
for folder in $(ls $DATA_LOCATION); do
    # Check if the folder matches the format SMM_STO_*
    if [[ $folder == $FOLDER_FORMAT ]]; then
        # Load the main folder
        MAIN_FOLDER="$DATA_LOCATION/$folder"
        MO_SUB_FOLDER="$MAIN_FOLDER/$MEDICINE_FOLDER_FORMAT"
        
        # json parsing stage
        for json in $MO_SUB_FOLDER/*.json; 
        do
            # get name and note from the json file
            TEN_THUOC=$(jq -r '.TenThuoc' "$json")
            GHI_CHU=$(jq -r '.GhiChu' "$json")
            TAN_SUAT_CHUNG=$(jq -r '.TanSuatChung' "$json")
            DSTAN_SUAT_CU_THE=$(jq -c '.DSTanSuatCuThe' "$json")    

            # looping through the time list
            jq -c '.DSMocThoiGian[]' "$json" | while read -r moc; do
                # add condition to check for the moc is used every day, or day in week, or day in month match

                # get the time and am/pm from the moc
                GIO=$(echo "$moc" | jq '.[0]')
                PHUT=$(echo "$moc" | jq '.[1]')
                AMPM=$(echo "$moc" | jq -r '.[2]')
                LIEU=$(echo "$moc" | jq '.[3]')

                #convert to 24-hour format
                GIO24=$GIO
                if [[ "$AMPM" == "PM" && $GIO -ne 12 ]]; then
                    GIO24=$((GIO + 12))
                elif [[ "$AMPM" == "AM" && $GIO -eq 12 ]]; then
                    GIO24=0
                fi

                add_entry=false
                if [[ "$TAN_SUAT_CHUNG" == "Mỗi ngày" ]]; then
                    add_entry=true
                elif [[ "$TAN_SUAT_CHUNG" == "Ngày trong tuần" ]]; then
                    # Lấy thứ hiện tại (1=Monday, 7=Sunday)
                    current_weekday=$(date +%u)+1
                    # Kiểm tra nếu DSTanSuatCuThe chứa thứ hiện tại
                    if echo "$DSTAN_SUAT_CU_THE" | jq ". | index($current_weekday)" | grep -qv null; then
                        add_entry=true
                    fi
                elif [[ "$TAN_SUAT_CHUNG" == "Ngày trong tháng" ]]; then
                    # Lấy ngày trong tháng hiện tại
                    current_day=$(date +%-d)
                    if echo "$DSTAN_SUAT_CU_THE" | jq ". | index($current_day)" | grep -qv null; then
                        add_entry=true
                    fi
                fi

                # create the crontab entry
                if $add_entry; then
                    notify_text="$GIO:$PHUT $AMPM - $TEN_THUOC ($lieu viên): $GHI_CHU"
                    cron_entry="$GIO24 $PHUT * * * $DISPLAY_ENV /bin/bash $BASE_LOCATION/src/main/java/cacdanhdaden/javamainproject/history_loader.sh \"$TEN_THUOC\" \"$GIO\" \"$PHUT\" \"$AMPM\" \"$LIEU\" \"$GHI_CHU\" \"$folder\""
                    echo "$cron_entry" >> "$CRONFILE"
                fi
            done
        done
    fi
done

crontab -r 
crontab "$CRONFILE"


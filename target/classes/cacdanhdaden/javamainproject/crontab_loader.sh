#! /bin/bash
# This script is used to load data for the crontab
# This script will relate to the history_loader.sh script


BASE_LOCATION=$(pwd)
DATA_LOCATION="/home/shanghuang"
FOLDER_FORMAT="SMM_STO_*"
MEDICINE_FOLDER_FORMAT="MO"
DISPLAY_ENV="DISPLAY=:0"
CRONFILE="/tmp/today_crontab.txt"
> "$CRONFILE"
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
                elif [[ "$TAN_SUAT_CHUNG" == "Khi cần thiết" ]]; then
                    add_entry=false
                fi

                # Check to remove any entry that passed the current time
                current_time=$(date +%H:%M)
                entry_time=$(printf "%02d:%02d" "$GIO24" "$PHUT")
                if [[ "$GIO24" -lt $(date +%H) || ( "$GIO24" -eq $(date +%H) && "$PHUT" -lt $(date +%M) ) ]]; then
                    add_entry=false
                    
                    # check if tan suat chung is "Khi cần thiết" and if so not add into the crontab and skip the history_loader.sh
                    if [[ "$TAN_SUAT_CHUNG" == "Khi cần thiết" ]]; then
                        add_entry=false
                    else 
                        /bin/bash /home/shanghuang/Documents/Study\ Vault/Subject\ Documentation/IS216/Practice\ documentations/Code\ Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/history_loader.sh "$TEN_THUOC" "$GIO" "$PHUT" "$AMPM" "$LIEU" "$GHI_CHU" "$folder" skip
                    fi
                fi

                # create the crontab entry
                if $add_entry; then
                    cron_entry="$PHUT $GIO24 * * * $DISPLAY_ENV /bin/bash \"/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/history_loader.sh\" \"$TEN_THUOC\" \"$GIO\" \"$PHUT\" \"$AMPM\" \"$LIEU\" \"$GHI_CHU\" \"$folder\""
                    echo "$cron_entry" >> "$CRONFILE"
                fi
            done
        done
    fi
done

# Lưu crontab hiện tại (nếu có) và lọc bỏ các dòng liên quan đến history_loader.sh
crontab -l 2>/dev/null | grep -v history_loader.sh | grep -v today_crontab_tag > /tmp/old_cron.txt

# Thêm lại dòng tự động chạy crontab_loader.sh mỗi ngày (nếu chưa có)
if ! grep -q "crontab_loader.sh" /tmp/old_cron.txt; then
    echo "@reboot /bin/bash \"/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/crontab_loader.sh\"" >> /tmp/old_cron.txt
    echo "0 0 * * * /bin/bash \"/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/crontab_loader.sh\"" >> /tmp/old_cron.txt
fi

# Thêm các dòng thông báo thuốc mới
cat "$CRONFILE" >> /tmp/old_cron.txt

cat /tmp/old_cron.txt
# Nạp lại crontab
crontab /tmp/old_cron.txt
rm /tmp/old_cron.txt
crontab -l 

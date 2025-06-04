#! /bin/bash
# This script is used to load data for the crontab
# This script will relate to the history_loader.sh script

# algorithm
# 1. load require param to enter the json
# 2. add flag to check final condition of passing item into crontab
# 3. add condition to check the generic freq - grfq
    # 3.1 if grfq = everyday -> flag = true
    # 3.2 if grfq = selected in week
        # 3.2.1 if selected -> flag = true
        # 3.2.2 if not -> flag = false
    # 3.3 if grfq = selected in month
        # 3.3.1 if selected -> flag = true
        # 3.3.2 if not -> flag = false
    # 3.4 if grfq = when necessary -> flag = false
# 4. add condition to check the data time - dati
    # 4.1 if flag = false -> skip
    # 4.2 if flag = true -> add condition to check the data time - dati
        # 4.2.1 if dati after the current time -> flag = true
        # 4.2.2 if dati before the current time -> add condition to check for item in the notify_log
            # 4.2.2.1 if item with same name, same day and skip status -> skip
            # 4.2.2.2 if not -> add item with skip status into notify_log
# 5. add condition to allow set data into crontab 
    # 5.1 if flag = false -> skip
    # 5.2 if flag = true -> load into crontab
# 6. return to the 1.

# Add variable for convenience
BASE_LOCATION=$(pwd)
DATA_LOCATION="/home/shanghuang"
FOLDER_FORMAT="SMM_STO_*"
MEDICINE_FOLDER_FORMAT="MO"
HISTORY_FOLDER_FORMAT="30HO"
DISPLAY_ENV="DISPLAY=:0"
CRONFILE="/tmp/today_crontab.txt"

# Remove the old cron file if it exists
> "$CRONFILE"

# Create notify_log file if it does not exist

# cd to parent folder of folder that matches format SMM_STO_*
for folder in $(ls $DATA_LOCATION); do
    # Check if the folder matches the format SMM_STO_*
    if [[ $folder == $FOLDER_FORMAT ]]; then
        # Add variable for convenience
        MAIN_FOLDER="$DATA_LOCATION/$folder"
        MO_SUB_FOLDER="$MAIN_FOLDER/$MEDICINE_FOLDER_FORMAT"
        HISTORY_FILE="$MAIN_FOLDER/$HISTORY_FOLDER_FORMAT/notify_log.json"

        # Check if the notify_log file exists, if not create it
        if [[ ! -f "$HISTORY_FILE" ]]; then
            echo "[]" > "$HISTORY_FILE"
        fi
        
        # Loop through all json files in the MO_SUB_FOLDER
        for json in $MO_SUB_FOLDER/*.json; 
        do
            # Get name and note from the json file
            TEN_THUOC=$(jq -r '.TenThuoc' "$json")
            GHI_CHU=$(jq -r '.GhiChu' "$json")
            TAN_SUAT_CHUNG=$(jq -r '.TanSuatChung' "$json")
            DSTAN_SUAT_CU_THE=$(jq -c '.DSTanSuatCuThe' "$json")    

            # Looping through the time list
            jq -c '.DSMocThoiGian[]' "$json" | while read -r moc; do

                # Get the time and am/pm from the current moc variable
                GIO=$(echo "$moc" | jq '.[0]')
                PHUT=$(echo "$moc" | jq '.[1]')
                AMPM=$(echo "$moc" | jq -r '.[2]')
                LIEU=$(echo "$moc" | jq '.[3]')

                # Convert to 24-hour format for easier comparison
                GIO24=$GIO
                if [[ "$AMPM" == "PM" && $GIO -ne 12 ]]; then
                    GIO24=$((GIO + 12))
                elif [[ "$AMPM" == "AM" && $GIO -eq 12 ]]; then
                    GIO24=0
                fi

                # Add flag variable to check if the entry should be added to crontab at the end
                add_entry=false
                if [[ "$TAN_SUAT_CHUNG" == "Mỗi ngày" ]]; then
                    add_entry=true
                elif [[ "$TAN_SUAT_CHUNG" == "Ngày trong tuần" ]]; then
                    current_weekday=$(date +%u)+1
                    if echo "$DSTAN_SUAT_CU_THE" | jq ". | index($current_weekday)" | grep -qv null; then
                        add_entry=true
                    fi
                elif [[ "$TAN_SUAT_CHUNG" == "Ngày trong tháng" ]]; then
                    current_day=$(date +%-d)
                    if echo "$DSTAN_SUAT_CU_THE" | jq ". | index($current_day)" | grep -qv null; then
                        add_entry=true
                    fi
                elif [[ "$TAN_SUAT_CHUNG" == "Khi cần thiết" ]]; then
                    add_entry=false
                fi

                # If the entry is not to be added, skip the rest of the loop
                if ! $add_entry; then
                    continue
                else 
                # If the entry is to be added, check the time
                    current_time=$(date +%H:%M)
                    entry_time=$(printf "%02d:%02d" "$GIO24" "$PHUT")
                    # If the entry time is after the current time, set add_entry to true
                    if [[ "$GIO24" -gt $(date +%H) || ( "$GIO24" -eq $(date +%H) && "$PHUT" -ge $(date +%M) ) ]]; then
                        add_entry=true
                    else
                    # If the entry time is before the current time, check if the entry is already in the notify_log
                        # If the entry is already in the notify_log, continue to the next iteration
                        # The condition to check is on the name, day (only get yyyy-MM-dd), and skip status
                        if jq --arg ten_thuoc "$TEN_THUOC" \
                            --arg entry_time "$(date +%Y-%m-%d)" \
                            --arg status "skip" \
                            '. | map(select(.TenThuoc == $ten_thuoc and (.MocThoiGian | startswith($entry_time)) and .TrangThai == $status)) | length > 0' \
                            "$HISTORY_FILE"; then
                            add_entry=false
                        else
                            /bin/bash "/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/history_loader.sh" "$TEN_THUOC" "$GIO" "$PHUT" "$AMPM" "$LIEU" "$GHI_CHU" "$folder" "skip"
                        fi
                    fi
                fi

                # If the flag is true, prepare to add the entry to crontab
                if $add_entry; then
                    cron_entry="$PHUT $GIO24 * * * $DISPLAY_ENV /bin/bash \"/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/history_loader.sh\" \"$TEN_THUOC\" \"$GIO\" \"$PHUT\" \"$AMPM\" \"$LIEU\" \"$GHI_CHU\" \"$folder\""
                    echo "$cron_entry" >> "$CRONFILE"
                else 
                    # If the flag is false, skip adding to crontab
                    continue
                fi
            done
        done
    fi
done

# Remove the old crontab entries related to history_loader.sh and today_crontab_tag
crontab -l 2>/dev/null | grep -v history_loader.sh | grep -v today_crontab_tag > /tmp/old_cron.txt

# Check if crontab_loader.sh is already in the old cron file, if not, add it
if ! grep -q "crontab_loader.sh" /tmp/old_cron.txt; then
    echo "@reboot /bin/bash \"/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/crontab_loader.sh\"" >> /tmp/old_cron.txt
    echo "0 0 * * * /bin/bash \"/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/javamainproject/crontab_loader.sh\"" >> /tmp/old_cron.txt
fi

# Append the new cron entries to the old cron file
cat "$CRONFILE" >> /tmp/old_cron.txt

cat /tmp/old_cron.txt
# Load the new cron file into crontab
crontab /tmp/old_cron.txt
rm /tmp/old_cron.txt
crontab -l 

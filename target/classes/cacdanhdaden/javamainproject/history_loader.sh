#! /bin/bash

#! /bin/bash
# filepath: /home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/cacdanhdaden/history_loader.sh

THUOC="$1"
GIO="$2"
PHUT="$3"
AMPM="$4"
LIEU="$5"
GHI_CHU="$6"
SAVE_FOLDER=""
LOGFILE="/home/shanghuang/$7/30HO/notify_log.json"

zenity --question \
  --width=400 \
  --height=200 \
  --title="Nhắc uống thuốc" \
  --ok-label="Xác nhận" \
  --cancel-label="Bỏ qua" \
  --text="$GIO:$PHUT $AMPM\n$THUOC ($LIEU viên)\n$GHI_CHU"

if [ $? -eq 0 ]; then
    STATUS="confirm"
else
    STATUS="skip"
fi

TIMESTAMP=$(date +"%Y-%m-%d %H:%M:%S")

# Kiểm tra nếu file log không tồn tại thì tạo mới
if [ ! -f "$LOGFILE" ]; then
    echo "[]" > "$LOGFILE"
fi

# Ghi log dạng JSON (append)
jq --arg TenThuoc "$THUOC" \
   --arg MocThoiGian "$GIO:$PHUT $AMPM" \
   --arg LieuSuDung "$LIEU" \
   --arg TrangThai "$STATUS" \
   --arg GhiChu "$GHI_CHU" \
   --arg ThoiGian "$TIMESTAMP" \
   '. += [{"TenThuoc":$TenThuoc,"MocThoiGian":$MocThoiGian,"LieuSuDung":$LieuSuDung,"TrangThai":$TrangThai,"GhiChu":$GhiChu,"ThoiGian":$ThoiGian}]' \
   "$LOGFILE" > "${LOGFILE}.tmp" && mv "${LOGFILE}.tmp" "$LOGFILE"

# Lọc lại log chỉ giữ các bản ghi trong 30 ngày gần nhất
CUTOFF_DATE=$(date -d "30 days ago" +"%Y-%m-%d %H:%M:%S")
jq --arg cutoff "$CUTOFF_DATE" '
  map(select(.ThoiGian >= $cutoff))
' "$LOGFILE" > "${LOGFILE}.tmp" && mv "${LOGFILE}.tmp" "$LOGFILE"

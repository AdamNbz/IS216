/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shanghuang
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortExample {

    // (Giữ nguyên class ThoiGianSuDung như đã định nghĩa ở câu trả lời trước)
    public static class ThoiGianSuDung implements Comparable<ThoiGianSuDung> {
        private int gio;       // H (Giờ)
        private int phut;      // M (Phút)
        private String amPm;   // AM/PM
        private double lieuSuDung; // LSD (Liều sử dụng)
        private String tenThuoc;   // Tên thuốc
        private String ghiChu;     // Ghi chú

        public ThoiGianSuDung(int gio, int phut, String amPm, double lieuSuDung, String tenThuoc, String ghiChu) {
            this.gio = gio;
            this.phut = phut;
            this.amPm = amPm;
            this.lieuSuDung = lieuSuDung;
            this.tenThuoc = tenThuoc;
            this.ghiChu = ghiChu;
        }

        public int getGio() {
            return gio;
        }

        public int getPhut() {
            return phut;
        }

        public String getAmPm() {
            return amPm;
        }

        public double getLieuSuDung() {
            return lieuSuDung;
        }

        public String getTenThuoc() {
            return tenThuoc;
        }

        public String getGhiChu() {
            return ghiChu;
        }

        @Override
        public String toString() {
            return "ThoiGianSuDung{" +
                    "gio=" + gio +
                    ", phut=" + phut +
                    ", amPm='" + amPm + '\'' +
                    ", lieuSuDung=" + lieuSuDung +
                    ", tenThuoc='" + tenThuoc + '\'' +
                    ", ghiChu='" + ghiChu + '\'' +
                    '}';
        }

        @Override
        public int compareTo(ThoiGianSuDung other) {
            // Chuyển đổi giờ sang định dạng 24 tiếng
            int thisHour24 = convertTo24Hour(this.gio, this.amPm);
            int otherHour24 = convertTo24Hour(other.gio, other.amPm);

            // So sánh giờ
            int hourComparison = Integer.compare(thisHour24, otherHour24);
            if (hourComparison != 0) {
                return hourComparison;
            }

            // Nếu giờ giống nhau, so sánh phút
            return Integer.compare(this.phut, other.phut);
        }


        // Hàm chuyển đổi giờ từ định dạng 12 tiếng sang 24 tiếng
        private int convertTo24Hour(int hour, String amPm) {
            if (amPm.equals("PM") && hour != 12) {
                return hour + 12;
            } else if (amPm.equals("AM") && hour == 12) {
                return 0; // 12 AM là 0 giờ trong định dạng 24 tiếng
            } else {
                return hour;
            }
        }
		
		public String getTimeString() {
            return String.format("%d:%02d %s", gio, phut, amPm);
        }
    }



    public static void main(String[] args) {
        // 1. Tạo List<ThoiGianSuDung>
        List<ThoiGianSuDung> danhSachThoiGian = new ArrayList<>();

        // 2. Thêm các đối tượng ThoiGianSuDung vào List
        danhSachThoiGian.add(new ThoiGianSuDung(1, 0, "PM", 1.0, "Thuốc A", "Uống sau ăn"));
        danhSachThoiGian.add(new ThoiGianSuDung(8, 0, "AM", 1.0, "Thuốc B", "Uống trước ăn"));
        danhSachThoiGian.add(new ThoiGianSuDung(12, 30, "PM", 0.5, "Thuốc C", "Uống khi đói"));
        danhSachThoiGian.add(new ThoiGianSuDung(7, 15, "PM", 2.0, "Thuốc D", "Uống trước khi ngủ"));
        danhSachThoiGian.add(new ThoiGianSuDung(7, 0, "AM", 2.0, "Thuốc D", "Uống trước khi ngủ"));
        danhSachThoiGian.add(new ThoiGianSuDung(7, 0, "AM", 2.0, "Thuốc E", "Uống trước khi ngủ"));
        danhSachThoiGian.add(new ThoiGianSuDung(8, 0, "PM", 1.5, "Thuốc F", "Uống sau ăn no"));

        // 3. Sắp xếp List
        Collections.sort(danhSachThoiGian);

        // 4. In ra List đã sắp xếp (tùy chọn)
        System.out.println("Danh sách sau khi sắp xếp:");
        for (ThoiGianSuDung thoiGian : danhSachThoiGian) {
            System.out.println(thoiGian);
        }
		
		// 4. Nhóm các thuốc theo mốc thời gian
        Map<String, List<ThoiGianSuDung>> timeToThuoc = new LinkedHashMap<>();
        for (ThoiGianSuDung thoiGian : danhSachThoiGian) {
            String time = thoiGian.getTimeString();
            timeToThuoc.computeIfAbsent(time, k -> new ArrayList<>()).add(thoiGian);
        }

        // 5. In ra các mốc thời gian và danh sách thuốc tương ứng
        System.out.println("Các mốc thời gian và danh sách thuốc:");
        for (Map.Entry<String, List<ThoiGianSuDung>> entry : timeToThuoc.entrySet()) {
            String time = entry.getKey();
            List<ThoiGianSuDung> thuocList = entry.getValue();

            System.out.println(time + ":");
            for (ThoiGianSuDung thuoc : thuocList) {
                System.out.println("  - " + thuoc.getTenThuoc() + " (" + thuoc.getLieuSuDung() + ")"); // In tên thuốc và liều dùng
            }
        }
    }
}

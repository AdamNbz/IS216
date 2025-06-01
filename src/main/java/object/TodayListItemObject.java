/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author shanghuang
 */
public class TodayListItemObject implements Comparable<TodayListItemObject> {
	private int gio;       // H (Giờ)
	private int phut;      // M (Phút)
	private String amPm;   // AM/PM
	private int lieuSuDung; // LSD (Liều sử dụng)
	private String tenThuoc;   // Tên thuốc
	private String ghiChu;     // Ghi chú

	public TodayListItemObject(
		int gio, 
		int phut, 
		String amPm, 
		int lieuSuDung, 
		String tenThuoc, 
		String ghiChu
	) {
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

	public int getLieuSuDung() {
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
		return "TodayListItem (" +
				"gio=" + gio +
				", phut=" + phut +
				", amPm='" + amPm + '\'' +
				", lieuSuDung=" + lieuSuDung +
				", tenThuoc='" + tenThuoc + '\'' +
				", ghiChu='" + ghiChu + '\'' +
				')';
	}

	@Override
	public int compareTo(TodayListItemObject other) {
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

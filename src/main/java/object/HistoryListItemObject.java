/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author shanghuang
 */
public class HistoryListItemObject {
	private String tenThuoc, mocThoiGian, lieuSuDung, trangThai, ghiChu, thoiGian;

	public HistoryListItemObject() {
		this.tenThuoc = "";
		this.mocThoiGian = "";
		this.lieuSuDung = "";
		this.trangThai = "";
		this.ghiChu = "";
		this.thoiGian = "";
	}

	public HistoryListItemObject(String tenThuoc, String mocThoiGian, String lieuSuDung, String trangThai, String ghiChu, String thoiGian) {
		this.tenThuoc = tenThuoc;
		this.mocThoiGian = mocThoiGian;
		this.lieuSuDung = lieuSuDung;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
		this.thoiGian = thoiGian;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public String getMocThoiGian() {
		return mocThoiGian;
	}

	public void setMocThoiGian(String mocThoiGian) {
		this.mocThoiGian = mocThoiGian;
	}

	public String getLieuSuDung() {
		return lieuSuDung;
	}

	public void setLieuSuDung(String lieuSuDung) {
		this.lieuSuDung = lieuSuDung;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	
	
}

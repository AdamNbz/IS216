/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.*;
import java.io.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author shanghuang
 */
public class MedicineObject {
	private String TenThuoc, DonVi, GhiChu, TanSuatChung, TanSuatCuThe;
	private int SLHienCo, SLNhacNho;
	private List<List<Object>> DSMocThoiGian; 
	private List<Object> DSTanSuatCuThe;
	
	public MedicineObject() {
		this.TenThuoc = null;
		this.DonVi = null;
		this.GhiChu = null;
		this.TanSuatChung = null;
		this.TanSuatCuThe = null;
		this.SLHienCo = 1;
		this.SLNhacNho = 1;
		this.DSMocThoiGian = new ArrayList<>(0);
		this.DSTanSuatCuThe = new ArrayList<>(0);
	}

	public MedicineObject(
		String TenThuoc, String DonVi, String GhiChu, String TanSuatChung, String TanSuatCuThe, 
		int SLHienCo, int SLNhacNho, 
		List<List<Object>> DSMocThoiGian
	) {
		this.TenThuoc = TenThuoc;
		this.DonVi = DonVi;
		this.GhiChu = GhiChu;
		this.TanSuatChung = TanSuatChung;
		this.TanSuatCuThe = TanSuatCuThe;
		this.SLHienCo = SLHienCo;
		this.SLNhacNho = SLNhacNho;
		this.DSMocThoiGian = DSMocThoiGian;
		this.DSTanSuatCuThe = parseSpecificFrequency(this.TanSuatCuThe);
	}

	public String getTenThuoc() {
		return TenThuoc;
	}

	public void setTenThuoc(String TenThuoc) {
		this.TenThuoc = TenThuoc;
	}

	public String getDonVi() {
		return DonVi;
	}

	public void setDonVi(String DonVi) {
		this.DonVi = DonVi;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String GhiChu) {
		this.GhiChu = GhiChu;
	}

	public String getTanSuatChung() {
		return TanSuatChung;
	}

	public void setTanSuatChung(String TanSuatChung) {
		this.TanSuatChung = TanSuatChung;
	}

	public String getTanSuatCuThe() {
		return TanSuatCuThe;
	}

	public void setTanSuatCuThe(String TanSuatCuThe) {
		this.TanSuatCuThe = TanSuatCuThe;
	}

	public int getSLHienCo() {
		return SLHienCo;
	}

	public void setSLHienCo(int SLHienCo) {
		this.SLHienCo = SLHienCo;
	}

	public int getSLNhacNho() {
		return SLNhacNho;
	}

	public void setSLNhacNho(int SLNhacNho) {
		this.SLNhacNho = SLNhacNho;
	}

	public List<List<Object>> getDSMocThoiGian() {
		return DSMocThoiGian;
	}

	public void setDSMocThoiGian(List<List<Object>> DSMocThoiGian) {
		this.DSMocThoiGian = DSMocThoiGian;
	}

	public List<Object> getDSTanSuatCuThe() {
		return DSTanSuatCuThe;
	}

	public void setDSTanSuatCuThe(List<Object> DSTanSuatCuThe) {
		this.DSTanSuatCuThe = DSTanSuatCuThe;
	}
	
	public void writeJSON(String UserName) {
		JSONObject jo = new JSONObject();
		jo.put("TenThuoc", this.TenThuoc);
		jo.put("DonVi", this.DonVi);
		jo.put("GhiChu", this.GhiChu);
		jo.put("TanSuatChung", this.TanSuatChung);
		jo.put("TanSuatCuThe", this.TanSuatCuThe);
		jo.put("SLHienCo", this.SLHienCo);
		jo.put("SLNhacNho", this.SLNhacNho);
		jo.put("DSMocThoiGian", this.DSMocThoiGian);
		jo.put("DSTanSuatCuThe", this.DSTanSuatCuThe);
		
		String filePath = "/home/shanghuang/SMM_STO_" + UserName + "/MO/MO_" + this.TenThuoc + ".json";
		try {
			// Kiểm tra xem file có tồn tại hay không
            File file = new File(filePath);
            if (!file.exists()) {
                // Tạo file nếu nó không tồn tại
                file.createNewFile();
                System.out.println("File mới đã được tạo: " + filePath);
            }

            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(jo.toJSONString());
            fileWriter.close();
            System.out.println("Đã ghi dữ liệu vào file: " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readJSON(String filePath) {
		JSONParser jp = new JSONParser();
		try {
			FileReader fr = new FileReader(filePath);
			JSONObject jo = (JSONObject) jp.parse(fr);
			this.TenThuoc = (String) jo.get("TenThuoc");
			this.DonVi = (String) jo.get("DonVi");
			this.GhiChu = (String) jo.get("GhiChu");
			this.TanSuatChung = (String) jo.get("TanSuatChung");
			this.TanSuatCuThe = (String) jo.get("TanSuatCuThe");
			this.SLHienCo = Integer.parseInt(String.valueOf(jo.get("SLHienCo")));
			this.SLNhacNho = Integer.parseInt(String.valueOf(jo.get("SLNhacNho")));
			this.DSMocThoiGian = (List<List<Object>>) jo.get("DSMocThoiGian");
			this.DSTanSuatCuThe = parseSpecificFrequency(this.TanSuatCuThe);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
	
	private List<Object> parseSpecificFrequency(String TanSuatCuThe) {
		List<Object> ls = new ArrayList<>();
		if (TanSuatCuThe == null) {
			
		} else {
			String[] num = TanSuatCuThe.split(",");
			ls = new ArrayList<>();

			for (String i: num) {
				try {
					int n = Integer.parseInt(i.trim());
					ls.add(n);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				}
			}
		}
		
		return ls;
	}
	
	public List<Object> parseSpecificFrequencyPublic(String TanSuatCuThe) {
		String[] num = TanSuatCuThe.split(",");
		List<Object> ls = new ArrayList<>();
		
		if (TanSuatCuThe == null) {
			
		} else {
			for (String i: num) {
				try {
					int n = Integer.parseInt(i.trim());
					ls.add(n);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
				}
			}
		}
		return ls;
	}
	
	public void print() {
		System.out.println(this.TenThuoc);
		System.out.println(this.DonVi);
		System.out.println(this.GhiChu);
		System.out.println(this.TanSuatChung);
		System.out.println(this.TanSuatCuThe);
		System.out.println(this.SLHienCo);
		System.out.println(this.SLNhacNho);
		System.out.println("---");
		for (List<Object> ll: this.DSMocThoiGian) {
			for (Object o: ll) {
				System.out.println(o + " ");
			}
			System.out.println();
		}
		System.out.println("---");
		for (Object o: this.DSTanSuatCuThe) {
			System.out.println(o);
		}
	}
	
	public void refill(int SL) {
		this.SLHienCo += SL;
	}
}

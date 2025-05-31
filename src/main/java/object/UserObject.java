/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author shanghuang
 */
public class UserObject {
	private String IdenName, UserName, Email, KVucSinhSong, TienSuBenhLy;
	private int Tuoi;

	public UserObject() {
		this.IdenName = "";
		this.UserName = "";
		this.Email = "";
		this.KVucSinhSong = "";
		this.TienSuBenhLy = "";
		this.Tuoi = 15;
	}

	public UserObject(String IdenName, String UserName, String Email, String KVucSinhSong, String TienSuBenhLy, int Tuoi) {
		this.IdenName = IdenName;
		this.UserName = UserName;
		this.Email = Email;
		this.KVucSinhSong = KVucSinhSong;
		this.TienSuBenhLy = TienSuBenhLy;
		this.Tuoi = Tuoi;
	}

	public String getIdenName() {
		return IdenName;
	}

	public void setIdenName(String IdenName) {
		this.IdenName = IdenName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getKVucSinhSong() {
		return KVucSinhSong;
	}

	public void setKVucSinhSong(String KVucSinhSong) {
		this.KVucSinhSong = KVucSinhSong;
	}

	public String getTienSuBenhLy() {
		return TienSuBenhLy;
	}

	public void setTienSuBenhLy(String TienSuBenhLy) {
		this.TienSuBenhLy = TienSuBenhLy;
	}

	public int getTuoi() {
		return Tuoi;
	}

	public void setTuoi(int Tuoi) {
		this.Tuoi = Tuoi;
	}
	
	public void writeJSON() {
		JSONObject jo = new JSONObject();
		jo.put("IdenName", this.IdenName);
		jo.put("UserName", this.UserName);
		jo.put("Email", this.Email);
		jo.put("KVucSinhSong", this.KVucSinhSong);
		jo.put("TienSuBenhLy", this.TienSuBenhLy);
		jo.put("Tuoi", this.Tuoi);
		
		String filePath = "/home/shanghuang/SMM_STO_" + this.IdenName + "/UO/UserObject.json";
		
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
			this.IdenName = (String) jo.get("IdenName");
			this.UserName = (String) jo.get("UserName");
			this.Email = (String) jo.get("Email");
			this.KVucSinhSong = (String) jo.get("KVucSinhSong");
			this.TienSuBenhLy = (String) jo.get("TienSuBenhLy");
			this.Tuoi = Integer.parseInt(String.valueOf(jo.get("Tuoi")));
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			this.IdenName = "";
			this.UserName = "";
			this.Email = "";
			this.KVucSinhSong = "";
			this.TienSuBenhLy = "";
			this.Tuoi = 15;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
}

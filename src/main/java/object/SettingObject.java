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
import java.util.List;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import userview.MainFrame;

/**
 *
 * @author shanghuang
 */
public class SettingObject {
	private boolean AutoStartUp, AutoClearHistory, NotiOnLowLevel, EnableConfirmButton, EnabelSkipButton;

	public SettingObject() {
		this.AutoStartUp = false;
		this.AutoClearHistory = false;
		this.NotiOnLowLevel = false;
		this.EnableConfirmButton = false;
		this.EnabelSkipButton = false;
	}

	public SettingObject(boolean AutoStartUp, boolean AutoClearHistory, boolean NotiOnLowLevel, boolean EnableConfirmButton, boolean EnabelSkipButton) {
		this.AutoStartUp = AutoStartUp;
		this.AutoClearHistory = AutoClearHistory;
		this.NotiOnLowLevel = NotiOnLowLevel;
		this.EnableConfirmButton = EnableConfirmButton;
		this.EnabelSkipButton = EnabelSkipButton;
	}

	public boolean isAutoStartUp() {
		return AutoStartUp;
	}

	public void setAutoStartUp(boolean AutoStartUp) {
		this.AutoStartUp = AutoStartUp;
	}

	public boolean isAutoClearHistory() {
		return AutoClearHistory;
	}

	public void setAutoClearHistory(boolean AutoClearHistory) {
		this.AutoClearHistory = AutoClearHistory;
	}

	public boolean isNotiOnLowLevel() {
		return NotiOnLowLevel;
	}

	public void setNotiOnLowLevel(boolean NotiOnLowLevel) {
		this.NotiOnLowLevel = NotiOnLowLevel;
	}

	public boolean isEnableConfirmButton() {
		return EnableConfirmButton;
	}

	public void setEnableConfirmButton(boolean EnableConfirmButton) {
		this.EnableConfirmButton = EnableConfirmButton;
	}

	public boolean isEnabelSkipButton() {
		return EnabelSkipButton;
	}

	public void setEnabelSkipButton(boolean EnabelSkipButton) {
		this.EnabelSkipButton = EnabelSkipButton;
	}
	
	public void writeJSON() {
		JSONObject jo = new JSONObject();
		jo.put("AutoStartUp", this.AutoStartUp);
		jo.put("AutoClearHistory", this.AutoClearHistory);
		jo.put("NotiOnLowLevel", this.NotiOnLowLevel);
		jo.put("EnableConfirmButton", this.EnableConfirmButton);
		jo.put("EnabelSkipButton", this.EnabelSkipButton);
		
		String filePath = "/home/shanghuang/SMM_STO_" + MainFrame.UserName + "/SO/SettingObject.json";
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
			this.AutoStartUp = (boolean) jo.get("AutoStartUp");
			this.AutoClearHistory = (boolean) jo.get("AutoClearHistory");
			this.NotiOnLowLevel = (boolean) jo.get("NotiOnLowLevel");
			this.EnableConfirmButton = (boolean) jo.get("EnableConfirmButton");
			this.EnabelSkipButton = (boolean) jo.get("EnabelSkipButton");
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			this.AutoStartUp = false;
			this.AutoClearHistory = false;
			this.NotiOnLowLevel = false;
			this.EnableConfirmButton = false;
			this.EnabelSkipButton = false;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
}

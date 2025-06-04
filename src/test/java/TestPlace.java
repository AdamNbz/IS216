
import elementpanel.InnerHistoryItemPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JPanel;
import object.HistoryListItemObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import static userview.MainFrame.UserName;
import static userview.MainFrame.isAreaGreaterThan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shanghuang
 */
public class TestPlace {
	public static void main(String[] args) {
		String directory = "/home/shanghuang/SMM_STO_tnkl123456/30HO/notify_log.json";
		File file = new File(directory);
		if (!file.exists() || file.length() == 0) {
			System.out.println("Không có lịch sử sử dụng thuốc.");
			return;
		} else {
			try {
				JSONParser parser = new JSONParser();
				JSONArray arr = (JSONArray) parser.parse(new java.io.FileReader(file));
				System.out.println(arr.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

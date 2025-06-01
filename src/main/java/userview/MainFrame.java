/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userview;
import com.formdev.flatlaf.FlatIntelliJLaf;
import elementpanel.InnerTodayItemPanel;
import elementpanel.MedicineItemPanel;
import elementpanel.TodayItemPanel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.UIManager;
import object.MedicineObject;
import object.TodayListItemObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author shanghuang
 */
public class MainFrame extends javax.swing.JFrame {
	public String charset = "<>?/.,:\";'{}|\\[\\]\\\\()!@#$%^&*\\-_+=~`";
	Pattern patt = Pattern.compile("[" + charset + "]");
	public static String UserName = null;
    /**
     * Creates new form MainFrame
     */
	private Dimension DMThuocDimension = new Dimension();
    public MainFrame(String UserName) {
		this.UserName = UserName;
        FlatIntelliJLaf.setup();
		try {
			UIManager.setLookAndFeel( new FlatIntelliJLaf() );
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
		UIManager.put( "Button.arc", 50 );
		UIManager.put( "Component.arc", 50 );
		UIManager.put( "ProgressBar.arc", 50 );
		UIManager.put( "TextComponent.arc", 50 );
		UIManager.put( "TextArea.border", 50 );
		UIManager.put( "ScrollPane.TextComponent.arc", 50 );
        initComponents();
        this.setVisible(true);
        this.setFrameInCenter();
        this.refresh_call();
		this.loadTodayUseList();
    }
    
    public void setFrameInCenter() {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - this.getWidth()) / 2;
        final int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }
	
	public boolean checkIllegalCharacter(String inp, Pattern pat) {
		Matcher match = pat.matcher(inp);
		return match.find();
	}
	
	private void loadTodayUseList() {
		Date NgHienTai = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		LocalDate localDate = NgHienTai.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int dayOfMonth = localDate.getDayOfMonth();
		int dayOfWeekValue = localDate.getDayOfWeek().getValue() + 1;
		
		String directory = "/home/shanghuang/SMM_STO_" + UserName + "/MO";
        File f_dir = new File(directory);
        File[] files = f_dir.listFiles(
            // filter to select only JSON files with name contain "MO_" prefix
            (file) -> file.isFile() &&
            file.getName().endsWith(".json") &&
            file.getName().startsWith("MO_")
        );
		
		MF_KhungNoiDungHomNay_JPanel.removeAll();
        MF_KhungNoiDungHomNay_JPanel.setPreferredSize(DMThuocDimension);
        LayoutManager lmkndhn = MF_KhungNoiDungHomNay_JPanel.getLayout();
        if (lmkndhn instanceof GridLayout) {
            ((GridLayout) lmkndhn).setColumns(1);
            ((GridLayout) lmkndhn).setRows(0);
            MF_KhungNoiDungHomNay_JPanel.setLayout(lmkndhn);
            MF_KhungNoiDungHomNay_JPanel.revalidate();
            MF_KhungNoiDungHomNay_JPanel.repaint();
        }
		List<TodayListItemObject> ltlio = new ArrayList<>();
		
		for (File f: files) {
            MedicineObject mo = new MedicineObject();
            mo.readJSON(f.getPath());
			
			if (mo.getTanSuatChung().contentEquals("Mỗi ngày")) {
				for (List<Object> lo : mo.getDSMocThoiGian()) {
					ltlio.add(
						new TodayListItemObject(
							Integer.parseInt(lo.get(0).toString()),
							Integer.parseInt(lo.get(1).toString()),
							lo.get(2).toString(),
							Integer.parseInt(lo.get(3).toString()),
							mo.getTenThuoc(),
							mo.getGhiChu()
						)
					);
				}
			} else if (mo.getTanSuatChung().contentEquals("Ngày trong tuần")) {
				if (!mo.getDSTanSuatCuThe().isEmpty()) { // thoa man danh sach khong null
					if (mo.getDSTanSuatCuThe().contains(dayOfWeekValue)) {
						for (List<Object> lo : mo.getDSMocThoiGian()) {
							ltlio.add(
								new TodayListItemObject(
									Integer.parseInt(lo.get(0).toString()),
									Integer.parseInt(lo.get(1).toString()),
									lo.get(2).toString(),
									Integer.parseInt(lo.get(3).toString()),
									mo.getTenThuoc(),
									mo.getGhiChu()
								)
							);
						}
					}
				}
			} else if (mo.getTanSuatChung().contentEquals("Ngày trong tháng")) {
				if (!mo.getDSTanSuatCuThe().isEmpty()) { // thoa man danh sach khong null
					if (mo.getDSTanSuatCuThe().contains(dayOfMonth)) {
						for (List<Object> lo : mo.getDSMocThoiGian()) {
							ltlio.add(
								new TodayListItemObject(
									Integer.parseInt(lo.get(0).toString()),
									Integer.parseInt(lo.get(1).toString()),
									lo.get(2).toString(),
									Integer.parseInt(lo.get(3).toString()),
									mo.getTenThuoc(),
									mo.getGhiChu()
								)
							);
						}
					}
				}
			}
        }
		
		Collections.sort(ltlio);
		
		for (TodayListItemObject tlio : ltlio) {
			System.out.println(tlio);
		}
		
		Map<String, List<TodayListItemObject>> msltlio = new LinkedHashMap<>();
		for (TodayListItemObject tlio : ltlio) {
            String time = tlio.getTimeString();
            msltlio.computeIfAbsent(time, k -> new ArrayList<>()).add(tlio);
        }
		
		// 5. In ra các mốc thời gian và danh sách thuốc tương ứng
        System.out.println("Các mốc thời gian và danh sách thuốc:");
        for (Map.Entry<String, List<TodayListItemObject>> entry : msltlio.entrySet()) {
            String time = entry.getKey();
            List<TodayListItemObject> thuocList = entry.getValue();

            System.out.println(time + ":");
            for (TodayListItemObject thuoc : thuocList) {
                System.out.println("  - " + thuoc.getTenThuoc() + " (" + thuoc.getLieuSuDung() + ")"); // In tên thuốc và liều dùng
            }
        }
		
		for (Map.Entry<String, List<TodayListItemObject>> entry : msltlio.entrySet()) {
			TodayItemPanel tip = new TodayItemPanel();
            tip.setData(entry.getKey().toString());
			
			for (TodayListItemObject tlio : entry.getValue()) {
				InnerTodayItemPanel itip = new InnerTodayItemPanel();
				itip.setData(tlio);
				
				// after load data to the inner panel, start add it to the tip panel
				LayoutManager lmtip = tip.getLayout();
				if (lmtip instanceof GridLayout) {
					((GridLayout) lmtip).setColumns(1);
					((GridLayout) lmtip).setRows(((GridLayout) lmtip).getRows() + 1);
					tip.setLayout(lmtip);
					tip.add(itip, -1);
					Dimension d = new Dimension((int) tip.getPreferredSize().getWidth()
						, (int) tip.getPreferredSize().getHeight() +
						(int) itip.getPreferredSize().getHeight() + 10);
					tip.setPreferredSize(d);
					tip.revalidate();
					tip.repaint();
				}				
			}
			
			// then add a cover flow layout panel on all of it for scrolling 
			JPanel Temporal_Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			Dimension d = new Dimension(MF_KhungNoiDungHomNay_JPanel.getPreferredSize());
			d.setSize(
				MF_KhungNoiDungHomNay_JPanel.getPreferredSize().getWidth(),
				MF_KhungNoiDungHomNay_JPanel.getPreferredSize().getHeight() + 10);
			Temporal_Panel.setPreferredSize(d);
			Temporal_Panel.add(MF_KhungNoiDungHomNay_JPanel);
			MF_NoiDungHomNay_JScrollPane.setViewportView(Temporal_Panel);

			MF_NoiDungHomNay_JScrollPane.revalidate();
			MF_NoiDungHomNay_JScrollPane.repaint();
        }
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MF_IntermidiateContainer_JTabbedPane = new javax.swing.JTabbedPane();
        MF_HomNay_JPanel = new javax.swing.JPanel();
        MF_NoiDungHomNay_JScrollPane = new javax.swing.JScrollPane();
        MF_KhungNoiDungHomNay_JPanel = new javax.swing.JPanel();
        MF_ThanhChucNangHomNay_JPanel = new javax.swing.JPanel();
        MF_BoQua_JButton = new javax.swing.JButton();
        MF_SuDung1Lan_JButton = new javax.swing.JButton();
        MF_XacNhan_JButton = new javax.swing.JButton();
        MF_DanhMucThuoc_JPanel = new javax.swing.JPanel();
        MF_NoiDungDanhMucThuoc_JScrollPane = new javax.swing.JScrollPane();
        MF_KhungNoiDungDanhMucThuoc_JPanel = new javax.swing.JPanel();
        MF_ThanhChucNangDanhMucThuoc_JPanel = new javax.swing.JPanel();
        MF_Them_JButton = new javax.swing.JButton();
        MF_TraCuu_JButton = new javax.swing.JButton();
        MF_TraCuu_JTextField = new javax.swing.JTextField();
        MF_LamMoi_JButton = new javax.swing.JButton();
        MF_LichSu_JPanel = new javax.swing.JPanel();
        MF_NoiDungLichSu_JScrollPane = new javax.swing.JScrollPane();
        MF_KhungNoiDungLichSu_JPanel = new javax.swing.JPanel();
        MF_ThanhChucNangLichSu_JPanel = new javax.swing.JPanel();
        MF_TraCuuThuocSuDung_JLabel = new javax.swing.JLabel();
        MF_TraCuuThuocSuDung_JTextField = new javax.swing.JTextField();
        MF_TraCuuThuocSuDung_JButton = new javax.swing.JButton();
        MF_XuatLichSu_JButton = new javax.swing.JButton();
        MF_BaoCaoThoiQuen_JButton = new javax.swing.JButton();
        MF_TraCuuOnline_JPanel = new javax.swing.JPanel();
        MF_JSeparator = new javax.swing.JSeparator();
        MF_ThanhChucNangTraCuuOnline_JPanel = new javax.swing.JPanel();
        MF_TenThuoc_JLabel = new javax.swing.JLabel();
        MF_TraCuuOnline_JTextField = new javax.swing.JTextField();
        MF_PhanLoai_JLabel = new javax.swing.JLabel();
        MF_LoaiTraCuu_JComboBox = new javax.swing.JComboBox<>();
        MF_TraCuuOnline_JButton = new javax.swing.JButton();
        MF_ThongTinTraCuuCoBan_JScrollPane = new javax.swing.JScrollPane();
        MF_ThongTinTraCuuCoBan_JTextArea = new javax.swing.JTextArea();
        MF_Chon_JMenuBar = new javax.swing.JMenuBar();
        MF_CaiDat_VePhanMem_Thoat_JMI_JMenu = new javax.swing.JMenu();
        MF_CaiDat_JMenuItem = new javax.swing.JMenuItem();
        MF_VePhanMem_JMenuItem = new javax.swing.JMenuItem();
        MF_VeCaNhan_JMenuItem = new javax.swing.JMenuItem();
        MF_GuiYKien_JMenuItem = new javax.swing.JMenuItem();
        MF_Thoat_JMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý dược phẩm cá nhân");
        setResizable(false);

        MF_NoiDungHomNay_JScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        MF_NoiDungHomNay_JScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        MF_KhungNoiDungHomNay_JPanel.setLayout(new java.awt.GridLayout(0, 1, 10, 10));
        MF_NoiDungHomNay_JScrollPane.setViewportView(MF_KhungNoiDungHomNay_JPanel);

        MF_ThanhChucNangHomNay_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        MF_BoQua_JButton.setText("Bỏ qua");
        MF_BoQua_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_BoQua_JButtonActionPerformed(evt);
            }
        });
        MF_ThanhChucNangHomNay_JPanel.add(MF_BoQua_JButton);

        MF_SuDung1Lan_JButton.setText("Sử dụng 1 lần");
        MF_SuDung1Lan_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_SuDung1Lan_JButtonActionPerformed(evt);
            }
        });
        MF_ThanhChucNangHomNay_JPanel.add(MF_SuDung1Lan_JButton);

        MF_XacNhan_JButton.setText("Xác nhận");
        MF_ThanhChucNangHomNay_JPanel.add(MF_XacNhan_JButton);

        javax.swing.GroupLayout MF_HomNay_JPanelLayout = new javax.swing.GroupLayout(MF_HomNay_JPanel);
        MF_HomNay_JPanel.setLayout(MF_HomNay_JPanelLayout);
        MF_HomNay_JPanelLayout.setHorizontalGroup(
            MF_HomNay_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MF_HomNay_JPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MF_ThanhChucNangHomNay_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
            .addComponent(MF_NoiDungHomNay_JScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        MF_HomNay_JPanelLayout.setVerticalGroup(
            MF_HomNay_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MF_HomNay_JPanelLayout.createSequentialGroup()
                .addComponent(MF_NoiDungHomNay_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MF_ThanhChucNangHomNay_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        // Code for increase scroll speed
        MF_NoiDungHomNay_JScrollPane.getVerticalScrollBar().setUnitIncrement(20);

        MF_IntermidiateContainer_JTabbedPane.addTab("Hôm nay", MF_HomNay_JPanel);

        MF_NoiDungDanhMucThuoc_JScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        MF_NoiDungDanhMucThuoc_JScrollPane.setToolTipText("");
        MF_NoiDungDanhMucThuoc_JScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        MF_NoiDungDanhMucThuoc_JScrollPane.setMaximumSize(new java.awt.Dimension(1065, 564));
        MF_NoiDungDanhMucThuoc_JScrollPane.setMinimumSize(new java.awt.Dimension(1065, 564));
        MF_NoiDungDanhMucThuoc_JScrollPane.setPreferredSize(new java.awt.Dimension(1065, 564));

        MF_KhungNoiDungDanhMucThuoc_JPanel.setMaximumSize(new java.awt.Dimension(1053, 1054));
        MF_KhungNoiDungDanhMucThuoc_JPanel.setMinimumSize(new java.awt.Dimension(1053, 582));
        MF_KhungNoiDungDanhMucThuoc_JPanel.setPreferredSize(new java.awt.Dimension(1053, 582));
        MF_KhungNoiDungDanhMucThuoc_JPanel.setLayout(new java.awt.GridLayout(0, 1, 10, 10));
        MF_NoiDungDanhMucThuoc_JScrollPane.setViewportView(MF_KhungNoiDungDanhMucThuoc_JPanel);

        MF_ThanhChucNangDanhMucThuoc_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        MF_Them_JButton.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        MF_Them_JButton.setText("Thêm");
        MF_Them_JButton.setMaximumSize(new java.awt.Dimension(80, 30));
        MF_Them_JButton.setMinimumSize(new java.awt.Dimension(80, 30));
        MF_Them_JButton.setPreferredSize(new java.awt.Dimension(80, 30));
        MF_Them_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_Them_JButtonActionPerformed(evt);
            }
        });
        MF_ThanhChucNangDanhMucThuoc_JPanel.add(MF_Them_JButton);

        MF_TraCuu_JButton.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        MF_TraCuu_JButton.setText("Tra cứu");
        MF_TraCuu_JButton.setMaximumSize(new java.awt.Dimension(150, 30));
        MF_TraCuu_JButton.setMinimumSize(new java.awt.Dimension(150, 30));
        MF_TraCuu_JButton.setPreferredSize(new java.awt.Dimension(150, 30));
        MF_TraCuu_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_TraCuu_JButtonActionPerformed(evt);
            }
        });
        MF_ThanhChucNangDanhMucThuoc_JPanel.add(MF_TraCuu_JButton);

        MF_TraCuu_JTextField.setMaximumSize(new java.awt.Dimension(350, 30));
        MF_TraCuu_JTextField.setMinimumSize(new java.awt.Dimension(350, 30));
        MF_TraCuu_JTextField.setPreferredSize(new java.awt.Dimension(350, 30));
        MF_ThanhChucNangDanhMucThuoc_JPanel.add(MF_TraCuu_JTextField);

        MF_LamMoi_JButton.setText("Làm mới");
        MF_LamMoi_JButton.setMaximumSize(new java.awt.Dimension(150, 30));
        MF_LamMoi_JButton.setMinimumSize(new java.awt.Dimension(150, 30));
        MF_LamMoi_JButton.setPreferredSize(new java.awt.Dimension(150, 30));
        MF_LamMoi_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_LamMoi_JButtonActionPerformed(evt);
            }
        });
        MF_ThanhChucNangDanhMucThuoc_JPanel.add(MF_LamMoi_JButton);

        javax.swing.GroupLayout MF_DanhMucThuoc_JPanelLayout = new javax.swing.GroupLayout(MF_DanhMucThuoc_JPanel);
        MF_DanhMucThuoc_JPanel.setLayout(MF_DanhMucThuoc_JPanelLayout);
        MF_DanhMucThuoc_JPanelLayout.setHorizontalGroup(
            MF_DanhMucThuoc_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MF_NoiDungDanhMucThuoc_JScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MF_ThanhChucNangDanhMucThuoc_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MF_DanhMucThuoc_JPanelLayout.setVerticalGroup(
            MF_DanhMucThuoc_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MF_DanhMucThuoc_JPanelLayout.createSequentialGroup()
                .addComponent(MF_NoiDungDanhMucThuoc_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MF_ThanhChucNangDanhMucThuoc_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        // Code for increase scroll speed
        MF_NoiDungDanhMucThuoc_JScrollPane.getVerticalScrollBar().setUnitIncrement(20);

        MF_IntermidiateContainer_JTabbedPane.addTab("Danh mục thuốc", MF_DanhMucThuoc_JPanel);

        MF_NoiDungLichSu_JScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        MF_NoiDungLichSu_JScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        MF_KhungNoiDungLichSu_JPanel.setLayout(new java.awt.GridLayout(1, 1));
        MF_NoiDungLichSu_JScrollPane.setViewportView(MF_KhungNoiDungLichSu_JPanel);

        MF_ThanhChucNangLichSu_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        MF_TraCuuThuocSuDung_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        MF_TraCuuThuocSuDung_JLabel.setText("Tra cứu thuốc đã sử dụng:");
        MF_ThanhChucNangLichSu_JPanel.add(MF_TraCuuThuocSuDung_JLabel);

        MF_TraCuuThuocSuDung_JTextField.setPreferredSize(new java.awt.Dimension(250, 26));
        MF_ThanhChucNangLichSu_JPanel.add(MF_TraCuuThuocSuDung_JTextField);

        MF_TraCuuThuocSuDung_JButton.setText("Tra cứu");
        MF_ThanhChucNangLichSu_JPanel.add(MF_TraCuuThuocSuDung_JButton);

        MF_XuatLichSu_JButton.setText("Xuất lịch sử");
        MF_ThanhChucNangLichSu_JPanel.add(MF_XuatLichSu_JButton);

        MF_BaoCaoThoiQuen_JButton.setText("Báo cáo thói quen");
        MF_ThanhChucNangLichSu_JPanel.add(MF_BaoCaoThoiQuen_JButton);

        javax.swing.GroupLayout MF_LichSu_JPanelLayout = new javax.swing.GroupLayout(MF_LichSu_JPanel);
        MF_LichSu_JPanel.setLayout(MF_LichSu_JPanelLayout);
        MF_LichSu_JPanelLayout.setHorizontalGroup(
            MF_LichSu_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MF_LichSu_JPanelLayout.createSequentialGroup()
                .addGroup(MF_LichSu_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MF_ThanhChucNangLichSu_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MF_NoiDungLichSu_JScrollPane))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MF_LichSu_JPanelLayout.setVerticalGroup(
            MF_LichSu_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MF_LichSu_JPanelLayout.createSequentialGroup()
                .addComponent(MF_NoiDungLichSu_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MF_ThanhChucNangLichSu_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        // Code for increase scroll speed
        MF_NoiDungLichSu_JScrollPane.getVerticalScrollBar().setUnitIncrement(20);

        MF_IntermidiateContainer_JTabbedPane.addTab("Lịch sử", MF_LichSu_JPanel);

        MF_ThanhChucNangTraCuuOnline_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        MF_TenThuoc_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        MF_TenThuoc_JLabel.setText("Tên thuốc:");
        MF_TenThuoc_JLabel.setMaximumSize(new java.awt.Dimension(110, 30));
        MF_TenThuoc_JLabel.setMinimumSize(new java.awt.Dimension(110, 30));
        MF_TenThuoc_JLabel.setPreferredSize(new java.awt.Dimension(110, 30));
        MF_ThanhChucNangTraCuuOnline_JPanel.add(MF_TenThuoc_JLabel);

        MF_TraCuuOnline_JTextField.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        MF_TraCuuOnline_JTextField.setMaximumSize(new java.awt.Dimension(300, 30));
        MF_TraCuuOnline_JTextField.setMinimumSize(new java.awt.Dimension(300, 30));
        MF_TraCuuOnline_JTextField.setPreferredSize(new java.awt.Dimension(300, 30));
        MF_TraCuuOnline_JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_TraCuuOnline_JTextFieldActionPerformed(evt);
            }
        });
        MF_ThanhChucNangTraCuuOnline_JPanel.add(MF_TraCuuOnline_JTextField);

        MF_PhanLoai_JLabel.setText("Phân loại:");
        MF_PhanLoai_JLabel.setMaximumSize(new java.awt.Dimension(110, 30));
        MF_PhanLoai_JLabel.setMinimumSize(new java.awt.Dimension(110, 30));
        MF_PhanLoai_JLabel.setPreferredSize(new java.awt.Dimension(110, 30));
        MF_ThanhChucNangTraCuuOnline_JPanel.add(MF_PhanLoai_JLabel);

        MF_LoaiTraCuu_JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên thuốc", "Hoạt chất" }));
        MF_LoaiTraCuu_JComboBox.setMaximumSize(new java.awt.Dimension(150, 30));
        MF_LoaiTraCuu_JComboBox.setMinimumSize(new java.awt.Dimension(150, 30));
        MF_LoaiTraCuu_JComboBox.setPreferredSize(new java.awt.Dimension(150, 30));
        MF_ThanhChucNangTraCuuOnline_JPanel.add(MF_LoaiTraCuu_JComboBox);

        MF_TraCuuOnline_JButton.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        MF_TraCuuOnline_JButton.setText("Tra cứu");
        MF_TraCuuOnline_JButton.setMaximumSize(new java.awt.Dimension(130, 30));
        MF_TraCuuOnline_JButton.setMinimumSize(new java.awt.Dimension(130, 30));
        MF_TraCuuOnline_JButton.setPreferredSize(new java.awt.Dimension(130, 30));
        MF_TraCuuOnline_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_TraCuuOnline_JButtonActionPerformed(evt);
            }
        });
        MF_ThanhChucNangTraCuuOnline_JPanel.add(MF_TraCuuOnline_JButton);

        MF_ThongTinTraCuuCoBan_JTextArea.setEditable(false);
        MF_ThongTinTraCuuCoBan_JTextArea.setColumns(20);
        MF_ThongTinTraCuuCoBan_JTextArea.setFont(new java.awt.Font("SF Mono SemiBold", 0, 24)); // NOI18N
        MF_ThongTinTraCuuCoBan_JTextArea.setRows(30);
        MF_ThongTinTraCuuCoBan_JTextArea.setToolTipText("Lưu ý rằng thông tin này được lấy từ kết quả tìm kiếm đầu tiên tại drugbank.vn\nThông tin chi tiết về thuốc và nhà cung cấp sản phẩm của thuốc sẽ được hiển thị bằng tệp PDF\nNếu có bất thường gì xảy ra (vd thông tin trên màn hình không hiển thị đầy đủ hoặc trống)\nHãy kiểm tra lại tên thuốc và thực hiện lại, hoặc truy cập trực tiếp drugbank.vn!");
        MF_ThongTinTraCuuCoBan_JTextArea.setMaximumSize(new java.awt.Dimension(1041, 530));
        MF_ThongTinTraCuuCoBan_JTextArea.setMinimumSize(new java.awt.Dimension(1041, 530));
        MF_ThongTinTraCuuCoBan_JScrollPane.setViewportView(MF_ThongTinTraCuuCoBan_JTextArea);

        javax.swing.GroupLayout MF_TraCuuOnline_JPanelLayout = new javax.swing.GroupLayout(MF_TraCuuOnline_JPanel);
        MF_TraCuuOnline_JPanel.setLayout(MF_TraCuuOnline_JPanelLayout);
        MF_TraCuuOnline_JPanelLayout.setHorizontalGroup(
            MF_TraCuuOnline_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MF_TraCuuOnline_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MF_TraCuuOnline_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MF_ThanhChucNangTraCuuOnline_JPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                    .addComponent(MF_JSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MF_ThongTinTraCuuCoBan_JScrollPane, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        MF_TraCuuOnline_JPanelLayout.setVerticalGroup(
            MF_TraCuuOnline_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MF_TraCuuOnline_JPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(MF_ThanhChucNangTraCuuOnline_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MF_JSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MF_ThongTinTraCuuCoBan_JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );

        // Code for increase scroll speed
        MF_ThongTinTraCuuCoBan_JScrollPane.getVerticalScrollBar().setUnitIncrement(20);

        MF_IntermidiateContainer_JTabbedPane.addTab("Tra cứu trực tuyến", MF_TraCuuOnline_JPanel);

        MF_Chon_JMenuBar.setBackground(null);
        MF_Chon_JMenuBar.setForeground(null);
        MF_Chon_JMenuBar.setBorderPainted(false);

        MF_CaiDat_VePhanMem_Thoat_JMI_JMenu.setText("Chọn");

        MF_CaiDat_JMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_COMMA, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MF_CaiDat_JMenuItem.setText("Cài đặt");
        MF_CaiDat_JMenuItem.setToolTipText("");
        MF_CaiDat_JMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_CaiDat_JMenuItemActionPerformed(evt);
            }
        });
        MF_CaiDat_VePhanMem_Thoat_JMI_JMenu.add(MF_CaiDat_JMenuItem);

        MF_VePhanMem_JMenuItem.setText("Về phần mềm");
        MF_CaiDat_VePhanMem_Thoat_JMI_JMenu.add(MF_VePhanMem_JMenuItem);

        MF_VeCaNhan_JMenuItem.setText("Về cá nhân");
        MF_VeCaNhan_JMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_VeCaNhan_JMenuItemActionPerformed(evt);
            }
        });
        MF_CaiDat_VePhanMem_Thoat_JMI_JMenu.add(MF_VeCaNhan_JMenuItem);

        MF_GuiYKien_JMenuItem.setText("Gửi ý kiến");
        MF_GuiYKien_JMenuItem.setToolTipText("");
        MF_GuiYKien_JMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_GuiYKien_JMenuItemActionPerformed(evt);
            }
        });
        MF_CaiDat_VePhanMem_Thoat_JMI_JMenu.add(MF_GuiYKien_JMenuItem);

        MF_Thoat_JMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        MF_Thoat_JMenuItem.setText("Thoát");
        MF_Thoat_JMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MF_Thoat_JMenuItemActionPerformed(evt);
            }
        });
        MF_CaiDat_VePhanMem_Thoat_JMI_JMenu.add(MF_Thoat_JMenuItem);

        MF_Chon_JMenuBar.add(MF_CaiDat_VePhanMem_Thoat_JMI_JMenu);

        setJMenuBar(MF_Chon_JMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MF_IntermidiateContainer_JTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MF_IntermidiateContainer_JTabbedPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MF_Thoat_JMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_Thoat_JMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MF_Thoat_JMenuItemActionPerformed

    private void MF_CaiDat_JMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_CaiDat_JMenuItemActionPerformed
        PreferencesFrame pf = new PreferencesFrame(this);
    }//GEN-LAST:event_MF_CaiDat_JMenuItemActionPerformed

    private void MF_GuiYKien_JMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_GuiYKien_JMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MF_GuiYKien_JMenuItemActionPerformed

    private void MF_TraCuuOnline_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_TraCuuOnline_JButtonActionPerformed
        String TenThuocVariableHolder = MF_TraCuuOnline_JTextField.getText();
        String LoaiTraCuuVariableHolder = MF_LoaiTraCuu_JComboBox.getSelectedItem().toString();

        if (LoaiTraCuuVariableHolder.contentEquals("Tên thuốc")) {
            LoaiTraCuuVariableHolder = "tenThuoc";
        } else {
            LoaiTraCuuVariableHolder = "hoatChat";
        }

        System.out.println(TenThuocVariableHolder);

        String responseBody = new String();
        Map<Object, Object> mp = new HashMap<>();

        MF_ThongTinTraCuuCoBan_JTextArea.selectAll();
        MF_ThongTinTraCuuCoBan_JTextArea.replaceSelection("");

        if (TenThuocVariableHolder.isEmpty() || TenThuocVariableHolder.isBlank()) {
            JOptionPane.showMessageDialog(this, "Không thể tra cứu với tên thuốc rỗng", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (checkIllegalCharacter(TenThuocVariableHolder, patt)) {
            JOptionPane.showMessageDialog(this, "Không cho phép tra cứu với các ký tự đặc biệt", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            TenThuocVariableHolder = TenThuocVariableHolder.replace(" ", "-");
            String apiUrl = "https://drugbank.vn/services/drugbank/api/public/thuoc?page=-1&size=1&"
            + LoaiTraCuuVariableHolder
            + "="
            + TenThuocVariableHolder.toLowerCase()
            + "&sort=rate%2Cdesc&sort="
            + LoaiTraCuuVariableHolder
            + "%2Casc";
            try {
                // Tạo một HttpClient
                HttpClient client = HttpClient.newHttpClient();

                // Tạo một HttpRequest
                HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

                // Gửi request và nhận response
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Kiểm tra status code
                if (response.statusCode() == 200) {
                    responseBody = response.body();
                    System.out.println("Response Body:\n" + responseBody);

                } else {
                    System.err.println("Request failed with status code: " + response.statusCode());
                }

            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }

            mp.put("Mã", parseDataFromJsonString(responseBody, "id"));
            mp.put("Tên thuốc", parseDataFromJsonString(responseBody, "tenThuoc"));
            mp.put("Phân loại", parseDataFromJsonString(responseBody, "phanLoai"));
            mp.put("Nhóm thuốc", parseDataFromJsonString(responseBody, "nhomThuoc"));
            mp.put("Hoạt chất", parseDataFromJsonString(responseBody, "hoatChat"));
            mp.put("Nồng độ", parseDataFromJsonString(responseBody, "nongDo"));
            mp.put("Tá dược", parseDataFromJsonString(responseBody, "taDuoc"));
            mp.put("Bào chế", parseDataFromJsonString(responseBody, "baoChe"));
            mp.put("Tuổi thọ", parseDataFromJsonString(responseBody, "tuoiTho"));
            mp.put("Công ty sản xuất", parseDataFromJsonString(responseBody, "congTySx"));

            mp.forEach(
                (k,v) -> {
                    System.out.println(k + ": " + v);
                    if (v == null) {
                        MF_ThongTinTraCuuCoBan_JTextArea.append(k + ": Không có thông tin\n");
                    } else {
                        MF_ThongTinTraCuuCoBan_JTextArea.append(k + ": " + v + "\n");
                    }
                }
            );

            String fileNameOri = getDownloadFileName(responseBody);
			fileNameOri = fileNameOri.replace(" ", "%20");

            if (fileNameOri.contentEquals("No filename")) {
                System.out.println("No file download");
                JOptionPane.showMessageDialog(this, "Thuốc này chưa cập nhật HDSD trên CSDL. Vui lòng tìm kiếm trực tuyến", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                String downloadURL = "https://cdn.drugbank.vn/" + fileNameOri;

                try {
                    Path downloadFiledPath = downloadFile(downloadURL, TenThuocVariableHolder);
                    if (downloadFiledPath != null) {
                        openFile(downloadFiledPath.toFile());
                    }
                } catch (IOException | InterruptedException ioeie) {
                    ioeie.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_MF_TraCuuOnline_JButtonActionPerformed

    private void MF_TraCuuOnline_JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_TraCuuOnline_JTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MF_TraCuuOnline_JTextFieldActionPerformed

    private void MF_LamMoi_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_LamMoi_JButtonActionPerformed
        String directory = "/home/shanghuang/SMM_STO_" + UserName + "/MO";
        File f_dir = new File(directory);
        File[] files = f_dir.listFiles(
            // filter to select only JSON files with name contain "MO_" prefix
            (file) -> file.isFile() &&
            file.getName().endsWith(".json") &&
            file.getName().startsWith("MO_")
        );

        MF_KhungNoiDungDanhMucThuoc_JPanel.removeAll();
        MF_KhungNoiDungDanhMucThuoc_JPanel.setPreferredSize(DMThuocDimension);
        LayoutManager lm = MF_KhungNoiDungDanhMucThuoc_JPanel.getLayout();
        if (lm instanceof GridLayout) {
            ((GridLayout) lm).setColumns(1);
            ((GridLayout) lm).setRows(0);
            MF_KhungNoiDungDanhMucThuoc_JPanel.setLayout(lm);
            MF_KhungNoiDungDanhMucThuoc_JPanel.revalidate();
            MF_KhungNoiDungDanhMucThuoc_JPanel.repaint();
        }

        for (File f: files) {
            MedicineObject mo = new MedicineObject();
            mo.readJSON(f.getPath());
            MedicineItemPanel mip = new MedicineItemPanel(MainFrame.this);
            mip.loadData(mo);
            if (lm instanceof GridLayout) {
                ((GridLayout) lm).setColumns(1);
                ((GridLayout) lm).setRows(((GridLayout) lm).getRows() + 1);
                MF_KhungNoiDungDanhMucThuoc_JPanel.setLayout(lm);
                MF_KhungNoiDungDanhMucThuoc_JPanel.add(mip, -1);
                Dimension d = new Dimension((int) DMThuocDimension.getSize().getWidth()
                    , (int) DMThuocDimension.getSize().getHeight() +
                    (int) mip.getPreferredSize().getHeight() + 10);
                MF_KhungNoiDungDanhMucThuoc_JPanel.setPreferredSize(d);
                MF_KhungNoiDungDanhMucThuoc_JPanel.revalidate();
                MF_KhungNoiDungDanhMucThuoc_JPanel.repaint();
            }
        }
        JPanel Temporal_Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Dimension d = new Dimension(MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize());
        d.setSize(
            MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize().getWidth(),
            MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize().getHeight() + 10);
        Temporal_Panel.setPreferredSize(d);
        Temporal_Panel.add(MF_KhungNoiDungDanhMucThuoc_JPanel);
        MF_NoiDungDanhMucThuoc_JScrollPane.setViewportView(Temporal_Panel);

        MF_NoiDungDanhMucThuoc_JScrollPane.revalidate();
        MF_NoiDungDanhMucThuoc_JScrollPane.repaint();
    }//GEN-LAST:event_MF_LamMoi_JButtonActionPerformed

    private void MF_TraCuu_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_TraCuu_JButtonActionPerformed
        String TenTraCuuVariableHolder = MF_TraCuu_JTextField.getText();

        if (TenTraCuuVariableHolder.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không thể tra cứu với tên thuốc rỗng", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String directory = "/home/shanghuang/SMM_STO_" + UserName + "/MO/MO_" + TenTraCuuVariableHolder + ".json";
            File f = new File(directory);

            MF_KhungNoiDungDanhMucThuoc_JPanel.removeAll();
            LayoutManager lm = MF_KhungNoiDungDanhMucThuoc_JPanel.getLayout();
            if (lm instanceof GridLayout) {
                ((GridLayout) lm).setColumns(1);
                ((GridLayout) lm).setRows(0);
                MF_KhungNoiDungDanhMucThuoc_JPanel.setLayout(lm);
                MF_KhungNoiDungDanhMucThuoc_JPanel.revalidate();
                MF_KhungNoiDungDanhMucThuoc_JPanel.repaint();
            }

            MedicineObject mo = new MedicineObject();
            mo.readJSON(f.getPath());
            MedicineItemPanel mip = new MedicineItemPanel(MainFrame.this);
            mip.loadData(mo);
            if (lm instanceof GridLayout) {
                ((GridLayout) lm).setColumns(1);
                ((GridLayout) lm).setRows(((GridLayout) lm).getRows() + 1);
                MF_KhungNoiDungDanhMucThuoc_JPanel.setLayout(lm);
                MF_KhungNoiDungDanhMucThuoc_JPanel.add(mip, -1);
                Dimension d = new Dimension((int) MF_KhungNoiDungDanhMucThuoc_JPanel.getSize().getWidth()
                    , (int) mip.getPreferredSize().getHeight() + 20);
                MF_KhungNoiDungDanhMucThuoc_JPanel.setPreferredSize(d);
                MF_KhungNoiDungDanhMucThuoc_JPanel.revalidate();
                MF_KhungNoiDungDanhMucThuoc_JPanel.repaint();
            }

            JPanel Temporal_Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            Dimension d = new Dimension(MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize());
            d.setSize(
                MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize().getWidth(),
                MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize().getHeight() + 10
            );
            Temporal_Panel.setPreferredSize(d);
            Temporal_Panel.add(MF_KhungNoiDungDanhMucThuoc_JPanel);
            MF_NoiDungDanhMucThuoc_JScrollPane.setViewportView(Temporal_Panel);

            MF_NoiDungDanhMucThuoc_JScrollPane.revalidate();
            MF_NoiDungDanhMucThuoc_JScrollPane.repaint();
        }
    }//GEN-LAST:event_MF_TraCuu_JButtonActionPerformed

    private void MF_Them_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_Them_JButtonActionPerformed
        // TODO add your handling code here:
        AddMedicationFrame AMF = new AddMedicationFrame(MainFrame.this, this.UserName);
    }//GEN-LAST:event_MF_Them_JButtonActionPerformed

    private void MF_SuDung1Lan_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_SuDung1Lan_JButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MF_SuDung1Lan_JButtonActionPerformed

    private void MF_BoQua_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_BoQua_JButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MF_BoQua_JButtonActionPerformed

    private void MF_VeCaNhan_JMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MF_VeCaNhan_JMenuItemActionPerformed
        // TODO add your handling code here:
		AccountInformationFrame aif = new AccountInformationFrame(this);
    }//GEN-LAST:event_MF_VeCaNhan_JMenuItemActionPerformed

	// Hàm tải file từ URL
    private static Path downloadFile(String fileURL, String fileName) throws IOException, InterruptedException {
        try {
            URI uri = URI.create(fileURL);
            Path targetPath = Paths.get("/home/shanghuang/SMM_STO_" + UserName + "/OSRO/OSRO_" + fileName);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            HttpResponse<Path> response = client.send(request,
                    HttpResponse.BodyHandlers.ofFile(targetPath));

            if (response.statusCode() == 200) {
                System.out.println("File downloaded successfully to: " + targetPath.toAbsolutePath());
                return targetPath.toAbsolutePath();
            } else {
                System.err.println("Failed to download file. Status code: " + response.statusCode());
                return null;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("URL không hợp lệ: " + e.getMessage());
            return null;
        }
    }


    // Hàm mở file bằng trình xử lý mặc định
    private static void openFile(File file) throws IOException {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            } else {
                System.err.println("File không tồn tại: " + file.getAbsolutePath());
            }
        } else {
            System.err.println("Desktop API không được hỗ trợ.");
        }
    }
	
	private static String getString(JSONObject jsonObject, String key) {
        return jsonObject.containsKey(key) ? (String) jsonObject.get(key) : "Không có thông tin";
    }
	
	private static String getDownloadFileName(String JsonString) {
		String temp = new String();
		JSONParser jp = new JSONParser();
		
		JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(JsonString);

            if (!jsonArray.isEmpty()) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(0);

                // Truy cập đối tượng meta
                JSONObject metaObject = (JSONObject) jsonObject.get("meta");

                // Lấy giá trị của fileName
                String fileName = (metaObject != null && metaObject.containsKey("fileName")) ?
                        (String) metaObject.get("fileName") : "No filename";

                // In thông tin
                System.out.println("Filename: " + fileName);
				
				temp = fileName;

            } else {
                System.out.println("JSONArray rỗng.");
            }

        } catch (ParseException e) {
            System.err.println("Lỗi phân tích JSON: " + e.getMessage());
            e.printStackTrace();
        }
		
		return temp;
	}
	
	private String parseDataFromJsonString(String JsonString, String key) {
		String temp = new String();
		JSONParser jp = new JSONParser();
		
		try {
			JSONArray ja = (JSONArray) jp.parse(JsonString);

			if (!ja.isEmpty()) {
				JSONObject ja_get = (JSONObject) ja.get(0);

				temp = getString(ja_get, key);
			} else {
				System.out.println("No data for require field");
			}

		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
		return temp;
	}
	
	public void refresh_call() {
		String directory = "/home/shanghuang/SMM_STO_" + UserName + "/MO";
		File f_dir = new File(directory);
		File[] files = f_dir.listFiles(
            // filter to select only JSON files with name contain "MO_" prefix
            (file) -> file.isFile() && 
            file.getName().endsWith(".json") && 
            file.getName().startsWith("MO_")
		);
		
		
		MF_KhungNoiDungDanhMucThuoc_JPanel.removeAll();
		LayoutManager lm = MF_KhungNoiDungDanhMucThuoc_JPanel.getLayout();
		if (lm instanceof GridLayout) {
			((GridLayout) lm).setColumns(1);
			((GridLayout) lm).setRows(0);
			MF_KhungNoiDungDanhMucThuoc_JPanel.setLayout(lm);
			MF_KhungNoiDungDanhMucThuoc_JPanel.revalidate();
			MF_KhungNoiDungDanhMucThuoc_JPanel.repaint();
		}
		
		for (File f: files) {
			MedicineObject mo = new MedicineObject();
			mo.readJSON(f.getPath());
			MedicineItemPanel mip = new MedicineItemPanel(MainFrame.this);
			mip.loadData(mo);
			if (lm instanceof GridLayout) {
				((GridLayout) lm).setColumns(1);
				((GridLayout) lm).setRows(((GridLayout) lm).getRows() + 1);
				MF_KhungNoiDungDanhMucThuoc_JPanel.setLayout(lm);
				MF_KhungNoiDungDanhMucThuoc_JPanel.add(mip, -1);
				Dimension d = new Dimension((int) MF_KhungNoiDungDanhMucThuoc_JPanel.getSize().getWidth()
						, (int) MF_KhungNoiDungDanhMucThuoc_JPanel.getSize().getHeight() + 
								(int) mip.getPreferredSize().getHeight() + 10);
				MF_KhungNoiDungDanhMucThuoc_JPanel.setPreferredSize(d);
				MF_KhungNoiDungDanhMucThuoc_JPanel.revalidate();
				MF_KhungNoiDungDanhMucThuoc_JPanel.repaint();
			}
		}
		JPanel Temporal_Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Dimension d = new Dimension(MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize());
		d.setSize(
			MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize().getWidth(), 
			MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize().getHeight() + 10);
		Temporal_Panel.setPreferredSize(d);
		Temporal_Panel.add(MF_KhungNoiDungDanhMucThuoc_JPanel);
		MF_NoiDungDanhMucThuoc_JScrollPane.setViewportView(Temporal_Panel);
		
		MF_NoiDungDanhMucThuoc_JScrollPane.revalidate();
		MF_NoiDungDanhMucThuoc_JScrollPane.repaint();
		
		DMThuocDimension.setSize(MF_KhungNoiDungDanhMucThuoc_JPanel.getPreferredSize());
	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            String osName = System.getProperty("os.name").toLowerCase();
    
            if (osName.contains("linux")) {
                // Sử dụng GTK trên Linux
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("GTK+".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } else if (osName.contains("windows")) {
                // Sử dụng giao diện Windows trên Windows
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(UserName).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MF_BaoCaoThoiQuen_JButton;
    private javax.swing.JButton MF_BoQua_JButton;
    private javax.swing.JMenuItem MF_CaiDat_JMenuItem;
    private javax.swing.JMenu MF_CaiDat_VePhanMem_Thoat_JMI_JMenu;
    private javax.swing.JMenuBar MF_Chon_JMenuBar;
    private javax.swing.JPanel MF_DanhMucThuoc_JPanel;
    private javax.swing.JMenuItem MF_GuiYKien_JMenuItem;
    private javax.swing.JPanel MF_HomNay_JPanel;
    private javax.swing.JTabbedPane MF_IntermidiateContainer_JTabbedPane;
    private javax.swing.JSeparator MF_JSeparator;
    private javax.swing.JPanel MF_KhungNoiDungDanhMucThuoc_JPanel;
    private javax.swing.JPanel MF_KhungNoiDungHomNay_JPanel;
    private javax.swing.JPanel MF_KhungNoiDungLichSu_JPanel;
    private javax.swing.JButton MF_LamMoi_JButton;
    private javax.swing.JPanel MF_LichSu_JPanel;
    private javax.swing.JComboBox<String> MF_LoaiTraCuu_JComboBox;
    private javax.swing.JScrollPane MF_NoiDungDanhMucThuoc_JScrollPane;
    private javax.swing.JScrollPane MF_NoiDungHomNay_JScrollPane;
    private javax.swing.JScrollPane MF_NoiDungLichSu_JScrollPane;
    private javax.swing.JLabel MF_PhanLoai_JLabel;
    private javax.swing.JButton MF_SuDung1Lan_JButton;
    private javax.swing.JLabel MF_TenThuoc_JLabel;
    private javax.swing.JPanel MF_ThanhChucNangDanhMucThuoc_JPanel;
    private javax.swing.JPanel MF_ThanhChucNangHomNay_JPanel;
    private javax.swing.JPanel MF_ThanhChucNangLichSu_JPanel;
    private javax.swing.JPanel MF_ThanhChucNangTraCuuOnline_JPanel;
    private javax.swing.JButton MF_Them_JButton;
    private javax.swing.JMenuItem MF_Thoat_JMenuItem;
    private javax.swing.JScrollPane MF_ThongTinTraCuuCoBan_JScrollPane;
    private javax.swing.JTextArea MF_ThongTinTraCuuCoBan_JTextArea;
    private javax.swing.JButton MF_TraCuuOnline_JButton;
    private javax.swing.JPanel MF_TraCuuOnline_JPanel;
    private javax.swing.JTextField MF_TraCuuOnline_JTextField;
    private javax.swing.JButton MF_TraCuuThuocSuDung_JButton;
    private javax.swing.JLabel MF_TraCuuThuocSuDung_JLabel;
    private javax.swing.JTextField MF_TraCuuThuocSuDung_JTextField;
    private javax.swing.JButton MF_TraCuu_JButton;
    private javax.swing.JTextField MF_TraCuu_JTextField;
    private javax.swing.JMenuItem MF_VeCaNhan_JMenuItem;
    private javax.swing.JMenuItem MF_VePhanMem_JMenuItem;
    private javax.swing.JButton MF_XacNhan_JButton;
    private javax.swing.JButton MF_XuatLichSu_JButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}

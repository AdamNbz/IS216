/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userview;
import elementpanel.TimeStoneAdditionPanel;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import elementpanel.MedicineItemPanel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import object.MedicineObject;

/**
 *
 * @author Tina
 */
public class EditMedicationFrame extends javax.swing.JFrame {
	private static MedicineItemPanel mip;
	private MedicineObject mo;
	public static MainFrame mf;
	public String charset = "<>?/.,:\";'{}|\\[\\]\\\\()!@#$%^&*\\-_+=~`";
	Pattern patt = Pattern.compile("[" + charset + "]");
	int DEBUG = 0;
	String Specific_data = null;
	
    /**
     * Creates new form AddingMedFrame
     */
    public EditMedicationFrame(MedicineItemPanel mip, MainFrame mf) {
		this.mip = mip;
		this.mf = mf;
		this.mo = mip.getMedicineObject();
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
		EMF_TanSuatSuDung_JButton.setEnabled(false);
		EMF_ThanhChucNang_JPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 10" );
		
		EMF_Ten_JTextField.setText(mo.getTenThuoc());
		EMF_DonVi_JTextField.setText(mo.getDonVi());
		EMF_GhiChu_JTextField.setText(mo.getGhiChu());
		EMF_TanSuatSuDung_JComboBox.setSelectedItem(mo.getTanSuatChung());
		Specific_data = mo.getTanSuatCuThe();
		EMF_UuTienThongBao_JToggleButton.setSelected(mo.isUuTienThongBao());
		EMF_TuDongXacNhanSuDung_JToggleButton.setSelected(mo.isTuDongXacNhan());
		EMF_KhoangThoiGianLapThongBao_JSpinner.setValue(mo.getKhoangThongBao());
		EMF_HienCo_JSpinner.setValue(mo.getSLHienCo());
		EMF_NhacNho_JSpinner.setValue(mo.getSLNhacNho());
		
		EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setValue(mo.getDSMocThoiGian().get(0).get(0));
		EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setValue(mo.getDSMocThoiGian().get(0).get(1));
		EMF_AM_PM_JComboBox.setSelectedItem(mo.getDSMocThoiGian().get(0).get(2));
		EMF_LieuSuDung_JSpinner.setValue(mo.getDSMocThoiGian().get(0).get(3));
		LayoutManager layout = EMF_KhungNoiDungThuoc_JPanel.getLayout();
		
		for (List<Object> ls : mo.getDSMocThoiGian().subList(
				1, mo.getDSMocThoiGian().size())
		) {
			TimeStoneAdditionPanel tsap = new TimeStoneAdditionPanel(EMF_KhungNoiDungThuoc_JPanel);
			tsap.setValue(ls);
			((GridLayout) layout).setColumns(1);
			((GridLayout) layout).setRows(((GridLayout) layout).getRows() + 1);
			EMF_KhungNoiDungThuoc_JPanel.setLayout(layout);
			EMF_KhungNoiDungThuoc_JPanel.add(tsap, -1);
			EMF_KhungNoiDungThuoc_JPanel.revalidate();
			EMF_KhungNoiDungThuoc_JPanel.repaint();
		}
		
		this.setFrameInCenter();
        this.setVisible(true);
    }
    
    public void setFrameInCenter() {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - this.getWidth()) / 2;
        final int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }
	
	public boolean checkUnit(String unit) {
		final Pattern UNIT_REGEX = Pattern.compile("^\\s*(\\d+(\\.\\d+)?)\\s*(viên|chiếc|tuýp|gói|lọ|vỉ|ống|chai|m[gG]|g|ml|cc)\\s*$", Pattern.CASE_INSENSITIVE);
		return UNIT_REGEX.matcher(unit).matches();
	}
	
	private Connection connect() {
        // connection parameter
        String dbURL = "jdbc:oracle:thin:@192.168.124.180:32772:XE";
        String driver = "oracle.jdbc.OracleDriver";
        Connection con = null;
        
        // catching error in connection
        try {
            // class loader
            Class.forName(driver);
            
            // connection
            con = DriverManager.getConnection(dbURL, "c##shanghuang", "181105");

            // debug block
            if (con != null) {
                if (DEBUG == 1) {
                    System.out.println("Kết nối đến cơ sử dữ liệu thành công");
                }
            }
        } catch(SQLException se) { 
            // sql exception
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException ex) { 
            // class exception
            Logger.getLogger(EditMedicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return connection
        if (con != null) {
            return con;
        } else {
            return null;
        }
    }
	
	public boolean checkIllegalCharacter(String inp, Pattern pat) {
		Matcher match = pat.matcher(inp);
		return match.find();
	}
    
    public int get_JPanel2_height() {
        return this.EMF_MocThoiGianSuDungThuoc_JPanel.getSize().height;
    }
    
    public int get_JPanel10_height() {
        return this.EMF_KhungNoiDungThuoc_JPanel.getSize().height;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EMF_ThanhChucNang_JPanel = new javax.swing.JPanel();
        EMF_Huy_JButton = new javax.swing.JButton();
        EMF_LuuDonThuoc_JLabel = new javax.swing.JLabel();
        EMF_Luu_JButton = new javax.swing.JButton();
        EMF_NoiDungThemThuoc_JScrollPane = new javax.swing.JScrollPane();
        EMF_KhungNoiDungThuoc_JPanel = new javax.swing.JPanel();
        EMF_Ten_JPanel = new javax.swing.JPanel();
        EMF_Ten_JLabel = new javax.swing.JLabel();
        EMF_Ten_JTextField = new javax.swing.JTextField();
        EMF_DonVi_JPanel = new javax.swing.JPanel();
        EMF_DonVi_JLabel = new javax.swing.JLabel();
        EMF_DonVi_JTextField = new javax.swing.JTextField();
        EMF_GhiChu_JPanel = new javax.swing.JPanel();
        EMF_GhiChu_JLabel = new javax.swing.JLabel();
        EMF_GhiChu_JTextField = new javax.swing.JTextField();
        EMF_TanSuatSuDung_JPanel = new javax.swing.JPanel();
        EMF_TanSuatSuDung_JLabel = new javax.swing.JLabel();
        EMF_TanSuatSuDung_JComboBox = new javax.swing.JComboBox<>();
        EMF_TanSuatSuDung_JButton = new javax.swing.JButton();
        EMF_UuTienThongBao_JPanel = new javax.swing.JPanel();
        EMF_UuTienThongBao_JLabel = new javax.swing.JLabel();
        EMF_UuTienThongBao_JToggleButton = new javax.swing.JToggleButton();
        EMF_TuDongXacNhanSuDung_JPanel = new javax.swing.JPanel();
        EMF_TuDongXacNhanSuDung_JLabel = new javax.swing.JLabel();
        EMF_TuDongXacNhanSuDung_JToggleButton = new javax.swing.JToggleButton();
        EMF_KhoangThoiGianLapThongBao_JPanel = new javax.swing.JPanel();
        EMF_KhoangThoiGianLapThongBao_JLabel = new javax.swing.JLabel();
        EMF_KhoangThoiGianLapThongBao_JSpinner = new javax.swing.JSpinner();
        EMF_QuanLySoLuongThuoc_JPanel = new javax.swing.JPanel();
        EMF_QuanLySoLuongThuoc_JLabel = new javax.swing.JLabel();
        EMF_HienCo_JLabel = new javax.swing.JLabel();
        EMF_HienCo_JSpinner = new javax.swing.JSpinner();
        EMF_NhacNho_JLabel = new javax.swing.JLabel();
        EMF_NhacNho_JSpinner = new javax.swing.JSpinner();
        EMF_MocThoiGianSuDungThuoc_JPanel = new javax.swing.JPanel();
        EMF_MocThoiGianSuDungThuoc_Them_JButton = new javax.swing.JButton();
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner = new javax.swing.JSpinner();
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner = new javax.swing.JSpinner();
        EMF_AM_PM_JComboBox = new javax.swing.JComboBox<>();
        EMF_LieuSuDung_JLabel = new javax.swing.JLabel();
        EMF_LieuSuDung_JSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        EMF_Huy_JButton.setFont(new java.awt.Font("SF Mono", 0, 24)); // NOI18N
        EMF_Huy_JButton.setText("Hủy");
        EMF_Huy_JButton.setMaximumSize(new java.awt.Dimension(120, 40));
        EMF_Huy_JButton.setMinimumSize(new java.awt.Dimension(120, 40));
        EMF_Huy_JButton.setPreferredSize(new java.awt.Dimension(120, 40));
        EMF_Huy_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_Huy_JButtonActionPerformed(evt);
            }
        });
        EMF_ThanhChucNang_JPanel.add(EMF_Huy_JButton);

        EMF_LuuDonThuoc_JLabel.setFont(new java.awt.Font("SF Mono", 0, 36)); // NOI18N
        EMF_LuuDonThuoc_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        EMF_LuuDonThuoc_JLabel.setText("Chỉnh đơn thuốc");
        EMF_LuuDonThuoc_JLabel.setMaximumSize(new java.awt.Dimension(425, 40));
        EMF_LuuDonThuoc_JLabel.setMinimumSize(new java.awt.Dimension(425, 40));
        EMF_LuuDonThuoc_JLabel.setPreferredSize(new java.awt.Dimension(425, 40));
        EMF_ThanhChucNang_JPanel.add(EMF_LuuDonThuoc_JLabel);

        EMF_Luu_JButton.setFont(new java.awt.Font("SF Mono", 0, 24)); // NOI18N
        EMF_Luu_JButton.setText("Lưu");
        EMF_Luu_JButton.setMaximumSize(new java.awt.Dimension(120, 40));
        EMF_Luu_JButton.setMinimumSize(new java.awt.Dimension(120, 40));
        EMF_Luu_JButton.setPreferredSize(new java.awt.Dimension(120, 40));
        EMF_Luu_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_Luu_JButtonActionPerformed(evt);
            }
        });
        EMF_ThanhChucNang_JPanel.add(EMF_Luu_JButton);

        EMF_NoiDungThemThuoc_JScrollPane.setBorder(null);
        EMF_NoiDungThemThuoc_JScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        EMF_NoiDungThemThuoc_JScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        EMF_KhungNoiDungThuoc_JPanel.setLayout(new java.awt.GridLayout(9, 1, 5, 5));

        EMF_Ten_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_Ten_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_Ten_JLabel.setText("Tên:");
        EMF_Ten_JLabel.setMaximumSize(new java.awt.Dimension(270, 30));
        EMF_Ten_JLabel.setMinimumSize(new java.awt.Dimension(270, 30));
        EMF_Ten_JLabel.setPreferredSize(new java.awt.Dimension(270, 30));
        EMF_Ten_JPanel.add(EMF_Ten_JLabel);

        EMF_Ten_JTextField.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_Ten_JTextField.setMaximumSize(new java.awt.Dimension(385, 30));
        EMF_Ten_JTextField.setMinimumSize(new java.awt.Dimension(385, 30));
        EMF_Ten_JTextField.setPreferredSize(new java.awt.Dimension(385, 30));
        EMF_Ten_JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_Ten_JTextFieldActionPerformed(evt);
            }
        });
        EMF_Ten_JPanel.add(EMF_Ten_JTextField);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_Ten_JPanel);

        EMF_DonVi_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_DonVi_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_DonVi_JLabel.setText("Đơn vị:");
        EMF_DonVi_JLabel.setMaximumSize(new java.awt.Dimension(270, 30));
        EMF_DonVi_JLabel.setMinimumSize(new java.awt.Dimension(270, 30));
        EMF_DonVi_JLabel.setPreferredSize(new java.awt.Dimension(270, 30));
        EMF_DonVi_JPanel.add(EMF_DonVi_JLabel);

        EMF_DonVi_JTextField.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_DonVi_JTextField.setMaximumSize(new java.awt.Dimension(385, 30));
        EMF_DonVi_JTextField.setMinimumSize(new java.awt.Dimension(385, 30));
        EMF_DonVi_JTextField.setPreferredSize(new java.awt.Dimension(385, 30));
        EMF_DonVi_JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_DonVi_JTextFieldActionPerformed(evt);
            }
        });
        EMF_DonVi_JPanel.add(EMF_DonVi_JTextField);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_DonVi_JPanel);

        EMF_GhiChu_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_GhiChu_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_GhiChu_JLabel.setText("Ghi chú:");
        EMF_GhiChu_JLabel.setMaximumSize(new java.awt.Dimension(270, 30));
        EMF_GhiChu_JLabel.setMinimumSize(new java.awt.Dimension(270, 30));
        EMF_GhiChu_JLabel.setPreferredSize(new java.awt.Dimension(270, 30));
        EMF_GhiChu_JPanel.add(EMF_GhiChu_JLabel);

        EMF_GhiChu_JTextField.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_GhiChu_JTextField.setMaximumSize(new java.awt.Dimension(385, 30));
        EMF_GhiChu_JTextField.setMinimumSize(new java.awt.Dimension(385, 30));
        EMF_GhiChu_JTextField.setPreferredSize(new java.awt.Dimension(385, 30));
        EMF_GhiChu_JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_GhiChu_JTextFieldActionPerformed(evt);
            }
        });
        EMF_GhiChu_JPanel.add(EMF_GhiChu_JTextField);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_GhiChu_JPanel);

        EMF_TanSuatSuDung_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_TanSuatSuDung_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_TanSuatSuDung_JLabel.setText("Tần suất sử dụng thuốc:");
        EMF_TanSuatSuDung_JLabel.setMaximumSize(new java.awt.Dimension(270, 30));
        EMF_TanSuatSuDung_JLabel.setMinimumSize(new java.awt.Dimension(270, 30));
        EMF_TanSuatSuDung_JLabel.setPreferredSize(new java.awt.Dimension(270, 30));
        EMF_TanSuatSuDung_JPanel.add(EMF_TanSuatSuDung_JLabel);

        EMF_TanSuatSuDung_JComboBox.setFont(new java.awt.Font("SF Mono", 0, 16)); // NOI18N
        EMF_TanSuatSuDung_JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mỗi ngày", "Ngày trong tuần", "Ngày trong tháng", "Khi cần thiết" }));
        EMF_TanSuatSuDung_JComboBox.setMaximumSize(new java.awt.Dimension(250, 30));
        EMF_TanSuatSuDung_JComboBox.setMinimumSize(new java.awt.Dimension(250, 30));
        EMF_TanSuatSuDung_JComboBox.setPreferredSize(new java.awt.Dimension(250, 30));
        EMF_TanSuatSuDung_JComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EMF_TanSuatSuDung_JComboBoxItemStateChanged(evt);
            }
        });
        EMF_TanSuatSuDung_JPanel.add(EMF_TanSuatSuDung_JComboBox);

        EMF_TanSuatSuDung_JButton.setText("...");
        EMF_TanSuatSuDung_JButton.setMaximumSize(new java.awt.Dimension(40, 30));
        EMF_TanSuatSuDung_JButton.setMinimumSize(new java.awt.Dimension(40, 30));
        EMF_TanSuatSuDung_JButton.setPreferredSize(new java.awt.Dimension(40, 30));
        EMF_TanSuatSuDung_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_TanSuatSuDung_JButtonActionPerformed(evt);
            }
        });
        EMF_TanSuatSuDung_JPanel.add(EMF_TanSuatSuDung_JButton);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_TanSuatSuDung_JPanel);

        EMF_UuTienThongBao_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_UuTienThongBao_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_UuTienThongBao_JLabel.setText("Đặt mức độ ưu tiên thông báo cao hơn:");
        EMF_UuTienThongBao_JLabel.setMaximumSize(new java.awt.Dimension(410, 30));
        EMF_UuTienThongBao_JLabel.setMinimumSize(new java.awt.Dimension(410, 30));
        EMF_UuTienThongBao_JLabel.setPreferredSize(new java.awt.Dimension(410, 30));
        EMF_UuTienThongBao_JPanel.add(EMF_UuTienThongBao_JLabel);

        EMF_UuTienThongBao_JToggleButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EMF_UuTienThongBao_JToggleButton.setText("Y/N");
        EMF_UuTienThongBao_JToggleButton.setMaximumSize(new java.awt.Dimension(70, 30));
        EMF_UuTienThongBao_JToggleButton.setMinimumSize(new java.awt.Dimension(70, 30));
        EMF_UuTienThongBao_JToggleButton.setPreferredSize(new java.awt.Dimension(70, 30));
        EMF_UuTienThongBao_JToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_UuTienThongBao_JToggleButtonActionPerformed(evt);
            }
        });
        EMF_UuTienThongBao_JPanel.add(EMF_UuTienThongBao_JToggleButton);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_UuTienThongBao_JPanel);

        EMF_TuDongXacNhanSuDung_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_TuDongXacNhanSuDung_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_TuDongXacNhanSuDung_JLabel.setText("Tự động xác nhận sử dụng thuốc:");
        EMF_TuDongXacNhanSuDung_JLabel.setMaximumSize(new java.awt.Dimension(410, 30));
        EMF_TuDongXacNhanSuDung_JLabel.setMinimumSize(new java.awt.Dimension(410, 30));
        EMF_TuDongXacNhanSuDung_JLabel.setPreferredSize(new java.awt.Dimension(410, 30));
        EMF_TuDongXacNhanSuDung_JPanel.add(EMF_TuDongXacNhanSuDung_JLabel);

        EMF_TuDongXacNhanSuDung_JToggleButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EMF_TuDongXacNhanSuDung_JToggleButton.setText("Y/N");
        EMF_TuDongXacNhanSuDung_JToggleButton.setMaximumSize(new java.awt.Dimension(70, 30));
        EMF_TuDongXacNhanSuDung_JToggleButton.setMinimumSize(new java.awt.Dimension(70, 30));
        EMF_TuDongXacNhanSuDung_JToggleButton.setPreferredSize(new java.awt.Dimension(70, 30));
        EMF_TuDongXacNhanSuDung_JToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMF_TuDongXacNhanSuDung_JToggleButtonActionPerformed(evt);
            }
        });
        EMF_TuDongXacNhanSuDung_JPanel.add(EMF_TuDongXacNhanSuDung_JToggleButton);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_TuDongXacNhanSuDung_JPanel);

        EMF_KhoangThoiGianLapThongBao_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_KhoangThoiGianLapThongBao_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_KhoangThoiGianLapThongBao_JLabel.setText("Khoảng thời gian lặp thông báo: ");
        EMF_KhoangThoiGianLapThongBao_JLabel.setMaximumSize(new java.awt.Dimension(410, 30));
        EMF_KhoangThoiGianLapThongBao_JLabel.setMinimumSize(new java.awt.Dimension(410, 30));
        EMF_KhoangThoiGianLapThongBao_JLabel.setPreferredSize(new java.awt.Dimension(410, 30));
        EMF_KhoangThoiGianLapThongBao_JPanel.add(EMF_KhoangThoiGianLapThongBao_JLabel);

        EMF_KhoangThoiGianLapThongBao_JSpinner.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_KhoangThoiGianLapThongBao_JSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMF_KhoangThoiGianLapThongBao_JSpinner.setFocusable(false);
        EMF_KhoangThoiGianLapThongBao_JSpinner.setMaximumSize(new java.awt.Dimension(70, 30));
        EMF_KhoangThoiGianLapThongBao_JSpinner.setMinimumSize(new java.awt.Dimension(70, 30));
        EMF_KhoangThoiGianLapThongBao_JSpinner.setPreferredSize(new java.awt.Dimension(70, 30));
        EMF_KhoangThoiGianLapThongBao_JSpinner.setRequestFocusEnabled(false);
        EMF_KhoangThoiGianLapThongBao_JSpinner.setValue(5);
        EMF_KhoangThoiGianLapThongBao_JSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EMF_KhoangThoiGianLapThongBao_JSpinnerStateChanged(evt);
            }
        });
        SpinnerNumberModel KhoangThoiGianLapThongBao_model = new SpinnerNumberModel(5, 5, 60, 5);
        EMF_KhoangThoiGianLapThongBao_JSpinner.setModel(KhoangThoiGianLapThongBao_model);
        EMF_KhoangThoiGianLapThongBao_JPanel.add(EMF_KhoangThoiGianLapThongBao_JSpinner);
        JComponent editor_KhoangThoiGianLapThongBao = EMF_KhoangThoiGianLapThongBao_JSpinner.getEditor();
        JFormattedTextField tf_KhoangThoiGianLapThongBao = ((JSpinner.DefaultEditor) editor_KhoangThoiGianLapThongBao).getTextField();
        tf_KhoangThoiGianLapThongBao.setEditable(false);
        tf_KhoangThoiGianLapThongBao.setColumns(3);
        tf_KhoangThoiGianLapThongBao.setHorizontalAlignment(JTextField.CENTER);
        EMF_KhoangThoiGianLapThongBao_JSpinner.setSize(64, 32);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_KhoangThoiGianLapThongBao_JPanel);

        EMF_QuanLySoLuongThuoc_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_QuanLySoLuongThuoc_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_QuanLySoLuongThuoc_JLabel.setText("Quản lý số lượng thuốc:");
        EMF_QuanLySoLuongThuoc_JLabel.setMaximumSize(new java.awt.Dimension(315, 30));
        EMF_QuanLySoLuongThuoc_JLabel.setMinimumSize(new java.awt.Dimension(315, 30));
        EMF_QuanLySoLuongThuoc_JLabel.setPreferredSize(new java.awt.Dimension(315, 30));
        EMF_QuanLySoLuongThuoc_JPanel.add(EMF_QuanLySoLuongThuoc_JLabel);

        EMF_HienCo_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_HienCo_JLabel.setText("Hiện có");
        EMF_HienCo_JLabel.setMaximumSize(new java.awt.Dimension(90, 30));
        EMF_HienCo_JLabel.setMinimumSize(new java.awt.Dimension(90, 30));
        EMF_HienCo_JLabel.setPreferredSize(new java.awt.Dimension(90, 30));
        EMF_QuanLySoLuongThuoc_JPanel.add(EMF_HienCo_JLabel);

        EMF_HienCo_JSpinner.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_HienCo_JSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMF_HienCo_JSpinner.setFocusable(false);
        EMF_HienCo_JSpinner.setMaximumSize(new java.awt.Dimension(70, 30));
        EMF_HienCo_JSpinner.setMinimumSize(new java.awt.Dimension(70, 30));
        EMF_HienCo_JSpinner.setPreferredSize(new java.awt.Dimension(70, 30));
        EMF_HienCo_JSpinner.setRequestFocusEnabled(false);
        EMF_HienCo_JSpinner.setValue(1);
        EMF_HienCo_JSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EMF_HienCo_JSpinnerStateChanged(evt);
            }
        });
        SpinnerNumberModel HienCo_model = new SpinnerNumberModel(1, 1, 100, 1);
        EMF_HienCo_JSpinner.setModel(HienCo_model);
        EMF_QuanLySoLuongThuoc_JPanel.add(EMF_HienCo_JSpinner);
        JComponent editor_HienCo = EMF_HienCo_JSpinner.getEditor();
        JFormattedTextField tf_HienCo = ((JSpinner.DefaultEditor) editor_HienCo).getTextField();
        tf_HienCo.setEditable(false);
        tf_HienCo.setColumns(3);
        tf_HienCo.setHorizontalAlignment(JTextField.CENTER);
        EMF_HienCo_JSpinner.setSize(64, 32);

        EMF_NhacNho_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_NhacNho_JLabel.setText("Nhắc nhở");
        EMF_NhacNho_JLabel.setMaximumSize(new java.awt.Dimension(90, 30));
        EMF_NhacNho_JLabel.setMinimumSize(new java.awt.Dimension(90, 30));
        EMF_NhacNho_JLabel.setPreferredSize(new java.awt.Dimension(90, 30));
        EMF_QuanLySoLuongThuoc_JPanel.add(EMF_NhacNho_JLabel);

        EMF_NhacNho_JSpinner.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_NhacNho_JSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMF_NhacNho_JSpinner.setFocusable(false);
        EMF_NhacNho_JSpinner.setMaximumSize(new java.awt.Dimension(70, 30));
        EMF_NhacNho_JSpinner.setMinimumSize(new java.awt.Dimension(70, 30));
        EMF_NhacNho_JSpinner.setPreferredSize(new java.awt.Dimension(70, 30));
        EMF_NhacNho_JSpinner.setRequestFocusEnabled(false);
        EMF_NhacNho_JSpinner.setValue(1);
        EMF_NhacNho_JSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EMF_NhacNho_JSpinnerStateChanged(evt);
            }
        });
        SpinnerNumberModel NhacNho_model = new SpinnerNumberModel(1, 1, 100, 1);
        EMF_NhacNho_JSpinner.setModel(NhacNho_model);
        EMF_QuanLySoLuongThuoc_JPanel.add(EMF_NhacNho_JSpinner);
        JComponent editor_NhacNho = EMF_NhacNho_JSpinner.getEditor();
        JFormattedTextField tf_NhacNho = ((JSpinner.DefaultEditor) editor_NhacNho).getTextField();
        tf_NhacNho.setEditable(false);
        tf_NhacNho.setColumns(3);
        tf_NhacNho.setHorizontalAlignment(JTextField.CENTER);
        EMF_NhacNho_JSpinner.setSize(64, 32);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_QuanLySoLuongThuoc_JPanel);

        EMF_MocThoiGianSuDungThuoc_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        EMF_MocThoiGianSuDungThuoc_Them_JButton.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_MocThoiGianSuDungThuoc_Them_JButton.setText("Thêm");
        EMF_MocThoiGianSuDungThuoc_Them_JButton.setMaximumSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Them_JButton.setMinimumSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Them_JButton.setPreferredSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Them_JButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EMF_MocThoiGianSuDungThuoc_Them_JButtonMouseClicked(evt);
            }
        });
        EMF_MocThoiGianSuDungThuoc_JPanel.add(EMF_MocThoiGianSuDungThuoc_Them_JButton);

        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setFocusable(false);
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setMaximumSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setMinimumSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setPreferredSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setRequestFocusEnabled(false);
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EMF_MocThoiGianSuDungThuoc_Gio_JSpinnerStateChanged(evt);
            }
        });
        SpinnerNumberModel Gio_model = new SpinnerNumberModel(0, 0, 12, 1);
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setModel(Gio_model);
        EMF_MocThoiGianSuDungThuoc_JPanel.add(EMF_MocThoiGianSuDungThuoc_Gio_JSpinner);
        JComponent editor_Gio = EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.getEditor();
        JFormattedTextField tf_Gio = ((JSpinner.DefaultEditor) editor_Gio).getTextField();
        tf_Gio.setEditable(false);
        tf_Gio.setColumns(3);
        tf_Gio.setHorizontalAlignment(JTextField.CENTER);
        EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setSize(64, 32);

        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setFocusable(false);
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setMaximumSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setMinimumSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setPreferredSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setRequestFocusEnabled(false);
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EMF_MocThoiGianSuDungThuoc_Phut_JSpinnerStateChanged(evt);
            }
        });
        SpinnerNumberModel Phut_model = new SpinnerNumberModel(0, 0, 60, 1);
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setModel(Phut_model);
        EMF_MocThoiGianSuDungThuoc_JPanel.add(EMF_MocThoiGianSuDungThuoc_Phut_JSpinner);
        JComponent editor_Phut = EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.getEditor();
        JFormattedTextField tf_Phut = ((JSpinner.DefaultEditor) editor_Phut).getTextField();
        tf_Phut.setEditable(false);
        tf_Phut.setColumns(3);
        tf_Phut.setHorizontalAlignment(JTextField.CENTER);
        EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setSize(64, 32);

        EMF_AM_PM_JComboBox.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_AM_PM_JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        EMF_AM_PM_JComboBox.setMaximumSize(new java.awt.Dimension(90, 30));
        EMF_AM_PM_JComboBox.setMinimumSize(new java.awt.Dimension(90, 30));
        EMF_AM_PM_JComboBox.setPreferredSize(new java.awt.Dimension(90, 30));
        EMF_MocThoiGianSuDungThuoc_JPanel.add(EMF_AM_PM_JComboBox);

        EMF_LieuSuDung_JLabel.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_LieuSuDung_JLabel.setText("Liều sử dụng");
        EMF_LieuSuDung_JLabel.setMaximumSize(new java.awt.Dimension(140, 30));
        EMF_LieuSuDung_JLabel.setMinimumSize(new java.awt.Dimension(140, 30));
        EMF_LieuSuDung_JLabel.setPreferredSize(new java.awt.Dimension(180, 30));
        EMF_MocThoiGianSuDungThuoc_JPanel.add(EMF_LieuSuDung_JLabel);

        EMF_LieuSuDung_JSpinner.setFont(new java.awt.Font("SF Mono", 0, 18)); // NOI18N
        EMF_LieuSuDung_JSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EMF_LieuSuDung_JSpinner.setFocusable(false);
        EMF_LieuSuDung_JSpinner.setMaximumSize(new java.awt.Dimension(90, 30));
        EMF_LieuSuDung_JSpinner.setMinimumSize(new java.awt.Dimension(90, 30));
        EMF_LieuSuDung_JSpinner.setPreferredSize(new java.awt.Dimension(90, 30));
        EMF_LieuSuDung_JSpinner.setRequestFocusEnabled(false);
        EMF_LieuSuDung_JSpinner.setValue(1);
        EMF_LieuSuDung_JSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                EMF_LieuSuDung_JSpinnerStateChanged(evt);
            }
        });
        SpinnerNumberModel LieuSuDung_model = new SpinnerNumberModel(1, 1, 100, 1);
        EMF_LieuSuDung_JSpinner.setModel(LieuSuDung_model);
        EMF_MocThoiGianSuDungThuoc_JPanel.add(EMF_LieuSuDung_JSpinner);
        JComponent editor_LieuSuDung = EMF_LieuSuDung_JSpinner.getEditor();
        JFormattedTextField tf_LieuSuDung = ((JSpinner.DefaultEditor) editor_LieuSuDung).getTextField();
        tf_LieuSuDung.setEditable(false);
        tf_LieuSuDung.setColumns(3);
        tf_LieuSuDung.setHorizontalAlignment(JTextField.CENTER);
        EMF_LieuSuDung_JSpinner.setSize(64, 32);

        EMF_KhungNoiDungThuoc_JPanel.add(EMF_MocThoiGianSuDungThuoc_JPanel);

        EMF_NoiDungThemThuoc_JScrollPane.setViewportView(EMF_KhungNoiDungThuoc_JPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EMF_ThanhChucNang_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(EMF_NoiDungThemThuoc_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EMF_ThanhChucNang_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EMF_NoiDungThemThuoc_JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EMF_Huy_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_Huy_JButtonActionPerformed
        this.mf.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_EMF_Huy_JButtonActionPerformed

    private void EMF_Luu_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_Luu_JButtonActionPerformed
        String TenThuocVariableHolder = EMF_Ten_JTextField.getText();
		String DonViVariableHolder = EMF_DonVi_JTextField.getText();
		String GhiChuVariableHolder = EMF_GhiChu_JTextField.getText();
		String TanSuatChungVariableHolder = EMF_TanSuatSuDung_JComboBox.getSelectedItem().toString();
		String TanSuatCuTheVariableHolder = Specific_data;
		
		boolean UuTienThongBaoVariableHolder = false;
		if (EMF_UuTienThongBao_JToggleButton.isEnabled() == true) {
			UuTienThongBaoVariableHolder = EMF_UuTienThongBao_JToggleButton.isSelected();
		}
		
		boolean AutoConfirmVariableHolder = false;
		if (EMF_TuDongXacNhanSuDung_JToggleButton.isEnabled() == true) {
			AutoConfirmVariableHolder = EMF_TuDongXacNhanSuDung_JToggleButton.isSelected();
		}
		
		int KhoangThongBaoVariableHolder = Integer.parseInt(
				EMF_KhoangThoiGianLapThongBao_JSpinner.getValue().toString()
		);
		int SLHienCoVariableHolder = Integer.parseInt(
				EMF_HienCo_JSpinner.getValue().toString()
		);
		int SLNhacNhoVariableHolder = Integer.parseInt(
				EMF_NhacNho_JSpinner.getValue().toString()
		);
		
		List<List<Object>> MocThoiGianVariableHolder = new ArrayList<>();
		
		for (Component cpm: EMF_KhungNoiDungThuoc_JPanel.getComponents()) {
			if (cpm instanceof TimeStoneAdditionPanel timeStoneAdditionPanel) {
				MocThoiGianVariableHolder.add(timeStoneAdditionPanel.loadValue());
			}
		}
		
		List<Object> ls = new ArrayList<>();
		ls.add(EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.getValue());
		ls.add(EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.getValue());
		ls.add(EMF_AM_PM_JComboBox.getSelectedItem());
		ls.add(EMF_LieuSuDung_JSpinner.getValue());
		MocThoiGianVariableHolder.addFirst(ls);
		
		if (DEBUG == 1) {
			System.out.println(TenThuocVariableHolder);
			System.out.println(DonViVariableHolder);
			System.out.println(GhiChuVariableHolder);
			System.out.println(TanSuatChungVariableHolder);
			System.out.println(TanSuatCuTheVariableHolder);
			System.out.println(UuTienThongBaoVariableHolder);
			System.out.println(AutoConfirmVariableHolder);
			System.out.println(KhoangThongBaoVariableHolder);
			System.out.println(SLHienCoVariableHolder);
			System.out.println(SLNhacNhoVariableHolder);
			
			for (List<Object> ll: MocThoiGianVariableHolder) {
				for (Object o: ll) {
					System.out.println(o + " ");
				}
				System.out.println();
			}
		}
		MedicineObject mo = new MedicineObject(
				TenThuocVariableHolder,
				DonViVariableHolder, 
				GhiChuVariableHolder, 
				TanSuatChungVariableHolder, 
				TanSuatCuTheVariableHolder, 
				UuTienThongBaoVariableHolder,
				AutoConfirmVariableHolder, 
				KhoangThongBaoVariableHolder, 
				SLHienCoVariableHolder, 
				SLNhacNhoVariableHolder, 
				MocThoiGianVariableHolder
		);
		mo.writeJSON(MainFrame.UserName);
		
		this.mf.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_EMF_Luu_JButtonActionPerformed

    private void EMF_Ten_JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_Ten_JTextFieldActionPerformed
        if (checkIllegalCharacter(EMF_Ten_JTextField.getText(), patt)) {
				JOptionPane.showMessageDialog(this, "Tên thuốc không được phép tồn tại ký tự đặc biệt. Vui lòng nhập lại", "Error", JOptionPane.ERROR_MESSAGE);
				EMF_Ten_JTextField.setText("");
		}
    }//GEN-LAST:event_EMF_Ten_JTextFieldActionPerformed

    private void EMF_UuTienThongBao_JToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_UuTienThongBao_JToggleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EMF_UuTienThongBao_JToggleButtonActionPerformed

    private void EMF_TuDongXacNhanSuDung_JToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_TuDongXacNhanSuDung_JToggleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EMF_TuDongXacNhanSuDung_JToggleButtonActionPerformed

    private void EMF_MocThoiGianSuDungThuoc_Them_JButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EMF_MocThoiGianSuDungThuoc_Them_JButtonMouseClicked
      	TimeStoneAdditionPanel JP = new TimeStoneAdditionPanel(EMF_KhungNoiDungThuoc_JPanel);
		JP.setSize(EMF_MocThoiGianSuDungThuoc_JPanel.getSize());
        
        LayoutManager layout = EMF_KhungNoiDungThuoc_JPanel.getLayout();
        
        if (layout instanceof GridLayout) {
            ((GridLayout) layout).setColumns(1);
            ((GridLayout) layout).setRows(((GridLayout) layout).getRows() + 1);
            EMF_KhungNoiDungThuoc_JPanel.setLayout(layout);
            EMF_KhungNoiDungThuoc_JPanel.add(JP, -1);
            EMF_KhungNoiDungThuoc_JPanel.revalidate();
            EMF_KhungNoiDungThuoc_JPanel.repaint();
        }
        
    }//GEN-LAST:event_EMF_MocThoiGianSuDungThuoc_Them_JButtonMouseClicked

    private void EMF_TanSuatSuDung_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_TanSuatSuDung_JButtonActionPerformed
        // TODO add your handling code here:
        if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Mỗi ngày")) {
            EMF_TanSuatSuDung_JButton.setEnabled(false); 
        } else if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Ngày trong tuần")) {
			String previousData = Specific_data;
			
            Specific_data = JOptionPane.showInputDialog(this, "Nhập các ngày trong tuần bạn muốn\n(phân cách bằng dấu \",\"):\n" + "2: Thứ Hai, 3: Thứ Ba, 4: Thứ Tư\n5: Thứ Năm, 6: Thứ Sáu, 7: Thứ Bảy\n8: Chủ Nhật", "Lựa chọn ngày trong tuần", JOptionPane.QUESTION_MESSAGE, null, null, previousData).toString();
        } else if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Ngày trong tháng")) {
			String previousData = Specific_data;
            Specific_data = JOptionPane.showInputDialog(this, "Nhập các ngày trong tháng bạn muốn\n(phân cách bằng dấu \",\"): ", "Lựa chọn ngày trong tháng", JOptionPane.QUESTION_MESSAGE, null, null, previousData).toString();
        } else if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Khi cần thiết")) {
			EMF_TanSuatSuDung_JButton.setEnabled(false); 
        }
    }//GEN-LAST:event_EMF_TanSuatSuDung_JButtonActionPerformed

    private void EMF_TanSuatSuDung_JComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EMF_TanSuatSuDung_JComboBoxItemStateChanged
        // TODO add your handling code here:
		EMF_TanSuatSuDung_JButton.setEnabled(false);
		EMF_UuTienThongBao_JToggleButton.setSelected(false);
		EMF_TuDongXacNhanSuDung_JToggleButton.setSelected(false);
		EMF_KhoangThoiGianLapThongBao_JSpinner.setValue(5);
        if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Mỗi ngày")) {
            EMF_TanSuatSuDung_JButton.setEnabled(false);
			EMF_UuTienThongBao_JToggleButton.setEnabled(true);
			EMF_TuDongXacNhanSuDung_JToggleButton.setEnabled(true);
			EMF_KhoangThoiGianLapThongBao_JSpinner.setEnabled(true);
        } else if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Ngày trong tuần")) {
			EMF_TanSuatSuDung_JButton.setEnabled(true);
			EMF_UuTienThongBao_JToggleButton.setEnabled(true);
			EMF_TuDongXacNhanSuDung_JToggleButton.setEnabled(true);
			EMF_KhoangThoiGianLapThongBao_JSpinner.setEnabled(true);
        } else if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Ngày trong tháng")) {
			EMF_TanSuatSuDung_JButton.setEnabled(true);
			EMF_UuTienThongBao_JToggleButton.setEnabled(true);
			EMF_TuDongXacNhanSuDung_JToggleButton.setEnabled(true);
			EMF_KhoangThoiGianLapThongBao_JSpinner.setEnabled(true);
        } else if (EMF_TanSuatSuDung_JComboBox.getSelectedItem().equals("Khi cần thiết")) {
            EMF_TanSuatSuDung_JButton.setEnabled(false);
			EMF_UuTienThongBao_JToggleButton.setEnabled(false);
			EMF_TuDongXacNhanSuDung_JToggleButton.setEnabled(false);
			EMF_KhoangThoiGianLapThongBao_JSpinner.setEnabled(false);
        }
    }//GEN-LAST:event_EMF_TanSuatSuDung_JComboBoxItemStateChanged

    private void EMF_DonVi_JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_DonVi_JTextFieldActionPerformed
        if (!checkUnit(EMF_DonVi_JTextField.getText())) {
			JOptionPane.showMessageDialog(this, "Đơn vị không đúng định dạng. Vui lòng nhập lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_DonVi_JTextField.setText("");
		}
    }//GEN-LAST:event_EMF_DonVi_JTextFieldActionPerformed

    private void EMF_GhiChu_JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMF_GhiChu_JTextFieldActionPerformed
        if (checkIllegalCharacter(EMF_GhiChu_JTextField.getText(), patt)) {
			JOptionPane.showMessageDialog(this, "Ghi chú không được phép tồn tại ký tự đặc biệt. Vui lòng nhập lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_GhiChu_JTextField.setText("");
		}
    }//GEN-LAST:event_EMF_GhiChu_JTextFieldActionPerformed

    private void EMF_KhoangThoiGianLapThongBao_JSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EMF_KhoangThoiGianLapThongBao_JSpinnerStateChanged
        if (Integer.parseInt(EMF_KhoangThoiGianLapThongBao_JSpinner.getValue().toString()) < 0) {
			JOptionPane.showMessageDialog(this, "Khoảng thời gian phải là số dương. Vui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_KhoangThoiGianLapThongBao_JSpinner.setValue(5);
		}
    }//GEN-LAST:event_EMF_KhoangThoiGianLapThongBao_JSpinnerStateChanged

    private void EMF_HienCo_JSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EMF_HienCo_JSpinnerStateChanged
        if (Integer.parseInt(EMF_HienCo_JSpinner.getValue().toString()) < 0) {
			JOptionPane.showMessageDialog(this, "Lượng thuốc hiện có phải là số dương. Vui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_HienCo_JSpinner.setValue(1);
		}
    }//GEN-LAST:event_EMF_HienCo_JSpinnerStateChanged

    private void EMF_NhacNho_JSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EMF_NhacNho_JSpinnerStateChanged
		if (Integer.parseInt(EMF_NhacNho_JSpinner.getValue().toString()) < 0) {
			JOptionPane.showMessageDialog(this, "Lượng thuốc nhắc nhở bổ sung phải là số dương. Vui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_NhacNho_JSpinner.setValue(1);
		}
    }//GEN-LAST:event_EMF_NhacNho_JSpinnerStateChanged

    private void EMF_MocThoiGianSuDungThuoc_Gio_JSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EMF_MocThoiGianSuDungThuoc_Gio_JSpinnerStateChanged
        if (Integer.parseInt(EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.getValue().toString()) < 0) {
			JOptionPane.showMessageDialog(this, "Mốc giờ phải là số dương.\nVui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setValue(0);
		} else if (Integer.parseInt(EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.getValue().toString()) > 12) {
			JOptionPane.showMessageDialog(this, "Mốc giờ phải nằm trong khoảng 0 đến 12.\nVui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_MocThoiGianSuDungThuoc_Gio_JSpinner.setValue(12);
		}
    }//GEN-LAST:event_EMF_MocThoiGianSuDungThuoc_Gio_JSpinnerStateChanged

    private void EMF_MocThoiGianSuDungThuoc_Phut_JSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EMF_MocThoiGianSuDungThuoc_Phut_JSpinnerStateChanged
        if (Integer.parseInt(EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.getValue().toString()) < 0) {
			JOptionPane.showMessageDialog(this, "Mốc phút phải là số dương.\nVui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setValue(0);
		} else if (Integer.parseInt(EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.getValue().toString()) > 60) {
			JOptionPane.showMessageDialog(this, "Mốc phút phải nằm trong khoảng 0 đến 60.\nVui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_MocThoiGianSuDungThuoc_Phut_JSpinner.setValue(60);
		}
    }//GEN-LAST:event_EMF_MocThoiGianSuDungThuoc_Phut_JSpinnerStateChanged

    private void EMF_LieuSuDung_JSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_EMF_LieuSuDung_JSpinnerStateChanged
        if (Integer.parseInt(EMF_LieuSuDung_JSpinner.getValue().toString()) < 0) {
			JOptionPane.showMessageDialog(this, "Lượng thuốc nhắc nhở bổ sung phải là số dương. Vui lòng chọn lại", "Error", JOptionPane.ERROR_MESSAGE);
			EMF_LieuSuDung_JSpinner.setValue(1);
		}
    }//GEN-LAST:event_EMF_LieuSuDung_JSpinnerStateChanged

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
            java.util.logging.Logger.getLogger(EditMedicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMedicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMedicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMedicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditMedicationFrame(mip, mip.mf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EMF_AM_PM_JComboBox;
    private javax.swing.JLabel EMF_DonVi_JLabel;
    private javax.swing.JPanel EMF_DonVi_JPanel;
    private javax.swing.JTextField EMF_DonVi_JTextField;
    private javax.swing.JLabel EMF_GhiChu_JLabel;
    private javax.swing.JPanel EMF_GhiChu_JPanel;
    private javax.swing.JTextField EMF_GhiChu_JTextField;
    private javax.swing.JLabel EMF_HienCo_JLabel;
    private javax.swing.JSpinner EMF_HienCo_JSpinner;
    private javax.swing.JButton EMF_Huy_JButton;
    private javax.swing.JLabel EMF_KhoangThoiGianLapThongBao_JLabel;
    private javax.swing.JPanel EMF_KhoangThoiGianLapThongBao_JPanel;
    private javax.swing.JSpinner EMF_KhoangThoiGianLapThongBao_JSpinner;
    private javax.swing.JPanel EMF_KhungNoiDungThuoc_JPanel;
    private javax.swing.JLabel EMF_LieuSuDung_JLabel;
    private javax.swing.JSpinner EMF_LieuSuDung_JSpinner;
    private javax.swing.JLabel EMF_LuuDonThuoc_JLabel;
    private javax.swing.JButton EMF_Luu_JButton;
    private javax.swing.JSpinner EMF_MocThoiGianSuDungThuoc_Gio_JSpinner;
    private javax.swing.JPanel EMF_MocThoiGianSuDungThuoc_JPanel;
    private javax.swing.JSpinner EMF_MocThoiGianSuDungThuoc_Phut_JSpinner;
    private javax.swing.JButton EMF_MocThoiGianSuDungThuoc_Them_JButton;
    private javax.swing.JLabel EMF_NhacNho_JLabel;
    private javax.swing.JSpinner EMF_NhacNho_JSpinner;
    private javax.swing.JScrollPane EMF_NoiDungThemThuoc_JScrollPane;
    private javax.swing.JLabel EMF_QuanLySoLuongThuoc_JLabel;
    private javax.swing.JPanel EMF_QuanLySoLuongThuoc_JPanel;
    private javax.swing.JButton EMF_TanSuatSuDung_JButton;
    private javax.swing.JComboBox<String> EMF_TanSuatSuDung_JComboBox;
    private javax.swing.JLabel EMF_TanSuatSuDung_JLabel;
    private javax.swing.JPanel EMF_TanSuatSuDung_JPanel;
    private javax.swing.JLabel EMF_Ten_JLabel;
    private javax.swing.JPanel EMF_Ten_JPanel;
    private javax.swing.JTextField EMF_Ten_JTextField;
    private javax.swing.JPanel EMF_ThanhChucNang_JPanel;
    private javax.swing.JLabel EMF_TuDongXacNhanSuDung_JLabel;
    private javax.swing.JPanel EMF_TuDongXacNhanSuDung_JPanel;
    private javax.swing.JToggleButton EMF_TuDongXacNhanSuDung_JToggleButton;
    private javax.swing.JLabel EMF_UuTienThongBao_JLabel;
    private javax.swing.JPanel EMF_UuTienThongBao_JPanel;
    private javax.swing.JToggleButton EMF_UuTienThongBao_JToggleButton;
    // End of variables declaration//GEN-END:variables
}

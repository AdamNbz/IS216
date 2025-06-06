/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userview;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import javax.swing.UIManager;
import object.SettingObject;

/**
 *
 * @author Hinno
 */
public class PreferencesFrame extends javax.swing.JFrame {
	public static MainFrame mf;
    /**
     * Creates new form PreferencesFrame
     */
    public PreferencesFrame(MainFrame mf) {
        this.mf = mf;
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
		JSONLoader();
		this.setFrameInCenter();
        this.setVisible(true);
    }
	
	public void JSONLoader() {
		SettingObject so = new SettingObject();
		so.readJSON("/home/shanghuang/SMM_STO_" + MainFrame.UserName + "/SO/SettingObject.json");
		PF_TuDongMoKhiDangNhap_JToggleButton.setSelected(so.isAutoStartUp());
		PF_TuDongXoaLichSu_JToggleButton.setSelected(so.isAutoClearHistory());
		PF_ThongBaoSoLuongThuocThap_JToggleButton.setSelected(so.isNotiOnLowLevel());
		PF_DongY_JToggleButton.setSelected(so.isEnableConfirmButton());
		PF_BoQua_JToggleButton.setSelected(so.isEnabelSkipButton());
	}
	
	public void setFrameInCenter() {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - this.getWidth()) / 2;
        final int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PF_CatDat_JLabel = new javax.swing.JLabel();
        PF_TuDongMoKhiDangNhap_JPanel = new javax.swing.JPanel();
        PF_TuDongMoKhiDangNhap_JLabel = new javax.swing.JLabel();
        PF_TuDongMoKhiDangNhap_JToggleButton = new javax.swing.JToggleButton();
        PF_TuDongXoaLichSu_JPanel = new javax.swing.JPanel();
        PF_TuDongXoaLichSu_JLabel = new javax.swing.JLabel();
        PF_TuDongXoaLichSu_JToggleButton = new javax.swing.JToggleButton();
        PF_ThongBaoSoLuongThuocThap_JPanel = new javax.swing.JPanel();
        PF_ThongBaoSoLuongThuocThap_JLabel = new javax.swing.JLabel();
        PF_ThongBaoSoLuongThuocThap_JToggleButton = new javax.swing.JToggleButton();
        PF_CacNutThongBao_JPanel = new javax.swing.JPanel();
        PF_CacNutThongBao_JLabel = new javax.swing.JLabel();
        PF_DongY_JPanel = new javax.swing.JPanel();
        PF_DongY_JLabel = new javax.swing.JLabel();
        PF_DongY_JToggleButton = new javax.swing.JToggleButton();
        PF_BoQua_JPanel = new javax.swing.JPanel();
        PF_BoQua_JLabel = new javax.swing.JLabel();
        PF_BoQua_JToggleButton = new javax.swing.JToggleButton();
        PF_LuuCaiDat_JButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(Color.decode("#7f8c8d"));
        setMaximumSize(new java.awt.Dimension(565, 550));
        setMinimumSize(new java.awt.Dimension(565, 550));
        setPreferredSize(new java.awt.Dimension(565, 550));
        getContentPane().setLayout(new java.awt.GridLayout(8, 1, 5, 5));

        PF_CatDat_JLabel.setBackground(new Color(0,0,0,0));
        PF_CatDat_JLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        PF_CatDat_JLabel.setForeground(Color.decode("#7f8c8d"));
        PF_CatDat_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PF_CatDat_JLabel.setText("Cài đặt");
        getContentPane().add(PF_CatDat_JLabel);

        PF_TuDongMoKhiDangNhap_JPanel.setBackground(new Color(0,0,0,0));
        PF_TuDongMoKhiDangNhap_JPanel.setForeground(Color.decode("#7f8c8d"));
        PF_TuDongMoKhiDangNhap_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PF_TuDongMoKhiDangNhap_JLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PF_TuDongMoKhiDangNhap_JLabel.setText("Tự động mở khi bật nguồn");
        PF_TuDongMoKhiDangNhap_JLabel.setMaximumSize(new java.awt.Dimension(420, 30));
        PF_TuDongMoKhiDangNhap_JLabel.setMinimumSize(new java.awt.Dimension(420, 30));
        PF_TuDongMoKhiDangNhap_JLabel.setPreferredSize(new java.awt.Dimension(420, 30));
        PF_TuDongMoKhiDangNhap_JPanel.add(PF_TuDongMoKhiDangNhap_JLabel);

        PF_TuDongMoKhiDangNhap_JToggleButton.setText("Y/N");
        PF_TuDongMoKhiDangNhap_JToggleButton.setMaximumSize(new java.awt.Dimension(130, 30));
        PF_TuDongMoKhiDangNhap_JToggleButton.setMinimumSize(new java.awt.Dimension(130, 30));
        PF_TuDongMoKhiDangNhap_JToggleButton.setPreferredSize(new java.awt.Dimension(130, 30));
        PF_TuDongMoKhiDangNhap_JPanel.add(PF_TuDongMoKhiDangNhap_JToggleButton);

        getContentPane().add(PF_TuDongMoKhiDangNhap_JPanel);

        PF_TuDongXoaLichSu_JPanel.setBackground(new Color(0,0,0,0));
        PF_TuDongXoaLichSu_JPanel.setForeground(Color.decode("#7f8c8d"));
        PF_TuDongXoaLichSu_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PF_TuDongXoaLichSu_JLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PF_TuDongXoaLichSu_JLabel.setText("Tự động xóa lịch sử");
        PF_TuDongXoaLichSu_JLabel.setMaximumSize(new java.awt.Dimension(420, 30));
        PF_TuDongXoaLichSu_JLabel.setMinimumSize(new java.awt.Dimension(420, 30));
        PF_TuDongXoaLichSu_JLabel.setPreferredSize(new java.awt.Dimension(420, 30));
        PF_TuDongXoaLichSu_JPanel.add(PF_TuDongXoaLichSu_JLabel);

        PF_TuDongXoaLichSu_JToggleButton.setText("Y/N");
        PF_TuDongXoaLichSu_JToggleButton.setMaximumSize(new java.awt.Dimension(130, 30));
        PF_TuDongXoaLichSu_JToggleButton.setMinimumSize(new java.awt.Dimension(130, 30));
        PF_TuDongXoaLichSu_JToggleButton.setPreferredSize(new java.awt.Dimension(130, 30));
        PF_TuDongXoaLichSu_JPanel.add(PF_TuDongXoaLichSu_JToggleButton);

        getContentPane().add(PF_TuDongXoaLichSu_JPanel);

        PF_ThongBaoSoLuongThuocThap_JPanel.setBackground(new Color(0,0,0,0));
        PF_ThongBaoSoLuongThuocThap_JPanel.setForeground(Color.decode("#7f8c8d"));
        PF_ThongBaoSoLuongThuocThap_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PF_ThongBaoSoLuongThuocThap_JLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PF_ThongBaoSoLuongThuocThap_JLabel.setText("Thông báo số lượng thuốc thấp");
        PF_ThongBaoSoLuongThuocThap_JLabel.setToolTipText("");
        PF_ThongBaoSoLuongThuocThap_JLabel.setMaximumSize(new java.awt.Dimension(420, 30));
        PF_ThongBaoSoLuongThuocThap_JLabel.setMinimumSize(new java.awt.Dimension(420, 30));
        PF_ThongBaoSoLuongThuocThap_JLabel.setPreferredSize(new java.awt.Dimension(420, 30));
        PF_ThongBaoSoLuongThuocThap_JPanel.add(PF_ThongBaoSoLuongThuocThap_JLabel);

        PF_ThongBaoSoLuongThuocThap_JToggleButton.setText("Y/N");
        PF_ThongBaoSoLuongThuocThap_JToggleButton.setMaximumSize(new java.awt.Dimension(130, 30));
        PF_ThongBaoSoLuongThuocThap_JToggleButton.setMinimumSize(new java.awt.Dimension(130, 30));
        PF_ThongBaoSoLuongThuocThap_JToggleButton.setPreferredSize(new java.awt.Dimension(130, 30));
        PF_ThongBaoSoLuongThuocThap_JPanel.add(PF_ThongBaoSoLuongThuocThap_JToggleButton);

        getContentPane().add(PF_ThongBaoSoLuongThuocThap_JPanel);

        PF_CacNutThongBao_JPanel.setBackground(new Color(0,0,0,0));
        PF_CacNutThongBao_JPanel.setForeground(Color.decode("#7f8c8d"));
        PF_CacNutThongBao_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PF_CacNutThongBao_JLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PF_CacNutThongBao_JLabel.setText("Các nút thông báo");
        PF_CacNutThongBao_JLabel.setMaximumSize(new java.awt.Dimension(420, 30));
        PF_CacNutThongBao_JLabel.setMinimumSize(new java.awt.Dimension(420, 30));
        PF_CacNutThongBao_JLabel.setPreferredSize(new java.awt.Dimension(420, 30));
        PF_CacNutThongBao_JPanel.add(PF_CacNutThongBao_JLabel);

        getContentPane().add(PF_CacNutThongBao_JPanel);

        PF_DongY_JPanel.setBackground(new Color(0,0,0,0));
        PF_DongY_JPanel.setForeground(Color.decode("#7f8c8d"));
        PF_DongY_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PF_DongY_JLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PF_DongY_JLabel.setText("Đồng ý");
        PF_DongY_JLabel.setMaximumSize(new java.awt.Dimension(420, 30));
        PF_DongY_JLabel.setMinimumSize(new java.awt.Dimension(420, 30));
        PF_DongY_JLabel.setPreferredSize(new java.awt.Dimension(420, 30));
        PF_DongY_JPanel.add(PF_DongY_JLabel);

        PF_DongY_JToggleButton.setText("Y/N");
        PF_DongY_JToggleButton.setMaximumSize(new java.awt.Dimension(130, 30));
        PF_DongY_JToggleButton.setMinimumSize(new java.awt.Dimension(130, 30));
        PF_DongY_JToggleButton.setPreferredSize(new java.awt.Dimension(130, 30));
        PF_DongY_JPanel.add(PF_DongY_JToggleButton);

        getContentPane().add(PF_DongY_JPanel);

        PF_BoQua_JPanel.setBackground(new Color(0,0,0,0));
        PF_BoQua_JPanel.setForeground(Color.decode("#7f8c8d"));
        PF_BoQua_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PF_BoQua_JLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PF_BoQua_JLabel.setText("Bỏ qua");
        PF_BoQua_JLabel.setMaximumSize(new java.awt.Dimension(420, 30));
        PF_BoQua_JLabel.setMinimumSize(new java.awt.Dimension(420, 30));
        PF_BoQua_JLabel.setPreferredSize(new java.awt.Dimension(420, 30));
        PF_BoQua_JPanel.add(PF_BoQua_JLabel);

        PF_BoQua_JToggleButton.setText("Y/N");
        PF_BoQua_JToggleButton.setMaximumSize(new java.awt.Dimension(130, 30));
        PF_BoQua_JToggleButton.setMinimumSize(new java.awt.Dimension(130, 30));
        PF_BoQua_JToggleButton.setPreferredSize(new java.awt.Dimension(130, 30));
        PF_BoQua_JPanel.add(PF_BoQua_JToggleButton);

        getContentPane().add(PF_BoQua_JPanel);

        PF_LuuCaiDat_JButton.setBackground(Color.decode("#7f8c8d"));
        PF_LuuCaiDat_JButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PF_LuuCaiDat_JButton.setText("Lưu cài đặt");
        PF_LuuCaiDat_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PF_LuuCaiDat_JButtonActionPerformed(evt);
            }
        });
        getContentPane().add(PF_LuuCaiDat_JButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PF_LuuCaiDat_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PF_LuuCaiDat_JButtonActionPerformed
        SettingObject so = new SettingObject(
				PF_TuDongMoKhiDangNhap_JToggleButton.isSelected(),
				PF_TuDongXoaLichSu_JToggleButton.isSelected(),
				PF_ThongBaoSoLuongThuocThap_JToggleButton.isSelected(),
				PF_DongY_JToggleButton.isSelected(),
				PF_BoQua_JToggleButton.isSelected()
		);
		so.writeJSON();
		this.mf.setVisible(true);
		this.dispose();
    }//GEN-LAST:event_PF_LuuCaiDat_JButtonActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PreferencesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreferencesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreferencesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreferencesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreferencesFrame(mf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PF_BoQua_JLabel;
    private javax.swing.JPanel PF_BoQua_JPanel;
    private javax.swing.JToggleButton PF_BoQua_JToggleButton;
    private javax.swing.JLabel PF_CacNutThongBao_JLabel;
    private javax.swing.JPanel PF_CacNutThongBao_JPanel;
    private javax.swing.JLabel PF_CatDat_JLabel;
    private javax.swing.JLabel PF_DongY_JLabel;
    private javax.swing.JPanel PF_DongY_JPanel;
    private javax.swing.JToggleButton PF_DongY_JToggleButton;
    private javax.swing.JButton PF_LuuCaiDat_JButton;
    private javax.swing.JLabel PF_ThongBaoSoLuongThuocThap_JLabel;
    private javax.swing.JPanel PF_ThongBaoSoLuongThuocThap_JPanel;
    private javax.swing.JToggleButton PF_ThongBaoSoLuongThuocThap_JToggleButton;
    private javax.swing.JLabel PF_TuDongMoKhiDangNhap_JLabel;
    private javax.swing.JPanel PF_TuDongMoKhiDangNhap_JPanel;
    private javax.swing.JToggleButton PF_TuDongMoKhiDangNhap_JToggleButton;
    private javax.swing.JLabel PF_TuDongXoaLichSu_JLabel;
    private javax.swing.JPanel PF_TuDongXoaLichSu_JPanel;
    private javax.swing.JToggleButton PF_TuDongXoaLichSu_JToggleButton;
    // End of variables declaration//GEN-END:variables
}

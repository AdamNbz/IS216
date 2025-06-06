/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userview;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import object.UserObject;

/**
 *
 * @author Hinno
 */
public class AccountInformationFrame extends javax.swing.JFrame {
	public static MainFrame mf;
    /**
     * Creates new form CreateAccountFrame
     */
    public AccountInformationFrame(MainFrame mf) {
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
		loadData();
        this.setFrameInCenter();
        this.setVisible(true);
    }
	
	private void loadData() {
		UserObject uo = new UserObject();
		uo.readJSON("/home/shanghuang/SMM_STO_" + mf.UserName + "/UO/UserObject.json");
		AIF_TenTaiKhoan_JTextField.setText(uo.getIdenName());
		AIF_HoTen_JTextField.setText(uo.getUserName());
		AIF_Email_JTextField.setText(uo.getEmail());
		AIF_Tuoi_JSpinner.setValue(uo.getTuoi());
		AIF_KhuVucSinhSong_JComboBox.setSelectedItem(uo.getKVucSinhSong());
		AIF_TienSuBenhLy_JTextArea.insert(uo.getTienSuBenhLy(), 0);
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

        AIF_TaoTaiKhoan_JLabel = new javax.swing.JLabel();
        AIF_TenTaiKhoan_JL_JTF_JPanel = new javax.swing.JPanel();
        AIF_TenTaiKhoan_JLabel = new javax.swing.JLabel();
        AIF_TenTaiKhoan_JTextField = new javax.swing.JTextField();
        AIF_HoTen_JL_JTF_JPanel = new javax.swing.JPanel();
        AIF_HoTen_JLabel = new javax.swing.JLabel();
        AIF_HoTen_JTextField = new javax.swing.JTextField();
        AIF_Email_JL_JTF_JPanel = new javax.swing.JPanel();
        AIF_Email_JLabel = new javax.swing.JLabel();
        AIF_Email_JTextField = new javax.swing.JTextField();
        AIF_Tuoi_JL_JS_JPanel = new javax.swing.JPanel();
        AIF_Tuoi_JLabel = new javax.swing.JLabel();
        AIF_Tuoi_JSpinner = new javax.swing.JSpinner();
        AIF_KhuVucSinhSong_JL_JCB_JPanel = new javax.swing.JPanel();
        AIF_KhuVucSinhSong_JLabel = new javax.swing.JLabel();
        AIF_KhuVucSinhSong_JComboBox = new javax.swing.JComboBox<>();
        AIF_TienSuBenhLy_JL_JTA_JPanel = new javax.swing.JPanel();
        AIF_TienSuBenhLy_JLabel = new javax.swing.JLabel();
        AIF_TienSuBenhLy_JScrollPane = new javax.swing.JScrollPane();
        AIF_TienSuBenhLy_JTextArea = new javax.swing.JTextArea();
        AIF_ThanhChucNang_JPanel = new javax.swing.JPanel();
        AIF_CapNhat_JButton = new javax.swing.JButton();
        AIF_TroVe_JButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(630, 600));
        setMinimumSize(new java.awt.Dimension(630, 600));
        setPreferredSize(new java.awt.Dimension(630, 600));
        setResizable(false);

        AIF_TaoTaiKhoan_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 36)); // NOI18N
        AIF_TaoTaiKhoan_JLabel.setText("TÀI KHOẢN");
        AIF_TaoTaiKhoan_JLabel.setPreferredSize(new java.awt.Dimension(200, 50));

        AIF_TenTaiKhoan_JL_JTF_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        AIF_TenTaiKhoan_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_TenTaiKhoan_JLabel.setText("Tên tài khoản:");
        AIF_TenTaiKhoan_JLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        AIF_TenTaiKhoan_JLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        AIF_TenTaiKhoan_JLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        AIF_TenTaiKhoan_JL_JTF_JPanel.add(AIF_TenTaiKhoan_JLabel);

        AIF_TenTaiKhoan_JTextField.setFont(new java.awt.Font("SF Mono SemiBold", 0, 14)); // NOI18N
        AIF_TenTaiKhoan_JTextField.setEnabled(false);
        AIF_TenTaiKhoan_JTextField.setMaximumSize(new java.awt.Dimension(400, 30));
        AIF_TenTaiKhoan_JTextField.setMinimumSize(new java.awt.Dimension(400, 30));
        AIF_TenTaiKhoan_JTextField.setPreferredSize(new java.awt.Dimension(400, 30));
        AIF_TenTaiKhoan_JL_JTF_JPanel.add(AIF_TenTaiKhoan_JTextField);

        AIF_HoTen_JL_JTF_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        AIF_HoTen_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_HoTen_JLabel.setText("Họ tên:");
        AIF_HoTen_JLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        AIF_HoTen_JLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        AIF_HoTen_JLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        AIF_HoTen_JL_JTF_JPanel.add(AIF_HoTen_JLabel);

        AIF_HoTen_JTextField.setFont(new java.awt.Font("SF Mono SemiBold", 0, 14)); // NOI18N
        AIF_HoTen_JTextField.setMaximumSize(new java.awt.Dimension(400, 30));
        AIF_HoTen_JTextField.setMinimumSize(new java.awt.Dimension(400, 30));
        AIF_HoTen_JTextField.setPreferredSize(new java.awt.Dimension(400, 30));
        AIF_HoTen_JL_JTF_JPanel.add(AIF_HoTen_JTextField);

        AIF_Email_JL_JTF_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        AIF_Email_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_Email_JLabel.setText("Email:");
        AIF_Email_JLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        AIF_Email_JLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        AIF_Email_JLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        AIF_Email_JL_JTF_JPanel.add(AIF_Email_JLabel);

        AIF_Email_JTextField.setFont(new java.awt.Font("SF Mono SemiBold", 0, 14)); // NOI18N
        AIF_Email_JTextField.setMaximumSize(new java.awt.Dimension(400, 30));
        AIF_Email_JTextField.setMinimumSize(new java.awt.Dimension(400, 30));
        AIF_Email_JTextField.setPreferredSize(new java.awt.Dimension(400, 30));
        AIF_Email_JL_JTF_JPanel.add(AIF_Email_JTextField);

        AIF_Tuoi_JL_JS_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        AIF_Tuoi_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_Tuoi_JLabel.setText("Tuổi:");
        AIF_Tuoi_JLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        AIF_Tuoi_JLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        AIF_Tuoi_JLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        AIF_Tuoi_JL_JS_JPanel.add(AIF_Tuoi_JLabel);

        AIF_Tuoi_JSpinner.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_Tuoi_JSpinner.setMaximumSize(new java.awt.Dimension(100, 30));
        AIF_Tuoi_JSpinner.setMinimumSize(new java.awt.Dimension(100, 30));
        AIF_Tuoi_JSpinner.setPreferredSize(new java.awt.Dimension(100, 30));
        AIF_Tuoi_JL_JS_JPanel.add(AIF_Tuoi_JSpinner);

        AIF_KhuVucSinhSong_JL_JCB_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        AIF_KhuVucSinhSong_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_KhuVucSinhSong_JLabel.setText("Khu vực sinh sống:");
        AIF_KhuVucSinhSong_JLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        AIF_KhuVucSinhSong_JLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        AIF_KhuVucSinhSong_JLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        AIF_KhuVucSinhSong_JL_JCB_JPanel.add(AIF_KhuVucSinhSong_JLabel);

        AIF_KhuVucSinhSong_JComboBox.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_KhuVucSinhSong_JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Miền Bắc", "Miền Trung", "Miền Nam", " " }));
        AIF_KhuVucSinhSong_JComboBox.setMaximumSize(new java.awt.Dimension(170, 30));
        AIF_KhuVucSinhSong_JComboBox.setMinimumSize(new java.awt.Dimension(170, 30));
        AIF_KhuVucSinhSong_JComboBox.setPreferredSize(new java.awt.Dimension(170, 30));
        AIF_KhuVucSinhSong_JL_JCB_JPanel.add(AIF_KhuVucSinhSong_JComboBox);

        AIF_TienSuBenhLy_JL_JTA_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        AIF_TienSuBenhLy_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_TienSuBenhLy_JLabel.setText("Tiền sử bệnh lý:");
        AIF_TienSuBenhLy_JLabel.setMaximumSize(new java.awt.Dimension(200, 30));
        AIF_TienSuBenhLy_JLabel.setMinimumSize(new java.awt.Dimension(200, 30));
        AIF_TienSuBenhLy_JLabel.setPreferredSize(new java.awt.Dimension(200, 30));
        AIF_TienSuBenhLy_JL_JTA_JPanel.add(AIF_TienSuBenhLy_JLabel);

        AIF_TienSuBenhLy_JScrollPane.setMaximumSize(new java.awt.Dimension(400, 100));
        AIF_TienSuBenhLy_JScrollPane.setMinimumSize(new java.awt.Dimension(400, 100));
        AIF_TienSuBenhLy_JScrollPane.setPreferredSize(new java.awt.Dimension(400, 100));

        AIF_TienSuBenhLy_JTextArea.setColumns(20);
        AIF_TienSuBenhLy_JTextArea.setRows(5);
        AIF_TienSuBenhLy_JTextArea.setMaximumSize(new java.awt.Dimension(400, 100));
        AIF_TienSuBenhLy_JTextArea.setMinimumSize(new java.awt.Dimension(400, 100));
        AIF_TienSuBenhLy_JTextArea.setPreferredSize(new java.awt.Dimension(400, 100));
        AIF_TienSuBenhLy_JScrollPane.setViewportView(AIF_TienSuBenhLy_JTextArea);

        AIF_TienSuBenhLy_JL_JTA_JPanel.add(AIF_TienSuBenhLy_JScrollPane);

        AIF_ThanhChucNang_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        AIF_CapNhat_JButton.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_CapNhat_JButton.setText("Cập nhật");
        AIF_CapNhat_JButton.setToolTipText("Nếu không nhấn cập nhật mà trở về thì toàn bộ thông tin đã sửa chữa sẽ không được lưu");
        AIF_CapNhat_JButton.setMaximumSize(new java.awt.Dimension(150, 30));
        AIF_CapNhat_JButton.setMinimumSize(new java.awt.Dimension(150, 30));
        AIF_CapNhat_JButton.setPreferredSize(new java.awt.Dimension(150, 30));
        AIF_ThanhChucNang_JPanel.add(AIF_CapNhat_JButton);

        AIF_TroVe_JButton.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        AIF_TroVe_JButton.setText("Trở về");
        AIF_TroVe_JButton.setMaximumSize(new java.awt.Dimension(150, 30));
        AIF_TroVe_JButton.setMinimumSize(new java.awt.Dimension(150, 30));
        AIF_TroVe_JButton.setPreferredSize(new java.awt.Dimension(150, 30));
        AIF_TroVe_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AIF_TroVe_JButtonActionPerformed(evt);
            }
        });
        AIF_ThanhChucNang_JPanel.add(AIF_TroVe_JButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(AIF_TienSuBenhLy_JL_JTA_JPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AIF_KhuVucSinhSong_JL_JCB_JPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AIF_Tuoi_JL_JS_JPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AIF_Email_JL_JTF_JPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AIF_HoTen_JL_JTF_JPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(AIF_ThanhChucNang_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AIF_TenTaiKhoan_JL_JTF_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AIF_TaoTaiKhoan_JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AIF_TaoTaiKhoan_JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AIF_TenTaiKhoan_JL_JTF_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AIF_HoTen_JL_JTF_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AIF_Email_JL_JTF_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AIF_Tuoi_JL_JS_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AIF_KhuVucSinhSong_JL_JCB_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AIF_TienSuBenhLy_JL_JTA_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AIF_ThanhChucNang_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AIF_TroVe_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AIF_TroVe_JButtonActionPerformed
        // TODO add your handling code here:
		this.mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AIF_TroVe_JButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AuthenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthenticationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountInformationFrame(mf).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AIF_CapNhat_JButton;
    private javax.swing.JPanel AIF_Email_JL_JTF_JPanel;
    private javax.swing.JLabel AIF_Email_JLabel;
    private javax.swing.JTextField AIF_Email_JTextField;
    private javax.swing.JPanel AIF_HoTen_JL_JTF_JPanel;
    private javax.swing.JLabel AIF_HoTen_JLabel;
    private javax.swing.JTextField AIF_HoTen_JTextField;
    private javax.swing.JComboBox<String> AIF_KhuVucSinhSong_JComboBox;
    private javax.swing.JPanel AIF_KhuVucSinhSong_JL_JCB_JPanel;
    private javax.swing.JLabel AIF_KhuVucSinhSong_JLabel;
    private javax.swing.JLabel AIF_TaoTaiKhoan_JLabel;
    private javax.swing.JPanel AIF_TenTaiKhoan_JL_JTF_JPanel;
    private javax.swing.JLabel AIF_TenTaiKhoan_JLabel;
    private javax.swing.JTextField AIF_TenTaiKhoan_JTextField;
    private javax.swing.JPanel AIF_ThanhChucNang_JPanel;
    private javax.swing.JPanel AIF_TienSuBenhLy_JL_JTA_JPanel;
    private javax.swing.JLabel AIF_TienSuBenhLy_JLabel;
    private javax.swing.JScrollPane AIF_TienSuBenhLy_JScrollPane;
    private javax.swing.JTextArea AIF_TienSuBenhLy_JTextArea;
    private javax.swing.JButton AIF_TroVe_JButton;
    private javax.swing.JPanel AIF_Tuoi_JL_JS_JPanel;
    private javax.swing.JLabel AIF_Tuoi_JLabel;
    private javax.swing.JSpinner AIF_Tuoi_JSpinner;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userview;
import javax.swing.*;
import java.sql.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import supervisorview.*;
/**
 *
 * @author shanghuang
 */
public class AuthenticationFrame extends javax.swing.JFrame {

    /**
     * Creates new form AuthenticationFrame
     */
    public AuthenticationFrame() {
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
        initComponents();
        this.setVisible(true);
        this.setFrameInCenter();
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
        java.awt.GridBagConstraints gridBagConstraints;

        AF_Title_JLabel = new javax.swing.JLabel();
        AF_Subtitle_JLabel = new javax.swing.JLabel();
        AF_TenDangNhap_JTF_JL_JPanel = new javax.swing.JPanel();
        AF_TenDangNhap_JTextField = new javax.swing.JTextField();
        AF_TenDangNhap_JLabel = new javax.swing.JLabel();
        AF_MatKhau_JTF_JL_JPanel = new javax.swing.JPanel();
        AF_MatKhau_JPasswordField = new javax.swing.JPasswordField();
        AF_MatKhau_JLabel = new javax.swing.JLabel();
        AF_QuenMatKhau_JL_JB_JPanel = new javax.swing.JPanel();
        AF_QuenMatKhau_JLabel = new javax.swing.JLabel();
        AF_QuenMatKhau_JButton = new javax.swing.JButton();
        AF_KhongTaiKhoan_DangNhap_JL_JB_JPanel = new javax.swing.JPanel();
        AF_KhongTaiKhoan_JLabel = new javax.swing.JLabel();
        AF_KhongTaiKhoan_JButton = new javax.swing.JButton();
        AF_DangNhap_JButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        AF_Title_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 1, 36)); // NOI18N
        AF_Title_JLabel.setText("ỨNG DỤNG QUẢN LÝ DƯỢC PHẨM CÁ NHÂN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 133, 0, 143);
        getContentPane().add(AF_Title_JLabel, gridBagConstraints);

        AF_Subtitle_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 30)); // NOI18N
        AF_Subtitle_JLabel.setText("Đăng nhập tài khoản");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(86, 326, 0, 0);
        getContentPane().add(AF_Subtitle_JLabel, gridBagConstraints);

        AF_TenDangNhap_JTextField.setFont(new java.awt.Font("SF Mono SemiBold", 0, 30)); // NOI18N

        AF_TenDangNhap_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 30)); // NOI18N
        AF_TenDangNhap_JLabel.setText("Tên đăng nhập:");

        javax.swing.GroupLayout AF_TenDangNhap_JTF_JL_JPanelLayout = new javax.swing.GroupLayout(AF_TenDangNhap_JTF_JL_JPanel);
        AF_TenDangNhap_JTF_JL_JPanel.setLayout(AF_TenDangNhap_JTF_JL_JPanelLayout);
        AF_TenDangNhap_JTF_JL_JPanelLayout.setHorizontalGroup(
            AF_TenDangNhap_JTF_JL_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_TenDangNhap_JTF_JL_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AF_TenDangNhap_JLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AF_TenDangNhap_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        AF_TenDangNhap_JTF_JL_JPanelLayout.setVerticalGroup(
            AF_TenDangNhap_JTF_JL_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_TenDangNhap_JTF_JL_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AF_TenDangNhap_JTF_JL_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AF_TenDangNhap_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AF_TenDangNhap_JLabel))
                .addContainerGap())
        );

        AF_TenDangNhap_JTF_JL_JPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AF_TenDangNhap_JLabel, AF_TenDangNhap_JTextField});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 133, 0, 143);
        getContentPane().add(AF_TenDangNhap_JTF_JL_JPanel, gridBagConstraints);

        AF_MatKhau_JPasswordField.setFont(new java.awt.Font("SF Mono SemiBold", 0, 30)); // NOI18N

        AF_MatKhau_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 30)); // NOI18N
        AF_MatKhau_JLabel.setText("Mật khẩu:");

        javax.swing.GroupLayout AF_MatKhau_JTF_JL_JPanelLayout = new javax.swing.GroupLayout(AF_MatKhau_JTF_JL_JPanel);
        AF_MatKhau_JTF_JL_JPanel.setLayout(AF_MatKhau_JTF_JL_JPanelLayout);
        AF_MatKhau_JTF_JL_JPanelLayout.setHorizontalGroup(
            AF_MatKhau_JTF_JL_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_MatKhau_JTF_JL_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AF_MatKhau_JLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AF_MatKhau_JPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        AF_MatKhau_JTF_JL_JPanelLayout.setVerticalGroup(
            AF_MatKhau_JTF_JL_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_MatKhau_JTF_JL_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AF_MatKhau_JTF_JL_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AF_MatKhau_JPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AF_MatKhau_JLabel))
                .addContainerGap())
        );

        AF_MatKhau_JTF_JL_JPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AF_MatKhau_JLabel, AF_MatKhau_JPasswordField});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 133, 0, 143);
        getContentPane().add(AF_MatKhau_JTF_JL_JPanel, gridBagConstraints);

        AF_QuenMatKhau_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AF_QuenMatKhau_JLabel.setText("Quên mật khẩu");
        AF_QuenMatKhau_JLabel.setToolTipText("");

        AF_QuenMatKhau_JButton.setText("Nhấn vào đây");
        AF_QuenMatKhau_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AF_QuenMatKhau_JButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AF_QuenMatKhau_JL_JB_JPanelLayout = new javax.swing.GroupLayout(AF_QuenMatKhau_JL_JB_JPanel);
        AF_QuenMatKhau_JL_JB_JPanel.setLayout(AF_QuenMatKhau_JL_JB_JPanelLayout);
        AF_QuenMatKhau_JL_JB_JPanelLayout.setHorizontalGroup(
            AF_QuenMatKhau_JL_JB_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_QuenMatKhau_JL_JB_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AF_QuenMatKhau_JLabel)
                .addGap(39, 39, 39)
                .addComponent(AF_QuenMatKhau_JButton)
                .addContainerGap())
        );
        AF_QuenMatKhau_JL_JB_JPanelLayout.setVerticalGroup(
            AF_QuenMatKhau_JL_JB_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_QuenMatKhau_JL_JB_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AF_QuenMatKhau_JL_JB_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AF_QuenMatKhau_JLabel)
                    .addComponent(AF_QuenMatKhau_JButton))
                .addContainerGap())
        );

        AF_QuenMatKhau_JL_JB_JPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AF_QuenMatKhau_JButton, AF_QuenMatKhau_JLabel});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 550, 0, 143);
        getContentPane().add(AF_QuenMatKhau_JL_JB_JPanel, gridBagConstraints);

        AF_KhongTaiKhoan_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AF_KhongTaiKhoan_JLabel.setText("Chưa có tài khoản?");
        AF_KhongTaiKhoan_JLabel.setToolTipText("");

        AF_KhongTaiKhoan_JButton.setText("Nhấn vào đây");
        AF_KhongTaiKhoan_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AF_KhongTaiKhoan_JButtonActionPerformed(evt);
            }
        });

        AF_DangNhap_JButton.setText("ĐĂNG NHẬP");
        AF_DangNhap_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AF_DangNhap_JButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout = new javax.swing.GroupLayout(AF_KhongTaiKhoan_DangNhap_JL_JB_JPanel);
        AF_KhongTaiKhoan_DangNhap_JL_JB_JPanel.setLayout(AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout);
        AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.setHorizontalGroup(
            AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AF_KhongTaiKhoan_JLabel)
                .addGap(39, 39, 39)
                .addGroup(AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AF_DangNhap_JButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AF_KhongTaiKhoan_JButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.setVerticalGroup(
            AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AF_KhongTaiKhoan_JLabel)
                    .addComponent(AF_KhongTaiKhoan_JButton))
                .addGap(18, 18, 18)
                .addComponent(AF_DangNhap_JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AF_KhongTaiKhoan_DangNhap_JL_JB_JPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AF_KhongTaiKhoan_JButton, AF_KhongTaiKhoan_JLabel});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 500, 0, 143);
        getContentPane().add(AF_KhongTaiKhoan_DangNhap_JL_JB_JPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AF_DangNhap_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AF_DangNhap_JButtonActionPerformed
        // TODO add your handling code here:
        String TenDangNhapVariableHolder = AF_TenDangNhap_JTextField.getText();
        String MatKhauVariableHolder = new String(AF_MatKhau_JPasswordField.getPassword());
        
        // Mau code de test hoat dong chuc nang
        if (
                TenDangNhapVariableHolder.equals("HuynhThanhSang") &&
                MatKhauVariableHolder.equals("181105")
        ) {
//            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=password;encrypt=true;trustServerCertificate=true";
//            try {
//               Connection con = DriverManager.getConnection(connectionUrl); 
//            } // Handle any errors that may have occurred.
//            catch (SQLException se) {
//                System.out.println(se.getMessage());
//                this.dispose();
//            }
            
            
            JOptionPane.showMessageDialog(this, "Đăng nhập người dùng hợp lệ");
            this.dispose();
            MainFrame MF = new MainFrame();
        } else if (TenDangNhapVariableHolder.equals("admin") &&
                MatKhauVariableHolder.equals("admin")
        ) {
            JOptionPane.showMessageDialog(this, "Đăng nhập giám sát viên hợp lệ");
            this.dispose();
            MainSupervisorFrame MSF = new MainSupervisorFrame();
        } else {
            if (
                TenDangNhapVariableHolder.equals("") &&
                MatKhauVariableHolder.equals("")
            ) {
                JOptionPane.showMessageDialog(this, "Thông tin đăng nhập không được bỏ trống");
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập không hợp lệ");
                AF_TenDangNhap_JTextField.setText("");
                AF_MatKhau_JPasswordField.setText("");
            }
        }
    }//GEN-LAST:event_AF_DangNhap_JButtonActionPerformed

    private void AF_KhongTaiKhoan_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AF_KhongTaiKhoan_JButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        CreateAccountFrame CAF = new CreateAccountFrame();
    }//GEN-LAST:event_AF_KhongTaiKhoan_JButtonActionPerformed

    private void AF_QuenMatKhau_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AF_QuenMatKhau_JButtonActionPerformed
        // TODO add your handling code here:
        ForgotPasswordFrame FPF = new ForgotPasswordFrame();
    }//GEN-LAST:event_AF_QuenMatKhau_JButtonActionPerformed

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
                new AuthenticationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AF_DangNhap_JButton;
    private javax.swing.JPanel AF_KhongTaiKhoan_DangNhap_JL_JB_JPanel;
    private javax.swing.JButton AF_KhongTaiKhoan_JButton;
    private javax.swing.JLabel AF_KhongTaiKhoan_JLabel;
    private javax.swing.JLabel AF_MatKhau_JLabel;
    private javax.swing.JPasswordField AF_MatKhau_JPasswordField;
    private javax.swing.JPanel AF_MatKhau_JTF_JL_JPanel;
    private javax.swing.JButton AF_QuenMatKhau_JButton;
    private javax.swing.JPanel AF_QuenMatKhau_JL_JB_JPanel;
    private javax.swing.JLabel AF_QuenMatKhau_JLabel;
    private javax.swing.JLabel AF_Subtitle_JLabel;
    private javax.swing.JLabel AF_TenDangNhap_JLabel;
    private javax.swing.JPanel AF_TenDangNhap_JTF_JL_JPanel;
    private javax.swing.JTextField AF_TenDangNhap_JTextField;
    private javax.swing.JLabel AF_Title_JLabel;
    // End of variables declaration//GEN-END:variables
}

package view_ques1;
import java.awt.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import cacdanhdaden.lab5.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class SignInUpForm extends javax.swing.JFrame {
    private Selection s;
    /**
     * Creates new form SignInUpForm
     */
    int DEBUG = 1;
    
    public SignInUpForm(Selection s) {
        this.s = s;
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
            java.util.logging.Logger.getLogger(SignInUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpperPanel = new javax.swing.JPanel();
        UsernamePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UsernameField = new javax.swing.JTextField();
        PasswordPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        ConfirmPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ConfirmField = new javax.swing.JPasswordField();
        LowerPanel = new javax.swing.JPanel();
        SignInButton = new javax.swing.JButton();
        SignUpButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(362, 244));
        setResizable(false);

        UpperPanel.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Username");

        javax.swing.GroupLayout UsernamePanelLayout = new javax.swing.GroupLayout(UsernamePanel);
        UsernamePanel.setLayout(UsernamePanelLayout);
        UsernamePanelLayout.setHorizontalGroup(
            UsernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UsernameField)
                .addContainerGap())
        );
        UsernamePanelLayout.setVerticalGroup(
            UsernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsernamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(UsernamePanel);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Password");

        javax.swing.GroupLayout PasswordPanelLayout = new javax.swing.GroupLayout(PasswordPanel);
        PasswordPanel.setLayout(PasswordPanelLayout);
        PasswordPanelLayout.setHorizontalGroup(
            PasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasswordField)
                .addContainerGap())
        );
        PasswordPanelLayout.setVerticalGroup(
            PasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PasswordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(PasswordPanel);

        ConfirmPanel.setPreferredSize(new java.awt.Dimension(315, 52));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Confirm");

        javax.swing.GroupLayout ConfirmPanelLayout = new javax.swing.GroupLayout(ConfirmPanel);
        ConfirmPanel.setLayout(ConfirmPanelLayout);
        ConfirmPanelLayout.setHorizontalGroup(
            ConfirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmField)
                .addContainerGap())
        );
        ConfirmPanelLayout.setVerticalGroup(
            ConfirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConfirmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ConfirmField, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(ConfirmPanel);

        LowerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        SignInButton.setText("Sign in");
        SignInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButtonActionPerformed(evt);
            }
        });
        LowerPanel.add(SignInButton);

        SignUpButton.setText("Sign up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });
        LowerPanel.add(SignUpButton);

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        LowerPanel.add(CancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpperPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(LowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Connection connect() {
        // Connection parameter
        String dbURL = "jdbc:mysql://localhost:3306/QLSP";
        String driver = "com.mysql.jdbc.Driver";
        Connection con = null;
        
        // Catching error in connection
        try {
            // Class loader
            Class.forName(driver);
            
            // Connection
            con = DriverManager.getConnection(dbURL, "root", "181105");

            // Debug 
            if (con != null) {
                if (DEBUG == 1) {
                    System.out.println("Kết nối đến cơ sử dữ liệu thành công");
                }
            }
        } catch(SQLException se) { 
            // SQL Exception
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException ex) { 
            // Class Exception
            Logger.getLogger(SignInUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return connection
        if (con != null) {
            return con;
        } else {
            return null;
        }
    }
    
    private void SignInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInButtonActionPerformed
        // Select input text from UsernameField and PasswordField
        String Username = UsernameField.getText();
        String Password = new String(PasswordField.getPassword());
        
        // Debug
        if (DEBUG == 1) {
            System.out.println(Username);
            System.out.println(Password);
        }
        
        // Create connection
        Connection con = connect();
        
        if (con == null) {
            // Debug
            if (DEBUG == 1) {
                System.out.println("Không thể kết nối đến cơ sử dữ liệu");
            }
        } else {
            // Query
            boolean result = false;
            String query = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
            
            // Catching error in query execution
            try {
                // Load parameter in to query
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, Username);
                ps.setString(2, Password);
                
                // Execute and return boolean value
                result = ps.execute();
                con.close();
            } catch (SQLException se) {
                // SQL Exception
                System.out.println(se.getMessage());
            }

            if (result == false) {
                // Error display
                JOptionPane.showMessageDialog(this, "Đăng nhập không thành công. Vui lòng nhập lại", "Error", JOptionPane.ERROR_MESSAGE);
                
                // Debug
                if (DEBUG == 1) {
                    System.out.println("No user found");
                }
            } else {
                // Success display
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Debug
                if (DEBUG == 1) {
                    System.out.println("User found");
                }
            }
        }
    }//GEN-LAST:event_SignInButtonActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        // Select input text from UsernameField, PasswordField and ConfirmField
        String Username = UsernameField.getText();
        String Password = new String(PasswordField.getPassword());
        String Confirm = new String(ConfirmField.getPassword());
        
        // Debug
        if (DEBUG == 1) {
            System.out.println(Username);
            System.out.println(Password);
            System.out.println(Confirm);
        }
        
        // Check Confirm vs Password
        if (Confirm.contentEquals(Password) == false) {
            JOptionPane.showMessageDialog(this, "Mật khẩu và Xác nhận mật khẩu không giống. Vui lòng nhập lại", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Create connection
            Connection con = connect();
            
            if (con == null) {
                // Debug
                if (DEBUG == 1) {
                    System.out.println("Không thể kết nối đến cơ sử dữ liệu");
                }   
            } else {
                // Query
                boolean result = false;
                String query = "INSERT INTO USER VALUE (?, ?)";
                
                // Catching error in query execution
                try {
                    // Load parameter in to query
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, Username);
                    ps.setString(2, Password);
                    
                    // Execute and return boolean value
                    ps.executeUpdate();
                    result = true;
                    con.close();
                } catch (SQLException se) {
                    // SQL Exception
                    System.out.println(se.getMessage());
                }

                if (result == false) {
                    // Error display
                    JOptionPane.showMessageDialog(this, "Không thể đăng ký tài khoản. Vui lòng thử lại", "Error", JOptionPane.ERROR_MESSAGE);
                    
                    // Debug
                    if (DEBUG == 1) {
                        System.out.println("Fail");
                    }
                } else {
                    // Success display
                    JOptionPane.showMessageDialog(this, "Bạn đã đăng ký tài khoản thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Debug
                    if (DEBUG == 1) {
                        System.out.println("Sucess");
                    }
                }
            } 
        }
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.s.setVisible(true);
        // Exit the program
        this.setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JPasswordField ConfirmField;
    private javax.swing.JPanel ConfirmPanel;
    private javax.swing.JPanel LowerPanel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JPanel PasswordPanel;
    private javax.swing.JButton SignInButton;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JPanel UpperPanel;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JPanel UsernamePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

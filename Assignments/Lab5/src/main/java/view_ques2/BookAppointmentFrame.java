package view_ques2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class BookAppointmentFrame extends javax.swing.JFrame {
    private MainFrame mf;
    int DEBUG = 1;
    /**
     * Creates new form BookAppointmentFrame
     */
    public BookAppointmentFrame(MainFrame mf) {
        this.mf = mf;
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
            java.util.logging.Logger.getLogger(BookAppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        loadingBSiName();
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
        MaBNPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        MaBNInput = new javax.swing.JTextField();
        TenBNPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TenBNInput = new javax.swing.JTextField();
        NgKhamPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        NgKhamInput = new com.toedter.calendar.JDateChooser();
        YCauPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        YCauInput = new javax.swing.JTextField();
        BSiPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        BSiInput = new javax.swing.JComboBox<>();
        LowerPanel = new javax.swing.JPanel();
        DatLichKhamPanel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpperPanel.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jLabel1.setText("Mã bệnh nhân");
        jLabel1.setPreferredSize(new java.awt.Dimension(140, 20));

        MaBNInput.setText("Mã bệnh nhân");
        MaBNInput.setPreferredSize(new java.awt.Dimension(218, 48));
        MaBNInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaBNInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MaBNPanelLayout = new javax.swing.GroupLayout(MaBNPanel);
        MaBNPanel.setLayout(MaBNPanelLayout);
        MaBNPanelLayout.setHorizontalGroup(
            MaBNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaBNPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaBNInput, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );
        MaBNPanelLayout.setVerticalGroup(
            MaBNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MaBNPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MaBNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MaBNInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(MaBNPanel);

        jLabel2.setText("Tên bệnh nhân");
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 20));

        TenBNInput.setText("Tên bệnh nhân");
        TenBNInput.setEnabled(false);
        TenBNInput.setPreferredSize(new java.awt.Dimension(218, 48));

        javax.swing.GroupLayout TenBNPanelLayout = new javax.swing.GroupLayout(TenBNPanel);
        TenBNPanel.setLayout(TenBNPanelLayout);
        TenBNPanelLayout.setHorizontalGroup(
            TenBNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TenBNPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TenBNInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TenBNPanelLayout.setVerticalGroup(
            TenBNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TenBNPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TenBNPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TenBNInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(TenBNPanel);

        jLabel3.setText("Ngày khám");
        jLabel3.setPreferredSize(new java.awt.Dimension(140, 20));

        NgKhamInput.setPreferredSize(new java.awt.Dimension(218, 48));

        javax.swing.GroupLayout NgKhamPanelLayout = new javax.swing.GroupLayout(NgKhamPanel);
        NgKhamPanel.setLayout(NgKhamPanelLayout);
        NgKhamPanelLayout.setHorizontalGroup(
            NgKhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NgKhamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NgKhamInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        NgKhamPanelLayout.setVerticalGroup(
            NgKhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NgKhamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NgKhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NgKhamInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(NgKhamPanel);

        jLabel4.setText("Yêu cầu khám");
        jLabel4.setPreferredSize(new java.awt.Dimension(140, 20));

        YCauInput.setText("Yêu cầu khám");
        YCauInput.setPreferredSize(new java.awt.Dimension(218, 48));

        javax.swing.GroupLayout YCauPanelLayout = new javax.swing.GroupLayout(YCauPanel);
        YCauPanel.setLayout(YCauPanelLayout);
        YCauPanelLayout.setHorizontalGroup(
            YCauPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YCauPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(YCauInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        YCauPanelLayout.setVerticalGroup(
            YCauPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YCauPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(YCauPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YCauInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(YCauPanel);

        jLabel5.setText("Bác sĩ khám");
        jLabel5.setPreferredSize(new java.awt.Dimension(140, 20));

        BSiInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên bác sĩ" }));
        BSiInput.setPreferredSize(new java.awt.Dimension(218, 48));

        javax.swing.GroupLayout BSiPanelLayout = new javax.swing.GroupLayout(BSiPanel);
        BSiPanel.setLayout(BSiPanelLayout);
        BSiPanelLayout.setHorizontalGroup(
            BSiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BSiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BSiInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BSiPanelLayout.setVerticalGroup(
            BSiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BSiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BSiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BSiInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        UpperPanel.add(BSiPanel);

        DatLichKhamPanel.setText("Đặt lịch khám");
        DatLichKhamPanel.setPreferredSize(new java.awt.Dimension(180, 50));
        DatLichKhamPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatLichKhamPanelActionPerformed(evt);
            }
        });
        LowerPanel.add(DatLichKhamPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpperPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Connection connect() {
        // Connection parameter
        String dbURL = "jdbc:mysql://localhost:3306/QLKB";
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
            Logger.getLogger(BookAppointmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return connection
        if (con != null) {
            return con;
        } else {
            return null;
        }
    }
    
    private void loadingBSiName() {
        ResultSet rs = null;
        List<String> list = new ArrayList<>();
        
        // Create connection
        Connection con = connect();
        
        if (con == null) {
            // Debug
            if (DEBUG == 1) {
                System.out.println("Không thể kết nối đến cơ sử dữ liệu");
            }   
        } else {
            // Query
            String query = "SELECT BACSI.TENBS FROM BACSI";

            // Catching error in query execution
            try {
                // Load parameter in to query
                PreparedStatement ps = con.prepareStatement(query);

                // Execute and return boolean value
                rs = ps.executeQuery();
                
                if (rs.isBeforeFirst()) {
                    BSiInput.removeAllItems();
                    
                    while (rs.next() == true) {
                        list.add(rs.getString("TENBS"));
                    }
                    
                    if (DEBUG == 1) {
                        for (String bsi: list) {
                            System.out.println(bsi);
                        }
                    }
                    
                    
                    for (String bsi: list) {
                        BSiInput.addItem(bsi);
                    }
                    
                    // Debug
                    if (DEBUG == 1) {
                        System.out.println("Sucess");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Không tải được danh sách bác sĩ", "Error", JOptionPane.ERROR_MESSAGE);
                    
                    // Debug
                    if (DEBUG == 1) {
                        System.out.println("Fail");
                    }
                }

                con.close();
            } catch (SQLException se) {
                // SQL Exception
                System.out.println(se.getMessage());
                se.printStackTrace();
            }
        }
    }
    
    private String loadMABS(Connection con, String Bsi) {
        ResultSet rs = null;
        boolean check = false;
        String query = "SELECT BACSI.MABS FROM BACSI WHERE BACSI.TENBS = ?";

        // Catching error in query execution
        try {
            // Load parameter in to query
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Bsi);

            // Execute and return boolean value
            rs = ps.executeQuery();

            if (rs.next()) {
                Bsi = rs.getString("MABS");
            }

            check = true;
        } catch (SQLException se) {
            // SQL Exception
            System.out.println(se.getMessage());
        }

        if (check == false) {
            // Debug
            if (DEBUG == 1) {
                System.out.println("Fail");
            }
        } else {
            // Debug
            if (DEBUG == 1) {
                System.out.println("Sucess");
            }
        }
        return Bsi;
    }
    
    private void DatLichKhamPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatLichKhamPanelActionPerformed
        String MaBN = MaBNInput.getText();
        String TenBN = TenBNInput.getText();
        
        if (TenBN.contentEquals("Bệnh nhân chưa đăng ký")) {
            JOptionPane.showMessageDialog(this, "Bệnh nhân chưa đăng ký", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            NgKhamInput.setDateFormatString("y-M-d");
            Date NgKham = NgKhamInput.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date NgHienTai = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            if (DEBUG == 1) {
                System.out.println(NgHienTai);
                System.out.println(NgKham);
            }
            
            if (NgKham.before(NgHienTai)) {
                JOptionPane.showMessageDialog(this, "Ngày khám phải sau ngày hiện tại", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String YCau = YCauInput.getText();
                String Bsi = BSiInput.getSelectedItem().toString();
                
                if (DEBUG == 1) {
                    System.out.println(MaBN);
                    System.out.println(TenBN);
                    System.out.println(NgKham);
                    System.out.println(YCau);
                    System.out.println(Bsi);
                }

                // Create connection
                Connection con = connect();
                
                if (con == null) {
                    // Debug
                    if (DEBUG == 1) {
                        System.out.println("Không thể kết nối đến cơ sử dữ liệu");
                    }   
                } else {
                    Bsi = loadMABS(con, Bsi);
                    
                    KhamBenh kb = new KhamBenh(MaBN, TenBN, YCau, Bsi, NgKham);
                    
                    // Query
                    boolean result = false;
                    Random rand = new Random();
                    int num = 1000 + rand.nextInt(9000);
                    String query2 = "INSERT INTO KHAMBENH VALUE (\"KB" + Integer.toString(num) + "\", ?, ?, ?, ?, NULL, false)";

                    // Catching error in query execution
                    try {
                        // Load parameter in to query
                        PreparedStatement ps = con.prepareStatement(query2);
                        ps.setString(1, kb.getInfo(1).toString());
                        ps.setString(2, kb.getInfo(2).toString());
                        ps.setString(3, formatter.format(NgKham));
                        ps.setString(4, kb.getInfo(4).toString());

                        // Execute and return boolean value
                        ps.executeUpdate();
                        result = true;
                        con.close();
                    } catch (SQLException se) {
                        // SQL Exception
                        System.out.println(se.getMessage());
                    }
                }
                DetailBookAppointmentFrame dbaf = new DetailBookAppointmentFrame(mf);
                this.dispose();
            }
        }
    }//GEN-LAST:event_DatLichKhamPanelActionPerformed

    private void MaBNInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaBNInputActionPerformed
        String MaBN = MaBNInput.getText();
        String TenBN = null;
        ResultSet rs = null;
        
        if (DEBUG == 1) {
            System.out.println(MaBN);
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
            String query = "SELECT BENHNHAN.MABN, BENHNHAN.TENBN FROM BENHNHAN WHERE BENHNHAN.MABN = ?";

            // Catching error in query execution
            try {
                // Load parameter in to query
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, MaBN);

                // Execute and return boolean value
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    TenBN = rs.getString("TENBN");
                    
                    // Debug
                    if (DEBUG == 1) {
                        System.out.println("Sucess");
                    }
                } else {
                    TenBN = "Bệnh nhân chưa đăng ký";
                    
                    // Debug
                    if (DEBUG == 1) {
                        System.out.println("Fail");
                    }
                }
                
                TenBNInput.setText(TenBN);
                
                con.close();
            } catch (SQLException se) {
                // SQL Exception
                System.out.println(se.getMessage());
                se.printStackTrace();
            }
        }
    }//GEN-LAST:event_MaBNInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BSiInput;
    private javax.swing.JPanel BSiPanel;
    private javax.swing.JButton DatLichKhamPanel;
    private javax.swing.JPanel LowerPanel;
    private javax.swing.JTextField MaBNInput;
    private javax.swing.JPanel MaBNPanel;
    private com.toedter.calendar.JDateChooser NgKhamInput;
    private javax.swing.JPanel NgKhamPanel;
    private javax.swing.JTextField TenBNInput;
    private javax.swing.JPanel TenBNPanel;
    private javax.swing.JPanel UpperPanel;
    private javax.swing.JTextField YCauInput;
    private javax.swing.JPanel YCauPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}

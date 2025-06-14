package view_ques2;

import java.awt.Dimension;
import java.awt.Toolkit;
import cacdanhdaden.lab5.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class MainFrame extends javax.swing.JFrame {
    private Selection s;
    /**
     * Creates new form MainFrame
     */
    public MainFrame(Selection s) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        ThemThongTinButton = new javax.swing.JButton();
        DatLichKhamButton = new javax.swing.JButton();
        ThanhToanButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        ThemThongTinButton.setText("Thêm thông tin bệnh nhân");
        ThemThongTinButton.setPreferredSize(new java.awt.Dimension(260, 50));
        ThemThongTinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemThongTinButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ThemThongTinButton);

        DatLichKhamButton.setText("Đặt lịch khám bệnh nhân");
        DatLichKhamButton.setPreferredSize(new java.awt.Dimension(260, 50));
        DatLichKhamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatLichKhamButtonActionPerformed(evt);
            }
        });
        jPanel1.add(DatLichKhamButton);

        ThanhToanButton.setText("Thanh toán tiền khám bệnh");
        ThanhToanButton.setPreferredSize(new java.awt.Dimension(260, 50));
        ThanhToanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThanhToanButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ThanhToanButton);

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ThemThongTinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemThongTinButtonActionPerformed
        AddInfoFrame aif = new AddInfoFrame(MainFrame.this);
        this.dispose();
    }//GEN-LAST:event_ThemThongTinButtonActionPerformed

    private void DatLichKhamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatLichKhamButtonActionPerformed
        BookAppointmentFrame baf = new BookAppointmentFrame(MainFrame.this);
        this.dispose();
    }//GEN-LAST:event_DatLichKhamButtonActionPerformed

    private void ThanhToanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThanhToanButtonActionPerformed
        PaymentFrame pf = new PaymentFrame(MainFrame.this);
        this.dispose();
    }//GEN-LAST:event_ThanhToanButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton DatLichKhamButton;
    private javax.swing.JButton ThanhToanButton;
    private javax.swing.JButton ThemThongTinButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

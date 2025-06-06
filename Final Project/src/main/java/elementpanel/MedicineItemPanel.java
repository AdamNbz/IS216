/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package elementpanel;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import object.MedicineObject;
import userview.EditMedicationFrame;
import userview.MainFrame;


/**
 *
 * @author shanghuang
 */
public class MedicineItemPanel extends javax.swing.JPanel {
	private MedicineObject mo;
	public MainFrame mf;
	/**
	 * Creates new form MedicineItemPanel
	 */
	public MedicineItemPanel(MainFrame mf) {
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
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MIP_TenThuoc_JLabel = new javax.swing.JLabel();
        MIP_Info_JPanel = new javax.swing.JPanel();
        MIP_Left_JPanel = new javax.swing.JPanel();
        MIP_DViThuoc_JLabel = new javax.swing.JLabel();
        MIP_GCThuoc_JLabel = new javax.swing.JLabel();
        MIP_UuTien_JLabel = new javax.swing.JLabel();
        MIP_SL_JLabel = new javax.swing.JLabel();
        MIP_Right_JPanel = new javax.swing.JPanel();
        MIP_Edit_JButton = new javax.swing.JButton();
        MIP_Delete_JButton = new javax.swing.JButton();
        MIP_Refill_JButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        setMaximumSize(new java.awt.Dimension(1041, 140));
        setMinimumSize(new java.awt.Dimension(1041, 140));
        setPreferredSize(new java.awt.Dimension(1041, 140));
        setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        MIP_TenThuoc_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 24)); // NOI18N
        MIP_TenThuoc_JLabel.setText("TenThuoc");
        MIP_TenThuoc_JLabel.setToolTipText("Tên thuốc");
        MIP_TenThuoc_JLabel.setMaximumSize(new java.awt.Dimension(1029, 54));
        MIP_TenThuoc_JLabel.setMinimumSize(new java.awt.Dimension(1029, 54));
        MIP_TenThuoc_JLabel.setPreferredSize(new java.awt.Dimension(1029, 54));
        add(MIP_TenThuoc_JLabel);

        MIP_Info_JPanel.setMaximumSize(new java.awt.Dimension(1029, 54));
        MIP_Info_JPanel.setMinimumSize(new java.awt.Dimension(1029, 54));
        MIP_Info_JPanel.setPreferredSize(new java.awt.Dimension(1029, 54));
        MIP_Info_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        MIP_Left_JPanel.setMaximumSize(new java.awt.Dimension(840, 40));
        MIP_Left_JPanel.setMinimumSize(new java.awt.Dimension(840, 40));
        MIP_Left_JPanel.setPreferredSize(new java.awt.Dimension(840, 40));
        MIP_Left_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        MIP_DViThuoc_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        MIP_DViThuoc_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MIP_DViThuoc_JLabel.setText("DonViThuoc");
        MIP_DViThuoc_JLabel.setToolTipText("Đơn vị thuốc");
        MIP_DViThuoc_JLabel.setMaximumSize(new java.awt.Dimension(150, 30));
        MIP_DViThuoc_JLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        MIP_DViThuoc_JLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        MIP_Left_JPanel.add(MIP_DViThuoc_JLabel);

        MIP_GCThuoc_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        MIP_GCThuoc_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MIP_GCThuoc_JLabel.setText("GhiChuThuoc");
        MIP_GCThuoc_JLabel.setToolTipText(MIP_GCThuoc_JLabel.getText());
        MIP_GCThuoc_JLabel.setMaximumSize(new java.awt.Dimension(400, 30));
        MIP_GCThuoc_JLabel.setMinimumSize(new java.awt.Dimension(400, 30));
        MIP_GCThuoc_JLabel.setPreferredSize(new java.awt.Dimension(400, 30));
        MIP_Left_JPanel.add(MIP_GCThuoc_JLabel);

        MIP_UuTien_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        MIP_UuTien_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MIP_UuTien_JLabel.setText("UuTien");
        MIP_UuTien_JLabel.setToolTipText("Mức độ ưu tiên thông báo");
        MIP_UuTien_JLabel.setMaximumSize(new java.awt.Dimension(180, 30));
        MIP_UuTien_JLabel.setMinimumSize(new java.awt.Dimension(180, 30));
        MIP_UuTien_JLabel.setPreferredSize(new java.awt.Dimension(180, 30));
        MIP_Left_JPanel.add(MIP_UuTien_JLabel);

        MIP_SL_JLabel.setFont(new java.awt.Font("SF Mono SemiBold", 0, 18)); // NOI18N
        MIP_SL_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MIP_SL_JLabel.setText("SL");
        MIP_SL_JLabel.setToolTipText("Số lượng thuốc hiện có");
        MIP_SL_JLabel.setMaximumSize(new java.awt.Dimension(90, 30));
        MIP_SL_JLabel.setMinimumSize(new java.awt.Dimension(90, 30));
        MIP_SL_JLabel.setPreferredSize(new java.awt.Dimension(90, 30));
        MIP_Left_JPanel.add(MIP_SL_JLabel);

        MIP_Info_JPanel.add(MIP_Left_JPanel);

        MIP_Right_JPanel.setMaximumSize(new java.awt.Dimension(200, 40));
        MIP_Right_JPanel.setMinimumSize(new java.awt.Dimension(200, 40));
        MIP_Right_JPanel.setPreferredSize(new java.awt.Dimension(200, 40));
        MIP_Right_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        MIP_Edit_JButton.setIcon(new javax.swing.ImageIcon("/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/image/edit.png")
        );
        MIP_Edit_JButton.setToolTipText("Chỉnh sửa thuốc");
        MIP_Edit_JButton.setBorder(null);
        MIP_Edit_JButton.setMaximumSize(new java.awt.Dimension(30, 30));
        MIP_Edit_JButton.setMinimumSize(new java.awt.Dimension(30, 30));
        MIP_Edit_JButton.setPreferredSize(new java.awt.Dimension(30, 30));
        MIP_Edit_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIP_Edit_JButtonActionPerformed(evt);
            }
        });
        MIP_Right_JPanel.add(MIP_Edit_JButton);

        MIP_Delete_JButton.setIcon(new javax.swing.ImageIcon("/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/image/delete.png"));
        MIP_Delete_JButton.setToolTipText("Xóa thuốc");
        MIP_Delete_JButton.setBorder(null);
        MIP_Delete_JButton.setMaximumSize(new java.awt.Dimension(30, 30));
        MIP_Delete_JButton.setMinimumSize(new java.awt.Dimension(30, 30));
        MIP_Delete_JButton.setPreferredSize(new java.awt.Dimension(30, 30));
        MIP_Delete_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIP_Delete_JButtonActionPerformed(evt);
            }
        });
        MIP_Right_JPanel.add(MIP_Delete_JButton);

        MIP_Refill_JButton.setIcon(new javax.swing.ImageIcon("/home/shanghuang/Documents/Study Vault/Subject Documentation/IS216/Practice documentations/Code Section/JavaMainProject/JavaMainProject/src/main/java/image/refill.png"));
        MIP_Refill_JButton.setToolTipText("Bổ sung số lượng thuốc");
        MIP_Refill_JButton.setBorder(null);
        MIP_Refill_JButton.setMaximumSize(new java.awt.Dimension(30, 30));
        MIP_Refill_JButton.setMinimumSize(new java.awt.Dimension(30, 30));
        MIP_Refill_JButton.setPreferredSize(new java.awt.Dimension(30, 30));
        MIP_Refill_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIP_Refill_JButtonActionPerformed(evt);
            }
        });
        MIP_Right_JPanel.add(MIP_Refill_JButton);

        MIP_Info_JPanel.add(MIP_Right_JPanel);

        add(MIP_Info_JPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void MIP_Edit_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIP_Edit_JButtonActionPerformed
        // TODO add your handling code here:
		EditMedicationFrame emf = new EditMedicationFrame(MedicineItemPanel.this, this.mf);
    }//GEN-LAST:event_MIP_Edit_JButtonActionPerformed

    private void MIP_Delete_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIP_Delete_JButtonActionPerformed
        String filePath = "/home/shanghuang/SMM_STO_" + mf.UserName + "/MO/MO_" + MIP_TenThuoc_JLabel.getText() + ".json" ;
		File fileToDelete = new File(filePath);
		if (fileToDelete.exists()) { // Kiểm tra xem file có tồn tại hay không
            boolean isDeleted = fileToDelete.delete(); // Xóa file

            if (isDeleted) {
                System.out.println("File " + filePath + " đã được xóa thành công.");
            } else {
                System.err.println("Không thể xóa file " + filePath + ".");
            }
        } else {
            System.err.println("File " + filePath + " không tồn tại.");
        }
		this.mf.refresh_call();
    }//GEN-LAST:event_MIP_Delete_JButtonActionPerformed

    private void MIP_Refill_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIP_Refill_JButtonActionPerformed
		int SL = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số lượng muốn bổ sung: ", "Lựa chọn ngày trong tuần", JOptionPane.QUESTION_MESSAGE, null, null, String.valueOf(0)).toString());
		this.mo.refill(SL);
		this.mo.writeJSON(mf.UserName);
		this.mf.refresh_call();
    }//GEN-LAST:event_MIP_Refill_JButtonActionPerformed

	public void loadData(
		MedicineObject mo
	) {
		this.mo = mo;
		MIP_TenThuoc_JLabel.setText(mo.getTenThuoc());
		MIP_DViThuoc_JLabel.setText(mo.getDonVi());
		
		MIP_GCThuoc_JLabel.setText(mo.getGhiChu());
		if (mo.isUuTienThongBao() == true) {
			MIP_UuTien_JLabel.setText("High priority");
		} else {
			MIP_UuTien_JLabel.setText("Low priority");
		}

		MIP_SL_JLabel.setText(String.valueOf(mo.getSLHienCo()));
	}
	
	public MedicineObject getMedicineObject() {
		return this.mo;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MIP_DViThuoc_JLabel;
    private javax.swing.JButton MIP_Delete_JButton;
    private javax.swing.JButton MIP_Edit_JButton;
    private javax.swing.JLabel MIP_GCThuoc_JLabel;
    private javax.swing.JPanel MIP_Info_JPanel;
    private javax.swing.JPanel MIP_Left_JPanel;
    private javax.swing.JButton MIP_Refill_JButton;
    private javax.swing.JPanel MIP_Right_JPanel;
    private javax.swing.JLabel MIP_SL_JLabel;
    private javax.swing.JLabel MIP_TenThuoc_JLabel;
    private javax.swing.JLabel MIP_UuTien_JLabel;
    // End of variables declaration//GEN-END:variables
}

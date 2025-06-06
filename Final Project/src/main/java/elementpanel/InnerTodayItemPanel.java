/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package elementpanel;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import object.TodayListItemObject;

/**
 *
 * @author shanghuang
 */
public class InnerTodayItemPanel extends javax.swing.JPanel {

	/**
	 * Creates new form InnerTodeyItemPanel
	 */
	public InnerTodayItemPanel() {
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
	
	public void setData(TodayListItemObject tlio) {
		ITIP_TenThuoc_JLabel.setText(tlio.getTenThuoc());
		ITIP_LieuSuDung_JLabel.setText(String.valueOf(tlio.getLieuSuDung())); 
		ITIP_GhiChu_JLabel.setText(tlio.getGhiChu());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ITIP_TenThuoc_JLabel = new javax.swing.JLabel();
        ITIP_LowerPanel_JPanel = new javax.swing.JPanel();
        ITIP_Info_JPanel = new javax.swing.JPanel();
        ITIP_LieuSuDung_JLabel = new javax.swing.JLabel();
        ITIP_GhiChu_JLabel = new javax.swing.JLabel();
        ITIP_Select_Panel = new javax.swing.JToggleButton();

        setMaximumSize(new java.awt.Dimension(1029, 100));
        setMinimumSize(new java.awt.Dimension(1017, 104));
        setLayout(new java.awt.GridLayout(2, 1, 5, 0));

        ITIP_TenThuoc_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ITIP_TenThuoc_JLabel.setText("Tên thuốc");
        ITIP_TenThuoc_JLabel.setMaximumSize(new java.awt.Dimension(1017, 30));
        ITIP_TenThuoc_JLabel.setMinimumSize(new java.awt.Dimension(1017, 30));
        ITIP_TenThuoc_JLabel.setPreferredSize(new java.awt.Dimension(1017, 30));
        add(ITIP_TenThuoc_JLabel);

        ITIP_LowerPanel_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        ITIP_Info_JPanel.setMaximumSize(new java.awt.Dimension(836, 42));
        ITIP_Info_JPanel.setMinimumSize(new java.awt.Dimension(836, 42));
        ITIP_Info_JPanel.setPreferredSize(new java.awt.Dimension(827, 42));
        ITIP_Info_JPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        ITIP_LieuSuDung_JLabel.setText("Liều");
        ITIP_LieuSuDung_JLabel.setMaximumSize(new java.awt.Dimension(100, 30));
        ITIP_LieuSuDung_JLabel.setMinimumSize(new java.awt.Dimension(100, 30));
        ITIP_LieuSuDung_JLabel.setPreferredSize(new java.awt.Dimension(100, 30));
        ITIP_Info_JPanel.add(ITIP_LieuSuDung_JLabel);

        ITIP_GhiChu_JLabel.setText("Ghi chú");
        ITIP_GhiChu_JLabel.setMaximumSize(new java.awt.Dimension(400, 30));
        ITIP_GhiChu_JLabel.setMinimumSize(new java.awt.Dimension(400, 30));
        ITIP_GhiChu_JLabel.setPreferredSize(new java.awt.Dimension(400, 30));
        ITIP_Info_JPanel.add(ITIP_GhiChu_JLabel);

        ITIP_LowerPanel_JPanel.add(ITIP_Info_JPanel);

        ITIP_Select_Panel.setText("Select");
        ITIP_Select_Panel.setMaximumSize(new java.awt.Dimension(170, 42));
        ITIP_Select_Panel.setMinimumSize(new java.awt.Dimension(170, 42));
        ITIP_Select_Panel.setPreferredSize(new java.awt.Dimension(170, 42));
        ITIP_LowerPanel_JPanel.add(ITIP_Select_Panel);

        add(ITIP_LowerPanel_JPanel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ITIP_GhiChu_JLabel;
    private javax.swing.JPanel ITIP_Info_JPanel;
    private javax.swing.JLabel ITIP_LieuSuDung_JLabel;
    private javax.swing.JPanel ITIP_LowerPanel_JPanel;
    private javax.swing.JToggleButton ITIP_Select_Panel;
    private javax.swing.JLabel ITIP_TenThuoc_JLabel;
    // End of variables declaration//GEN-END:variables
}

package cacdanhdaden.lab5;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class TEST {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Transfer Row Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            // Tạo JTableA
            String[] columnNamesA = {"Column 1", "Column 2", "Column 3"};
            DefaultTableModel modelA = new DefaultTableModel(columnNamesA, 0);
            JTable tableA = new JTable(modelA);
            modelA.addRow(new Object[]{"A1", "A2", "A3"});
            modelA.addRow(new Object[]{"B1", "B2", "B3"});
            modelA.addRow(new Object[]{"C1", "C2", "C3"});
            JScrollPane scrollPaneA = new JScrollPane(tableA);

            // Tạo JTableB
            String[] columnNamesB = {"Column 1", "Column 2", "Column 3"};
            DefaultTableModel modelB = new DefaultTableModel(columnNamesB, 0);
            JTable tableB = new JTable(modelB);
            JScrollPane scrollPaneB = new JScrollPane(tableB);

            // Thêm ListSelectionListener vào JTableA
            tableA.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    if (!event.getValueIsAdjusting()) {
                        int selectedRow = tableA.getSelectedRow();
                        if (selectedRow != -1) { // Đảm bảo có hàng được chọn
                            // Lấy dữ liệu từ hàng đã chọn
                            Object[] rowData = new Object[modelA.getColumnCount()];
                            for (int i = 0; i < modelA.getColumnCount(); i++) {
                                rowData[i] = modelA.getValueAt(selectedRow, i);
                            }

                            // Thêm dữ liệu vào JTableB
                            modelB.addRow(rowData);

                            // Xóa hàng đã chọn khỏi JTableA (tùy chọn)
                            modelA.removeRow(selectedRow);
                            // Khi xóa hàng, cần kiểm tra lại selectedRow để tránh IndexOutOfBoundsException
                            if (selectedRow >= modelA.getRowCount()) {
                                tableA.clearSelection(); // bỏ chọn nếu hàng cuối cùng bị xóa
                            } else {
                                tableA.setRowSelectionInterval(selectedRow, selectedRow); //Chọn lại hàng sau khi xóa (nếu có)
                            }

                        }
                    }
                }
            });

            // Thêm các JTable vào JFrame
            frame.add(new JLabel("JTable A"));
            frame.add(scrollPaneA);
            frame.add(new JLabel("JTable B"));
            frame.add(scrollPaneB);

            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

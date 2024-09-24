/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.My;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vinh
 */
public class DemoJTable extends JFrame {

    private JTable tblSanPham;
    private JButton btThem, btXoa;
    DefaultTableModel model;
    private JTextField txtMaSo, txtTen, txtGia;

    public DemoJTable(String title) {
        super(title);
        createGui();
        processEvent();
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        DemoJTable frm = new DemoJTable("Demo JTable");
        frm.setVisible(true);
    }

    private void createGui() {
        Object[][] data = {
            {"001", "Gạo", "45000"},
            {"002", "Đường", "47000"},};
        String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Gía bán"};
        model = new DefaultTableModel(data, columnNames);
        tblSanPham = new JTable(model);
        // tạo thành phần quản lý cuộn cho Jtable
        JScrollPane srcollTable = new JScrollPane(tblSanPham);
        JPanel p = new JPanel();
        p.add(new JLabel("Mã"));
        p.add(txtMaSo = new JTextField(5));
        p.add(new JLabel("Tên"));
        p.add(txtTen = new JTextField(10));
        p.add(new JLabel("Gía bán"));
        p.add(txtGia = new JTextField(10));
        p.add(btThem = new JButton("Thêm"));
        p.add(btXoa = new JButton("Xoá"));

        // add jtable ra cửa sổ
        add(srcollTable, BorderLayout.CENTER);
        add(p, BorderLayout.NORTH);
    }
//

    private void processEvent() {
        btThem.addActionListener((e) -> {
            String err = "";
            try {
                String masp = txtMaSo.getText();
                String tensp = txtTen.getText();

                if (masp.length() == 0) {
                    err = "Bạn chưa nhập mã sản phẩm";
                }
                if (tensp.length() == 0) {
                    err = "\nBạn chưa nhập tên";
                }
                double gia = Double.parseDouble(txtGia.getText());
                if (err.length() > 0) {
                    JOptionPane.showConfirmDialog(this, err, "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                model.addRow(new Object[]{masp, tensp, gia});
            } catch (Exception ex) {
                err += "\nNhập sai kiểu giá bán";
                JOptionPane.showConfirmDialog(this, err, "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        );
        btXoa.addActionListener((e) -> {
            // lấy chỉ số dòng được chọn trong jtable
            int selectedIndex = tblSanPham.getSelectedRow();
            // kiểm tra nếu có dòng nào được chọn
            if (selectedIndex >= 0) {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // xóa dòng dữ liệu tương ứng
                    model.removeRow(selectedIndex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn dòng cần xóa");
            }
        });

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Vinh
 */
public class DemoJCombobox extends JFrame {

    private JLabel lb1, lb2, lb3, lb4;
    private JTextField txt1, txt2, txtKQ;
    private JButton btnTinh;
    private JComboBox<String> cbPhepTinh;

    public static void main(String[] args) {
        DemoJCombobox rd = new DemoJCombobox();
        rd.setVisible(true);
    }

    public DemoJCombobox() {
        setTitle("Tính toán đơn giản");
        taoGiaoDien();
//      pack();
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2, 5, 5));
        p1.add(lb1 = new JLabel("Số đầu tiên"));
        p1.add(txt1 = new JTextField());
        txt1.setPreferredSize(new Dimension(100, 30));
        p1.add(lb2 = new JLabel("Số thứ 2"));
        p1.add(txt2 = new JTextField());
        p1.add(lb3 = new JLabel("Phép tính"));
        p1.add(cbPhepTinh = new JComboBox<>());
        p1.add(lb4 = new JLabel("Kết quả"));
        p1.add(txtKQ = new JTextField());
        txtKQ.setEditable(false);
        add(btnTinh = new JButton("Tính"), BorderLayout.SOUTH);

        add(p1);

        cbPhepTinh.addItem("+");
        cbPhepTinh.addItem("-");
        cbPhepTinh.addItem("*");
        cbPhepTinh.addItem("/");

        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(txt1.getText());
                    double y = Double.parseDouble(txt2.getText());
                    double kq = 0;
                    String phepTinh = (String) cbPhepTinh.getSelectedItem();
                    if (phepTinh.equals("+")) {
                        kq = x + y;
                    } else if (phepTinh.equals("-")) {
                        kq = x - y;
                    } else if (phepTinh.equals("*")) {
                        kq = x * y;
                    } else {
                        if (y == 0) {
                            txtKQ.setText("Không thể chia cho 0");
                            return;
                        }
                        kq = x / y;
                    }
                    txtKQ.setText(String.valueOf(kq));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Nhập sai, vui lòng nhập lại", "Chú ý", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

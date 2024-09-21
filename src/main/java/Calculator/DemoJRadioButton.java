/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Vinh
 */
public class DemoJRadioButton extends JFrame {

    private JLabel lb1, lb2, lb3, lb4;
    private JTextField txt1, txt2, txtKQ;
    private JButton btnTinh;
    private JRadioButton rdCong, rdTru, rdNhan, rdChia;

    public static void main(String[] args) {
        DemoJRadioButton rd = new DemoJRadioButton();
        rd.setVisible(true);
    }

    public DemoJRadioButton() {
        setTitle("Tính toán đơn giản");
        taoGiaoDien();
        pack();
//      setSize(400, 300);
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

        JPanel p2 = new JPanel();
        p2.add(rdCong = new JRadioButton("+"));
        p2.add(rdTru = new JRadioButton("-"));
        p2.add(rdNhan = new JRadioButton("*"));
        p2.add(rdChia = new JRadioButton("/"));

        p1.add(lb3 = new JLabel("Phép tính"));

        p1.add(p2);

        p1.add(lb4 = new JLabel("Kết quả"));
        p1.add(txtKQ = new JTextField());

        add(p1);
        add(btnTinh = new JButton("Tính"), BorderLayout.SOUTH);

        ButtonGroup btgPhepTinh = new ButtonGroup();
        btgPhepTinh.add(rdCong);
        btgPhepTinh.add(rdTru);
        btgPhepTinh.add(rdNhan);
        btgPhepTinh.add(rdChia);
        rdCong.setSelected(true);

        btnTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(txt1.getText());
                    double y = Double.parseDouble(txt2.getText());
                    double kq = 0;
                    if (rdCong.isSelected()) {
                        kq = x + y;
                    } else if (rdTru.isSelected()) {
                        kq = x - y;
                    } else if (rdNhan.isSelected()) {
                        kq = x * y;
                    } else {
                        if("0".equals(txt2.getText())){
                            txtKQ.setText("Không thể chia cho 0");
                            return;
                        }
                        kq = x / y;
                    }
                    txtKQ.setText(String.valueOf(kq));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Nhập sai kiểu dữ liệu, vui lòng nhập lại", "Chú ý", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}

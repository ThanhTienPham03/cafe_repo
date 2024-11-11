package Cafe_GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import connectDB.ConnectDB;
import dao.LoaiSP_Dao;
import dao.San_Pham_Dao;

public class BanHang extends JPanel {
    private JLabel lbMaHD, lbSoLuong, lbTong, lbTitle, lbSelectedItems;
    private JTextField txtMaHD, txtSoLuong, txtTong;
    private JButton btnThemHD, btnXoaHD, btnThemSP, btnGiamSP;
    private JTextArea txtSelectedItems;
    private San_Pham_Dao sp_dao;
    private LoaiSP_Dao loai_dao;

    // Order management variables
    private int orderCount = 0;
    private double orderTotal = 0.0;

    public BanHang() throws ClassNotFoundException {
        ConnectDB.getInstance().connect();
        sp_dao = new San_Pham_Dao();
        loai_dao = new LoaiSP_Dao();

        setSize(new Dimension(1100, 900));
        setLayout(new BorderLayout());

        add(createEmptyPanel(), BorderLayout.WEST);
        add(createProductPanel(), BorderLayout.CENTER);
        add(createPaymentPanel(), BorderLayout.EAST);
    }

    private JPanel createEmptyPanel() {
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(16, 500));
        emptyPanel.setOpaque(false);
        return emptyPanel;
    }

    private JPanel createProductPanel() {
        JPanel productPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        productPanel.setBorder(BorderFactory.createTitledBorder("Các sản phẩm"));

        String[][] productInfo = {
            {"image/Macchiato.JPG", "Macchiato", "30.0"},
            {"image/Americano.jpg", "Americano", "25.0"},
            {"image/sua_tuoi_cafe.JPG", "Sữa tươi cafe", "20.0"},
            {"image/Cocacola.JPG", "Cocacola", "15.0"},
            {"image/chanh_day.JPG", "Chanh dây", "18.0"},
            {"image/tra_olong.JPG", "Trà ô long", "22.0"},
            {"image/tra_Dao.JPG", "Trà đào", "25.0"},
            {"image/yougurt_dau_tam.JPG", "Yogurt dâu tằm", "28.0"},
            {"image/nuoc_cam.JPG", "Nước cam", "20.0"},
            {"image/cacao_nong.JPG", "Cacao nóng", "30.0"},
            {"image/tra_lipton.JPG", "Trà Lipton", "22.0"},
            {"image/soda_chanh.JPG", "Soda chanh", "20.0"}
        };

        for (String[] product : productInfo) {
            productPanel.add(createProductBox(product[0], product[1], Double.parseDouble(product[2])));
        }

        return productPanel;
    }

    private Box createProductBox(String imagePath, String name, double price) {
        Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createTitledBorder(name));
        box.setPreferredSize(new Dimension(185, 200));

        JLabel imageLabel = new JLabel(new ImageIcon(imagePath));
        imageLabel.setPreferredSize(new Dimension(100, 90));

        JLabel priceLabel = new JLabel(String.format("Giá: %.2f", price));

        JButton addButton = createButton("Cộng", e -> addOrder(name, price));
        JButton subtractButton = createButton("Trừ", e -> removeOrder(price));

        box.add(imageLabel);
        box.add(Box.createVerticalStrut(10));
        box.add(priceLabel);
        box.add(Box.createHorizontalStrut(20));
        box.add(addButton);
        box.add(Box.createHorizontalStrut(10));
        box.add(subtractButton);

        return box;
    }

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }

    private Box createPaymentPanel() {
        Box paymentBox = Box.createVerticalBox();
        paymentBox.setPreferredSize(new Dimension(250, 500));
        paymentBox.setBorder(BorderFactory.createTitledBorder("Thanh toán"));

        paymentBox.add(Box.createVerticalStrut(10));
        paymentBox.add(Box.createVerticalStrut(10));
        txtSelectedItems = new JTextArea(10, 20);
        txtSelectedItems.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtSelectedItems);
        paymentBox.add(scrollPane);
        paymentBox.add(createButtonBox(btnThemHD = new JButton("Thêm hóa đơn"), btnXoaHD = new JButton("Hủy HĐ")));

        return paymentBox;
    }

    private Box createLabelBox(String text, Font font, Color color) {
        Box box = Box.createHorizontalBox();
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        box.add(label);
        return box;
    }

    private Box createInputBox(String labelText, JTextField textField) {
        Box box = Box.createHorizontalBox();
        JLabel label = new JLabel(labelText);
        box.add(label);
        box.add(textField);
        label.setPreferredSize(new Dimension(100, label.getPreferredSize().height));
        return box;
    }

    private Box createButtonBox(JButton... buttons) {
        Box box = Box.createHorizontalBox();
        for (JButton button : buttons) {
            box.add(button);
            box.add(Box.createHorizontalStrut(10));
        }
        return box;
    }

    private void addOrder(String name, double price) {
        orderCount++;
        orderTotal += price;
        txtSelectedItems.append(name + ": " + String.format("%.2f", price) + " VND\n");
        updateOrderDisplay();
    }

    private void removeOrder(double price) {
        if (orderCount > 0) {
            orderCount--;
            orderTotal -= price;
            updateOrderDisplay();
        }
    }

    private void updateOrderDisplay() {
        txtSoLuong.setText(String.valueOf(orderCount));
        txtTong.setText(String.format("%.2f", orderTotal));
    }
}
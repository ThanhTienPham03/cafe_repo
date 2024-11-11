package Cafe_GUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TrangChu extends JPanel{
	public TrangChu() {
		setPreferredSize(new Dimension(1100, 200)); //800, 500
        setLayout(new BorderLayout());
        setVisible(true);
	}
	protected void paintComponent(Graphics g) {
        String imagePath = "image/cafe_homePage.png"; // Path to your GIF image file
        File imageFile = new File(imagePath);

        //Chèn ảnh vào Option menu
        try {
            // Đọc ảnh từ file
            Image image = ImageIO.read(imageFile);

            // Tạo icon cho ảnh
            int newWidth = getWidth(); // Get the width of the panel
            int newHeight = getHeight(); // Get the height of the panel
            Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH); //getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            g.drawImage(scaledImage, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Coded by Amir Radman 

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GUI extends JFrame {
	
	public static void main(String[] args) {
		Fields f1 = new Fields();
		f1.setVisible(true);
		Toolkit tk1 = Toolkit.getDefaultToolkit();
		Dimension screenSize1 = tk1.getScreenSize();
		int screenHeight1 = screenSize1.height;
		int screenWidth1 = screenSize1.width;
		f1.setSize(400, 400);
		f1.setLocation(screenWidth1 / 4, screenHeight1 / 4);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
// Coded by Amir Radman

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
	JLabel Similarity, mUsed1, mUsed2, Common;
	JTextField f1, f2, f3, f4;

	public Display(String textOne, String textTwo) {
		super("Result Display");
		Similarity = new JLabel("% Similarity");
		mUsed1 = new JLabel("Text1 Most Used");
		mUsed2 = new JLabel("Text2 Most Used");
		Common = new JLabel("Most Common Words");

		f1 = new JTextField(20);
		
		f2 = new JTextField(20);
		f2.setText(textOne);
		
		f3 = new JTextField(20);
		f3.setText(textTwo);
		
		f4 = new JTextField(20);

		setLayout(new GridLayout(4, 2));

		add(Similarity);
		add(f1);
		add(mUsed1);
		add(f2);
		add(mUsed2);
		add(f3);
		add(Common);
		add(f4);
	}
}

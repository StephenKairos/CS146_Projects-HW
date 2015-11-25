import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Fields extends JFrame {
	
	public HashTable tableOne;
	public HashTable tableTwo;
	public static final int offset = 387;
	
	public Fields() {
		super("Text Comparison Analysis");
		text1 = new JTextArea(10, 10);
		text2 = new JTextArea(10, 10);

		Compare = new JButton("Analyze");
		Compare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableOne = new HashTable();
				String toAnalyze = text1.getText();
				Scanner in = new Scanner(toAnalyze);
				in.useDelimiter("[^\\p{Alpha}']+");
				while(in.hasNext()) {
					tableOne.add(in.next().toLowerCase());
				}
				
				tableTwo = new HashTable();
				toAnalyze = text2.getText();
				in = new Scanner(toAnalyze);
				in.useDelimiter("[^\\p{Alpha}']+");
				while(in.hasNext()) {
					tableTwo.add(in.next().toLowerCase());
				}
				
				drawDisplay(tableOne.toString(), tableTwo.toString());
				//output.setText("" + table.uniqueWords);
			}
		});
		
		setLayout(new FlowLayout());

		add(text1);
		add(text2);
		add(new JLabel("                  "));

		JScrollPane scroll = new JScrollPane(text1,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JScrollPane scroll2 = new JScrollPane(text2,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		add(scroll);
		add(scroll2);

		String[] sorts = { "MergeSort", "QuickSort", "HeapSort" };
		JComboBox sortLists = new JComboBox(sorts);
		sortLists.setSelectedIndex(1);
		add(new JLabel("                   "));
		add(sortLists);
		add(new JLabel("     "));
		add(Compare);

		text1.setText("Enter Text Here");
		text2.setText("Enter Text Here");
	}

	public void drawDisplay(String textOne, String textTwo) {
		Display d1 = new Display(textOne, textTwo);
		d1.setVisible(true);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		d1.setSize(400, 400);
		d1.setLocation(screenWidth / 4 + offset, screenHeight / 4);
		d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	JTextArea text1, text2;
	JButton Compare;
}

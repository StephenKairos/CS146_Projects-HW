import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

public class WindowFrame extends JFrame {

	public static HashTable table;
	public static JTextField input = new JTextField();
	public static JTextArea output = new JTextArea();
	public static JButton analyze = new JButton("Analyze");
	
	public static void main(String[] args) {
		WindowFrame frame = new WindowFrame("Text Analyzer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		addToPane(frame.getContentPane());
		frame.setVisible(true);
	}
	
	public WindowFrame(String title) {
		super(title);
	}
	
	public static void addToPane(Container pane) {
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        c.gridy = 0;
        pane.add(input, c);
        c.gridy = 1;
        pane.add(output, c);
        c.gridy = 2;
        analyze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = new HashTable();
				String toAnalyze = input.getText();
				Scanner in = new Scanner(toAnalyze);
				in.useDelimiter("[^\\p{Alpha}']+");
				while(in.hasNext()) {
					table.add(in.next().toLowerCase());
				}
				
				output.setText(table.toString());
				//output.setText("" + table.uniqueWords);
			}
		});
        pane.add(analyze, c);
	}
}

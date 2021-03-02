package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTitleBegin extends JPanel{

	private JLabel title; 
	private Font font = new Font(Font.SERIF, Font.ITALIC, 28); 
	
	public PanelTitleBegin() {
		title = new JLabel("CRAPS VEGAS"); 
		title.setForeground(Color.WHITE);
		setLayout(new FlowLayout());
		add(title);
		title.setFont(font);
		setBackground(new Color(17,130,0));
		setBackground(new Color(179,9,34));
		
	}

}

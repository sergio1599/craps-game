package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewRules extends JInternalFrame{

	private JDesktopPane desktop; 
	private ManagementWindow mgWindow; 
	
	private JTextArea lblRules; 
	private Font fontText = new Font("Euphemia", 2, 13);
	
	public ViewRules(JDesktopPane desktop, ManagementWindow mgWindow) {
		this.desktop=desktop;
		this.mgWindow=mgWindow; 
		setTitle("Reglas");
		setSize(new Dimension(900,300));
		setLocation(50,150);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setLayout(new GridLayout(1,1));
		setFrameIcon(new ImageIcon("resources/icons/"));
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setBackground(new Color(17,130,0));
		beginElements(); 
		addElements();
		
		//setVisible(true);
	}

	private void beginElements() {
		lblRules = new JTextArea(); 
		lblRules.setText("\t\t\tINSTRUCCIONES\n"
				+ "->El jugador que tiene el turno realiza el lanzamiento de dos dados, si obtiene un 7 o un 11 en el primer tiro, el jugador gana.\n"
				+ "->Si no, la suma de lanzamiento es 2, 3, o 12 (llamado CRAPS) en el primer tiro o lanzamiento, el jugador pierde.\n"
				+ "->Si la suma es 4, 5, 6, 8, 9 , o 10 en el primer tiro, la suma se convierte en el punto de ganador.\n"
				+ "->Para ganar el jugador debe seguir tirando los dados hasta que salga otra vez su punto. El jugador pierde si lanza un 7 antes de que salga el punto.");
		lblRules.setForeground(new Color(17,120,0));
		lblRules.setFont(fontText);
		lblRules.setEditable(false);
		
	}

	
	private void addElements() {
		add(new JScrollPane(lblRules));  
		
	}
}

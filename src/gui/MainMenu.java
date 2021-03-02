package gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.ActionsGame;

public class MainMenu extends JMenuBar{

	private ManagementWindow main;
	private JMenu files;
	private JMenu game; 
	private JMenu help; 
	private JMenuItem exit; 
	private JMenuItem play; 
	private JMenuItem rules; 
	
	public MainMenu(ManagementWindow main) {
		this.main=main; 
		setBackground(new Color(17,130,0));
		beginElements(); 
		addElements(); 
		
		
	}

	private void beginElements() {
		files = new JMenu("Archivo"); 
		files.setForeground(Color.white);
		files.setMnemonic('A');
		game = new JMenu("Juego"); 
		game.setForeground(Color.white);
		game.setMnemonic('J');
		help = new JMenu("Ayuda");
		help.setForeground(Color.white);
		help.setMnemonic('Y');
		
		exit = new JMenuItem("Salir");
		exit.setMnemonic('S');
		exit.setIcon(new ImageIcon("resources/icons/exit.png"));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));	
		exit.setActionCommand(ActionsGame.EXIT);
		exit.addActionListener(main.getControll());
		
		play = new JMenuItem("Jugar");
		play.setMnemonic('J');
		play.setIcon(new ImageIcon("resources/icons/dice.png"));
		play.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_MASK));
		play.setActionCommand(ActionsGame.WINDOW_GAME);
		play.addActionListener(main.getControll());
		
		rules = new JMenuItem("Reglas");
		rules.setMnemonic('R');
		rules.setIcon(new ImageIcon("resources/icons/rules.png"));
		rules.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
		rules.setActionCommand(ActionsGame.RULES);
		rules.addActionListener(main.getControll());
		
		
	}

	private void addElements() {
		add(files); 
		add(game); 
		add(help); 
		
		files.add(exit); 
		game.add(play); 
		help.add(rules); 
	}
	
	
}

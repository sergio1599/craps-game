package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controll.ControllGame;
import model.ActionsGame;

public class MainWindow extends JFrame {

	private JDesktopPane desktop;
	private MainMenu mainMenu; 
	private ControllGame controll; 
	private ViewWelcome viewWelcome; 
	private ManagementWindow main;
	private ViewRules viewRules; 
	
	public MainWindow(ManagementWindow main) {
		this.main=main;
		setTitle("CRAPS GAME");
		setSize(new Dimension(1000,800));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("resources/icons/dices.png").getImage());
		beginElements();
		addElements();
		
	}
	
	

	private void beginElements() {
		desktop = new JDesktopPane();
		desktop.setBackground(new Color(179,9,34));
//		setBackground(new Color(179,9,34));
//		setBackground(new Color(17,130,0));
		mainMenu = new MainMenu(main); 
		viewWelcome = new ViewWelcome(desktop,main);
		viewRules = new ViewRules(desktop, main); 
		
	}


	private void addElements() {
		this.add(desktop, BorderLayout.CENTER); 
		desktop.add(viewWelcome);
		desktop.add(viewRules); 
		try {
			viewWelcome.setMaximum(true);
			viewWelcome.setVisible(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		this.setJMenuBar(mainMenu);
	}


	
	public ViewRules getViewRules() {
		return viewRules;
	}



	public void setViewRules(ViewRules viewRules) {
		this.viewRules = viewRules;
	}

	public ControllGame getControll() {
		return controll; 
	}


	public JDesktopPane getDesktop() {
		return desktop;
	}



	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}



	public MainMenu getMainMenu() {
		return mainMenu;
	}



	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}



	public ViewWelcome getViewWelcome() {
		return viewWelcome;
	}



	public void setViewWelcome(ViewWelcome viewWelcome) {
		this.viewWelcome = viewWelcome;
	}



	public ManagementWindow getMain() {
		return main;
	}



	public void setMain(ManagementWindow main) {
		this.main = main;
	}



	public void setControll(ControllGame controll) {
		this.controll = controll;
	}
	
	
	
}

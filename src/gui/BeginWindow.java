package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BeginWindow extends JFrame{

	
	PanelTitleBegin panelTittle; 
	PanelBegin panelBegin; 
	ManagementWindow management; 
	
	public BeginWindow(ManagementWindow management) {
		this.management=management;
		setTitle("CRAPS GAME");
		setSize(new Dimension(500,350));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("resources/icons/dices.png").getImage());
		beginElements();
		addElements();
		setVisible(true);
	}
	
	private void beginElements() {
		panelTittle=new PanelTitleBegin();
		panelBegin=new PanelBegin(management);
		
		
	}
	
	private void addElements() {
		add(panelTittle,BorderLayout.NORTH);
		add(panelBegin,BorderLayout.CENTER);
		
	}

	public PanelTitleBegin getPanelTittle() {
		return panelTittle;
	}

	public void setPanelTittle(PanelTitleBegin panelTittle) {
		this.panelTittle = panelTittle;
	}

	public PanelBegin getPanelBegin() {
		return panelBegin;
	}

	public void setPanelBegin(PanelBegin panelBegin) {
		this.panelBegin = panelBegin;
	}

	public ManagementWindow getManagement() {
		return management;
	}

	public void setManagement(ManagementWindow management) {
		this.management = management;
	}
	
	

}

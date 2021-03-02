package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

public class PlayerWindow extends JFrame{

	private ManagementWindow mngWindow;
	private PlayerPanel playerPanel;
	private PanelTitleBegin panelTitle;
	
	private Font fontTitle = new Font(Font.SERIF, Font.ITALIC, 28); 
	private Font fontText = new Font("Euphemia", 2, 13);
	private Font fontButton = new Font("Euphemia", 3, 13);
	
	public PlayerWindow(ManagementWindow mngWindow) {
		this.mngWindow=mngWindow; 
		setTitle("JUGAR");
		setSize(new Dimension(500,400));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("resources/icons/dice64.png").getImage());
		beginElements(); 
		addElements();
		getContentPane().setBackground(new Color(179,9,34));
	}

	private void beginElements() {
		playerPanel=new PlayerPanel(mngWindow);
		panelTitle=new PanelTitleBegin();
		
		//setBackground(new Color(179,9,34));
	}

	private void addElements() {
		add(panelTitle,BorderLayout.NORTH);
		add(playerPanel,BorderLayout.CENTER);
	}

	public ManagementWindow getMngWindow() {
		return mngWindow;
	}

	public void setMngWindow(ManagementWindow mngWindow) {
		this.mngWindow = mngWindow;
	}

	public Font getFontTitle() {
		return fontTitle;
	}

	public void setFontTitle(Font fontTitle) {
		this.fontTitle = fontTitle;
	}

	public Font getFontText() {
		return fontText;
	}

	public void setFontText(Font fontText) {
		this.fontText = fontText;
	}

	public Font getFontButton() {
		return fontButton;
	}

	public void setFontButton(Font fontButton) {
		this.fontButton = fontButton;
	}

	public PlayerPanel getPlayerPanel() {
		return playerPanel;
	}

	public void setPlayerPanel(PlayerPanel playerPanel) {
		this.playerPanel = playerPanel;
	}

	public PanelTitleBegin getPanelTitle() {
		return panelTitle;
	}

	public void setPanelTitle(PanelTitleBegin panelTitle) {
		this.panelTitle = panelTitle;
	}
	
	
	
}

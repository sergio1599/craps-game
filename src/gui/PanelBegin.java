package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.ActionsGame;

public class PanelBegin extends JPanel{

	ManagementWindow management; 
	private JLabel lblNumberPlayers; 
	private JLabel lblNewGame; 
	private JLabel lblIcon; 
	private JSpinner spnNumberPlayers; 
	private JButton btnPlay; 
	private Font fontTitle = new Font(Font.SERIF, Font.ITALIC, 28); 
	private Font fontText = new Font("Euphemia", 2, 13);
	private Font fontButton = new Font("Euphemia", 3, 13);
	
	public PanelBegin(ManagementWindow management) {
		this.management=management; 
		setLayout(new GridBagLayout());
		Border loweredbevel= BorderFactory.createEtchedBorder(); 
		TitledBorder title=BorderFactory.createTitledBorder(loweredbevel,"");
		title.setTitlePosition(TitledBorder.CENTER);
		this.setBorder(title);
		beginElements();
		addElements();
		setBackground(new Color(179,9,34));
		setBackground(new Color(17,130,0));
	}
	private void beginElements() {
		 lblNumberPlayers = new JLabel("Número de jugadores"); 
		 lblNumberPlayers.setFont(fontText);
		 lblNumberPlayers.setForeground(Color.white);
		 lblNewGame = new JLabel("Nuevo Juego");
		 lblNewGame.setFont(fontTitle);
		 lblNewGame.setForeground(Color.white);
		 lblIcon = new JLabel(); 
		 lblIcon.setIcon(new ImageIcon("resources/icons/dice64.png"));
		 SpinnerNumberModel model= new SpinnerNumberModel(2, 2, 100, 1); 
		 spnNumberPlayers=new JSpinner(model);
		 spnNumberPlayers.setFont(fontText);
		 btnPlay = new JButton("Jugar"); 
		 btnPlay.setFont(fontButton);
		 btnPlay.setActionCommand(ActionsGame.PLAY);
		 btnPlay.setBackground(new Color(17,130,0));
		 btnPlay.setBackground(new Color(179,9,34));
		// btnPlay.setBackground(new Color(17,130,0));
		 btnPlay.setBorder(BorderFactory.createRaisedBevelBorder());
		 btnPlay.setForeground(Color.white);
		 btnPlay.addActionListener(management.getControll());
		 
	}
	
	private void addElements() {
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.weightx=1.0; 
		gbc.gridx=1;
		gbc.gridy=0; 
		gbc.gridwidth =1; 
		gbc.fill = GridBagConstraints.NONE; 
		add(lblIcon,gbc); 

		
		gbc.gridy=1;
		gbc.fill = GridBagConstraints.HORIZONTAL; 
		add(new JLabel(" "),gbc);
		
		gbc.gridy=2; 
		add(lblNewGame,gbc); 
		
		
		gbc.gridy=3;
		add(new JLabel(" "),gbc);
			
		
		gbc.gridx=0; 
		gbc.gridy=4; 
		add(lblNumberPlayers,gbc); 
		
		gbc.gridx=1; 
		add(spnNumberPlayers,gbc); 
		
		gbc.gridx=2;
		add(new JLabel(" "),gbc);
		
		gbc.gridx=3;  
		add(btnPlay,gbc); 
	}
	public ManagementWindow getManagement() {
		return management;
	}
	public void setManagement(ManagementWindow management) {
		this.management = management;
	}
	public JLabel getLblNumberPlayers() {
		return lblNumberPlayers;
	}
	public void setLblNumberPlayers(JLabel lblNumberPlayers) {
		this.lblNumberPlayers = lblNumberPlayers;
	}
	public JLabel getLblNewGame() {
		return lblNewGame;
	}
	public void setLblNewGame(JLabel lblNewGame) {
		this.lblNewGame = lblNewGame;
	}
	public JLabel getLblIcon() {
		return lblIcon;
	}
	public void setLblIcon(JLabel lblIcon) {
		this.lblIcon = lblIcon;
	}
	public JSpinner getSpnNumberPlayers() {
		return spnNumberPlayers;
	}
	public void setSpnNumberPlayers(JSpinner spnNumberPlayers) {
		this.spnNumberPlayers = spnNumberPlayers;
	}
	public JButton getBtnPlay() {
		return btnPlay;
	}
	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
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

	
	
}

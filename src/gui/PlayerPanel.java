package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.spec.MGF1ParameterSpec;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ActionsGame;

public class PlayerPanel extends JPanel{

	ManagementWindow mngWindow;
	JLabel lblTitlePlayer; 
	JLabel lblCode; 
	JLabel lblName;
	JLabel lblBudget; 
	JTextField txtCode; 
	JTextField txtName; 
	JTextField txtBudget; 
	JButton btnAddPlayer;
	JButton btnBack; 
	JButton btnPlay;
	
	private Font fontTitle = new Font(Font.SERIF, Font.ITALIC, 28); 
	private Font fontText = new Font("Euphemia", 2, 13);
	private Font fontButton = new Font("Euphemia", 3, 13);
	
	public PlayerPanel(ManagementWindow mngWindow) {
		this.mngWindow=mngWindow;
		setLayout(new GridBagLayout());
		setBackground(new Color(17,130,0));
		beginElements(); 
		addElements();
	}
	private void beginElements() {
		lblTitlePlayer = new JLabel("Por favor añade el jugador numero: 1");
		lblTitlePlayer.setFont(fontText);
		lblTitlePlayer.setForeground(Color.white);
		lblCode = new JLabel("Código"); 
		lblCode.setFont(fontText);
		lblCode.setForeground(Color.white);
		lblName= new JLabel("Nombre"); 
		lblName.setFont(fontText);
		lblName.setForeground(Color.white);
		lblBudget = new JLabel("Presupuesto"); 
		lblBudget.setFont(fontText);
		lblBudget.setForeground(Color.white);
		
		txtName = new JTextField(); 
		txtName.setFont(fontText);
		txtName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txtCode = new JTextField(); 
		txtCode.setFont(fontText);
		txtCode.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txtBudget = new JTextField(); 
		txtBudget.setFont(fontText);
		txtBudget.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txtBudget.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char aux=e.getKeyChar();
				if(!Character.isDigit(aux)) {
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		btnAddPlayer = new JButton("Añadir Jugador"); 
		btnAddPlayer.setFont(fontButton);
		btnAddPlayer.setBackground(new Color(179,9,34));
		btnAddPlayer.setForeground(Color.white);
		btnAddPlayer.setBorder(BorderFactory.createRaisedBevelBorder());
		btnAddPlayer.setActionCommand(ActionsGame.ADD_PLAYER);
		btnAddPlayer.addActionListener(mngWindow.getControll());
		
		btnBack = new JButton("Volver"); 
		btnBack.setFont(fontButton);
		btnBack.setBackground(new Color(179,9,34));
		btnBack.setForeground(Color.white);
		btnBack.setBorder(BorderFactory.createRaisedBevelBorder());
		btnBack.setActionCommand(ActionsGame.BACK_BEGIN);
		btnBack.addActionListener(mngWindow.getControll());
		
		btnPlay=new JButton("Jugar");
		btnPlay.setEnabled(false);
		btnPlay.setBackground(new Color(179,9,34));
		btnPlay.setForeground(Color.white);
		btnPlay.setBorder(BorderFactory.createRaisedBevelBorder());
		btnPlay.setActionCommand(ActionsGame.STAR_GAME);
		btnPlay.addActionListener(mngWindow.getControll());
		btnPlay.setFont(fontButton);

	
	}

	private void addElements() {
		GridBagConstraints gbc = new GridBagConstraints(); 
		gbc.weightx=1.0;
		
		gbc.gridx=0;
		gbc.gridy=0;
		add(new JLabel(" "),gbc);
		
		gbc.gridx=1;
		add(lblTitlePlayer,gbc);
		
		gbc.gridx=2;
		add(new JLabel(" "),gbc);
		
		gbc.gridy=1;
		gbc.gridx=0;
		add(new JLabel(" "),gbc);
		
		gbc.gridy=2;
		gbc.gridx=0;
		add(lblCode,gbc);
		
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtCode,gbc);
		
		gbc.gridx=3;
		add(btnPlay,gbc);
		
		gbc.gridy=3;
		add(new JLabel(" "),gbc);
		
		gbc.gridy=4;
		gbc.gridx=0;
		gbc.fill=0;
		add(lblName,gbc);
		
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(txtName,gbc);
		
		gbc.gridx=3;
		add(btnAddPlayer,gbc); 
		
		gbc.gridy=5; 
		add(new JLabel(" "),gbc); 
		
		gbc.gridy=6; 
		gbc.gridx=0; 
		gbc.fill=0; 
		add(lblBudget,gbc); 
		
		gbc.gridx=1; 
		gbc.fill=GridBagConstraints.HORIZONTAL; 
		add(txtBudget,gbc); 
		
		gbc.gridx=3; 
		add(btnBack,gbc); 
		
		
	}

	public ManagementWindow getMngWindow() {
		return mngWindow;
	}

	public void setMngWindow(ManagementWindow mngWindow) {
		this.mngWindow = mngWindow;
	}

	public JLabel getLblTitlePlayer() {
		return lblTitlePlayer;
	}

	public void setLblTitlePlayer(JLabel lblTitlePlayer) {
		this.lblTitlePlayer = lblTitlePlayer;
	}

	public JLabel getLblCode() {
		return lblCode;
	}

	public void setLblCode(JLabel lblCode) {
		this.lblCode = lblCode;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	public JLabel getLblBudget() {
		return lblBudget;
	}

	public void setLblBudget(JLabel lblBudget) {
		this.lblBudget = lblBudget;
	}

	public JTextField getTxtCode() {
		return txtCode;
	}

	public void setTxtCode(JTextField txtCode) {
		this.txtCode = txtCode;
	}

	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtBudget() {
		return txtBudget;
	}

	public void setTxtBudget(JTextField txtBudget) {
		this.txtBudget = txtBudget;
	}

	public JButton getBtnAddPlayer() {
		return btnAddPlayer;
	}

	public void setBtnAddPlayer(JButton btnAddPlayer) {
		this.btnAddPlayer = btnAddPlayer;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
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
	public JButton getBtnPlayGame() {
		return btnPlay;
	}
	public void setBtnPlay(JButton btnPlay) {
		this.btnPlay = btnPlay;
	}
	
	
	
}

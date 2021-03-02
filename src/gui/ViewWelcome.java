package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;


import model.ActionsGame;

public class ViewWelcome extends JInternalFrame{

	private JDesktopPane desktop; 
	private ManagementWindow mgWindow; 
	
	private JButton btnBack;
	private JButton btnLeave;
	private JButton btnThrow;
	private JButton btnExit;
	private JLabel lblTitle;
	private JLabel lblDiceOne;
	private JLabel lblDiceTwo;
	private JLabel lblImageDiceOne;
	private JLabel lblImageDiceTwo; 
	
	private JTable table; 
	private DefaultTableModel modelTab;
	
	private Font fontTitle = new Font(Font.SERIF, Font.ITALIC, 20); 
	private Font fontText = new Font("Euphemia", 2, 13);
	private Font fontButton = new Font("Euphemia", 3, 13);

	public ViewWelcome(JDesktopPane desktop,ManagementWindow mgWindow) {
		this.desktop=desktop;
		this.mgWindow=mgWindow;
		setTitle("Ventana de juego");
		setSize(new Dimension(350,200));
		setLocation(50,150);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setLayout(new GridBagLayout());
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
		
		btnBack=new JButton("Volver");
		btnBack.setFont(fontButton);
		btnBack.setBackground(new Color(179,9,34));
		btnBack.setForeground(Color.white);
		btnBack.setActionCommand(ActionsGame.BACK_BEGIN);
		btnBack.addActionListener(mgWindow.getControll());
		
		btnThrow=new JButton("Lanzar");
		btnThrow.setFont(fontButton);
		btnThrow.setBackground(new Color(179,9,34));
		btnThrow.setForeground(Color.white);
		btnThrow.setActionCommand(ActionsGame.THROW_DICE);
		btnThrow.addActionListener(mgWindow.getControll());
		
		btnExit=new JButton("Salir");
		btnExit.setFont(fontButton);
		btnExit.setBackground(new Color(179,9,34));
		btnExit.setForeground(Color.white);
		btnExit.setActionCommand(ActionsGame.EXIT);
		btnExit.addActionListener(mgWindow.getControll());
		
		btnLeave=new JButton("Rendirse");
		btnLeave.setFont(fontButton);
		btnLeave.setBackground(new Color(179,9,34));
		btnLeave.setForeground(Color.white);
		btnLeave.setActionCommand(ActionsGame.LEAVE_GAME);
		btnLeave.addActionListener(mgWindow.getControll());
		
		lblTitle=new JLabel("Lanza el jugador: id, Nombre");
		lblTitle.setFont(fontTitle);
		lblTitle.setForeground(Color.WHITE);
		
		lblDiceOne=new JLabel("Dado uno ");
		lblDiceOne.setFont(fontText);
		lblDiceOne.setForeground(Color.WHITE);
		
		lblDiceTwo=new JLabel("Dado Dos ");
		lblDiceTwo.setFont(fontText);
		lblDiceTwo.setForeground(Color.WHITE);
		
		lblImageDiceOne = new JLabel(); 
		lblImageDiceOne.setIcon(new ImageIcon("resources/dicesGif/dados-01.gif")); 
		
		lblImageDiceTwo= new JLabel(); 
		lblImageDiceTwo.setIcon(new ImageIcon("resources/dicesGif/dados-05.gif"));
		
		
		String[] headings=new String[]{"ID","Nombre","Presupuesto", "Puntaje","Punto","Estado","Jugadores restantes","Posición"};
		modelTab =new DefaultTableModel(headings,0);
		table=new JTable(modelTab);
		table.setAutoResizeMode(HEIGHT);
	}


	private void addElements() {
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.weightx=1.0;
		
//		gbc.gridy=0;
//		gbc.gridx=0;
//		gbc.gridwidth=2;
//		gbc.fill= GridBagConstraints.HORIZONTAL; 
//		add(btnBack,gbc);
//		
//		gbc.gridy=0; 
//		gbc.gridx=5; 
//		gbc.gridwidth=2; 
//		gbc.fill= GridBagConstraints.HORIZONTAL; 
//		add(btnLeave,gbc);
//		
//		gbc.gridy=1; 
//		gbc.gridx=4; 
//		gbc.gridwidth=2;
//		gbc.fill= GridBagConstraints.HORIZONTAL; 
//		add(lblTitle,gbc); 
//		
//		gbc.gridy=2; 
//		gbc.gridx=3; 
//		gbc.gridwidth=2; 
//		gbc.fill= GridBagConstraints.HORIZONTAL; 
//		add(new JLabel(" "),gbc); 
//		
//		gbc.gridy=3; 
//		gbc.gridx=2; 
//		gbc.gridwidth=2; 
//		gbc.fill= GridBagConstraints.HORIZONTAL; 
//		add(lblDiceOne,gbc);
//		
//		gbc.gridy=3; 
//		gbc.gridx=5; 
//		gbc.gridwidth=2; 
//		gbc.fill= GridBagConstraints.HORIZONTAL; 
//		add(lblDiceTwo,gbc);
//		
//		gbc.gridy=4; 
//		gbc.gridx=2;
//		gbc.gridwidth=2; 
//		gbc.gridheight=4;
//		gbc.fill= GridBagConstraints.BOTH;
//		add(new JTextArea(" "),gbc); 
//		
//		gbc.gridy=3; 
//		gbc.gridx=5; 
//		gbc.gridwidth=2; 
//		gbc.gridheight=4;
//		gbc.fill= GridBagConstraints.BOTH;
//		add(new JLabel(" "),gbc); 
//		
//		gbc.gridy=4; 
//		gbc.gridx=5; 
//		gbc.gridwidth=2; 
//		gbc.gridheight=4; 
//		gbc.fill= GridBagConstraints.BOTH;
//		add(new JTextArea(" "),gbc); 
//		
//		gbc.gridy=9; 
//		gbc.gridx=4; 
//		gbc.gridwidth=1; 
//		gbc.gridheight=0; 
//		gbc.fill=GridBagConstraints.NONE;
//		add(btnThrow,gbc); 
//	
		
		
		gbc.gridx=0; 
		gbc.gridy=0; 
		gbc.gridwidth=1; 
		gbc.fill=GridBagConstraints.HORIZONTAL; 
		add(btnThrow,gbc); 
		
		gbc.gridx=1;
		add(new JLabel(" "),gbc); 
		
		gbc.gridx=2; 
		gbc.gridy=0; 
		gbc.gridwidth=2; 
		gbc.fill=GridBagConstraints.HORIZONTAL; 
		add(lblTitle,gbc); 
		
		gbc.gridx=0; 
		gbc.gridy=1; 
		gbc.gridwidth=1; 
		add(new JLabel(" "),gbc); 
		
		gbc.gridx=0; 
		gbc.gridy=2; 
		gbc.gridwidth=1; 
		add(btnLeave,gbc);
		
		
		gbc.gridx=1; 
		gbc.gridy=2; 
		gbc.gridwidth=1; 
		add(new JLabel(" "),gbc); 
		
		gbc.gridx=2; 
		gbc.gridy=2; 
		gbc.gridwidth=1; 
		add(lblDiceOne,gbc); 
		
		gbc.gridx=3; 
		gbc.gridy=2; 
		gbc.gridwidth=1; 
		add(new JLabel(" "),gbc); 
		
		gbc.gridx=4; 
		gbc.gridy=2; 
		gbc.gridwidth=1; 
		add(lblDiceTwo,gbc); 
		
		gbc.gridx=0; 
		gbc.gridy=3; 
		gbc.gridwidth=1; 
		add(new JLabel(" "),gbc);
		
		gbc.gridx=0; 
		gbc.gridy=4; 
		gbc.gridwidth=1; 
		gbc.fill=GridBagConstraints.HORIZONTAL; 
		add(btnBack,gbc); 
		
		gbc.gridx=0; 
		gbc.gridy=5; 
		gbc.gridwidth=1; 
		add(new JLabel(" "),gbc);
		
		gbc.gridx=0; 
		gbc.gridy=6; 
		gbc.gridwidth=1; 
		gbc.fill=GridBagConstraints.HORIZONTAL; 
		add(btnExit,gbc); 
		
		gbc.gridx=2; 
		gbc.gridy=4; 
		gbc.gridwidth=1;
		gbc.gridheight=3; 
		gbc.fill=GridBagConstraints.BOTH; 
		add(lblImageDiceOne,gbc); 
		
		gbc.gridx=5; 
		gbc.gridy=4; 
		gbc.gridwidth=1;
		gbc.fill=GridBagConstraints.BOTH; 
		add(new JLabel(" "),gbc); 
		
		gbc.gridx=3; 
		gbc.gridy=4; 
		gbc.gridwidth=1;
		gbc.fill=GridBagConstraints.HORIZONTAL; 
		add(new JLabel(" "),gbc);
		
		gbc.gridx=4; 
		gbc.gridy=4; 
		gbc.gridwidth=1;
		gbc.gridheight=3; 
		gbc.fill=GridBagConstraints.BOTH; 
		add(lblImageDiceTwo,gbc); 
		
		gbc.gridx=2; 
		gbc.gridy=7; 
		gbc.gridwidth=1;
		gbc.gridheight=1; 
		gbc.fill=GridBagConstraints.HORIZONTAL; 
		add(new JLabel(" "),gbc);
		
		gbc.gridx=1; 
		gbc.gridy=8; 
		gbc.gridwidth=4; 
		gbc.gridheight=3;
		add(new JScrollPane(table),gbc); 
		
	}


	public JDesktopPane getDesktop() {
		return desktop;
	}


	public void setDesktop(JDesktopPane desktop) {
		this.desktop = desktop;
	}


	public ManagementWindow getMgWindow() {
		return mgWindow;
	}


	public void setMgWindow(ManagementWindow mgWindow) {
		this.mgWindow = mgWindow;
	}


	public JButton getBtnBack() {
		return btnBack;
	}


	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}


	public JButton getBtnLeave() {
		return btnLeave;
	}


	public void setBtnLeave(JButton btnLeave) {
		this.btnLeave = btnLeave;
	}


	public JButton getBtnThrow() {
		return btnThrow;
	}


	public void setBtnThrow(JButton btnThrow) {
		this.btnThrow = btnThrow;
	}


	public JButton getBtnExit() {
		return btnExit;
	}


	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}


	public JLabel getLblTitle() {
		return lblTitle;
	}


	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}


	public JLabel getLblDiceOne() {
		return lblDiceOne;
	}


	public void setLblDiceOne(JLabel lblDiceOne) {
		this.lblDiceOne = lblDiceOne;
	}


	public JLabel getLblDiceTwo() {
		return lblDiceTwo;
	}


	public void setLblDiceTwo(JLabel lblDiceTwo) {
		this.lblDiceTwo = lblDiceTwo;
	}


	public JLabel getLblImageDiceOne() {
		return lblImageDiceOne;
	}


	public void setLblImageDiceOne(JLabel lblImageDiceOne) {
		this.lblImageDiceOne = lblImageDiceOne;
	}


	public JLabel getLblImageDiceTwo() {
		return lblImageDiceTwo;
	}


	public void setLblImageDiceTwo(JLabel lblImageDiceTwo) {
		this.lblImageDiceTwo = lblImageDiceTwo;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public DefaultTableModel getModelTab() {
		return modelTab;
	}


	public void setModelTab(DefaultTableModel modelTab) {
		this.modelTab = modelTab;
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

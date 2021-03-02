package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controll.ControllGame;
import model.ActionsGame;
import model.ManagementGame;
import model.Node;
import model.Player;

public class ManagementWindow implements ActionsGame{

	private MainWindow mainWindow;

	private ControllGame control;

	private BeginWindow beginWindow;

	private PlayerWindow playerWindow;

	String[] dates;

	public ManagementWindow() {
		dates=null;
	}


	private void beginElements() {
		mainWindow=new MainWindow(this);
		beginWindow=new BeginWindow(this);
		playerWindow=new PlayerWindow(this);

	}

	private void addElements() {


	}

	@Override
	public void exit() {
		int option=JOptionPane.showConfirmDialog(null,"¿Estas seguro de que quieres Salir?","SALIDA",JOptionPane.YES_NO_OPTION);
		if(option==0) {
			System.exit(option);
		}

	}

	@Override
	public void begin() {
		beginElements();
		addElements();
	}

	private void logicthrowDice() {
		int valueOne=control.getManagementGame().generateDices();
		int valueTwo=control.getManagementGame().generateDices();
		int valueDices=valueOne+valueTwo;
		System.out.println("Dados :"+valueDices);
		mainWindow.getViewWelcome().getLblImageDiceOne().setIcon(gifDice1(valueOne));
		mainWindow.getViewWelcome().getLblImageDiceTwo().setIcon(gifDice1(valueTwo));

		Player playerNow=control.getManagementGame().getTurn();
		if(playerNow.getNumFling()==0) {
			if (valueDices==7||valueDices==11) {
				//Jugador gana se llena la tabla 
				control.getManagementGame().setTurn(control.getManagementGame().findPlayerNode(control.getManagementGame().getTurn().getId()).getNext().getInfo());
				mainWindow.getViewWelcome().getLblTitle().setText("Lanza el jugador: "+control.getManagementGame().getTurn().getId()+ ",Nombre : "+control.getManagementGame().getTurn().getNickName());
				dates=control.fillReport();
				dates[3]=valueDices+"";
				dates[5]="En juego";
				dates[7]=" ";
				addReport(dates);
			}else { 
				if (valueDices==2||valueDices==3||valueDices==12) {
					dates=control.fillReport();
					dates[3]=valueDices+"";
					dates[5]="Eiminado";
					dates[7]=(control.getManagementGame().getPlayers().size())+"";
					readInput(LEAVE);
					//control.getManagementGame().setTurn(control.getManagementGame().findPlayerNode(control.getManagementGame().getTurn().getId()).getNext().getInfo());
					//mainWindow.getViewWelcome().getLblTitle().setText("Lanza el jugador: "+control.getManagementGame().getTurn().getId()+ ",Nombre : "+control.getManagementGame().getTurn().getNickName());
				}else {
					control.getManagementGame().getTurn().setNumFling(1);
					control.getManagementGame().getTurn().setPoint(valueDices);
					dates=control.fillReport();
					dates[3]=valueDices+"";
					dates[5]="En juego";
					dates[7]=" ";
					addReport(dates);

				}
			}
			//siguiente turno
		}else {
			System.out.println("Entro depues de la segunda opcion");
			if (valueDices==7) {
				dates=control.fillReport();
				dates[3]=valueDices+"";
				dates[5]="Eliminado";
				dates[7]=(control.getManagementGame().getPlayers().size())+"";
				readInput(LEAVE);
				//control.getManagementGame().setTurn(control.getManagementGame().findPlayerNode(control.getManagementGame().getTurn().getId()).getNext().getInfo());
				//mainWindow.getViewWelcome().getLblTitle().setText("Lanza el jugador: "+control.getManagementGame().getTurn().getId()+ ",Nombre : "+control.getManagementGame().getTurn().getNickName());
			}else {
			if (control.getManagementGame().getTurn().getPoint()==valueDices) {
				//jugador gana,sigue en el juego
				control.getManagementGame().getTurn().setNumFling(0);
				control.getManagementGame().getTurn().setPoint(0);
				control.getManagementGame().setTurn(control.getManagementGame().findPlayerNode(control.getManagementGame().getTurn().getId()).getNext().getInfo());
				mainWindow.getViewWelcome().getLblTitle().setText("Lanza el jugador: "+control.getManagementGame().getTurn().getId()+ ",Nombre : "+control.getManagementGame().getTurn().getNickName());
				dates=control.fillReport();
				dates[3]=valueDices+"";
				dates[5]="En juego";
				dates[7]=" ";
				addReport(dates);
			}else {
				
					dates=control.fillReport();
					dates[3]=valueDices+"";
					dates[5]="En Juego";
					dates[7]="";
					addReport(dates);
			}
			}
		}

		if(control.getPlayers().size()==1) {
			mainWindow.getViewWelcome().getLblTitle().setText("¡¡¡GANASTEEE!!! : "+control.getManagementGame().getTurn().getNickName());
			mainWindow.getViewWelcome().getBtnThrow().setEnabled(false);
			mainWindow.getViewWelcome().getBtnLeave().setEnabled(false);
			dates=control.fillReport();
			dates[3]=" ";
			dates[5]="Ganador";
			dates[7]=control.getPlayers().size()+"";
			addReport(dates);

		}

		//quedan dos jugadores
		//		if (control.getManagementGame().getNumPlayers()==2) {
		//			if (control.getManagementGame().getTurn().getPoint()==valueDices) {
		//				control.getManagementGame().setTurn(control.getManagementGame().findPlayerNode(control.getManagementGame().getTurn().getId()).getNext().getInfo());
		//				mainWindow.getViewWelcome().getLblTitle().setText("Lanza el jugador: "+control.getManagementGame().getTurn().getId()+ ",Nombre : "+control.getManagementGame().getTurn().getNickName());
		//			}else if (valueDices==7) {
		//				readInput(LEAVE);
		//			}
		//		}

	}

	@Override
	public String[] readInput(String option) {
		switch (option) {
		case ActionsGame.PLAY:
			playerWindow.getPlayerPanel().getTxtCode().setBorder(BorderFactory.createLineBorder(Color.WHITE));
			playerWindow.getPlayerPanel().getTxtName().setBorder(BorderFactory.createLineBorder(Color.WHITE));
			playerWindow.getPlayerPanel().getTxtBudget().setBorder(BorderFactory.createLineBorder(Color.WHITE));
			beginWindow.setVisible(false);
			mainWindow.setVisible(false);
			playerWindow.setVisible(true);
			control.getManagementGame().setNumPlayers(Integer.parseInt(beginWindow.getPanelBegin().getSpnNumberPlayers().getValue().toString()));
			break;
		case ActionsGame.STAR_GAME:
			beginWindow.setVisible(false);
			playerWindow.setVisible(false);
			mainWindow.setVisible(true);

			control.getManagementGame().generateTurn();
			String lblId=control.getManagementGame().getTurn().getId();
			String lblNickName=control.getManagementGame().getTurn().getNickName();
			mainWindow.getViewWelcome().getLblTitle().setText("Lanza el Jugador: "+lblNickName+" --- Codigo = "+lblId);
			dates=control.fillReport();
			dates[3]=" ";
			dates[5]="En juego";
			dates[7]="";
			addReport(dates);
			//viewWelcome.getLblImageDiceOne().setIcon(gifDice1(mngGame.generateDices()));

			break;
		case ActionsGame.WINDOW_GAME:
			mainWindow.getViewRules().setVisible(false);
			mainWindow.getViewWelcome().setVisible(true);
			break;
		case ActionsGame.RULES:
			mainWindow.getViewWelcome().setVisible(false);
			mainWindow.getViewRules().setVisible(true);
			break; 
		case ActionsGame.BACK_BEGIN:
			beginWindow.setVisible(true);
			mainWindow.setVisible(false);
			playerWindow.setVisible(false);
			control.setManagementGame(new ManagementGame());

			playerWindow.getPlayerPanel().getBtnPlayGame().setEnabled(false);
			playerWindow.getPlayerPanel().getBtnAddPlayer().setEnabled(true);
			mainWindow.getViewWelcome().getBtnThrow().setEnabled(true);
			mainWindow.getViewWelcome().getBtnLeave().setEnabled(true);

			playerWindow.getPlayerPanel().getTxtCode().setEditable(true);
			playerWindow.getPlayerPanel().getTxtName().setEnabled(true);
			playerWindow.getPlayerPanel().getTxtBudget().setEditable(true);

			playerWindow.getPlayerPanel().getTxtCode().setBackground(Color.white);
			playerWindow.getPlayerPanel().getTxtName().setBackground(Color.white);
			playerWindow.getPlayerPanel().getTxtBudget().setBackground(Color.white);
			
			while (mainWindow.getViewWelcome().getModelTab().getRowCount()>0) {
				mainWindow.getViewWelcome().getModelTab().removeRow(0);
			}
//			String[] headings=new String[]{"ID","Nombre","Presupuesto", "Puntaje","Punto","Estado","Jugadores restantes","Posición"};
//			mainWindow.getViewWelcome().setModelTab(new DefaultTableModel(headings,0));
//			mainWindow.getViewWelcome().setTable(new JTable(mainWindow.getViewWelcome().getModelTab()));
			break;
		case ActionsGame.THROW_DICE: 
			logicthrowDice();
			break; 
		case ActionsGame.LEAVE:
			if(control.getPlayers().size()>1) {
				Node<Player> nodeNext=control.getManagementGame().findPlayerNode(control.getManagementGame().getTurn().getId()).getNext();
				Player delPlayer=control.getManagementGame().detelePlayer(control.getManagementGame().getTurn());
				control.getManagementGame().setTableMoney(control.getManagementGame().getTableMoney()+delPlayer.getMoney());
				control.getManagementGame().setTurn(nodeNext.getInfo());
				mainWindow.getViewWelcome().getLblTitle().setText("Lanza el jugador: "+nodeNext.getInfo().getId()+ ",Nombre : "+nodeNext.getInfo().getNickName());
			}
			addReport(dates);
			break; 
		case ActionsGame.LEAVE_GAME:
			if(control.getPlayers().size()>1) {
				Node<Player> nodeNext=control.getManagementGame().findPlayerNode(control.getManagementGame().getTurn().getId()).getNext();
				Player delPlayer=control.getManagementGame().detelePlayer(control.getManagementGame().getTurn());
				control.getManagementGame().setTableMoney(control.getManagementGame().getTableMoney()+delPlayer.getMoney());
				control.getManagementGame().setTurn(nodeNext.getInfo());
				mainWindow.getViewWelcome().getLblTitle().setText("Lanza el jugador: "+nodeNext.getInfo().getId()+ ",Nombre : "+nodeNext.getInfo().getNickName());
			}
			dates[3]=" ";
			dates[5]="Abandono";
			dates[7]="";
			addReport(dates);
			if(control.getPlayers().size()==1) {
				mainWindow.getViewWelcome().getLblTitle().setText("¡¡¡GANASTEEE!!! : "+control.getManagementGame().getTurn().getNickName());
				mainWindow.getViewWelcome().getBtnThrow().setEnabled(false);
				mainWindow.getViewWelcome().getBtnLeave().setEnabled(false);
				dates=control.fillReport();
				dates[3]=" ";
				dates[5]="Ganador";
				dates[7]=control.getPlayers().size()+"";
				addReport(dates);

			}
			break;
		case ActionsGame.ADD_PLAYER:
			String id=playerWindow.getPlayerPanel().getTxtCode().getText();
			String nickName=playerWindow.getPlayerPanel().getTxtName().getText();
			String value=playerWindow.getPlayerPanel().getTxtBudget().getText();
			if (id.equals("")) {
				//playerWindow.getPlayerPanel().getTxtCode().setBackground(new Color(255,105,97));
				playerWindow.getPlayerPanel().getTxtCode().setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			if (nickName.equals("")) {
				//playerWindow.getPlayerPanel().getTxtName().setBackground(new Color(255,105,97));
				playerWindow.getPlayerPanel().getTxtName().setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			if (value.equals("")) {
				//playerWindow.getPlayerPanel().getTxtBudget().setBackground(new Color(255,105,97));
				playerWindow.getPlayerPanel().getTxtBudget().setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			if(id.equals("")||nickName.equals("")||value.equals("")) {
				JOptionPane.showMessageDialog(playerWindow, "Por favor digita Todos los espacios en blanco");
				return null;
			}else {
				playerWindow.getPlayerPanel().getTxtCode().setBorder(BorderFactory.createLineBorder(Color.WHITE));
				playerWindow.getPlayerPanel().getTxtName().setBorder(BorderFactory.createLineBorder(Color.WHITE));
				playerWindow.getPlayerPanel().getTxtBudget().setBorder(BorderFactory.createLineBorder(Color.WHITE));
				//playerWindow.getPlayerPanel().getTxtCode().setBackground(Color.WHITE);
				//playerWindow.getPlayerPanel().getTxtName().setBackground(Color.WHITE);
				//playerWindow.getPlayerPanel().getTxtBudget().setBackground(Color.WHITE);
				if(control.getPlayers().size()==control.getManagementGame().getNumPlayers()) {
					playerWindow.getPlayerPanel().getBtnPlayGame().setEnabled(true);
					JOptionPane.showMessageDialog(playerWindow, "Ya digitaste todos los jugadores De este juego");
				}else {
					return new String[]{id,nickName,value};
				}
			}

		case "otro valor":

			break;

		}

		return null;
	}

	@Override
	public void writeOutput(String option, String[] output, boolean state) {
		switch (option) {
		case ActionsGame.ADD_PLAYER:
			if(output!=null) {
				if(state) {
					JOptionPane.showMessageDialog(playerWindow, "El Jugador Fue agregado Corectamente");
					playerWindow.getPlayerPanel().getLblTitlePlayer().setText("Por Favor Agrega el jugador numero :"+(control.getPlayers().size()+1));
					playerWindow.getPlayerPanel().getTxtCode().setText("");
					playerWindow.getPlayerPanel().getTxtName().setText("");
					playerWindow.getPlayerPanel().getTxtBudget().setText("");
					if(control.getPlayers().size()==control.getManagementGame().getNumPlayers()) {
						playerWindow.getPlayerPanel().getBtnPlayGame().setEnabled(true);
						playerWindow.getPlayerPanel().getLblTitlePlayer().setText("Ya Digitaste todos Los jugadores");
						playerWindow.getPlayerPanel().getBtnAddPlayer().setEnabled(false);

						playerWindow.getPlayerPanel().getTxtCode().setEditable(false);
						playerWindow.getPlayerPanel().getTxtName().setEnabled(false);
						playerWindow.getPlayerPanel().getTxtBudget().setEditable(false);

						playerWindow.getPlayerPanel().getTxtCode().setBackground(Color.gray);;
						playerWindow.getPlayerPanel().getTxtName().setBackground(Color.gray);;
						playerWindow.getPlayerPanel().getTxtBudget().setBackground(Color.gray);;
					}
				}else {
					JOptionPane.showMessageDialog(playerWindow,"No se puede agregar el jugador porque ya existe");
				}
			}else {
			}
			break;

		default:
			break;
		}

	}

	public ImageIcon iconImageDiceOne=null; 

	public ImageIcon gifDice1(int Dice1) {

		switch (Dice1) {
		case 1:
			iconImageDiceOne = new ImageIcon("resources/dicesPng/1.png"); 
			break;

		case 2: 
			iconImageDiceOne = new ImageIcon("resources/dicesPng/2.png"); 
			break;

		case 3: 
			iconImageDiceOne = new ImageIcon("resources/dicesPng/3.png"); 
			break; 

		case 4:
			iconImageDiceOne = new ImageIcon("resources/dicesPng/4.png"); 
			break;

		case 5: 
			iconImageDiceOne = new ImageIcon("resources/dicesPng/5.png"); 
			break;

		case 6: 
			iconImageDiceOne = new ImageIcon("resources/dicesPng/6.png"); 
			break;	
		}
		return iconImageDiceOne; 

	}

	public void addReport(String[] dates) {	
		String id=dates[0]; 
		String name=dates[1];
		String budget=dates[2]; 
		String score=dates[3]; 
		String point=dates[4]; 
		String state=dates[5]; 
		String restPlayers=dates[6]; 
		String pos=dates[7];
		Object[] dates1= new Object[] {id,name,budget,score,point,state,restPlayers,pos};
		mainWindow.getViewWelcome().getModelTab().addRow(dates1);

	}

	@Override
	public void setControll(ControllGame controll) {
		this.control=controll;
	}

	@Override
	public ControllGame getControll() {
		return control;
	}
}

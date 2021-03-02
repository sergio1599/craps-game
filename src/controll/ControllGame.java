package controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.ManagementWindow;
import model.ActionsGame;
import model.ManagementGame;
import model.Player;

public class ControllGame implements ActionListener{

	private ActionsGame view; 
	private ManagementGame managementGame;
	
	public ControllGame(ActionsGame view) {
		this.view=view; 
		managementGame=new ManagementGame();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case ActionsGame.EXIT:
			view.exit();
			break;
		case ActionsGame.PLAY:
			view.readInput(ActionsGame.PLAY);
			break;
		case ActionsGame.VIEW_WELCOME:
			view.readInput(ActionsGame.VIEW_WELCOME);
			break;
		case ActionsGame.STAR_GAME:
			view.readInput(ActionsGame.STAR_GAME);
			break;
		case ActionsGame.WINDOW_GAME:
			view.readInput(ActionsGame.WINDOW_GAME);
			break;
		case ActionsGame.BACK_BEGIN:
			view.readInput(ActionsGame.BACK_BEGIN);
			break;
		case ActionsGame.ADD_PLAYER:
			addPlayer(view.readInput(ActionsGame.ADD_PLAYER));
			break;
		case ActionsGame.THROW_DICE:
			view.readInput(ActionsGame.THROW_DICE); 
			break; 
		case ActionsGame.LEAVE:
			view.readInput(ActionsGame.LEAVE);
			break; 
		case ActionsGame.RULES:
			view.readInput(ActionsGame.RULES); 
			break; 
		case ActionsGame.LEAVE_GAME:
			view.readInput(ActionsGame.LEAVE_GAME);
			break;
		}
	}

	
	/*private void leavePlayer(String[]dates) {
		if (dates!=null) {
			if (managementGame.detelePlayer()) {
				view.writeOutput(ActionsGame.LEAVE, dates, true);
			}else {
				view.writeOutput(ActionsGame.LEAVE, dates, false);
			}
		}
	}*/
	
	
	private void addPlayer(String[] dates) {
		if(dates!=null) {
			if(managementGame.addPlayer(dates[0],dates[1],Double.parseDouble(dates[2]))) {
				view.writeOutput(ActionsGame.ADD_PLAYER, dates, true);
			}else {
				view.writeOutput(ActionsGame.ADD_PLAYER, dates, false);
			}
			
		}else {
			
		}
	}
	
	public ArrayList<Player> getPlayers(){
		ArrayList<Player> out=managementGame.getPlayers();
		if(out!=null) {
			return (ArrayList<Player>) managementGame.getPlayers();
		}else {
			return new ArrayList<Player>();
		}
		
	}

	public ManagementGame getManagementGame() {
		return managementGame;
	}

	public void setManagementGame(ManagementGame managementGame) {
		this.managementGame = managementGame;
	}
	
	public String[] fillReport() {
		String id=managementGame.getTurn().getId()+"";
		String nombre=managementGame.getTurn().getNickName()+"";
		String presupuesto=managementGame.getTurn().getMoney()+"";
		String puntaje="puntaje"+"";
		String punto=managementGame.getTurn().getPoint()+"";
		String estado="En Juego"+"";
		String jugadores_restantes=getPlayers().size()+"";
		String posicion=getPlayers()+"";
		return new String[] {id,nombre,presupuesto,puntaje,punto,estado,jugadores_restantes,posicion};
	}
	
		
}

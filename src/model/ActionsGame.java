package model;

import controll.ControllGame;

public interface ActionsGame {

	
	public static String EXIT ="Salir";
	public static String VIEW_WELCOME ="VISTA BIENVENIDA"; 
	public static String PLAY= "Jugar"; 
	public static String RULES= "Reglas";
	public static String STAR_GAME="Empezar Juego";
	public static String WINDOW_GAME="Ventana de juego";
	public static String BACK_BEGIN="Regresar al inicio";
	public static String ADD_PLAYER="Agregar jugador";
	public static String THROW_DICE="Lanzar Dados";
	public static String LEAVE="Rendirse"; 
	public static String LEAVE_GAME="Rendirese en el juego";
	void exit(); 
	void begin(); 
	String[] readInput(String option); 
	void writeOutput(String option, String[]output, boolean state); 
	void setControll(ControllGame controll); 
	ControllGame getControll();
}

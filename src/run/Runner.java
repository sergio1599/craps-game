package run;

import controll.ControllGame;
import gui.BeginWindow;
import gui.MainWindow;
import gui.ManagementWindow;

public class Runner {

	public static void main(String[] args) {
		ManagementWindow mg=new ManagementWindow();
		ControllGame controll = new ControllGame(mg);
		mg.setControll(controll);
		mg.begin();

	}
}

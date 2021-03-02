package model;

import java.util.ArrayList;

public class ManagementGame {

	private LinkedListCircle<Player> list;

	private int numPlayers;
	
	private double tableMoney;

	private Player turn;

	public ManagementGame() {
		list=new LinkedListCircle<Player>(Player.compId);
		numPlayers=0;
		turn=null;
		tableMoney=0;
	}

	public boolean addPlayer(String id,String nickName,double money) {
		if(!list.isEmpty()) {
			if(findPlayer(id)==null) {
				list.addBegin(new Node<Player>(new Player(id, nickName, money)));
				return true;
			}else {
				return false;
			}
		}else {
			list.addBegin(new Node<Player>(new Player(id, nickName, money)));
			return true;
		}
	}

	public Player findPlayer(String id) {
		return list.findObject(new Player(id, null, 0.0));
	}

	public Node<Player> findPlayerNode(String id) {
		return list.findNoded(new Player(id, null, 0.0));
	}

	public Player detelePlayer(Player player) {
		if(list.findNoded(player)!=null) {
			return list.deleteNode(list.findNoded(player)).getInfo();
		}else {
			return null;
		}

	}

	public  ArrayList<Player> getPlayers(){
		if(!list.isEmpty()) {
			return list.getList();
		}
		return null;
	}

	public byte generateTurn() {
		int value=(int)(Math.random()*getPlayers().size())+1;
		this.turn=list.getObject(value);
		return (byte)value;
	}

	public int generateDices() {
		int value=(int)(Math.random()*6)+1;
		return value;
	}

	public LinkedListCircle<Player> getList() {
		return list;
	}

	public void setList(LinkedListCircle<Player> list) {
		this.list = list;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Player getTurn() {
		return turn;
	}

	public void setTurn(Player turn) {
		this.turn = turn;
	}

	public double getTableMoney() {
		return tableMoney;
	}

	public void setTableMoney(double tableMoney) {
		this.tableMoney = tableMoney;
	}
	
	
	
}

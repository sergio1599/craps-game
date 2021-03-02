package model;

import java.util.Comparator;

public class Player {
	
	private String id;
	private String nickName;
	private double money;
	private int numFling;
	private int point;
	
	public static Comparator<Player> compId=new Comparator<Player>() {
		
		@Override
		public int compare(Player o1, Player o2) {
			return o1.getId().compareTo(o2.getId());
		}
	};
	
	public Player(String id,String nickName,double money) {
		this.nickName=nickName;
		this.id=id;
		this.money=money;
		numFling=0;
		point=0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getNumFling() {
		return numFling;
	}

	public void setNumFling(int numFling) {
		this.numFling = numFling;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", nickName=" + nickName + ", money=" + money + ", numFling=" + numFling
				+ ", point=" + point + "]";
	}
	
	
	
}

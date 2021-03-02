/*package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.LinkedListCircle;
import model.Node;
import model.Player;

class CircleListTest {

	private LinkedListCircle<Player> list;
	
	private void setup() {
		list=new LinkedListCircle<Player>(Player.compId);
//		list.addBegin(new Node<Player>(new Player("2", "Daniel12", 123)));
//		list.addBegin(new Node<Player>(new Player("3", "Daniel13", 123)));
//		list.addBegin(new Node<Player>(new Player("4", "Daniel14", 123)));
//		list.addBegin(new Node<Player>(new Player("5", "Daniel15", 123)));
		list.addEnd(new Node<Player>(new Player("2", "Daniel12", 123)));
		list.addEnd(new Node<Player>(new Player("3", "Daniel12", 123)));
		list.addEnd(new Node<Player>(new Player("4", "Daniel12", 123)));
		list.addEnd(new Node<Player>(new Player("5", "Daniel12", 123)));
		list.addBegin(new Node<Player>(new Player("6", "Daniel15", 123)));
	}
	
	@Test
	void testFindObject() {
		setup();
		assertEquals("4",list.findNoded(new Player("4", "", 90)).getInfo().getId());
		assertEquals("2",list.findNoded(new Player("2", "", 90)).getInfo().getId());
		assertEquals("5",list.findNoded(new Player("5", "", 90)).getInfo().getId());
		for (Player player : list.getList()) {
			System.out.println(player.toString());
		}
		System.out.println("______________________");
	}
	
	@Test
	void testDeleteNode() {
		setup();
		assertEquals("5",list.deleteNode(list.findNoded(new Player("5","Daniel",0))).getInfo().getId());
		assertNull(list.findObject(new Player("5","Daniel",0)));
		assertEquals("4",list.deleteNode(list.findNoded(new Player("4","Daniel",0))).getInfo().getId());
		assertEquals("6",list.deleteNode(list.findNoded(new Player("6","Daniel",0))).getInfo().getId());
		assertEquals("3",list.deleteNode(list.findNoded(new Player("3","Daniel12",123))).getInfo().getId());
		for (Player player : list.getList()) {
			System.out.println(player.toString());
		}
	}
	
	@Test
	void testFindNextObject() {
		setup();
		assertEquals("5", list.findNoded(new Player("4", "", 0.0)).getNext().getInfo().getId());
		assertEquals("6", list.findNoded(new Player("5", "", 0.0)).getNext().getInfo().getId());
		assertEquals("2", list.findNoded(new Player("6", "", 0.0)).getNext().getInfo().getId());
		assertEquals("3", list.findNoded(new Player("2", "", 0.0)).getNext().getInfo().getId());
		assertEquals("4", list.findNoded(new Player("3", "", 0.0)).getNext().getInfo().getId());
	}

}*/

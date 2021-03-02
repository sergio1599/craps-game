package model;

import java.util.ArrayList;
import java.util.Comparator;

public class LinkedListCircle <T>{

	private Node<T> head;

	private Comparator<T> comparator;

	public LinkedListCircle(Comparator<T> comparator) {
		this.comparator=comparator;
		head=null;
	}

	public boolean isEmpty() {
		return head==null;
	}

	public void addBegin(Node<T> node) {

		if(isEmpty()) {
			head=node;
			node.setNext(node);
		}else {
			node.setNext(head.getNext());
			head.setNext(node);
		}
	}

	public Node<T> findNoded(T info){
		Node<T> node=head;
		do {
			if(comparator.compare(node.getInfo(),info)==0) {
				return node;
			}
			node=node.getNext();
		} while (node!=head);

		return null;
	}

	public T findObject(T info) {
		Node<T> node=head;

		do {
			if(comparator.compare(node.getInfo(),info)==0) {
				return node.getInfo();
			}
			node=node.getNext();
		} while (node!=head);
		return null;
	}

	public Node<T> getObjecNode(T info) {
		Node<T> node=head;

		do {
			if(comparator.compare(node.getInfo(),info)==0) {
				return node;
			}
			node=node.getNext();
		} while (node!=head);
		return null;
	}

	public Node<T> deleteNode(Node<T> node) {
		Node<T> aux=head;
		do {
			if(node==head&&aux.getNext()==head) {
				aux.setNext(node.getNext());
				head=aux;
				return node;
			}else {
			if(aux.getNext()==node) {
				aux.setNext(node.getNext());
				return node;
			}
			} 
			aux=aux.getNext();
		} while (aux!=head);
		return null;
	}

	public ArrayList<T> getList(){
		ArrayList<T> out=new ArrayList<>();
		Node<T> node=head;
		do {
			out.add(node.getNext().getInfo());
			node=node.getNext();
		} while (node!=head);

		return out;
	}

	public T getObject(int pos) {
		Node<T> node=head; 
		for (int i = 1; i <= getList().size(); i++) {
			if(i==pos) {
				return node.getInfo();
			}
			node=node.getNext();
		}

		return null;
	}
	
	public void addEnd(Node<T> node) {
		if(!isEmpty()) {
			node.setNext(head.getNext());
			head.setNext(node);
			head=node;
		}else {
			head=node;
			head.setNext(node);
		}

	}
}

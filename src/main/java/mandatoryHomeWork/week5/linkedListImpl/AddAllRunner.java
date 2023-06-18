package linkedListImpl;

import org.junit.Test;

import linkedListImpl.MyLinkedList.Node;

public class AddAllRunner extends MyLinkedList{

	@Test
	public void Nodes() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(3);
		newNode.next.next.next=new Node(4);
		newNode.next.next.next.next=new Node(5);
		
		Node newNode1 = new Node(6);
		newNode1.next=new Node(7);
		newNode1.next.next=new Node(8);
		newNode1.next.next.next=new Node(9);
		newNode1.next.next.next.next=new Node(10);
		
		//displayNode(newNode1);
		displayNode(addAll(newNode,newNode1));
	}
	
	@Test
	public void addNode2() {

		Node newNode = new Node(6);
		newNode.next=new Node(7);
		newNode.next.next=new Node(8);
		newNode.next.next.next=new Node(9);
		newNode.next.next.next.next=new Node(10);
		
		
	}
}

package week5.day1;

import org.junit.Test;

import linkedListImpl.MyLinkedList;
import linkedListImpl.MyLinkedList.Node;

public class LC_876_MiddleOfTheLinkedList extends MyLinkedList{

	@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(3);
		newNode.next.next.next=new Node(4);
		newNode.next.next.next.next=new Node(5);
		
		displayNode(middleNode(newNode));
	}
	
	@Test
	public void addNode2() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(3);
		newNode.next.next.next=new Node(4);
		newNode.next.next.next.next=new Node(5);
		newNode.next.next.next.next.next=new Node(6);
		
		displayNode(middleNode(newNode));
	}

	@Test
	public void addNode3() {

		Node newNode = new Node(1);
		
		displayNode(middleNode(newNode));
	}
	
	@Test
	public void addNode4() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		displayNode(middleNode(newNode));
	}
	//Time complexity ---> O(n)
	//Space Complexity ---> O(1)
	private Node middleNode(Node newNode) {
		//Find the size of the node
		int nodeSize = size(newNode);
		//System.out.println(nodeSize);
		
		//find the mid index of the node
		int mid=nodeSize/2;
		//System.out.println(mid);
		
		//return head if we have one node
		if(nodeSize==1) return newNode;
		
		//set a counter
		int count=-1;
		
		//assing the input node as head
		Node head=newNode;
		
		//traverse from head using head node itself till mid node without using temp node.
		while(count<=mid) {
			count++;
			if(count==mid) {
				return head;
			}
			head=head.next;
		}
		return head;
	}

}

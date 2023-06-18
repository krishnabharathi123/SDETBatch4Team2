package week5.day4;

import org.junit.Test;

import linkedListImpl.MyLinkedList;
import linkedListImpl.MyLinkedList.Node;

public class LC_61_RotateList extends MyLinkedList{
	@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(3);
		newNode.next.next.next=new Node(4);
		newNode.next.next.next.next=new Node(5);
		
		int k = 2;
			
		displayNode(rotateList(newNode,k));
		
	}
	

	@Test
	public void addNode2() {

		Node newNode = new Node(0);
		newNode.next=new Node(1);
		newNode.next.next=new Node(2);
		
		int k = 4;
		
		displayNode(rotateList(newNode,k));
		
		
	}
	
	@Test
	public void addNode3() {

		Node newNode = new Node();
		
		int k = 1;
		
		displayNode(rotateList(newNode,k));
		
		
	}
	
	
	
	/*
	 * Initiate the count variable as 0
	 * Find the head node
	 * loop till the count<k
	 * Set head node as temp and find the tail node and tail before node using temp.next.next!=null
	 * set tail.next=head;
	 * head=tail;
	 * t1.next=null;
	 * count++;
	 * 
	 */
	
	//Time Complexity ---> O(n*m)
	//Space Complexity --> O(n)
	private Node rotateList(Node newNode, int k) {
		MyLinkedList ll=new MyLinkedList();
		int count=0;
		Node head=newNode;
		//to handle null node
		if(ll.size(head)==1) {
			//return newNode;
			return head;
		}
		else if(head==null) {
			//return newNode;
			return head;
		}
		else{
		while(count<k) {
			Node temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
				Node tail=temp.next;
				tail.next=head;
				head=tail;
				temp.next=null;
				count++;
			
		}
		}
		
		return newNode;
	}
}

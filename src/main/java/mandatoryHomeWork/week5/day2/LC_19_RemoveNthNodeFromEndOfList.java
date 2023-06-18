package week5.day2;

import org.junit.Test;

import linkedListImpl.MyLinkedList;
import linkedListImpl.MyLinkedList.Node;

public class LC_19_RemoveNthNodeFromEndOfList extends MyLinkedList {

	
	@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(3);
		newNode.next.next.next=new Node(4);
		newNode.next.next.next.next=new Node(5);
		
		int n = 2;
		displayNode(removeEndNode(newNode,n));
		
	}
	
	@Test
	public void addNode2() {

		Node newNode = new Node(1);
		
		int n = 1;
		displayNode(removeEndNode(newNode,n));
		
	}
	
	@Test
	public void addNode3() {
		
		Node newNode = new Node(1);
		newNode.next=new Node(2);
		
		int n = 1;
		displayNode(removeEndNode(newNode,n));
		
	}
  //Overall time taken --> 1hr
	/*
	 * Find the size of the list(node)
	 * Find the index of element to be removed using size-n
	 * have a temp nodes--> temp1 and temp2
	 * Initiate head node as temp1 and head.next node as temp2
	 * loop till temp2.next !=null
	 * --> Increment the counter and traverse temp1 and temp2 from head till tep2 reaches index of element to be removed.
	 * ----> check if count == index of removable element ---> If yes, return head.
	 */
	// Time Complexity ---> O(n)
	// Space Complexity ---> O(n)
	private Node removeEndNode(Node head, int n) {
		
		MyLinkedList ll=new MyLinkedList();
		int nodeSize=ll.size(head);
		int removeIndex=nodeSize-n;
		int count=0;
		Node temp1=head;
		Node temp2=head.next;
		
		//when removable index is 0
		//remove the head alone
		if(removeIndex==0) {
			head=head.next;
			return head;
		}
		
		//regular case
		else {
		while(temp2.next!=null) {
			count++;
			if(count==removeIndex) {
				temp1.next=temp2.next;
				return head;
			}
			
			temp2=temp2.next;
			temp1=temp1.next;
		}
		//when removable index is last one
		//remove the temp2 node
			count++;
			if(count==removeIndex) {
				temp1.next=null;
				return head;
			}
		}
		
		
		
		return null;
	}
}

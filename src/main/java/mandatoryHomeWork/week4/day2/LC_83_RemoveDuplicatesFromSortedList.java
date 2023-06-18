package week4.day2;

import org.junit.Test;

import linkedListImpl.MyLinkedList;
import week4.day1.linkedListImplementation.Node;

public class LC_83_RemoveDuplicatesFromSortedList extends MyLinkedList{

	@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next=new Node(1);
		newNode.next.next=new Node(2);
		newNode.next.next.next=new Node(3);
		newNode.next.next.next.next=new Node(3);
		Node removeDuplicate = removeDuplicate(newNode);
		display(removeDuplicate);
		
	}
	
	@Test
	public void addNode2() {

		Node newNode = new Node(1);
		newNode.next=new Node(1);
		newNode.next.next=new Node(1);
		newNode.next.next.next=new Node(3);
		newNode.next.next.next.next=new Node(3);
		Node removeDuplicate = removeDuplicate(newNode);
		display(removeDuplicate);
		
	}
	
	@Test
	public void addNode3() {

		Node newNode = new Node(1);
		newNode.next=new Node(1);
		newNode.next.next=new Node(1);
		newNode.next.next.next=new Node(1);
		newNode.next.next.next.next=new Node(1);
		Node removeDuplicate = removeDuplicate(newNode);
		display(removeDuplicate);
		
	}
	
	@Test
	public void addNode4() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(3);
		newNode.next.next.next=new Node(4);
		newNode.next.next.next.next=new Node(5);
		Node removeDuplicate = removeDuplicate(newNode);
		display(removeDuplicate);
		
	}
	
	@Test
	public void addNode5() {

		Node newNode = new Node(1);
		newNode.next=new Node(1);
		newNode.next.next=new Node(2);
		Node removeDuplicate = removeDuplicate(newNode);
		display(removeDuplicate);
		
	}
	
	public void display(Node head) {
		Node n=head;
		
		if(head==null) {
			System.out.println("empty list");
			return;
		}
		else {
			//Node currentNode=head;
			while(n.next!=null) {
				
				System.out.println(n.data);
				n = n.next;
			}			
			System.out.println(n.data);
		}
		
	}
	public int size(Node head) {
		Node n=head;
		int count=0;
		if(head == null) {
			return 0;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				count++;
				temp=temp.next;
			}
			count=count+1;
		}
		return count;
	}
	private Node removeDuplicate(Node newNode) {
		
		Node head=newNode;
		
		if(head==null) {
			System.out.println("empty node");
		}
		else if(size(head)==1) {
			return head;
		}
		else {
			Node temp=head;
			//Node nextTemp=temp.next;
			while(temp.next.next!=null) {
				if(temp.data==temp.next.data) {
					temp.next=temp.next.next;
				}
				else {
					temp=temp.next;
					//nextTemp=temp.next;
				}
			}
			if(temp.data==temp.next.data) {
				temp.next=null;
			}
		}
		return head;
	}
	
}

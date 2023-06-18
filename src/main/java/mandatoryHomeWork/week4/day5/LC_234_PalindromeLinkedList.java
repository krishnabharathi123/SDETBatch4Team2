package week4.day5;

import org.junit.Test;

import linkedListImpl.MyLinkedList;
import linkedListImpl.MyLinkedList.Node;

public class LC_234_PalindromeLinkedList extends MyLinkedList{

	@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(2);
		newNode.next.next.next=new Node(1);
		
		System.out.println(palindromeCheck(newNode));
	}

	@Test
	public void addNode2() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		
		
		System.out.println(palindromeCheck(newNode));
	}
	
	@Test
	public void addNode3() {

		Node newNode = new Node(0);
		newNode.next=new Node(0);
		
		
		System.out.println(palindromeCheck(newNode));
	}
	
	@Test
	public void addNode4() {

		Node newNode = new Node(0);
		
		System.out.println(palindromeCheck(newNode));
	}
	private boolean palindromeCheck(Node newNode) {
		Node head;
		Node tail=null;
		Node temp;
		
		head=newNode;
		//when we have one element in node
		if(head.next==null) return true;
		
		//assigning head and tail for 1st time
		 temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		tail=temp.next;
		//count++;
		
		if(head.data!=tail.data) return false;
		
		//other elements
		//temp=head;
		while(head.next!=tail && head==tail) {
			head=head.next;
			
			while(temp.next.next!=tail) {
				temp=temp.next;
			}
			tail=temp.next;
			if(head.data!=tail.data) return false;
		}
			
		
		return true;
		
	}
	
	private boolean palindromeCheck1(Node newNode) {
		Node head;
		Node tail=null;
		Node temp;
		
		head=newNode;
		//when we have one element in node
		if(head.next==null) return true;
		
		//assigning head and tail for 1st time
		 temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		tail=temp.next;
		//count++;
		
		if(head.data!=tail.data) return false;
		
		//other elements
		//temp=head;
		while(head.next!=tail && head==tail) {
			head=head.next;
			
			while(temp.next.next!=tail) {
				temp=temp.next;
			}
			tail=temp.next;
			if(head.data!=tail.data) return false;
		}
			
		
		return true;
		
	}
}

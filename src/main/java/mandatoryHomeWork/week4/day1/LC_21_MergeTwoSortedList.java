package week4.day1;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LC_21_MergeTwoSortedList {

	@Test
	public void addNode1() {

		Node node1 = new Node(1);
		node1.next=new Node(2);
		node1.next.next=new Node(4);
		
		Node node2 = new Node(3);
		node2.next=new Node(5);
		node2.next.next=new Node(6);
		
		displayNode(mergeList(node1, node2));
		
		
	}

	private Node mergeList(Node node1, Node node2) {
		//creating a new node
		Node n3 = new Node();
		//assigning the new node as head node
		Node head = n3;
		//handling 1st node
		
		Node temp=null;
		while(node1.next!=null && node2.next!=null) {
		if(head.data==0) {
			if(node1.data<node2.data) {
				head.data=node1.data;
				node1=node1.next;
			}
			else {
				head.data=node2.data;
				node2=node2.next;

			}
		}
		
		else {
			
				 temp=head;
				if(node1.data<node2.data) {
					temp.next=new Node(node1.data);
					node1=node1.next;
					temp=temp.next;
				}
				else {
					temp.next=new Node(node2.data);
					node2=node2.next;
					temp=temp.next;
				}
			}
		}
		
		if(node1.data<node2.data) {
			temp.next=new Node(node1.data);
			node1=node1.next;
			temp=temp.next;
		}
		else {
			temp.next=new Node(node2.data);
			node2=node2.next;
			temp=temp.next;
		}
		return n3;
		
	}
}

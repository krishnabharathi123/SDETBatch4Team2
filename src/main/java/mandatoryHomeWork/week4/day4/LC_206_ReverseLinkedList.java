package week4.day4;

import org.junit.Test;

import linkedListImpl.MyLinkedList;
import linkedListImpl.MyLinkedList.Node;

public class LC_206_ReverseLinkedList extends MyLinkedList {

	@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next = new Node(2);
		newNode.next.next = new Node(3);
		newNode.next.next.next = new Node(4);
		newNode.next.next.next.next = new Node(5);
		Node reverse = reverseList(newNode);
		display(reverse);

	}

	public Node reverseList(Node head) {
		Node revNode=null;
		int size=1;
		if (head == null) {
			return null;
		} else if (size(head) == 1) {
			return head;
		}

		else {
			Node temp = head;
			Node tail=null;
			while (temp.next != null) {
				if (revNode==null) {
					revNode = new Node();
					revNode.data = temp.data;
					revNode.next = null;
					tail = revNode;
					//size++;
					
				} else {
					revNode = new Node();
					revNode.data = temp.data;
					revNode.next = tail;
					tail = revNode;
				}
				temp=temp.next;
				
				revNode = new Node();
				revNode.data = temp.data;
				revNode.next = tail;
			}
		}
		return revNode;

	}
}

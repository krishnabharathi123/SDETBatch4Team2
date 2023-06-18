package week4.day3;

import org.junit.Test;

import linkedListImpl.MyLinkedList;
import linkedListImpl.MyLinkedList.Node;

public class LC_203_RemoveLinkedListElements extends MyLinkedList {
	@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next = new Node(2);
		newNode.next.next = new Node(6);
		newNode.next.next.next = new Node(3);
		newNode.next.next.next.next = new Node(4);
		newNode.next.next.next.next.next = new Node(5);
		newNode.next.next.next.next.next.next = new Node(6);

		int val = 6;

	}

	@Test
	public void addNode2() {

		Node newNode = new Node();

		int val = 1;
		Node removeElements = removeElements(newNode, val);
		display(removeElements);

	}

	@Test
	public void addNode3() {

		Node newNode = new Node(7);
		newNode.next = new Node(7);
		newNode.next.next = new Node(7);
		newNode.next.next.next = new Node(7);

		int val = 7;
		Node removeElements = removeElements(newNode, val);
		display(removeElements);
	}

	public Node removeElements(Node head, int val) {

		if (head == null) {

			return head;
		} else {
			Node temp = head;
			Node temp1 = head.next;
			while (temp.next != null) {
				if (temp.data == val) {
					if (temp == head) {
						head = head.next;
						temp = head;
					}
					else {
						
					}
				} 
				else {
					temp = temp.next;
				}
			}
			if (temp.data == val && temp == head) {
				head = null;
				temp = head;
			}
		}
		return head;

	}
}

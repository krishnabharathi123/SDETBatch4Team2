package week4.day1.linkedListImplementation;
import java.util.HashMap;
public class LinkedList {

	// Our own implementation of Linked List
	// To indicate the 1st node as head node

	Node head = null;

	public void insert(int data) {
		// for every insert we need to create a node with the given value
		Node node = new Node();
		node.data = data;
		node.next = null;
		// check if head node is empty. If yes, assign the created node as a head
		if (head == null) {
			head = node;
		}
		// If head node is not empty, use a temp variable and jump till the
		// node.next!=null and add ur node at last position
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
				// temp.next=node;
			}
			temp.next = node;
		}
	}

	//100
	public void display() throws Exception {
		// have to start from head node
		Node n = head;
		if (head == null) {
			System.out.println("list is empty");
			return;

		} else {

			while (n.next != null) {
			
			System.out.println(n.data);
			n = n.next;
			}
		}
			System.out.println(n.data);
		/*
		 * try { System.out.println(n.data); } catch (Exception e) {
		 * System.out.println("list is empty"); }
		 */
	}

	// 10,25,35,45
	public int size() {
		Node n = head;
		int count = 0;
		if (head == null) {
			//System.out.println(count);
			return count;
		} else {
			while (n.next != null) {
				count++;// 3
				n = n.next;
			}
			return count + 1;
		}
	}
	
	public void displayInString() {
		Node n=head;
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		if(head==null) {
			//System.out.println("list is empty");
			System.out.println("[]");
			return;
		}
		else {
			while(n.next!=null) {
				//System.out.println("in");
				sb.append(n.data+",");
				n=n.next;
				}
			sb.append(n.data+",");
		}
		sb.append("]");
		System.out.println(sb);
	}
	
	/*
	 * assign a index variable as 0
	 * start from head node
	 * use a Hashmap to store index and data
	 * Check whether the list is empty. If yes, return -1
	 * If no, loop till the node.next is not equal to null and add the index and data in hashmap
	 * Validate whether the given index is not available in map. If yes, return -1.
	 * return the value of index
	 */
	public int get(int indx) {
		int index=0;
		Node n=head;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		//return -1 if the head is null i.e empty list
		if(head==null) {
			//System.out.println("Empty List");
			return -1;
		}
		else {
		while(n.next!=null) {
			map.put(index, n.data);
			index++;
			n=n.next;
		}
		map.put(index, n.data);
		}
		//return -1 if the given index is greater than map size
		if(!map.containsKey(indx)) {
			return -1;
		}
		return map.get(indx);
	}
	
	public int indexOf(int data) {
		int index=0;
		Node n=head;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		if(head==null) {
			//System.out.println("Empty List");
			return -1;
		}
		else {
		while(n.next!=null) {
			map.put(n.data, index);
			index++;
			n=n.next;
		}
		map.put(n.data, index);
		}
		//return -1 if the given index is greater than map size
		if(!map.containsKey(data)) {
			return -1;
		}
		return map.get(data);
	}
	
	public Node getHeadNode(int data ) {
		Node n = head;
		n.data=data;
		n.next=n.next;
		System.out.println(n.data);
		System.out.println(n.next);
		return head;
		
	}
}

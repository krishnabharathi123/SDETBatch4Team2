package myLinkedList;

import myLinkedList.LinkedListImpl.Node;

public class LinkedListImpl {
	
	Node head=null;
	Node tail = null;
	int size=0;
	
	//----------Inner class for Node-----------
	class Node{
		int val;
		Node next;
		
		//Constructor to create a node with value and next as null
		Node(int val){
			this.val=val;
		}
		
		//Constructor to create a node with value and next node
		Node(int val, Node node){
			this.val=val;
			this.next=node;
			
		}
	}
	
	// -------Method1: ------
	//insert node a beginning
	public void insertAtStart(int data) {
		//creating a node with give value
		
		Node node = new Node(data);
		
		//if head is null, then assign the created node as head and tail
		
		if(head==null) {
			head=tail=node;
			size++;
			return;
		}
		//if head is not null, then join the next of created node to the head
		//reassign the new node as head
		
		node.next=head;
		head=node;
		size++;
		
	}
	
	// -------Method2: ------
	//print all the node values from head
	public void display() {
		//assign head to a temp variable so that it can traverse without loosing head
		Node temp=head;
		
		while(temp!=null) {
			System.out.print(temp.val + "-->");
			temp=temp.next;
		}
		System.out.println();
	}
	
	// -------Method3: ------
	//insert node at end
	public void insertAtEnd(int data) {
		//creating a node with give value
		
		Node node = new Node(data);
		
		//if head is null, then assign the created node as head and tail
		if(head==null) {
			tail=head=node;
			size++;
			return;
		}
		
		//if tail is not null, then join the next of tail to the created node
		//reassign the new node as tail
		tail.next=node;
		tail=node;
		size++;
		
	}
	
	// -------Method4: ------
	//insert node at the specified index
	public void insertAtPosition(int index, int val) {
		
		
		//if need to insert in the 0th index, use insertAtStart
		if(index==0) {
			insertAtStart(val);
			return;
		}
		//if need to insert at the last index, use insertAtEnd
		if(index==size) {
			insertAtEnd(val);
			return;
		}
		//if insertion of the Node in middle, 
		//traverse from head till the index-1 and assign it as temp
		//store the temp.next nodes in a new variable called temp1
		//Now, link temp.next to the new node and new node.next to temp1
		Node temp=head;
		int count=0;
		while(count!=index-1) {
			temp=temp.next;
			count++;
		}
		Node node=new Node(val);
		Node temp1=temp.next;
		temp.next=node;
		node.next=temp1;
		size++;
		
		
	}
	
	// -------Method5: ------
	//delete the 1st node
	public int removeFirst() {
		//if head is null, nothing to remove so return -1
		if(head==null) {
			return -1;//nothing to remove
		}
		//store the head node value in a variable which can be returned
		int remVal=head.val;
		//move head to head.next and decrement the size
		head=head.next;
		size--;
		return remVal;
	}
	
	// -------Method6: ------
	//delete the 1st node
	public int removeLast() {
		//if tail is null, nothing to remove so return -1
				if(tail==null) {
					return -1;//nothing to remove
				}
				
			//store the tail value in a variable which can be returned
			int remVal=tail.val;
			
			//assign a temp variable in head
			//traverse temp till temp.next==tail
			//Now, set temp.next=null
			//return temp;
			
			Node temp=head;
			while(temp.next!=tail) {
				temp=temp.next;
			}
			temp.next=null;
			//assign the temp as tail
			tail=temp;
			size--;
			return remVal;
	}
	
	// -------Method7: ------
	//remove element from particular index
	public int removeAtPosition(int index) {
		//use removeFirst to remove the head value
		if(index==0) {// -------Method1: ------
			return removeFirst();
		}
		//if tail has to be removed, use removeLast
		if(index==size-1) {
			return removeLast();
		}
		
		//to remove the node in the middle, have the track of count starting from head
		//assign the temp variable as head
		//traverse the temp till index-1
		int count=0;
		Node temp=head;
		while(count!=index-1) {
			temp=temp.next;
			count++;
		}
		//now store the element to be removed in a variable to return
		int remVal=temp.next.val;
		//join temp.next to temp.next.next.. so the node to be removed will be left alone
		temp.next=temp.next.next;
		//decrement the size
		size--;
		return remVal;
	}
	
	// -------Method8: ------
	//get(int index) - returns the element in the given index
	public int get(int index) {
		//If the size of list is 1, 
		//then check whether the index is 0
		//If yes, return head value
		//else return -1;
		
		if(head==tail ) {
			if(index==0)
			return head.val;
			else return -1;
		}
		//if the index is 0, then return the head element
		if(index==0) {
			return head.val;
		}
		//if the index is size-1, then return the tail element
		if(index==size-1) {
			return tail.val;
		}
		//if the index is in between, then traverse temp node till its count==index and then return the temp node value
		int count=0;
		Node temp=head;
		while(count!=index) {
			temp=temp.next;
			count++;
		}
		return temp.val;
	}
	
	// -------Method9: ------
	//indexOf(int element) - return the index of the element or -1")
	
	public int indexOf(int element) {
		
		//check if the size of the list is 1
		//if size is 1, then check whether the head node value is equal to the element value
		//--> If yes, return 0
		//--> else, return -1
		if(head==tail) {
			if(head.val==element) return 0;
			else return -1;
		}
		
		//next check whether the element value is equal to tail node value..--> This is to check tail node in O(1)
		if(tail.val==element) {
			return size-1;
		}
		
		//if element is not in tail, then find from head till tail-1
		
		Node temp=head;
		int count=0;
		//traverse the temp till tail-1, since we no need to check tail value here..It is already checked before
		while(temp!=tail) {
			if(temp.val==element) return count;
			else {
				temp=temp.next;
				count++;
			}
		}
		return -1;
	}
	
	//addNode
		public void addNode() {
			
			Node node=new Node(1);
			node.next=new Node(2);
			node.next.next=new Node(2);
			node.next.next.next=new Node(12);
			node.next.next.next.next=new Node(5);
			addAll(node,2);
			
		}
		
	// -------Method10: ------
	//addAll(LinkedList list, int index) - add the new List to the existing List at specific index"
	
	public void addAll(Node list, int index) {
		int newSize=0;
		
		//PART1:----To add the list in the beginning----
		//add the tail of new list to the head of old list
		if(index==0) {
			//traverse till the tail of the new list
			Node listTail=list;
			newSize+=1;
			while(listTail.next!=null) {
				listTail=listTail.next;
				newSize++;
			}
			//tail of the new list should be connected to the head of old list
			listTail.next=head;
			//now head should be reassigned to the head of new list
			head=list;
			size=size+newSize;
			return;
		}
		
		//PART2:----To add the list in the end----
		if(index==size-1) {
			//connect the tail of old list to the head of new list
			tail.next=list;
		
			//now traverse till the end of new list and  assign the tail variable to the tail of new list
			while(tail.next!=null) {
				tail=tail.next;
				newSize++;
			}
			//adding a node size to the old size
			size=size+newSize;
			
			return;
		}
		
		//PART3: ----To add a node in the middle---
		/*
		 * Traverse the head of old list till index-1. Use temp variable to traverse
		 * assign temp.next as temp1 variable
		 * Now link temp.next to the new list head and new list tail to the temp1
		 */
		
		// Traverse the head of old list till index-1. Use temp variable to traverse
		int count=0;
		Node temp=head;
		while(count!=index-1) {
			temp=temp.next;
			count++;
		}
		//assign temp.next as temp1 variable
		Node temp1=temp.next;
		
		//Now link temp.next to the new list head 
		temp.next=list;
		
		//find the tail of new list
		Node listTail=list;
		newSize+=1;
		while(listTail.next!=null) {
			listTail=listTail.next;
			newSize++;
		}
		//new list tail to the temp1
		listTail.next=temp1;
		
		//adding a node size to the old size
		size=size+newSize;
	}
	
	// -------Method11: ------
	//return the index of the element or -1
	
	/*
	 * loop from head using temp variable till end temp.next!=null / head!=tail (or) loop temp till temp!=null
	 * check whether each and every node value is equal to the required element.
	 * -->If yes, add the index of the element(use counter variable) in a variable called max.
	 * ---->Compare the previous value and store the highest value in max.
	 * --> return the max which will be the last index of an element
	 */
	public int lastIndexOf(int element) {
		int max=-1;
		int count=0;
		Node temp=head;
		while(temp!=null) {
			if(temp.val==element) {
				max=Math.max(max, count);
			}
			temp=temp.next;
			count++;
		}
		return max;
	}
	
	
}

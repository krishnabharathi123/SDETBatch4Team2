package linkedListImpl;



public class MyLinkedList {
	Node head = null;

	public class Node {

		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		public Node() {
		//	this.data = null;
			this.next = null;
			
		}

	}
	
	//Insert data at the end
	public boolean insert(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return true;
		}
		else {
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		return true;
		}
		
	}
	
	public void display() {
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
	
	public int size() {
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
	
	public Node addNode(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			//return head;
		}
		else {
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		
		}
		return newNode;
		//displayNode(newNode);
	}
	public void displayNode(Node head) {
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
	
	public int indexOf(int val) {
		int index=-1;
		Node temp;
		if(head==null) {
			return index;
		}
		else {
			temp=head;
			while(temp.next!=null) {
				index++;//1
				if(temp.data==val) {
					return index;
				}
				temp=temp.next;
			}
		}
		if(temp.next==null && temp.data==val) {
			//index++;
			return ++index;
		}
		
		return index;
	}
	
	public int get(int index) throws Exception {
		int value;
		Node temp;
		int ind=-1;
		if(head==null) {
			throw new Exception("Element not present in list");
		}
		else {
			temp=head;
			while(temp.next!=null) {
				ind++;
				if(ind==index) {
					return temp.data;
				}
				temp=temp.next;
			}
		}
		if(temp.next==null && ++ind==index) {
			
			return temp.data;
		}
		
		return -1;
	}
	
	public int lastIndexOf(int element) {
		int index=-1;
		int lastIndex=-1;
		if(head==null) {
			return lastIndex;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				index++;
				if(temp.data==element) {
					lastIndex=index;
				}
				temp=temp.next;
			}
			if(temp.data==element) {
				lastIndex=++index;
			}
			return lastIndex;
		}
		
	}
	//doubt
	public void addAll() {
		Node n1 = new Node(10);
		n1.next = addNode(12);
		n1.next.next=addNode(15);
		//addNode(15);
		
		
		Node n2=new Node(20);
		n2.next = addNode(22);
		n2.next.next=addNode(25);
		
		displayNode(n1);
	}
	
	public Node addAll(Node n1, Node n2) {
		Node n=n1;
		if(n==null) {
			n=n2;
			return n1;
		}
		else {
			while(n.next!=null) {
				n=n.next;
			}
			n.next=n2;
		}
		return n1;
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
	
	public Node getHeadNode(int data ) {
		Node n = head;
		n.data=data;
		n.next=n.next;
		System.out.println(n.data);
		System.out.println(n.next);
		return head;
		
	}

	public void displayInString() {
		// TODO Auto-generated method stub
		
	}
}

package queueImplementation;

public class Queue {

	 public class Node {
	       public int number;
	       public Node next;
	    }
	    public Node start;
	    public Node end;
	    public int size = 0;
	    
	    public void enqueue(int no) {
	        // Created a new Node
	        Node node = new Node();
	        node.number = no;
	        // Handling the insertion of 1st element
	        if (start == null) {
	            start = node;
	            end = node;
	        }
	        // Handling the case of regular insertion at end.
	        else {
	            end.next = node;
	            end = node;
	        }	
	        size++;
	    }
	    
	    @Override
	    public String toString () {
	        StringBuffer sb = new StringBuffer();
	        sb.append("[");
	        Node current = start;
	        while (current != null) {
	            sb.append(current.number + ", ");
	            current = current.next;
	        }
	        sb.append("] --> " + "size: " + size);
	        return sb.toString();
	    }
	    
	    public void dequeue(int size) {
	    	int val=-1;
	    	//If queue is empty
	    	if(start==null) {
	    		System.out.println("Queue is empty");
	    		this.size--;
	    	}
	    	//when queue has only one element
	    	//start.next==null
	    	//size==1
	    	
	    	else if(start==end) {
	    		val=start.number;
	    		System.out.println(val);
	    		start=null;
	    		end=null;
	    		this.size--;
	    	}
	    	else {
	    		//while(start.next!=null) {
	    		while(start!=end) {
	    			val=start.number;
	    			System.out.println(val);
	    			start=start.next;
	    			this.size--;
	    		}
	    		val=start.number;
	    		System.out.println(val);
	    		start=null;
	    		this.size--;
	    		
	    	}
	    	
	    }
	    
	    public int size() {
	    	int count=0;
	    	Node head = start;
	    	Node tail = end;
	    	//if queue is empty
	    	if(head ==null ) return count;
	    	//if queue has only one node
	    	else if(head ==tail) return count++;
	    	//other nodes
	    	else{
	    		while(head!=tail) {
	    			count++;
	    			head=head.next;
	    		}
	    	}
	    	return count++;
	    }

}

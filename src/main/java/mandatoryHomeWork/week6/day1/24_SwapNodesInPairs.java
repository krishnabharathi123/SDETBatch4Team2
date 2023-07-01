package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class 24_SwapNodesInPairs

 {
@Test
	public void addNode1() {

		Node newNode = new Node(1);
		newNode.next=new Node(2);
		newNode.next.next=new Node(3);
		newNode.next.next.next=new Node(4);
		
		swapPairs(newNode);
	}
	
	@Test
	public void addNode2() {

		Node newNode = new Node(1);
		
		swapPairs(newNode);
	}
	
	

 public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null) return head;

        ListNode left=head, right=head.next;
        //pointing head.next to head.next.next (for 2 nodes it will be null)
        left.next=left.next.next;//pointing 1st node to 3rd node
        
        right.next=left; //re-pointing 2nd node to 1st node and creating a full node inside right

        while(left.next!=null && left.next.next!=null){

            ListNode temp=left.next; //3,4,5,6,7,8
            
            left.next=left.next.next; //1,4,5,6,7,8
                //1,4,3,5,6,7,8
                left=left.next; //4,5,6,7,8 - moved to 3rd node
                temp.next=temp.next.next; //3,5,6,7,8 - removed 3rd node form temp
                left.next=temp;// pointing 3rd nde next as temp -//4,3,5,6,7,8

               left=left.next;//re-pointing left pointer to 4th node..since we are gng to swap 5 and 6th node if available
                    
              
          //  return left;
        }
        



        //return head when we have either single or null node
        return right;
    }
}

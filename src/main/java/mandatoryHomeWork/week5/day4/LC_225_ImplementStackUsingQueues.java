package week5.day4;
import java.util.*;

import org.junit.Test;
public class LC_225_ImplementStackUsingQueues {

	Queue<Integer> q1 = new ArrayDeque<Integer>();
	Queue<Integer> q2 = new ArrayDeque<Integer>();
	
	 public LC_225_ImplementStackUsingQueues() {
	        
	    }
	    
	 //keep on push in the 1st queue
	    public void push(int x) {
	        q1.add(x);
	        
	        //while(q1.size()!=0) {
	        	//q2.push(q1.pop());
	        //}
	    }
	    
	    //empty q1 and add it in q2 and then pop out
	    public int pop() {
	    	
	        /*while(q1.size()!=0) {
	        	q2.push(q1.pop());
	        }*/
	        return q1.remove();
	    }
	    
	    public int top() {
	        //return q2.size();
	    	return q2.peek();
	    	
	    }
	    
	    public boolean empty() {
	        if(q2.size()==0) {
	        	return true;
	        }
	        return false;
	    }
	    
	    @Test
	    public void test() {
	    	q1.add(1);
	    	q1.add(2);
	    	q1.add(3);
	    	q1.add(4);
	    	q1.add(5);
	    	
	    	System.out.println(q1.remove());
	    	System.out.println(q1.remove());
	    }
	   /* public static void main(String[] args) {
	    	
	    	MyStack st=new MyStack();
	    	st.push(1);
	    	st.push(2);
	    	System.out.println(st.q1.pop());
	    	//st.push(3);
	    	
	    	//System.out.println(st.pop());
	    	//System.out.println(st.pop());
	    	//System.out.println(st.pop());
	    	
	    	//System.out.println(st.top());
	    	
	    	System.out.println(st.empty());
	    	
	    	
	    }*/
}

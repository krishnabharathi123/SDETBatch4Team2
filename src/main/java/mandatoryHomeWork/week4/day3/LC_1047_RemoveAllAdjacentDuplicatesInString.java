package week4.day3;

import org.junit.Test;
import stackImplementation.Stack;

public class LC_1047_RemoveAllAdjacentDuplicatesInString {

	@Test
	public void example1() {
		String s="abbaca";
		removeAdjDuplicates(s);
	}
	
	@Test
	public void example2() {
		String s="azxxzy";
		removeAdjDuplicates(s);
	}
	
	@Test
	public void example3() {
		String s="aaaaaaa";
		removeAdjDuplicates(s);
	}
	/*
	 * loop till the length of the string
	 * Check whether the character is available in the stack by peek. 
	 * If yes, remove the top element using pop.
	 * else, push it into the queue.
	 * 
	 */
	//Time Complexity --> O(n)
	//Space Complexity --> O(1)
	private void removeAdjDuplicates(String s) {
		Stack st=new Stack();
		for(int i=0;i<s.length();i++) {
			
			if(st.peek()!=null && st.peek()==s.charAt(i)) {
				st.pop();
			}
			
			else st.push(s.charAt(i));
			
		}
		
		int stackSize=st.size();
		
		s="";
		for(int j=0;j<stackSize;j++) {
			
			s=st.pop()+s;
			
		}
		System.out.println(s);
		
	}
}

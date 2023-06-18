package week5.day2;

import org.junit.Test;

public class LC_392_IsSubsequence {

	@Test
	public void positive() {
		String s="abc";
		String t ="ahbgdc";
		System.out.println(isSubsequence(s,t));
	}
	@Test
	public void edge1() {
		String s="";
		String t="";
		System.out.println(isSubsequence(s,t));
	}
	@Test
	public void edge2() {
		String s="a";
		String t="a";
		System.out.println(isSubsequence(s,t));
	}
	@Test
	public void negative1() {
		String s="axc";
		String t="ahbgdc";
		System.out.println(isSubsequence(s,t));
	}
	@Test
	public void negative2() {
		String s="x";
		String t="y";
		System.out.println(isSubsequence(s,t));
	}
	
	//2 pointer algorithm
	/*
	 * use left pointer for s and right pointer t
	 * loop till the right pointer is less than t.length
	 * --> if left value==right value 
	 * -----> increment the counter 
	 * ---------> check if the count == size of s --> If yes, return true;
	 * -----> increment left and right pointer
	 * --> else increment right pointer
	 */
	
	//Time complexity --> O(n)
	//Space Complexity --> O(1)
	private boolean isSubsequence(String s, String t) {
		
		 int left=0;
			int right=0;
			int count=0;
			if((s.length()==0 && t.length()==0) || s.length()==0) return true;
			else if( t.length()==0) return false;
			else {
			while(right<t.length()) {
				if(s.charAt(left)==t.charAt(right)) {
					count++;
					if(count==s.length()) return true;
					
					left++;
					right++;
				}
				else {
					right++;
				}
			}
			}
			return false;
		
		
	}
}

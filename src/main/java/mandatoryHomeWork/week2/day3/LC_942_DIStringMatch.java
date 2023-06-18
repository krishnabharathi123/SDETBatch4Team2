package week2.day3;

import java.util.Arrays;

import org.junit.Test;
//https://leetcode.com/problems/di-string-match/
public class LC_942_DIStringMatch {

	@Test
	public void example1() {
		String s = "IDID";
		diStringMatch(s);
	}

	@Test
	public void example2() {
		String s = "III";
		diStringMatch(s);

	}

	@Test
	public void example3() {
		String s = "DDI";
		diStringMatch(s);

	}
	
	/*
	 * Set 2 variables --> one for IMatch as O since the condition says after I the values should increase
	 * DMatch as str.length since the condition says after D the values should be decreased
	 * create an array with the length of string length + 1
	 * loop till the length of the array
	 * --> check whether the string character is equal to I 
	 * ----> If yes, assign the array value as IMatch and increment it
	 * ----> else, assign the array value as DMatch and decrement it;
	 * 
	 * Check whether the string length-1 value is equal to I
	 * 	If yes, add the last index of array as IMatch
	 *  else , add the last index of array as DMatch
	 * 
	 */
	//Time Complexity ---> O(n)
	//Space Complexity ---> O(n)
	private int[] diStringMatch(String s) {
		
		int iMatch=0;
		int dMatch=s.length();
		int[] arr = new int[s.length()+1];
		int i=0;
		
		for(;i<s.length();i++) {
			if(s.charAt(i)=='I') arr[i]=iMatch++;
			else arr[i]=dMatch--;
			}
		
		if(s.charAt(i-1)=='I') arr[i]=iMatch;
		else arr[i]=dMatch;
		System.out.println(Arrays.toString(arr));
		return arr;
	}
}

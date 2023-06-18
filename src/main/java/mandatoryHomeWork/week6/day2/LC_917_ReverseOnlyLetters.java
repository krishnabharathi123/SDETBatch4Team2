package week6.day2;

import java.util.Arrays;

import org.junit.Test;

public class LC_917_ReverseOnlyLetters {

	@Test
	public void example1() {
		String s="ab-cd";
		reverseLetters(s);
	}
	
	@Test
	public void example2() {
		String s="a-bC-dEf-ghIj";
		reverseLetters(s);
	}
	
	@Test
	public void example3() {
		String s="Test1ng-Leet=code-Q!";
		reverseLetters(s);
	}
	/*
	 * Convert the string into char array
	 * use 2 pointer in opposite direction
	 * loop till left crosses right
	 * check whether both the values are a character (Use ASCII)
	 * if it is a character, swap both the values and left ++ and right--
	 * if left value is not a character left++
	 * if right value is not a character right--
	 */
	
	//Time complexity --> O(n)
	//Space complexity --> O(n)	
	private void reverseLetters(String s) {
		
		char[] sArr=s.toCharArray();
		int left=0;
		int right=s.length()-1;
		
		while(left<=right) {
		if(isChar(sArr[left]) && isChar(sArr[right])) {
			char temp=sArr[left];
			sArr[left++]=sArr[right];
			sArr[right--]=temp;
		}
		else if(!isChar(sArr[left])) {
			left++;
		}
		
		else {
			right--;
		}
		}
		s="";
		for (char c : sArr) {
			s=s+c;
		}
		System.out.println(s);
	}

	private boolean isChar(int sArr) {
		
		//if(64<sArr<=90 && 96<sArr<=122) {
		//if((64<sArr && sArr<=90) || (96<sArr && sArr<=122)) {
		if(('A'<=sArr && sArr<='Z') || ('a'<=sArr && sArr<='z')) {
			return true;
		}
		
		return false;
	}

}

package week3.day5;

import org.junit.Test;

public class LC_744_FindSmallestNumberGreaterThanTarget {

	@Test
	public void example1() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'a';
		System.out.println(smallLetter(letters, target));
	}

	@Test
	public void example2() {
		char[] letters = { 'c', 'f', 'j' };
		char target = 'c';
		System.out.println(smallLetter(letters, target));
	}

	@Test
	public void example3() {
		char[] letters = { 'x', 'x', 'y', 'y' };
		char target = 'z';
		System.out.println(smallLetter(letters, target));
	}
	
	@Test
	public void example4() {
		char[] letters = { 'x', 'x', 'y', 'y' };
		char target = 'x';
		System.out.println(smallLetter(letters, target));
	}
	
/*
 * loop i from 0 till array length
 * check whether the letters[i]>target.. If yes, return letters[i]
 * If none of the condition matches, return 1st char in array
 */
	//Time Complexity --> O(n)
	//Space Complexity --> O(1)
	private char smallLetter(char[] letters, char target) {
		for(int i=0;i<letters.length;i++) {
			if(letters[i]>target) return letters[i];
		}
		return letters[0];
	}

}

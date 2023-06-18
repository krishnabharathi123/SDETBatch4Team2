package week2.day4;

import org.junit.Test;

public class LC_2000_ReversePrefixOfWord {

	@Test
	public void example1() {
		String str = "abcdefd";
		char ch = 'd';
		System.out.println(reversePrefix(str, ch));
	}

	@Test
	public void example2() {
		String str = "xyxzxe";
		char ch = 'z';
		System.out.println(reversePrefix(str, ch));
	}

	@Test
	public void example3() {
		String str = "abcd";
		char ch = 'z';
		System.out.println(reversePrefix(str, ch));
	}

	/*
	 * use indexOf(ch) to find the index of the given target character Validate if
	 * output is not equal to -1 
	 * --> If yes, loop from 0th index till the indexOf(ch) 
	 * ----> swap left and right pointer till left crosses right pointer
	 */
	//Time complexity --> O(n)
	//Space Complexity --> O(n)
	private String reversePrefix(String str, char ch) {
		StringBuilder sb = new StringBuilder(str);
		int chIndex = str.indexOf(ch);
		char temp;
		if (chIndex != -1) {
			int left = 0;
			int right = chIndex;
			while (left <= right) {
				temp = sb.charAt(left);
				sb.setCharAt(left++, sb.charAt(right));
				sb.setCharAt(right--, temp);
			}
		}
		return sb.toString();
	}

}

package week2.day5;

import org.junit.Test;

public class LC_557_ReverseWordsInAString {

	@Test
	public void positive() {
		String input = "Let's take LeetCode contest";
		reverseWords(input);
	}

	@Test
	public void positive1() {
		String input = "God Ding";
		reverseWords(input);
	}

	@Test
	public void edge() {
		String input = "yuyuyu";
		reverseWords(input);
	}

	@Test
	public void negative() {
		String input = " ";
		reverseWords(input);
	}
	/*
	 *Split the input string using space and store it in string array
	 *loop till the length of the string array
	 *Create a String builder and assign the ith index value of input string
	 *Keep left pointer as 0 and right pointer as stringbuilder length-1
	 *loop till left and right pointer crosses each other
	 *swap left and right variable and increment left and decrement right
	 *Create an output string and append the string builder values in it with space
	 *return the string 
	 */
	
	//Time Complexity ---> O(n*m)
	//Space Complexity ---> O(n)
	private void reverseWords(String input) {
		String[] split = input.split(" ");//O(n/k)
		String output = "";//O(1)
		for (int i = 0; i < split.length; i++) {//O(n)
			StringBuilder sb = new StringBuilder(split[i]);//O(n)
			int left = 0;
			int right = sb.length() - 1;
			char temp;
			while (left <= right) {//O(m)
				temp = sb.charAt(left);
				sb.setCharAt(left++, sb.charAt(right));
				sb.setCharAt(right--, temp);
			}
			output = output +" " +sb;
		}
		System.out.println(output.trim());

	}
}

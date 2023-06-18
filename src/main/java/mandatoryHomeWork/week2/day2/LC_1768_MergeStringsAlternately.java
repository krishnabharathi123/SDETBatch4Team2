package week2.day2;

import org.junit.Test;
//https://leetcode.com/problems/merge-strings-alternately/
public class LC_1768_MergeStringsAlternately {
	@Test
	public void positive() {
		String word1 = "abc";
		String word2 = "pqr";
		System.out.println(mergeAlternateString1(word1, word2));
	}

	@Test
	public void edge1() {
		String word1 = "ab";
		String word2 = "pqrs";
		System.out.println(mergeAlternateString1(word1, word2));
	}

	@Test
	public void negative1() {
		String word1 = "qwe";
		String word2 = "";
		System.out.println(mergeAlternateString1(word1, word2));
	}
	
	@Test
	public void negative2() {
		String word1 = "";
		String word2 = "";
		System.out.println(mergeAlternateString1(word1, word2));
	}

	@Test
	public void edge() {
		String word1 = "abcd";
		String word2 = "pq";
		System.out.println(mergeAlternateString1(word1, word2));

	}
	//Time taken ---> 25m
	/*
	 * Set the left pointer and right pointer value as 0.
	 * validate if the length of word1 is greater than or equal to the length of word2
	 * --> If yes, loop till the left pointer is lesser than the length of word1
	 * -----> check if right pointer is lesser than the length of word2
	 * -------> If yes, concatenate the output with left index of word 1 and right index of word2
	 * --------> If no, concatenate the output with left index of word 1
	 * ------> increment the left and right pointer
	 * --> If no, loop till the right pointer is lesser than the length of word2
	 * -----> check if left pointer is lesser than the length of word1
	 * -------> If yes, concatenate the output with left index of word 1 and right index of word2
	 * --------> If no, concatenate the output with left index of word 1
	 * return the output
	 */
	
	//Time taken --> 15mins
	
	//Time complexity --> O(n)
	//Space complexity -->O(1)
	
	private String mergeAlternateString1(String word1, String word2) {
		String output = "";
		int left = 0;
		int right = 0;
		if (word1.length() >= word2.length()) {
			while (left < word1.length()) {// O(n)
				if (right < word2.length()) output = output + word1.charAt(left++) + word2.charAt(right++);
				else output = output + word1.charAt(left++);
			}

		} else {
			while (right < word2.length()) {// O(n)
				if (left < word1.length()) output = output + word1.charAt(left++) + word2.charAt(right++);
				else output = output + word2.charAt(right++);
			}

		}
		return output;
	}
	
	//brute force
	private void mergeAlternateString(String word1, String word2) {
		String output = "";
		int left = 0;
		int right = 0;
		if (word1.length() == word2.length()) {
			while (left < word1.length()) {
				output = output + word1.charAt(left++) + word2.charAt(right++);
			}
			System.out.println(output);
		} else if (word1.length() > word2.length()) {
			while (left < word1.length()) {
				if (right < word2.length()) {
					output = output + word1.charAt(left++) + word2.charAt(right++);
				} else {
					output = output + word1.charAt(left++);
				}

			}
			System.out.println(output);
		} else {
			while (right < word2.length()) {
				if (left < word1.length()) {
					output = output + word1.charAt(left++) + word2.charAt(right++);
				} else {
					output = output + word2.charAt(right++);
				}

			}
			System.out.println(output);
		}

	}


}

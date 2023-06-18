package week1.day5;

import org.junit.Test;
//https://leetcode.com/problems/count-of-matches-in-tournament/
public class LC_1688_CountOfMatchesInTournament {

	@Test
	public void positive() {
		int num = 14;
		noOfMatches(num);
	}

	@Test
	public void negative() {
		int num = 0;
		noOfMatches(num);
	}

	@Test
	public void edge() {
		int num = 7;
		noOfMatches(num);

	}
	/*
	 * Loop the input number till num is greater than 1 Validate is num is even or
	 * not if yes ---> no.of.matches=num/2; and num=no.of matches if no --->
	 * no.of.matches=num-1/2; and num=no.of matches+1 add the no.of matches from
	 * each iteration as a total number of matches. Print the total number of
	 * matches
	 */
	// Time Complexity ---> O(n/2)

	private void noOfMatches(int num) {
		int matchCount;
		int totalMatch = 0;
		while (num > 1) {
			if (num % 2 == 0) {
				matchCount = num / 2;
				num = matchCount;
			} else {
				matchCount = (num - 1) / 2;
				num = matchCount + 1;
			}
			totalMatch = totalMatch + matchCount;// 7+3+2

		}
		System.out.println(totalMatch);

	}
}

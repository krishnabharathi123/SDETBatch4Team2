package week1.day3;

import org.junit.Test;
//https://leetcode.com/problems/power-of-two/description/
public class LC_231_PowerOfTwo {

	@Test
	public void positive() {
		int num = 128;
		System.out.println(twoPower2(num));
	}

	@Test
	public void negative() {
		int num = 0;
		System.out.println(twoPower2(num));

	}

	@Test
	public void edge() {
		int num = -8;
		System.out.println(twoPower2(num));

	}

	// not working for even non powers
	private boolean twoPower(int num) {
		int val = 1, i = 0;
		if (num == 1) {
			return true;
		}

		else if (num % 2 == 0) {

			while (val != num) {
				val = val * 2;
				i++;
			}
			System.out.println("2 power " + i);
			return true;
		}

		return false;

	}

	/*
	 * Check whether the given num is negative since the input is integer
	 * 	If negative then multiply with -1
	 * Check if the given number is 1. If yes return true .since 2^0 =1
	 * Check if given number is odd . If yes return false
	 * Check if given number is even. If yes verify the remainder of number continuously till number is less than 1
	 * 	If remainder is equal to 1 in any iteration , return false
	 * 		else return true.
	 */
	//TimeComplexity --> O(n)
	public boolean twoPower2(int num) {
		int val = 1, i = 0;
		if (num < 0) { //to handle negative values
			num = num * -1;
		}
		if (num == 1) {
			return true;
		} 
		
		else if (num % 2 != 0) {
			return false;
		} 
		//For even u can get modulus as 1 when n=1;
		else if (num % 2 == 0) {
			while (num > 1) {
				val = num % 2;
				if (val == 1) {
					return false;
				}
				num = num / 2;
			}
			
		}
		return true;
	}

}

package week2.day4;

import java.util.Arrays;

import org.junit.Test;

public class LC_905_SortArrayBrParity {
	@Test
	public void positive() {
		int[] num = { 3, 1, 2, 4, 17, 64, 90, 35 };

		sortParityArray(num);
	}

	@Test
	public void negative() {
		int[] num = { 0 };

		sortParityArray(num);
	}

	@Test
	public void edge() {
		int[] num = { 2, 1 };

		sortParityArray(num);
	}

	/*
	 * 2 pointer opposite direction --> no need to maintain order
	 * Check if left value is odd and right value is even
	 * --> If yes, swap left and right and increment left and decrement right
	 * else check whether left is even
	 * --> If yes, increment left
	 * else decrement right
	 */
	private int[] sortParityArray(int[] num) {
		int left = 0;
		int right = num.length - 1;
		int temp;
		while (left <= right) {
			if (num[left] % 2 != 0 && num[right] % 2 == 0) {
				temp = num[left];
				num[left++] = num[right];
				num[right--] = temp;
			} else if (num[left] % 2 == 0) {
				left++;
			} else {
				right--;
			}
		}
		return num;
	}
}

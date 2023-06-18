package week2.day3;

import java.util.Arrays;

import org.junit.Test;
//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
public class LC_1464_MaximumProductOfTwoElementsInAnArray {
	@Test
	public void positive() {
		int[] nums = { 3, 4, 5, 2 };
		System.out.println(maxProd1(nums));
	}

	@Test
	public void edge() {
		int[] nums = { 1, 5, 4, 5, 5, 5, 5 };
		System.out.println(maxProd(nums));
	}

	@Test
	public void edge1() {
		int[] nums = { 3, 7 };
		System.out.println(maxProd(nums));
	}

	@Test
	public void negative() {
		int[] nums = {};
		System.out.println(maxProd(nums));
	}

	@Test
	public void negative1() {
		int[] nums = { 9 };
		System.out.println(maxProd(nums));
	}

	/*
	 * create a variable called max and assign 0 to the variable Create 2 loops to
	 * test all the values within the array check if (nums[i] - 1) * (nums[j] - 1) >
	 * max --> If yes, assign max value as (nums[i] - 1) * (nums[j] - 1)
	 */
	// Time complexity ---> O(n^2)
	// Space Complexity ---> O(n)
	private int maxProd(int[] nums) {
		int max = 0;
		int val;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				val = (nums[i] - 1) * (nums[j] - 1);// 5
				if (val > max) {
					max = val;
				}
			}
		}
		return max;
	}

	/*
	 * Use Arrays.sort and sort the give array
	 * check if array length is greater than or equal to 1
	 * If yes, return the value-1  of last 2 arrays
	 * If array length ==1, return the 1st index
	 * else, return 0
	 */
	//Time Complexity ---> O(n)
	//Space Complexity ---> O(1)
	private int maxProd1(int[] nums) {
		Arrays.sort(nums);//O(n)
		if (nums.length >= 2)
			return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
		else if (nums.length == 1) {
			return nums[0];
		} else
			return 0;
	}

}

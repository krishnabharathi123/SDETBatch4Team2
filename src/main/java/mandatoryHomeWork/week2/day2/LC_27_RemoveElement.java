package week2.day2;

import java.util.Arrays;

import org.junit.Test;
//https://leetcode.com/problems/remove-element/
public class LC_27_RemoveElement {

	@Test
	public void positive() {
		int[] nums = { 3, 2, 2, 3 };
		int val = 3;
		removeEle(nums, val);
	}

	@Test
	public void positive1() {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		removeEle(nums, val);
	}

	@Test
	public void edge() {
		int[] nums = { 0 };
		int val = 0;
		removeEle(nums, val);
	}

	@Test
	public void negative() {
		int[] nums = { 0, 1, 4, 5 };
		int val = 6;
		removeEle(nums, val);
	}

	//Time taken ---> 25mins
	/*
	 * 2 pointer ---> opposite direction Set the left pointer to 0 Set the right and pointer to nums.length-1.
	 * Loop till the left pointer is less than or equal to right pointer
	 * --> check whether nums[left] == val && nums[right] != val
	 * ---> if yes, swap left and right value and increment left pointer and decrement right pointer
	 * ---> if no, check nums[left] != val && nums[right] == val
	 * -----> If yes, increment left and decrement right
	 * ---> If no, check nums[left] != val && nums[right] != val
	 * ------> If yes, increment left
	 * ---> else decrement right
	 * ---> return the left index which was the count of non target elements
	 */
	
	//Time taken ---> 15mins
	
	//Time Complexity -->O(n)
	//Space Complexity -->O(1)
	private int removeEle(int[] nums, int val) {
		int left = 0;
		int right = nums.length - 1;
		int temp;
		while (left <= right) {//O(n)
			if (nums[left] == val && nums[right] != val) {
				temp = nums[left];
				nums[left++] = nums[right];
				nums[right--] = temp;
			} else if (nums[left] != val && nums[right] == val) {
				left++;
				right--;
			} else if (nums[left] != val && nums[right] != val)
				left++;
			else
				right--;
		}
		return left;
	}

}

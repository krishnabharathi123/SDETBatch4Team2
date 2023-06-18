package week2.day1;

import java.util.Arrays;

import org.junit.Test;
// /https://leetcode.com/problems/move-zeroes/

public class LC_283_MoveZeroes {

	@Test
	public void positive() {
		int[] nums = { 0, 1, 0, 3, 1, 2 };
		moveZeroToRight(nums);
	}

	@Test
	public void edge() {
		int[] nums = { 0 };
		moveZeroToRight(nums);
	}

	@Test
	public void edge1() {
		int[] nums = { 0, 0, 0, 0, 0, 1, 2, 3, 4 };
		moveZeroToRight(nums);
	}

	@Test
	public void negative() {
		int[] nums = { 1, 2, 3, 4 };
		moveZeroToRight(nums);
	}
	//Time Taken --> 20mins to derive pseudocode
	/*@ pointer approach --> equividirectional
	 * 
	 * Assign left pointer to the 0th index
	 * Assign right pointer to the 1st index
	 * loop till the right pointer crosses the length of the array
	 * -> check whether the left pointer value==0 and right pointer value not equal to 0
	 * ---> If yes swap left and right and increment both left and right pointer
	 * ->else check if both the left and right pointer values are equal to zero
	 * ---> If yes, move right pointer alone
	 * -> else check if both left and right pointer are not equal to 0
	 * ---> If yes, move both the pointer 
	 * 
	 */
	
	//Time Taken --> 5mins to write code
	//Time Complexity ---> O(n)
	//Space Complexity ---> O(1)
	private void moveZeroToRight(int[] nums) {
		int left =0;//O(1)
		int right =1;//O(1)
		int temp;//O(1)
		while(right<nums.length) { //O(n)
			if(nums[left]==0 && nums[right]!=0) {
				temp=nums[left];
				nums[left++]=nums[right];
				nums[right++]=temp;
			}
			else if(nums[left]==0 && nums[right]==0) right++;
			else if(nums[left]!=0 && nums[right]!=0) {
				left++;
				right++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}

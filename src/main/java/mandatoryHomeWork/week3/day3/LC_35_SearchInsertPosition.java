package week3.day3;

import org.junit.Test;

public class LC_35_SearchInsertPosition {

	@Test
	public void example1() {
		int[] nums= {1,3,5,6};
		int target=5;
		System.out.println(searchInsrtPosition(nums,target));
	}

	@Test
	public void example2() {
		int[] nums= {1,3,5,6};
		int target=2;
		System.out.println(searchInsrtPosition(nums,target));
	}

	@Test
	public void example3() {
		int[] nums= {1,3,5,6};
		int target=4;
		System.out.println(searchInsrtPosition(nums,target));
	}
	
	//Time Complexity --> O(logn)
	//Space Complexity --> O(1)
	private int searchInsrtPosition(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;
		int mid;
		while(left<right) {
			mid=(right+left)/2;
			if(nums[mid]==target) {
				return mid;
			}
			else if(nums[mid]>target) right=mid-1;

			else if(nums[mid]<target) left=mid+1;
			
			}
		if(left==right) {
			if(nums[left]>target) return left;
			else if(nums[right]<target)  return left+1;
		}
		return left;
			
		}

}

package week3.day3;

import java.util.Arrays;

import org.junit.Test;

public class LC_1984_MinimumDifferenceBetweenHighestAndLowestOf_K_Scores {

	@Test
	public void example1() {
		int[] nums= {90};
		int k=1;
		System.out.println(minDiff(nums,k));
	}
	
	@Test
	public void example2() {
		int[] nums= {9,4,1,7};
		int k=2;
		System.out.println(minDiff(nums,k));
	}
	
	@Test
	public void example3() {
		int[] nums= {9,4,1,7};
		int k=3;
		System.out.println(minDiff(nums,k));
	}
	
	/* Sliding window technique
	 * Sort the input array
	 * Set minVal as Integer.MAX_VALUE
	 * loop the array 0 till nums.length-k
	 * -->set nums[i] as min and max nums[i+k-1]
	 * --> check whether the diff between min and max is lesser than minVal
	 * ----> If yes, assign the diff as minVal
	 * return the minVal
	 */
	//Time Complexity --> O(n logn)
	//Space Complexity --> O(1)
	private int minDiff(int[] nums, int k) {
		Arrays.sort(nums);//O(n logn)
		int minVal=Integer.MAX_VALUE;
		int min,max,diff;
		
		for(int i=0;i<=nums.length-k;i++) { //O(n)
			min=nums[i];
			max=nums[i+k-1];
			diff=max-min;
			if(minVal>diff) {
				minVal=diff;
				
			}
			
		}
		
		
		return minVal;
	}

}

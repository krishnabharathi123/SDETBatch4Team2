package week3.day1;

import org.junit.Test;

public class LC_643_MaximumAverageSubArrayI {

	@Test
	public void positive() {
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		maxAvgSubarr(nums, k);
	}

	@Test
	public void edge() {
		int[] nums = {5};
		int k = 1;
		maxAvgSubarr(nums, k);

	}
	
	@Test
	public void negative() {
		int[] nums = {};
		int k = 0;
		maxAvgSubarr(nums, k);

	}
	/*sliding window
	 *loop form 0 till k-1 and get the sum and average and assign the avg value as max
	 *loop from 1 to nums.length-k
	 *--> sum=sum-previous value+next k th value
	 *get the average
	 *check if the average is greater than max.if yes, assign it as a max
	 * 
	 */
	private void maxAvgSubarr(int[] nums, int k) {
		double sum=0;
		double avg;
		double max;
		for(int i=0;i<k;i++) {
			sum=sum+nums[i];
		}
		
		avg=sum/k;
		max=avg;
		
		for(int j=1;j<=nums.length-k;j++) {
			sum=sum-nums[j-1]+nums[k+j-1];
			avg=sum/k;
			if(avg>max) max=avg;
		}
		System.out.println(max);
		
	}
}

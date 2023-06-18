package week2.day5;

import java.util.Arrays;

import org.junit.Test;

public class LC_88_MergeSortedArray {

	@Test
	public void example1() {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;
		mergeSortedArray(nums1, nums2, m, n);
		
	}

	@Test
	public void example2() {
		int[] nums1 = { 1 };
		int[] nums2 = {};
		int m = 1;
		int n = 0;
		mergeSortedArray(nums1, nums2, m, n);
	}

	@Test
	public void example3() {
		int[] nums1 = { 0 };
		int[] nums2 = { 1 };
		int m = 0;
		int n = 1;
		mergeSortedArray(nums1, nums2, m, n);
	}
	/*
	 * Check if m equal to 0
	 * If yes ---> add nums2 values to nums1
	 * Check if n equal to 0
	 * If yes ---> leave nums1 as it is
	 * else 
	 * --> leave the values of nums1 from 0 to m-1
	 * --> loop throughout num2 length
	 * --> assign nums1[m++]=nums2[i];
	 * now sort nums1 
	 */
	
	//Time Complexity -->O(n)
	//Space Complexity -->O(1)
	
	private void mergeSortedArray(int[] nums1, int[] nums2, int m, int n) {
		if((m==0 && n==1)) nums1[0]=nums2[0];// to handle best case in O(1)
		else if(n!=0) {
	
			for(int i=0;i<n;i++) {
				nums1[m++]=nums2[i];
			}
			Arrays.sort(nums1);//O(n logn)
		
		
		}
		System.out.println(Arrays.toString(nums1));
	}
}

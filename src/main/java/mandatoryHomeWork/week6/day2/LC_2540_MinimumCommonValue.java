package week6.day2;

import org.junit.Test;

public class LC_2540_MinimumCommonValue {

	@Test
	public void example1() {
		int nums1[]= {1,2,3};
		int nums2[]= {2,4};
		minCommonVla(nums1,nums2);
	}
	
	@Test
	public void example2() {
		int nums1[]= {1,2,3,6};
		int nums2[]= {2,3,4,5};
		minCommonVla(nums1,nums2);
	}
	
	@Test
	public void edge() {
		int nums1[]= {2,2,2,2};
		int nums2[]= {2,2,2,2};
		minCommonVla(nums1,nums2);
	}
	
	@Test
	public void edge1() {
		int nums1[]= {1,1,2,2,3,3};
		int nums2[]= {3,3,4,4};
		minCommonVla(nums1,nums2);
		
	}
	
	@Test
	public void negative() {
		int nums1[]= {1,1,2,2,3,3};
		int nums2[]= {4,4,5,5,6,6};
		minCommonVla(nums1,nums2);
	}
	
	@Test
	public void negative1() {
		int nums1[]= {1};
		int nums2[]= {3,3,4,4};
		minCommonVla(nums1,nums2);
	}
	/*
	 * 2 pointer algo
	 * loop till left and right pointer crosses the array inputs
	 * Assign min value as Integer.MAX_VALUE
	 * if left value equals right value 
	 *    check whether the value is less than min value --> if yes, assign this value as min value and l++ and r++
	 * else check whether left value lesser than right value --> yes, l++
	 * else right++
	 * return the min value
	 */
	//Time Complexity --> O(n)
	//Space Complexity --> O(1)
	private int minCommonVla(int[] nums1, int[] nums2) {
		
		int left=0;
		int right=0;
		int min=Integer.MAX_VALUE;
		
		while(left<nums1.length && right<nums2.length) {
			
			if(nums1[left]==nums2[right]) {
				if(min>nums1[left]) min=nums1[left++];	
				right++;
			}
			else if(nums1[left]<nums2[right]){
					left++;
			}
			else right++;
			
		}
		if(min==Integer.MAX_VALUE) return -1;
		return min;
		
	}

}

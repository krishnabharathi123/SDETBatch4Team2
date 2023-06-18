package week1.day1;
import java.util.Arrays;

public class CorrectNumberAtCrtPosition {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 5, 6, 7, 9 };
		int target = 8;

		int[] nums1 = new int[nums.length + 1];
		int i=0;
		for (; i < nums.length; i++) {
			if (nums[i] < target) {
				nums1[i] = nums[i];
			} 
			else {
				nums1[i] = target;
				break;
			}
		}
		for(;i<nums1.length-1;i++) {
			nums1[i+1] = nums[i];
		}
		
		System.out.println(Arrays.toString(nums1));

	}

}

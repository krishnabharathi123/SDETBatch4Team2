package week3.day5;

import org.junit.Test;
import java.util.*;

public class LC_219_ContainsDuplicateII {

	public void example1() {
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;
		System.out.println(containsDuplicate(nums, k));
	}

	@Test
	public void example2() {
		int[] nums = { 1, 0, 0, 0, 1 };
		int k = 2;
		System.out.println(containsDuplicate(nums, k));
	}

	public void example3() {
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		int k = 2;
		System.out.println(containsDuplicate(nums, k));
	}

	// 1,2,3,1
	/* Loop till length of the array
	 * Create a hash map and store the value of nums as a key and index as a value
	 * check if the key is already available in map
	 * If yes, get the index and index of available value
	 * check the absolute diff between both and check whether the diff is <=k
	 * If yes, return true
	 * else return false.
	 */
	private boolean containsDuplicate(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
			
		}
		return false;
	}
}

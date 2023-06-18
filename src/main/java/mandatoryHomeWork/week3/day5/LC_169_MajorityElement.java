package week3.day5;
import java.util.*;

import org.junit.Test;
public class LC_169_MajorityElement {

	@Test
	public void example1() {
		int[] nums= {3,2,3};
		System.out.println(majorityElem1(nums));
	}
	
	@Test
	public void example2() {
		int[] nums= {2,2,1,1,1,2,2};
		System.out.println(majorityElem1(nums));
	}
	
	@Test
	public void example3() {
		int[] nums= {1};
		System.out.println(majorityElem1(nums));
	}
	
	/*HashMap
	 * all the values of map to the hashmap.
	 * --> keep num values as key and count as value
	 * Use for each to iterate the entry set 
	 * --> if i.getValue is greater than n/2, print the respective value
	 */
	//Time Complexity --> O(n)
	//Space Complexity --> O(n)
	private int majorityElem(int[] nums) {
		HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		System.out.println(map);
		for(Map.Entry<Integer, Integer> i:map.entrySet()) {
			if(i.getValue()>nums.length/2) return i.getKey();
		}
		
		return 0;
	}
	
	/* 
	 * Two Pointer algo - equividirectional
	 * Sort the given array
	 * Create a counter variable with 1 as a initial value
	 * left=0, right=1
	 * loop till right crosses the nums.length()
	 * --> Check if nums[left]==nums[right] --> If yes, increment the counter
	 * --> else --> left=right;
	 */
	//1,1,1,2,2,2,2
	//2,3,3
	//6,6,6,7,7
	//Time Complexity ---> O(n longn)
	//Space Complexity --> O(1)
	private int majorityElem1(int[] nums) {
		Arrays.sort(nums);
		int count=1;
		int left=0;
		int max=0;
		int maxVal=nums[0];//1
		
		for(int right=1;right<nums.length;right++) {
			if(nums[left]==nums[right]) {
				count++;//3
				//right++;
				//System.out.println("count"+count);
			}
			else {
				count=1;
				left=right;
				//right++;
			}
			if(max < count) {
				max=count;//3
				maxVal=nums[left];//1
			}
			
			}
		return maxVal;
		}
		
	
}

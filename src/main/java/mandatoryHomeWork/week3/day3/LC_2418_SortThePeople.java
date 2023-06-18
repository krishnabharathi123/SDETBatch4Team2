package week3.day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Test;

public class LC_2418_SortThePeople {

	@Test
	public void example1() {
		String[] names = { "Mary", "John", "Emma" };
		int[] heights = { 180, 165, 170 };
		sortPeople(names, heights);
	}

	@Test
	public void example2() {
		String[] names = { "Alice", "Bob", "Bob" };
		int[] heights = { 155, 185, 150 };
		sortPeople(names, heights);
	}

	@Test
	public void example3() {
		String[] names = { "John", "John", "John" };
		int[] heights = { 180, 165, 170 };
		sortPeople(names, heights);
	}

	/*
	 * HashMap Technique: 
	 * add heights of i as key in HashMap
	 * add names of i as a value in HashMap 
	 * Sort the heights array
	 * add the value of height to the output array in reverse order
	 */

	//Time Complexity --> O(n)
	//Space Complexity --> O(n)
	
	private void sortPeople(String[] names, int[] heights) {
		String[] out = new String[names.length];
		int k=out.length-1;
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		for (int i = 0; i < names.length; i++) {
			map.put(heights[i], names[i]);
		}
		
		Arrays.sort(heights);// 165,170,180

		for (int i : heights) {
			out[k--]=map.get(i);
		}
		
		System.out.println(Arrays.toString(out));

	}
}

package week3.day2;

import org.junit.Test;

public class LC_2379_MinimumRecolorsToGet_K_ConsecutiveBlackBlocks {

	@Test
	public void positive() {
		String blocks = "WBBWWBBWBW";
		int k = 7;
		consecutiveBlackBlocks(blocks, k);
	}


	@Test
	public void edge() {
		String blocks = "WBWBBBW";
		int k = 2;
		consecutiveBlackBlocks(blocks, k);

	}
	
	@Test
	public void edge1() {
		String blocks = "WBB";
		int k = 1;
		consecutiveBlackBlocks(blocks, k);

	}

	@Test
	public void negative() {
		String str = "WWWWWWWW";
		int k = 3;
		consecutiveBlackBlocks(str, k);

	}
	
	@Test
	public void negative1() {
		String str = "BBBBBBBB";
		int k = 3;
		consecutiveBlackBlocks(str, k);

	}
	//Understanding problem -5mins
	//Time taken for pseudocode -  30 mins
	
	/* Sliding window technique:
	 * loop from 0 to n.length
	 * keep left as slow pointer and right as fast pointer
	 * loop right from 0 to length of the character
	 * check whether right pointer character is equal to 'W'
	 * 	If yes, increment the counter
	 * check whether the window is equal to k-1
	 *  If yes, check whether the count is lesser than min, if yes, assign count to min
	 *  To remove the previous elemnt --> check whether the previous character is W, If yes, decrement the counter
	 *  increment left
	 */
	
	//Time Complexity --> O(n)
	//Space Complexity --> O(1)
	
	//Time taken for Code writing and debug - 35mins
	private void consecutiveBlackBlocks(String blocks, int k) {
		int min=Integer.MAX_VALUE;
		int left=0;
		int count=0;
		
		for(int right=0;right<blocks.length();right++) {
			
			if(blocks.charAt(right)=='W') count++;//1
			if(right-left==k-1) {
				if(count < min) min=count;//1
				
				if(blocks.charAt(left)=='W') count--;//0
				
				left++;
			}
		}
		System.out.println(min);
		
	}
}

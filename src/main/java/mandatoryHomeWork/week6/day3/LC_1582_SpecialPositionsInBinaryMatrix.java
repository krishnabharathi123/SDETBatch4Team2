package week6.day3;

import org.junit.Test;

public class LC_1582_SpecialPositionsInBinaryMatrix {

	@Test
	public void example1() {
		int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
		specialPos(mat);
	}
	@Test
	public void example2() {
		int[][] mat = {{1,0,0},{0,1,0},{0,0,1}};
		specialPos(mat);
	}
	@Test
	public void example3() {
		int[][] mat = {{0,0,0},{0,0,0},{0,0,0}};
		specialPos(mat);
	}
	@Test
	public void example4() {
		int[][] mat = {{0,0,0},{0,0,0},{0,0,0}};
		specialPos(mat);
	}
	
	private void specialPos(int[][] mat) {
		int i=0;
		int j=0;
		int onesCount=0;
		int count=0;
		int size=mat[0].length;//3
		while(j<size) {
			while(i<mat.length) {//3	
			
			int val=mat[i][j];//00,01,02
			//System.out.println(val);
			if(val==1) {
				onesCount++;
			}
			i++;
			
			}
			if(onesCount==1) {
				count++;
			}
			onesCount=0;
			i=0;
			j++;
		}
		System.out.println(count);
	}

}

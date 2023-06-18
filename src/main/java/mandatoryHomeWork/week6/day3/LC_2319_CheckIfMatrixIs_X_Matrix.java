package week6.day3;

import org.junit.Test;

public class LC_2319_CheckIfMatrixIs_X_Matrix {

	@Test
	public void example1() {
		int mat[][]= {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
		System.out.println(xMatrix(mat));
	}

	@Test
	public void example2() {
		int mat[][]= {{5,7,0},{0,3,1},{0,5,0}};
		System.out.println(xMatrix(mat));
	}
	
	/*
	 * outer loop for mat
	 * inner loop for mat[0]
	 * check whether the diagonal elements are non-zero
	 * If no, return false
	 * If yes, --> fine
	 * next, check whether non diagonal elements are zeros
	 * if no , return false
	 * 
	 */
	//Time Complexity --> O(n^2)
	//Space complexity --> O(1)
	private boolean xMatrix(int[][] mat) {
		int size=mat.length;//since n*n matrix
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(i==j || j==size-i-1) {
					if(mat[i][j]==0) return false;
				}
				else {
					if(mat[i][j]!=0) return false;
				}
			}
		}
		return true;
		
	}
}

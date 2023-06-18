package week6.day2;

import org.junit.Test;

public class LC_1572_MatrixDiagonalSum {

	@Test
	public void example1() {
		int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};
		diagonalSumUsingOnePass(mat);
	}

	@Test
	public void example2() {
		int mat[][]= {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		diagonalSumUsingOnePass(mat);
	}
	
	//@Test
	public void example3() {
		int mat[][]= {{1},{1},{1},{1}};
		diagonalSumUsingOnePass(mat);
	}
	
	@Test
	public void example4() {
		int mat[][]= {{5}};
		diagonalSumUsingOnePass(mat);
	}
	
	/*
	 * outer loop till the length of the mat
	 * Inner loop till the length of mat[i]
	 * If i==j or j==mat[i].length -i
	 * add the values into sum variable and return it
	 */
	//Time Complexity --> O[n*m]
	//Space Complexity --> O(1)
	private void diagonalSum(int[][] mat) {
		int sum=0;
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				if(i==j || j==mat[i].length-1-i) {
					sum=sum+mat[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	
	/*
	 * To find the diagonal using single outer loop
	 * val=mat[i][i];//to get primary diagonal
	 * val=mat[i][length-i-1]; //to get sec diagonal
	 * sum = sum+val;
	 * once when u come out of the loop, check whether matrix lengt is odd or edd
	 * if odd-> subtract the mat[len/2][len/2] from the overall sum value
	 */
	//Time Complexity --> O(n)
	//Space Complexity --> O(1)
	public void diagonalSumUsingOnePass(int[][] mat) {
		int sum=0;
		int val=0;
		
		for(int i=0;i<mat.length;i++) {
			sum=sum+mat[i][i]+mat[i][mat.length-i-1];
		}
		val=mat.length/2;
		if(mat.length%2!=0) {
			sum=sum-mat[val][val];
		}
		System.out.println(sum);
		
	}
	
}

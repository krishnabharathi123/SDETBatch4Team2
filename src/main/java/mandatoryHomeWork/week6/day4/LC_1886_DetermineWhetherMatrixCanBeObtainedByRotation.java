package week6.day4;

import java.util.Arrays;

import org.junit.Test;

public class LC_1886_DetermineWhetherMatrixCanBeObtainedByRotation {

	@Test
	public void example1() {
		int mat[][]= {{0,1},{1,0}};
		int target[][]= {{1,0},{0,1}};
		System.out.println(rotateArr(mat, target));
	}


	@Test
	public void example2() {
		int mat[][]= {{0,1},{1,1}};
		int target[][]= {{1,0},{0,1}};
		System.out.println(rotateArr(mat, target));
	}
	
	@Test
	public void example3() {
		int mat[][]= {{0,0,0},{0,1,0},{1,1,1}};
		int target[][]= {{1,1,1},{0,1,0},{0,0,0}};
		System.out.println(rotateArr(mat, target));
	}
	
	/*
	 * use 2 loops 
	 * outer loop for i and inner loop for j
	 * create a new array named rot and add the rotated value
	 * add rot[j][arr.length-1-j]=mat[i][j];
	 * rotate till the rot array equals to input array --> break
	 * return true if the rot array equals to the target array
	 */
	
	private boolean rotateArr(int[][] mat, int[][] target) {
		
		int size=mat.length;
		if(size==1) {
			if(Arrays.deepEquals(mat,target)){
				return true;
			}
			return false;
		}
		int[][] rot =new int[size][size];//n*n matrix
		int[][] temp=mat;
		while(!Arrays.deepEquals(rot, mat)) {
			rot = new int[size][size];
		for(int i=0;i<size;i++) {
			
			for(int j=0;j<size;j++) {
				
				rot[j][size-1-i]=temp[i][j];
				
				
			}
		}
		System.out.println(Arrays.toString(rot));
		
		if(Arrays.deepEquals(rot,target)) return true;
		else {
			temp=rot;
			
		} 
		}
		return false;
	}
	
	//not worring for all the solution --> this is not rotating
	 public boolean findRotation(int[][] mat, int[][] target) {
	        int size=mat.length; //n*n matrix
			int i=0,j=size-1;
			while(i<size) {
				if(Arrays.equals(mat[i], target[j])) {
					i++;
					j--;
				}
				else return false;
						
				}
			return true;
	    }
}

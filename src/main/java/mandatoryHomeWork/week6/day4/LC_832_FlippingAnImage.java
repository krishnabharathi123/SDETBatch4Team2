package week6.day4;

import org.junit.Test;

public class LC_832_FlippingAnImage {

	@Test
	public void example1() {
		int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println(imageFlip(image));
	}
	
	@Test
	public void example2() {
		int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		System.out.println(imageFlip(image));
	}
	@Test
	public void example3() {
		int[][] image = {{0}};
		
		System.out.println(imageFlip(image));
	}
	
	/*
	 * outer loop for the image size
	 * inner loop to access the inner array elements
	 * Use 2 pointer opposite direction to swap the values
	 * Come out of loop when left>right
	 * if left==right--> invert the element and return the element
	 */
	private int[][] imageFlip(int[][] image) {
		int size=image.length; //n*n matrix
		for(int i=0;i<size;i++) {
			
			int[] img=image[i];
				int left=0;
				int right=size-1;
				int temp;
				while(left<right) {//110-->011-->100
					temp=img[left];//1
					img[left++]=invert(img[right]);//1
					img[right--]=invert(temp);//0
				}
				if(left==right) {
					img[left] =	invert(img[left]);
				}
				
		
		}
		return image;
	}

	private int invert(int i) {
		if(i==0) return 1;
		return 0;
	}

}

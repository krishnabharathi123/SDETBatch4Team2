package week2.day4;

import java.util.Arrays;

import org.junit.Test;

public class SortEvenandOddIndicesIndependently {
	@Test
	public void positive() {
		int[] num = { 4, 1, 2, 3 };

		sortOddEven1(num);
	}

	@Test
	public void negative() {
		int[] num = { 1, 0, 7, 8, 1 };

		sortOddEven1(num);
	}

	@Test
	public void edge() {
		int[] num = { 2, 1 };

		sortOddEven1(num);
	}
	/*
	 * Check whether the length of input array is even or odd
	 * If even, then initialize num1 and num2 length as input array/2
	 * If odd, then initialize num1 length as input array len/2+1 and num2 length as input array/2
	 * add even indices values of input array in num1 array
	 * add odd indices values of input array in num2 array
	 * sort both the num1 and num2 arrays
	 * now add the num1 value in input array in incremental order in even position
	 * add num2 value in input array in decrement order in odd position
	 * 
	 */
	//Time complexity --> O(n)
	//Space Complexity --> O(n)
	public int[] sortOddEven1(int[] num) {
		int[] num1;
		int[] num2;
		if(num.length%2==0) {
		 num1=new int[num.length/2];
		 num2=new int[num.length/2];
		}
		else {
			num1=new int[num.length/2+1];
			num2=new int[num.length/2];
		}
		int k=0;
		for(int i=0;i<num.length;i=i+2) {
			num1[k++]=num[i];
		}
		k=0;
		for(int i=1;i<num.length;i=i+2) {
			num2[k++]=num[i];
		}
		Arrays.sort(num1);
		Arrays.sort(num2);
		k=0;
		int m=num2.length-1;
		for(int i=0;i<num.length;i++) {
			if(i%2==0) {
				num[i]=num1[k++];
			}
			else {
				num[i]=num2[m--];
			}
		}
		return num;
	}
	//not working for all test data
	private void sortOddEven(int[] num) {
		int left = 0;
		int right = 2;
		int temp;
		while (right < num.length) {
			if (num[left] > num[right]) {
				temp = num[left];
				num[left] = num[right];
				num[right] = temp;
				left+=2;
				right+=2;
			}
		}
		left = 1;
		right = 3;
		while (right < num.length) {
			if (num[left] < num[right]) {
				temp = num[left];
				num[left] = num[right];
				num[right] = temp;
				left+=2;
				right+=2;
			}
		}
		System.out.println(Arrays.toString(num));

	}
	
	//{ 1, 0, 7, 8, 1 }
	
}

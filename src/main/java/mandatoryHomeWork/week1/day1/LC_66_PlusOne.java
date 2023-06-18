package week1.day1;

import java.util.Arrays;

import org.junit.Test;
//https://leetcode.com/problems/plus-one/
public class LC_66_PlusOne {

	@Test
	public void positive() {
		int[] arr= {1,2,3};
		addoneWithoutInBuild(arr);
	}
	
	@Test
	public void negative() {
		int[] arr= {8,9,9};
		addoneWithoutInBuild(arr);
	}
	
	@Test
	public void edge() {
		int[] arr= {9};
		addoneWithoutInBuild(arr);
	}
	
	
	public void addOne(int[] arr) {
		
		int mul = arr.length;// 3
		int target = 0;

		for (int i = 0; i < arr.length; i++) {
			mul--;//1
			target = target + (arr[i] * multiple(mul));//0+(1*100) //100+(2*10) //120+(3) //123

		}

		target = target + 1;
		//System.out.println(target);//124

		String targetStr = String.valueOf(target);
		
		int[] out = new int[targetStr.length()];
		
		for (int i = 0; i < targetStr.length(); i++) {
			// solution 1: converting ASCII value to interger by subrating with 0 whose
			// ASCII of 0 is 48
			// out[i]=((targetStr.charAt(i))-48);
			out[i] = Character.getNumericValue(targetStr.charAt(i));
		}
		System.out.println(Arrays.toString(out));
	}

	public int multiple(int len) {
		int val = 1;
		while (len > 0) {
			val = val * 10;
			len--;

		}
		return val;
	}
	
	
	public void addoneWithoutInBuild(int[] arr) {
		
		arr[arr.length-1]=arr[arr.length-1]+1;
		
		for(int i=arr.length-1;i>=0;i--) {
			
			if(arr[i]>9 && i!=0) {
				arr[i]=0;
				arr[i-1]=arr[i-1]+1;
			}
			else if(arr[i]>9 && i==0) {
				int[] arr1=new int[arr.length+1];
				arr1[i]=1;
				arr=arr1;
			}
			
		}
		System.out.println(Arrays.toString(arr));
		
	}

}

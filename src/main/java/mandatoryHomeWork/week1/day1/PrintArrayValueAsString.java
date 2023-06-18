package week1.day1;

import org.junit.Test;

public class PrintArrayValueAsString {

	@Test
	public void positive() {
		int[] arr= {5,6,8,9};
		printingString(arr);
	}
	
	@Test
	public void negative() {
		int[] arr= {-5,8,-9,0};
		printingString(arr);
	}
	
	@Test
	public void edge() {
		int[] arr= {};
		printingString(arr);
	}
	
	
	public void printingString(int[] arr) {
		
		String str="";
		
		for(int i:arr) {
			str=str+i;
			
		}
		System.out.println(str);
		
	}
}

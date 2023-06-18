package week1.day2;

import org.junit.Test;
//https://leetcode.com/problems/add-digits/
public class LC_258_AddDigits {

	@Test
	public void positive() {
		int num= 785896;
		addingDigits(num);
	}
	
	
	@Test
	public void negative() {
		int num= -38;
		addingDigits(num);
	}
	
	@Test
	public void edge() {
		int num= 0;
		addingDigits(num);
	}
	
	private void addingDigits(int num) {
	
		while(num>9) {
			int n=num, k=0;
			while(n>0) {
				k=k+(n%10);
				n=n/10;
			}
			num=k;
		}
		System.out.println(num);
		
	}

	
}

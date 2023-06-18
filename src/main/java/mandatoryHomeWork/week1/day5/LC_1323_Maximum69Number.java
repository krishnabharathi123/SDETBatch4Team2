package week1.day5;

import org.junit.Test;
//https://leetcode.com/problems/maximum-69-number/
public class LC_1323_Maximum69Number {
	@Test
	public void positive() {
		int num = 9669;
		Maximum69(num);
	}

	@Test
	public void negative() {
		int num = 9996;
		Maximum69(num);
	}

	@Test
	public void edge() {
		int num = 66666;
		Maximum69(num);

	}

	/* Converting to String
	 * Convert the integer into String Loop through the length of the string Check
	 * the each and every character in string and change the value of 1st 6 to 9
	 * 
	 */
	//Time complexity ---> O(n)
	
	private void Maximum69(int num) {
		String val = String.valueOf(num);
		String str = "";
		char tar = '\u0000';
		int count = 0;
		for (int i = 0; i < val.length(); i++) {
			//9669
			tar = val.charAt(i);
			if (val.charAt(i) == '6' && count < 1) {
				tar = '9';
				count++;

			}
			str = str + tar;
		}
		System.out.println(Integer.parseInt(str));

	}
}

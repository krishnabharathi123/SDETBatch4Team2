package week1.day3;

import java.util.Arrays;

import org.junit.Test;

public class RemoveOccuranceOfIndex {

	@Test
	public void positive() {
		int[] num = { 1, 2, 3, 4, 5, 1 };
		int index = 1;
		removeOcc(num, index);
	}

	@Test
	public void negative() {
		int[] num = { 1, 0, 7, 8, 1 };
		int index = 8;
		removeOcc(num, index);
	}

	@Test
	public void edge() {
		int[] num = { 1, 1, 1, 1, 1 };
		int index = 0;
		removeOcc(num, index);
	}

	/*
	 * Validate whether the given index is less that input array length
	 * If yes ---> throw the error msg
	 * If no --->
	 * 		Store the array value present in given index in a target variable.
	 * 		loop till the array length
	 * 			verify whether the array value is equal to the target value
	 * 				if yes, then increment the counter
	 * 		create a new array with length = inputarray length - counter value
	 * 		loop till the array length
	 * 			add the input array value into output array if the array value is not equal to the target
	 * 		Print the output array
	 */
	// O[2n] --> O[n]
	private void removeOcc(int[] num, int index) {
		if (index < num.length) {
			int val = num[index];
			int count = 0;
			for (int i = 0; i < num.length; i++) {
				if (num[i] == val) {
					count++;
				}
			}
			int[] outArr = new int[num.length - count];
			int j = 0;
			for (int i = 0; i < num.length; i++) {
				if (num[i] != val) {
					outArr[j++] = num[i];
				}
			}
			System.out.println(Arrays.toString(outArr));
		} else {
			System.out.println("Given index is greater than the input array length");
		}
	}

}

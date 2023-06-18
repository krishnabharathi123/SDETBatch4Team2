package week1.day1;

import java.util.Arrays;

import org.junit.Test;

public class TrimArrayToGivenLength {

	@Test
	public void positive() {
		int[] arr = { 1, 2, 3, 6, 80, 67 };
		int target = 3;
		trimArray(arr, target);

	}

	@Test
	public void negative() {
		int[] arr = { 4, 3, 2, 1 };
		int target = 10;
		trimArray(arr, target);
	}

	@Test
	public void edge() {
		int[] arr = {};
		int target = 8;
		trimArray(arr, target);
	}

	private void trimArray(int[] arr, int target) {
		if (arr.length >= target) {
			int[] arr1 = new int[target];

			for (int i = 0; i < target; i++) {
				arr1[i] = arr[i];
			}
			System.out.println(Arrays.toString(arr1));

		} else {
			System.out.println(Arrays.toString(arr));
		}
	}
}

package week1.day1;

import java.util.Arrays;

import org.junit.Test;

public class RemoveArrayVal {

	@Test
	public void positive() {
		int[] arr = { 1, 2, 3, 6, 80, 67 };
		int target = 6;
		removeArrayValue(arr, target);

	}

	@Test
	public void negative() {
		int[] arr = { 4, 3, 2, 1 };
		int target = 6;
		removeArrayValue(arr, target);
	}

	@Test
	public void edge() {
		int[] arr = {};
		int target = 8;
		removeArrayValue(arr, target);
	}

	private void removeArrayValue(int[] arr, int target) {
		int left = 0, right = 0;

		int[] arr1 = new int[arr.length-1];
		while (left < arr.length) {
			if (arr[left] != target) {

				arr1[right++] = arr[left++];

			} else {
				left++;
			}
		}
		arr=arr1;
		System.out.println(Arrays.toString(arr));

	}

}

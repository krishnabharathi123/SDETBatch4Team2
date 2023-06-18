package week1.day1;

import org.junit.Test;

public class ValueContainsInArray {

	@Test
	public void positive() {
		int[] arr = { 1, 2, 3, 6, 80, 67 };
		int target = 6;
		isValuePrsnt(arr, target);

	}

	@Test
	public void negative() {
		int[] arr = { 4, 3, 2, 1 };
		int target = 6;
		isValuePrsnt(arr, target);
	}

	@Test
	public void edge() {
		int[] arr = {};
		int target = 8;
		isValuePrsnt(arr, target);
	}

	private void isValuePrsnt(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;
		boolean bVal = false;
		while (left < right) {
			if (arr[left] == target || arr[right] == target) {
				System.out.println("The target value is present in input array");
				bVal = true;
				break;
			} else {
				left++;
				right--;
			}

		}
		if (!bVal) {
			System.out.println("Target value is not available in input array");
		}
	}

}

package org.rentalsavg;

import java.util.Arrays;

public class ArraysHints {
	public void rotateArray(int[] arr, int shift) {
		shift %= arr.length;
		reverseArray(arr, 0, arr.length-1);
		reverseArray(arr, 0, shift-1);
		reverseArray(arr, shift, arr.length-1);
	}

	public Integer[] getUniqueElements(Integer[] arr) {
		Arrays.sort(arr);
		int index = 1;
		for (int i = 0; i < arr.length-1; ++i) {
			if (arr[i] != arr[i+1]) {
				arr[index++] = arr[i+1];
			}
		}
		return Arrays.copyOfRange(arr, 0, index);
	}

	private void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}

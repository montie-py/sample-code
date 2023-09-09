package org.rentalsavg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public int getSingleUniqueElementFromDoublesArray(int[] arr) {
		int result = 0;
		for (int element : arr) {
			result ^= element;
		}
		return result;
	}

	public int[] arraysIntersection1(int[] arr1, int[] arr2) {
		Map<Integer, Integer> occurences;
		int[] result;
		if (arr1.length < arr2.length) {
			occurences = getMapOccurences(arr1);
			result = getIntersectionFromMap(arr2, occurences);
		} else {
			occurences = getMapOccurences(arr2);
			result = getIntersectionFromMap(arr1, occurences);
		}

		return result;
	}

	public int[] arraysIntersection2(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int indexResult = 0, indexArr1 = 0, indexArr2 = 0;

		while ((indexArr1 < arr1.length) && (indexArr2 < arr2.length)) {
			if (arr1[indexArr1] == arr2[indexArr2]) {
				arr1[indexResult++] = arr1[indexArr1];
				indexArr1++;
				indexArr2++;
			} else if (arr1[indexArr1] < arr2[indexArr2]) {
				++indexArr1;
			} else {
				++indexArr2;
			}
		}

		return Arrays.copyOfRange(arr1, 0, indexResult);
	}

	public int[] plusOne(int[] numbers) {
		for (int i = numbers.length-1; i >= 0; --i) {
			if (numbers[i] < 9) {
				numbers[i]++;
				return numbers;
			} else {
				numbers[i] = 0;
			}
		}

		int[] result = new int[numbers.length +1];
		result[0] = 1;

		return result;
	}

	public void moveZeroes(int[] nums) {
		int length = nums.length;
		int index = 0;
		for (int i = 0; i < length; ++i) {
			if (nums[i] != 0) {
				nums[index++] = nums[i];
			}
		}

		if (index < length) {
			for (int i = index; i < length; ++i) {
				nums[i] = 0;
			}
		}
	}

	private int[] getIntersectionFromMap(int[] arr, Map<Integer, Integer> occurences) {
		List<Integer> intersections = new ArrayList<>();
		for (int elem : arr) {
			if (occurences.containsKey(elem)) {
				intersections.add(elem);
				int currentVal = occurences.get(elem);
				if (currentVal == 1) {
					occurences.remove(elem);
				} else {
					occurences.put(elem, currentVal-1);
				}
			}
		}
		int[] result = new int[intersections.size()];

		for(int i = 0; i < intersections.size(); ++i) {
			result[i] = intersections.get(i);
		}

		return result;
	}

	private Map<Integer, Integer> getMapOccurences(int[] arr) {
		Map<Integer, Integer> occurences = new HashMap<>();
		for (int elem : arr) {
			occurences.put(elem, occurences.getOrDefault(elem, 0)+1);
		}

		return occurences;
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

	public int[] twoSum(int[] ints, int target) {
		Map<Integer, Integer> records = new HashMap<>();
		int[] result = new int[2];

		for (int i = 0; i < ints.length; ++i) {
			if (records.containsKey(target-ints[i])) {
				result[0] = i;
				result[1] = records.get(target-ints[i]);
				return result;
			}

			records.put(ints[i], i);
		}

		return result;
	}
}

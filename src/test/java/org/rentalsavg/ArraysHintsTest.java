package org.rentalsavg;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraysHintsTest {

	private static ArraysHints arraysHints;

	@BeforeAll
	static void setUp() {
		arraysHints = new ArraysHints();
	}

	@Test
	@DisplayName("Rotate an array to the given int shift")
	void rotateArray() {
		int[] arr = new int[]{1,2,3,4,5,6,7};
		arraysHints.rotateArray(arr, 3);
		assertArrayEquals(new int[]{5,6,7,1,2,3,4}, arr);
	}

	@RepeatedTest(5)
	@DisplayName("It should return an array of unique elements from an array of duplicate ones")
	void getUniqueElements() {
		Integer[] arr = new Integer[]{2,5,2,3,6,4,1,4};
		List<Integer> listArr = new ArrayList<>(Arrays.asList(arr));
		Collections.shuffle(listArr);
		arr = listArr.toArray(new Integer[0]);
		System.out.println(Arrays.toString(arr));
		Integer[] uniqueResult = arraysHints.getUniqueElements(arr);
		assertArrayEquals(new Integer[]{1,2,3,4,5,6}, uniqueResult);
	}
}
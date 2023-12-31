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

	@Test
	void getUniqueElement() {
		int[] arr = new int[]{2, 5, 5, 6, 7, 8, 7, 6, 8};
		int unique = arraysHints.getSingleUniqueElementFromDoublesArray(arr);
		assertEquals(2, unique);
	}

	@Test
	void checkArraysIntersections1() {
		int[] arr1 = new int[]{2, 22, 1, 2, 2, 5, 6, 8};
		int[] arr2 = new int[]{34, 2, 7, 2, 15, 8};
		int[] uniqueBiggerFirst = arraysHints.arraysIntersection1(arr1, arr2);

		int[] arr3 = new int[]{4, 1, 2, 5, 8, 2};
		int[] arr4 = new int[]{2, 8, 2};
		int[] uniqueBiggerSecond = arraysHints.arraysIntersection1(arr3, arr4);

		assertAll(
				() -> assertArrayEquals(new int[]{2, 2, 8}, uniqueBiggerFirst),
				() -> assertArrayEquals(new int[]{2, 8, 2}, uniqueBiggerSecond)
		);
	}

	@Test
	@DisplayName("It should return the same array with the number, compound from all the digits, incremented with 1")
	void checkPlusOne() {
		int[] numbers = new int[]{1,2,3,4,5,6};
		int[] numbers2 = new int[]{9};
		int[] numbers3 = new int[]{8,9,9};
		assertAll(
				() -> assertArrayEquals(new int[]{1,2,3,4,5,7}, arraysHints.plusOne(numbers)),
				() -> assertArrayEquals(new int[]{1, 0}, arraysHints.plusOne(numbers2)),
				() -> assertArrayEquals(new int[]{9,0,0}, arraysHints.plusOne(numbers3))
		);
	}

	@Test
	@DisplayName("Move zeroes from an array to the its end without making a copy of array")
	void checkMoveZeroes() {
		int[] numbers = new int[]{0, 12, 3, 0, 4};
		int[] numbers2 = new int[]{0};
		arraysHints.moveZeroes(numbers);
		arraysHints.moveZeroes(numbers2);
		assertAll(
				() -> assertArrayEquals(new int[]{12, 3, 4, 0, 0}, numbers),
				() -> assertArrayEquals(new int[]{0}, numbers2)
		);
	}

	@Test
	@DisplayName("it should be exactly 2 elements in array, the sum of which is equal to 'target'. It should return the indices of that elements")
	void checkTwoSum() {
		int[] res1 = arraysHints.twoSum(new int[]{2,3,4}, 6);
		int[] res2 = arraysHints.twoSum(new int[]{2,7,11,15}, 9);

		assertAll(
				() -> assertArrayEquals(new int[]{2, 0}, res1),
				() -> assertArrayEquals(new int[]{1, 0}, res2)
		);
	}

	@Test
	@DisplayName("Validate sudoku board, if it's solvable")
	void validateSudoku() {
		char[][] board1 = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		char[][] board2 = {
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};

		assertAll(
				() -> assertTrue(arraysHints.checkSudoku(board1)),
				() -> assertFalse(arraysHints.checkSudoku(board2))
		);
	}
}
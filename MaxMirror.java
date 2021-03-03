package com.inn.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxMirror {

	public int maxMirror(int[] nums) {

		int count = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j >= 0 && i + count < nums.length; j--) {
				if (nums[i + count] == nums[j]) {
					count++;
				} else {
					max = Math.max(count, max);
					count = 0;
				}
			}
			max = Math.max(count, max);
		}
		return max;
	}

	public int countClumps(int[] nums) {
		boolean inclump = false;
		int clumpcnt = 0;
		// note the start-from-1 loop
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				// we are in a clump
				if (!inclump) {
					// this is the first time for this clump.
					inclump = true;
					clumpcnt++;
				}
			} else {
				inclump = false;
			}
		}
		return clumpcnt;
	}

	static int printEqualSumSets(int[] arr, int n) {
		int i, currSum, sum = 0;

		for (i = 0; i < arr.length; i++)
			sum += arr[i];

		if ((sum & 1) == 1) {
			return -1;
		}

		int k = sum >> 1;

		boolean[][] dp = new boolean[n + 1][k + 1];

		for (i = 1; i <= k; i++)
			dp[0][i] = false;

		for (i = 0; i <= n; i++)
			dp[i][0] = true;

		for (i = 1; i <= n; i++) {
			for (currSum = 1; currSum <= k; currSum++) {

				dp[i][currSum] = dp[i - 1][currSum];

				if (arr[i - 1] <= currSum)
					dp[i][currSum] = dp[i][currSum] | dp[i - 1][currSum - arr[i - 1]];
			}
		}

		List<Integer> set1 = new ArrayList<Integer>();
		List<Integer> set2 = new ArrayList<Integer>();

		if (!dp[n][k]) {
			return -1;
		}

		i = n;
		currSum = k;

		while (i > 0 && currSum >= 0) {

			if (dp[i - 1][currSum]) {
				i--;
				set2.add(arr[i]);
			}

			else if (dp[i - 1][currSum - arr[i - 1]]) {
				i--;
				currSum -= arr[i];
				set1.add(arr[i]);
			}
		}

		int total = 0;
		for (i = 0; i < set1.size(); i++)
			total += set1.get(i);
       return total;
	}

	@Test
	public void test() {
		int[] testArray = { 1, 2, 3, 8, 9, 3, 1, 2 };
		assertTrue(maxMirror(testArray) == 1,
				"Expected: " + String.valueOf(1) + ", Actual: " + String.valueOf(maxMirror(testArray)));
		System.out.println(String.valueOf(maxMirror(testArray)));
//		 assertTrue(countClumps(testArray) == 3,
//		 "Expected: " + String.valueOf(3) + ", Actual: " +
//		 String.valueOf(countClumps(testArray)));
		System.out.println(String.valueOf(countClumps(testArray)));
		int []arr = new int[]{ 5, 5, 1, 11 }; 
		int n = arr.length; 
		printEqualSumSets(arr, n);

	}
}
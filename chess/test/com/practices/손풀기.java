package com.practices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class 손풀기 {
	private static final Logger logger = LoggerFactory.getLogger(손풀기.class);
	private Sort sort;

	@BeforeEach
	void setUp() {
		sort = new Sort();
	}

	@Test
	void quickSort() {
		int[] A = new int[]{1, 34, 5, 4, 3, 6, 3, 45, 23, 7, 7, 5, 68, 568};
		sort.quickSort(A, 0, A.length - 1);
		for (int a : A) {
			logger.debug("a  : " + a);
		}
	}

	private class Sort {
		private void quickSort(int[] A, int low, int high) {
			if (low < high) {
				int p = partition(A, low, high);
				quickSort(A, low, p);
				quickSort(A, p+1, high);
			}
		}

		private int partition(int[] A, int low, int high) {
			int pivot = A[(low + high) / 2];
			int i = low - 1;
			int j = high + 1;
			while (true) {
				do {
					i += 1;
				} while (pivot > A[i]);

				do {
					j -= 1;

				} while (pivot < A[j]);

				if (i >= j) return j;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
	}
}

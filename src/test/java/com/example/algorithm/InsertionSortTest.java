package com.example.algorithm;

import static com.example.algorithm.TestUtils.sort;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

  InsertionSort<Integer> insertionSort = new InsertionSort<>();

  @Test
  void sort10() {
    sort(insertionSort, new Integer[] {}, true);
    sort(insertionSort, new Integer[] {10}, true);
    sort(insertionSort, new Integer[] {5, 2}, true);
    sort(insertionSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(insertionSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(insertionSort, 100000, false);
  }
}

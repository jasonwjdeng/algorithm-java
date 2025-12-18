package com.example.algorithm;

import static com.example.algorithm.TestUtils.generateArray;
import static com.example.algorithm.TestUtils.sort;

import org.junit.jupiter.api.Test;

class ThreeWayQuickSortTest {

  ThreeWayQuickSort<Integer> quickSort = new ThreeWayQuickSort<>();

  @Test
  void sort10() {
    sort(quickSort, new Integer[] {}, true);
    sort(quickSort, new Integer[] {10}, true);
    sort(quickSort, new Integer[] {5, 2}, true);
    sort(quickSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(quickSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(quickSort, 100000, false);
  }

  @Test
  void sort1000k() {
    sort(quickSort, 1000000, false);
  }

  @Test
  void sort1000kWithDuplicatedValue() {
    sort(quickSort, generateArray(1000000, 2), false);
  }
}

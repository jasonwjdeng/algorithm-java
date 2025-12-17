package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.TestUtils.sort;

class MergeSortTest {

  MergeSort<Integer> mergeSort = new MergeSort<>();

  @Test
  void sort10() {
    sort(mergeSort, new Integer[] {}, true);
    sort(mergeSort, new Integer[] {10}, true);
    sort(mergeSort, new Integer[] {5, 2}, true);
    sort(mergeSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(mergeSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(mergeSort, 100000, false);
  }

  @Test
  void sort1000k() {
    sort(mergeSort, 1000000, false);
  }
}

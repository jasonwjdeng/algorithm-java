package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.TestUtils.sort;

class CountingSortTest {

  CountingSort<Integer> countingSort = new CountingSort<>();

  @Test
  void sort10() {
    sort(countingSort, new Integer[] {}, true);
    sort(countingSort, new Integer[] {10}, true);
    sort(countingSort, new Integer[] {5, 2}, true);
    sort(countingSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(countingSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(countingSort, 100000, false);
  }

  @Test
  void sort1000k() {
    sort(countingSort, 1000000, false);
  }
}

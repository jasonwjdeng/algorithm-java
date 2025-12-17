package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.TestUtils.sort;

class RadixSortTest {

  RadixSort<Integer> radixSort = new RadixSort<>();

  @Test
  void sort10() {
    sort(radixSort, new Integer[] {}, true);
    sort(radixSort, new Integer[] {10}, true);
    sort(radixSort, new Integer[] {5, 2}, true);
    sort(radixSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(radixSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(radixSort, 100000, false);
  }
}

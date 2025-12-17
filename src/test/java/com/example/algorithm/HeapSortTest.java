package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.TestUtils.sort;

class HeapSortTest {

  HeapSort<Integer> heapSort = new HeapSort<>();

  @Test
  void sort10() {
    sort(heapSort, new Integer[] {}, true);
    sort(heapSort, new Integer[] {10}, true);
    sort(heapSort, new Integer[] {5, 2}, true);
    sort(heapSort, 10, true);
    sort(heapSort, 5, true);
  }

  @Test
  void sort10k() {
    sort(heapSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(heapSort, 100000, false);
  }

  @Test
  void sort1000k() {
    sort(heapSort, 1000000, false);
  }
}

package com.example.algorithm;

import static com.example.algorithm.TestUtils.sort;

import org.junit.jupiter.api.Test;

class SelectionSortTest {

  SelectionSort<Integer> selectionSort = new SelectionSort<>();

  @Test
  void sort10() {
    sort(selectionSort, new Integer[] {}, true);
    sort(selectionSort, new Integer[] {10}, true);
    sort(selectionSort, new Integer[] {5, 2}, true);
    sort(selectionSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(selectionSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(selectionSort, 100000, false);
  }
}

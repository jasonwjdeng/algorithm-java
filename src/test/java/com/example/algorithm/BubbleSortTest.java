package com.example.algorithm;

import static com.example.algorithm.TestUtils.sort;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

  BubbleSort<Integer> bubbleSort = new BubbleSort<>();

  @Test
  void sort10() {
    sort(bubbleSort, new Integer[] {}, true);
    sort(bubbleSort, new Integer[] {10}, true);
    sort(bubbleSort, new Integer[] {5, 2}, true);
    sort(bubbleSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(bubbleSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(bubbleSort, 100000, false);
  }
}

package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.TestUtils.sort;

class ShellSortTest {

  ShellSort<Integer> shellSort = new ShellSort<>();

  @Test
  void sort10() {
    sort(shellSort, new Integer[] {}, true);
    sort(shellSort, new Integer[] {10}, true);
    sort(shellSort, new Integer[] {5, 2}, true);
    sort(shellSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(shellSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(shellSort, 100000, false);
  }
}

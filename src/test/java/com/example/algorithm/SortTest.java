package com.example.algorithm;

import static com.example.algorithm.TestUtils.generateRandomArray;
import static com.example.algorithm.TestUtils.sort;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SortTest {
  List<Sort<Integer>> sortList =
      List.of(
          new BubbleSort<>(),
          new SelectionSort<>(),
          new InsertionSort<>(),
          new ShellSort<>(),
          new MergeSort<>(),
          new QuickSort<>(),
          new HeapSort<>(),
          new CountingSort<>(),
          new BucketSort<>());

  @Test
  void sort10() {
    int size = 10;
    sortBySize(size);
    sortBySize(0);
    sortBySize(1);
    sortBySize(2);
  }

  @Test
  void sort10k() {
    int size = 10000;
    sortBySize(size);
  }

  @Test
  void sort100k() {
    int size = 100000;
    sortBySize(size);
  }

  private void sortBySize(int size) {
    Integer[] nums = generateRandomArray(size);
    for (Sort<Integer> sort : sortList) {
      log.info(sort.getClass().getName());
      sort(sort, Arrays.copyOf(nums, nums.length), false);
    }
  }
}

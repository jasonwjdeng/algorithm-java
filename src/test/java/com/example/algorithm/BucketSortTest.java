package com.example.algorithm;

import org.junit.jupiter.api.Test;

import static com.example.algorithm.TestUtils.sort;

class BucketSortTest {

  BucketSort<Integer> bucketSort = new BucketSort<>();

  @Test
  void sort10() {
    sort(bucketSort, new Integer[] {}, true);
    sort(bucketSort, new Integer[] {10}, true);
    sort(bucketSort, new Integer[] {5, 2}, true);
    sort(bucketSort, new Integer[] {1_000_000_000, 999_999_999}, true);
    sort(bucketSort, 10, true);
  }

  @Test
  void sort10k() {
    sort(bucketSort, 10000, false);
  }

  @Test
  void sort100k() {
    sort(bucketSort, 100000, false);
  }

  @Test
  void sort1000k() {
    sort(bucketSort, 1000000, false);
  }
}

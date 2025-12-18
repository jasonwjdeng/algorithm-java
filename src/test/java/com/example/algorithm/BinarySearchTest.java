package com.example.algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  BinarySearch search = new BinarySearch();

  @Test
  void search10() {
    search(0);
    search(1);
    search(10);
  }

  @Test
  void search10k() {
    search(10_000);
  }

  @Test
  void search100k() {
    search(100_000);
  }

  @Test
  void search1000k() {
    search(1_000_000);
  }

  private void search(int size) {

    Integer[] integers = TestUtils.generateRandomArray(size);
    //        Arrays.sort(integers);
    int[] nums = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
    Arrays.sort(nums);
    //    ThreeWayQuickSort<Integer> sort = new ThreeWayQuickSort<>();
    //    sort.sort(nums);
    int target = (int) (Math.random() * size);
    //    target = nums[target];

    if (nums.length < 10) System.out.println("nums=" + Arrays.toString(nums) + ",target=" + target);

    Instant startTime = Instant.now();
    int result = search.search(nums, target);
    Instant endTime = Instant.now();

    int expected = Arrays.binarySearch(nums, target);
    expected = expected < 0 ? -1 : expected;

    System.out.printf(
        "result: %d, duration: %dms%n", result, Duration.between(startTime, endTime).toMillis());

    assertEquals(expected, result);
  }
}

package com.example.algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUtils {
  static Integer[] generateRandomArray(int size) {
    Integer[] nums = new Integer[size];
    for (int i = 0; i < size; i++) {
      nums[i] = (int) (Math.random() * size);
    }
    return nums;
  }

  static void sort(Sort<Integer> sort, int size, boolean logInfo) {
    sort(sort, generateRandomArray(size), logInfo);
  }

  static void sort(Sort<Integer> sort, Integer[] nums, boolean logInfo) {
    Integer[] numsCopy = Arrays.copyOf(nums, nums.length);

    if (logInfo) {
      log.info("nums: {}", Arrays.toString(nums));
      log.info("numsCopy: {}", Arrays.toString(numsCopy));
    }

    Instant startTime = Instant.now();
    sort.sort(nums);
    Instant endTime = Instant.now();

    Arrays.sort(numsCopy);
    if (logInfo) {
      log.info("nums: {}", Arrays.toString(nums));
      log.info("numsCopy: {}", Arrays.toString(numsCopy));
    }
    log.info("duration: {}ms", Duration.between(startTime, endTime).toMillis());

    assertArrayEquals(numsCopy, nums);
  }
}

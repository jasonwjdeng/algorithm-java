package com.example.algorithm;

import java.util.Arrays;

public class BucketSort<T extends Comparable<T>> extends Sort<T> {
  InsertionSort<Integer> insertionSort = new InsertionSort<>();

  @Override
  public void sort(T[] nums) {

    // 只接受长度大于1的整数数组
    if (nums.length <= 1) return;
    assert nums[0] instanceof Integer;
    Integer[] arr = (Integer[]) nums;

    // 找出数组中的最小值和最大值
    int min = arr[0], max = arr[0];
    for (int val : arr) {
      if (val < min) min = val;
      else if (val > max) max = val;
    }

    // 计算元素的跨度
    int len = max - min + 1;
    if (len <= 1) return;

    // 计算桶数
    int bucketCapacity = 5;
    int bucketCount = len / bucketCapacity + 1;
    System.out.println("bucketCount=" + bucketCount);
    // 初始化桶
    Integer[][] buckets = new Integer[bucketCount][0];

    // 把元素放入相应的桶中
    for (int val : arr) {
      int i = (val - min) / bucketCapacity;
      buckets[i] = arrayAppend(buckets[i], val);
    }

    // 对每个桶进行排序
    for (Integer[] bucket : buckets) {
      insertionSort.sort(bucket);
    }

    // 合并所有桶的元素
    int cur = 0;
    for (Integer[] bucket : buckets) {
      for (Integer val : bucket) {
        arr[cur++] = val;
      }
    }
  }
}

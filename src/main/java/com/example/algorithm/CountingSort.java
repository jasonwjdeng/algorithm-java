package com.example.algorithm;

public class CountingSort<T extends Comparable<T>> extends Sort<T> {
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

    // 计算需要分配的计数数组的长度
    int len = max - min + 1;
    if (len <= 1) return;

    // 计算每个元素的出现个数，下标对应该元素值相对最小值的偏移量
    int[] counting = new int[len];
    for (int val : arr) {
      counting[val - min]++;
    }

    // 根据计数数组把结果写入回原数组
    int cur = 0;
    for (int i = 0; i < counting.length; i++) {
      for (int j = 0; j < counting[i]; j++) {
        // 根据偏移量计算回原值
        arr[cur] = i + min;
        cur++;
      }
    }
  }
}

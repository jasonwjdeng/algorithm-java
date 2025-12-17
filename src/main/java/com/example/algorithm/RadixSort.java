package com.example.algorithm;

public class RadixSort<T extends Comparable<T>> extends Sort<T> {
  @Override
  public void sort(T[] nums) {

    // 只接受长度大于1的整数数组
    if (nums.length <= 1) return;
    assert nums[0] instanceof Integer;
    Integer[] arr = (Integer[]) nums;

    // 找出数组中的最大值
    int max = arr[0];
    for (int val : arr) {
      if (val > max) max = val;
    }
    System.out.println("max=" + max);

    // 找出最大值的位数
    int radix = 10;
    int digits = 0;
    int temp = max;
    while (temp > 0) {
      temp /= radix;
      digits++;
    }
    System.out.println("digits=" + digits);

    // 从个位开始对每一位数字进行排序
    int mod = radix;
    int div = 1;
    for (int i = 1; i <= digits; i++, mod *= radix, div *= radix) {
      // 初始化桶
      Integer[][] buckets = new Integer[radix][0];

      // 把每个元素放入对应的桶中，该桶是符合队列的先进先出原则
      for (int val : arr) {
        int index = (val % mod) / div;
        buckets[index] = arrayAppend(buckets[index], val);
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
}

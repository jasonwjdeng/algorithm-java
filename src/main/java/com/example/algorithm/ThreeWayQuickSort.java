package com.example.algorithm;

public class ThreeWayQuickSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    sort(nums, 0, nums.length - 1);
  }

  private void sort(T[] nums, int begin, int end) {
    if (begin >= end) return;
    // 优化：对小规模数据用插入排序
    if (end - begin < 16) {
      //      System.out.println("use insertion sort");
      insertionSort(nums, begin, end);
      return;
    }
    // 根据基准元素pivot进行分区:
    // 小于pivot的元素在lt左边
    // 大于pivot的元素在gt右边
    // 等于pivot的元素在区间[lt,gt]
    int lt = begin, gt = end;
    T pivot = nums[begin];//初始化基准元素为第一个元素
    int i = begin + 1;//当前指针指向第二个元素，即从第二个元素开始比较
    while (i <= gt) {//当前指针到达右边界退出循环
      int c = nums[i].compareTo(pivot);
      if (c < 0) {
        //小于基准元素的往左移
        swap(nums, i++, lt++);
      } else if (c > 0) {
        //大于基准元素的往右移
        swap(nums, i, gt--);
      } else {
        //等于基准元素的把指针右移
        i++;
      }
    }

    // 对左右两边的元素分别进行排序
    sort(nums, begin, lt - 1);
    sort(nums, gt + 1, end);
  }

  private void insertionSort(T[] nums, int begin, int end) {
    for (int i = begin; i <= end; i++) {
      for (int j = i; j > begin && less(nums[j], nums[j - 1]); j--) {
        swap(nums, j, j - 1);
      }
    }
    if (nums.length <= 10) {
      printArray(nums);
    }
  }
}

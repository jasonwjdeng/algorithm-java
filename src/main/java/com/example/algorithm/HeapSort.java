package com.example.algorithm;

import java.awt.font.NumericShaper;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
  @Override
  public void sort(T[] nums) {
    // 构造大根堆，也就是根节点大于等于其子节点
    int len = nums.length;
    // 优化：从叶子节点的根节点开始执行下沉，也就是叶子结点不需要执行下沉
    for (int i = len / 2; i >= 0; i--) {
      sink(nums, i, len);
    }
    // 遍历待排序元素直到剩下唯一一个元素就退出
    while (len > 1) {
      // 把最后一个元素与堆顶交换位置，并把待排序的数据长度减1
      // 相当于把堆顶元素（也就是最大的一个元素）放到数组的空闲位置
      swap(nums, 0, --len);
      // 把放到堆顶的元素下沉，重新构造大根堆
      sink(nums, 0, len);
    }
    // 最后构成一个升序排列的队列
    // 如果换成小根堆的话，就是构成一个降序排列的队列
  }

  private void sink(T[] nums, int k, int len) {
    int root = k;
    // 如果存在左子节点就执行遍历
    for (int sub = 2 * root + 1; sub < len; sub = 2 * root + 1) {
      // 如果存在右子节点，并且右子节点大于左子节点，选择右子节点进行交换
      if (sub + 1 < len && larger(nums[sub + 1], nums[sub])) sub++;
      // 如果根节点大于等于最大的子节点，意味着堆有序，结束循环
      if (!larger(nums[sub], nums[root])) break;
      // 把根节点和上面选定的子节点交换位置
      swap(nums, sub, root);
      // 继续下沉
      root = sub;
    }
  }
}

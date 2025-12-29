package com.example.leetcode;

// 860. 柠檬水找零
// https://leetcode.cn/problems/lemonade-change
public class Solution860 {
  public boolean lemonadeChange(int[] bills) {
    // 记录5元和10元的数目
    int five = 0, ten = 0;
    // 从头遍历账单
    for (int bill : bills) {
      if (bill == 5)
        // 如果收入5元，计数
        five++;
      else if (bill == 10) {
        // 如果收入10元，并且有5元找零
        if (five > 0) {
          ten++;
          five--;
        } else
          // 否则无法找零
          return false;
      } else {
        // 收入20元
        if (ten > 0 && five > 0) {
          // 如有10元，优先找零
          ten--;
          five--;
        } else if (five > 2)
          // 没有10元则用5元找零
          five -= 3;
        else
          // 没有适当的组合则无法找零
          return false;
      }
    }
    return true;
  }
}

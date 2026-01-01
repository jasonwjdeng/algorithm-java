package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 51.N皇后
// https://leetcode.cn/problems/n-queens/
public class Solution51 {
  public List<List<String>> solveNQueens(int n) {
    // 初始化结果容器
    List<List<String>> result = new ArrayList<>();
    // 初始化每次选择的路径
    char[][] chessboard = new char[n][n];
    for (char[] chars : chessboard) {
      Arrays.fill(chars, '.');
    }
    // 从第一行开始搜索
    backtracking(n, 0, result, chessboard);
    return result;
  }

  private void backtracking(int n, int row, List<List<String>> result, char[][] chessboard) {
    // 当检索完所有行就输出一个结果
    if (row == n) {
      result.add(arrayToList(chessboard));
      return;
    }
    // 搜索第row行所有可行方案
    for (int col = 0; col < n; col++) {
      if (isValid(n, col, row, chessboard)) {
        // 在当前位置(row,col)放置Q
        chessboard[row][col] = 'Q';
        // 从下一行开始搜索
        backtracking(n, row + 1, result, chessboard);
        // 撤销在当前位置(row,col)放置Q
        chessboard[row][col] = '.';
      }
    }
  }

  // 格式化输出内容
  private List<String> arrayToList(char[][] chessboard) {
    List<String> list = new ArrayList<>();
    for (char[] chars : chessboard) {
      list.add(new String(chars));
    }
    return list;
  }

  private boolean isValid(int n, int col, int row, char[][] chessboard) {
    // 检查之前的行，同一列是否有Q
    for (int r = 0; r < row; r++) {
      if (chessboard[r][col] == 'Q') return false;
    }
    // 检查之前的行，当前位置往左上角45度斜线是否有Q
    for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
      if (chessboard[r][c] == 'Q') return false;
    }
    // 检查之前的行，当前位置往右上角45度斜线是否有Q
    for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
      if (chessboard[r][c] == 'Q') return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution51 solution = new Solution51();
    System.out.println(solution.solveNQueens(4));
    //    System.out.println(solution.solveNQueens(3));
    //    System.out.println(solution.solveNQueens(5));
  }
}

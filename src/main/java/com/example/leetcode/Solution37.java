package com.example.leetcode;

import java.util.Arrays;

// 39.解数独
// https://leetcode.cn/problems/sudoku-solver/
public class Solution37 {

  private static final int N = 9;

  public void solveSudoku(char[][] board) {
    backtrack(board);
  }

  private boolean backtrack(char[][] board) {
    for (int row = 0; row < N; row++) {
      for (int col = 0; col < N; col++) {
        if (board[row][col] != '.') continue;
        for (char val = '1'; val <= '9'; val++) {
          if (isValid(board, row, col, val)) {
            board[row][col] = val;
            if (backtrack(board)) {
              return true;
            }
            board[row][col] = '.';
          }
        }
        return false;
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int row, int col, char val) {
    for (int c = 0; c < N; c++) {
      if (board[row][c] == val) return false;
    }
    for (int r = 0; r < N; r++) {
      if (board[r][col] == val) return false;
    }
    int rs = row / 3 * 3;
    int cs = col / 3 * 3;
    for (int r = rs; r < rs + 3; r++) {
      for (int c = cs; c < cs + 3; c++) {
        if (board[r][c] == val) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution37 solution = new Solution37();
    char[][] board = {
      {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
      {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
      {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
      {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
      {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
      {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
      {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
      {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
      {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    solution.solveSudoku(board);
    System.out.println(Arrays.deepToString(board));
  }
}

package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 17.电话号码的字母组合
// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
public class Solution17 {

  private final Map<Character, String> map = new HashMap<>();

  {
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    char[] choices = new char[digits.length()];
    backtracking(digits, 0, result, choices);
    return result;
  }

  private void backtracking(String digits, int index, List<String> result, char[] choices) {
    if (digits.length() == index) {
      result.add(new String(choices));
      return;
    }
    String letters = map.get(digits.charAt(index));
    for (int i = 0; i < letters.length(); i++) {
      choices[index] = letters.charAt(i);
      backtracking(digits, index + 1, result, choices);
    }
  }

  public static void main(String[] args) {
    Solution17 solution = new Solution17();
    System.out.println(solution.letterCombinations("23"));
    System.out.println(solution.letterCombinations("2"));
    System.out.println(solution.letterCombinations("89"));
  }
}

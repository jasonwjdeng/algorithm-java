package com.example.algorithm;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Sort<T extends Comparable<T>> {

  public abstract void sort(T[] nums);

  protected boolean less(T v, T w) {
    return v.compareTo(w) < 0;
  }

  protected boolean larger(T v, T w) {
    return v.compareTo(w) > 0;
  }

  protected void swap(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  protected void printArray(T[] a) {
    System.out.println(Arrays.stream(a).map(Objects::toString).collect(Collectors.joining(" ")));
  }

  static Integer[] arrayAppend(Integer[] arr, int val) {
    Integer[] newArr = Arrays.copyOf(arr, arr.length + 1);
    newArr[newArr.length - 1] = val;
    return newArr;
  }
}

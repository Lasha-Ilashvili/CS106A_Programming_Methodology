package Exam;

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class addBigInteger extends ConsoleProgram {
  public static void main(String[] args) {
    new addBigInteger().start();
  }

  public void run() {
    int[] arr1 = { 9, 2, 3, 2, 7 };
    int[] arr2 = { 2, 4, 5, 2, 6, 2, 8, 2, 7, 8, 3, 7, 2, 6, 2, 6, 2, 0, 2, 7, 0 };
    println(Arrays.toString(addBigInt(arr1, arr2)));
  }

  private int[] addBigInt(int[] a, int[] b) {
    int bigSize = Math.max(a.length, b.length), remainder = 0;
    int[] temp = new int[bigSize + 1];
    for (int i = 1; i <= temp.length; i++) {
      int value = remainder;
      if (last(a, i) >= 0)
        value += a[last(a, i)];
      if (last(b, i) >= 0)
        value += b[last(b, i)];

      temp[last(temp, i)] = value % 10;
      remainder = value / 10;
    }
    int[] result = temp;
    if (temp[0] == 0) {
      result = new int[temp.length - 1];
      for (int i = 1; i <= result.length; i++) {
        result[i - 1] = temp[i];
      }
    }
    return result;
  }

  private int last(int[] arr, int i) {
    return arr.length - i;
  }
}

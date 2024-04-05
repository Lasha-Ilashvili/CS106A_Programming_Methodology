package Exam;

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class create extends ConsoleProgram {
  public static void main(String[] args) {
    new create().start();
  }

  public void run() {
    int[] arr = { 2, 3 };
    println(Arrays.toString(createArr(arr)[1]));
  }

  private int[][] createArr(int[] a) {
    int[][] arr = new int[a.length][]; // set up
    for (int i = 0; i < a.length; i++) {
      arr[i] = new int[a[i]];
    }
    return arr;
  }
}

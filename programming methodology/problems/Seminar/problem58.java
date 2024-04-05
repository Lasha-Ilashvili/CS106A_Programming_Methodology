package Seminar;

import acm.program.ConsoleProgram;

public class problem58 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem58().start();
  }

  public void run() {
    int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    println("magic matrix status: " + magicMatrix(arr));
  }

  /*
   * check points:
   * arr size==arr[i] size;
   * arr[i] should be sorted && 1<=i<=n^n;
   * instruction:
   * loop from 0 to n^n-1
   * sum++; so i=0, sum=1, arr[i]=sum!!
   * sum++; so i=1, sum=2, arr[i]=sum!!
   * ..
   * ...
   * ..
   * sum++; so i=15, sum=16, arr[i]=sum!!
   * break;
   * output - true/false;
   */
  private boolean magicMatrix(int[][] arr) {
    int sum = 0, n = arr.length, rows = 0;
    for (int i = 0; i < n * n; i++) {
      int j = sum % n; // iterates from 0 to n-1
      if (j == 0 && sum != 0) // to iterate through dimensions
        rows++;
      if (arr[rows][j] != ++sum || arr.length != arr[rows].length)
        return false;
    }
    return true;
  }
}

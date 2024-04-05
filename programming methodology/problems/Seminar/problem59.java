package Seminar;

import acm.program.ConsoleProgram;

public class problem59 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem59().start();
  }

  public void run() {
    int[][] matrix = {
        // { 1, 0, 1, 0, 0 },
        // { 1, 0, 1, 1, 1 },
        // { 1, 1, 1, 1, 1 },
        // { 1, 0, 0, 1, 0 }
        // { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
        // { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
        // { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
        // { 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
        // { 1, 1, 1, 0, 0, 1, 1, 0 },
        // { 0, 1, 1, 1, 1, 1, 0, 0 },
        // { 0, 0, 1, 1, 1, 1, 0, 0 },
        // { 0, 0, 1, 1, 1, 1, 0, 0 }
        // { 0, 1, 0, 0 },
        // { 0, 1, 1, 1 },
        // { 1, 1, 1, 0 }
    };
    largestRect(matrix);
  }

  private void largestRect(int[][] matrix) {
    int result = 0, row = 0;
    for (int i = 0; i < matrix.length; i++) {
      row++;
      int maxArea = maxHistogram(matrix, i, row);
      if (maxArea > result)
        result = maxArea;
    }
    println("Max rectangle size is: " + result);
  }

  private int maxHistogram(int[][] matrix, int i, int row) {
    int largest = 0, sum = 0;
    for (int val = 1; val <= row; val++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (val == 1) {
          if (matrix[i][j] == 1)
            matrix[0][j]++;
          else
            matrix[0][j] = 0;
        }

        int num = matrix[0][j];
        if (num >= val)
          sum++;
        else
          sum = 0;
        if (sum * val > largest)
          largest = sum * val;
      }
      sum = 0;
    }
    return largest;
  }
}

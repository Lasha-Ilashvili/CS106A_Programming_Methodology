package Seminar;

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class problem56 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem56().start();
  }

  public void run() {
    int n = readInt("Enter an index: ");
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = readInt("Enter num: ");
    }
    println(Arrays.toString(sort(input)));
  }

  private int[] sort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      for (int j = i + 1; j < input.length; j++) {
        if (input[i] > input[j]) {
          int temp = input[i];
          input[i] = input[j];
          input[j] = temp;
        }
      }
    }
    return input;
  }
}

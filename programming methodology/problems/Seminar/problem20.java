package Seminar;

import acm.program.ConsoleProgram;

public class problem20 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem20().start();
  }

  public void run() {
    int n = readInt("Enter index: ");
    printSum(n);
  }

  private void printSum(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      int input = readInt("Enter num: ");
      sum += input;
    }
    println(sum);
  }
}

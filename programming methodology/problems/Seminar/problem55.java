package Seminar;

import acm.program.ConsoleProgram;

public class problem55 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem55().start();
  }

  public void run() {
    int n = readInt("Enter an index: ");
    println("Sort status is " + isSorted(n));
  }

  private boolean isSorted(int n) {
    int max = 0, sorted = 1;
    for (int i = 0; i < n; i++) {
      int input = readInt("Enter num: ");
      if (input < max)
        sorted = 0;
      else
        max = input;
    }
    return sorted == 1;
  }
}

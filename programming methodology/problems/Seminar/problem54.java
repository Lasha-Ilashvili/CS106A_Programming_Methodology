package Seminar;

import acm.program.ConsoleProgram;

public class problem54 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem54().start();
  }

  public void run() {
    int n = readInt("Enter an index: ");
    for (int i = 0; i < n; i++) {
      int input = readInt("Enter num: ");
      findtwoMax(input, i);
    }
    println("Two max nums are: " + max1 + " and " + max2);
  }

  private void findtwoMax(int input, int i) {
    if (input > max1 || input > max2) {
      if (max1 > max2)
        max2 = input;
      else
        max1 = input;
    }
  }

  private int max1 = 0;
  private int max2 = 0;
}

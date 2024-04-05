package Seminar;

import acm.program.ConsoleProgram;

public class problem25 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem25().start();
  }

  public void run() {
    int a, b;
    a = readInt("Enter num: ");
    b = readInt("Enter num: ");
    println("lcm is " + checkLcm(a, b));
  }

  private int checkLcm(int a, int b) {
    int bigValue = Math.max(a, b);
    int smallValue = Math.min(a, b);
    for (int i = 1; i < smallValue; i++) {
      if ((i * bigValue) % smallValue == 0)
        return bigValue * i;
    }
    return smallValue * bigValue;
  }
}

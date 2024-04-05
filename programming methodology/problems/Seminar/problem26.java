package Seminar;

import acm.program.ConsoleProgram;

public class problem26 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem26().start();
  }

  public void run() {
    int a, b;
    a = readInt("Enter num: ");
    b = readInt("Enter num: ");
    println("Gcd is " + checkGcd(a, b));
  }

  private int checkGcd(int a, int b) {
    int max = 1;
    for (int i = 1; i <= a && i <= b; i++) {
      if (a % i == 0 && b % i == 0)
        max = i;
    }
    return max;
  }
}

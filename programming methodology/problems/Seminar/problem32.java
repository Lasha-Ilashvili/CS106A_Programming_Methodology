package Seminar;

import acm.program.ConsoleProgram;

public class problem32 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem32().start();
  }

  private static final int max = 1000000;

  public void run() {
    for (int i = 1; i < max; i++) {
      if (isPrime(i))
        println(i);
    }
  }

  private boolean isPrime(int n) {
    for (int j = 2; j < n; j++) {
      if (n % j == 0)
        return false;
    }
    return true;
  }
}

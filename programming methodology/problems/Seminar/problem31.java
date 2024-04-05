package Seminar;

import acm.program.ConsoleProgram;

public class problem31 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem31().start();
  }

  public void run() {
    int n = readInt("Enter num: ");
    println("prime status is " + checkPrime(n));
  }

  private boolean checkPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        println("devisible by " + i);
        return false;
      }
    }
    return true;
  }
}

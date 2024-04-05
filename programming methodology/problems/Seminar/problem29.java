package Seminar;

import acm.program.ConsoleProgram;

public class problem29 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem29().start();
  }

  public void run() {
    int n = readInt("Enter num: ");
    println("nth fibonacci number is " + fibonacci(n));
  }

  private int fibonacci(int n) {
    if (n < 2)
      return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}

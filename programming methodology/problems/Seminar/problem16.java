package Seminar;

import acm.program.ConsoleProgram;

public class problem16 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem16().start(args);
  }

  public void run() {
    int a, b, c;
    a = readInput();
    b = readInput();
    c = readInput();
    println(1 / (1.0 / a + 1.0 / c + 1.0 / b));
  }

  private int readInput() {
    int n = readInt("Enter num: ");
    return n;
  }
}

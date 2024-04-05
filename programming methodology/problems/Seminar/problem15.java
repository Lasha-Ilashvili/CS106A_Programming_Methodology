package Seminar;

import acm.program.ConsoleProgram;

public class problem15 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem15().start(args);
  }

  public void run() {
    int n1, n2;
    n1 = readInt("Enter first number: ");
    n2 = readInt("Enter second number: ");
    println((n1 + n2) / 2.0);
  }
}

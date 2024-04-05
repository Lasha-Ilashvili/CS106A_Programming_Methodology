package Seminar;

import acm.program.ConsoleProgram;

public class problem17 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem17().start(args);
  }

  public void run() {
    double real = readDouble("Enter num: ");
    int n = (int) real;
    println(real + " consists of " + n + " and " + (real - n));
  }
}
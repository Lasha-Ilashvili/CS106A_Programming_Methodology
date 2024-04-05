package Seminar;

import acm.program.ConsoleProgram;

public class problem19 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem19().start();
  }

  public void run() {
    int n = readInt("Enter index: ");
    printHello(n);
  }

  private void printHello(int n) {
    for (int i = 0; i < n; i++) {
      println("hello " + i);
    }
  }
}

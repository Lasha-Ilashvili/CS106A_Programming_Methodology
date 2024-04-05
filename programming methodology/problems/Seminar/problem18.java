package Seminar;

import acm.program.ConsoleProgram;

public class problem18 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem18().start();
  }

  public void run() {
    int max, b;
    max = readInt("Enter num: ");
    b = readInt("Enter num: ");
    if (max < b)
      max = b;
    println(max);
  }
}

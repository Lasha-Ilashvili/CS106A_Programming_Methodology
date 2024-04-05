package Seminar;

import acm.program.ConsoleProgram;

public class problem24 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem24().start();
  }

  public void run() {
    int n = readInt("Enter num: ");
    for (int i = 1; i <= n; i++) {
      if (n % i == 0)
        println(i);
    }
  }
}

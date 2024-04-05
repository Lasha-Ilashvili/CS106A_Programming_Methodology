package Seminar;

import acm.program.ConsoleProgram;

public class problem28 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem28().start();
  }

  public void run() {
    int sum = 0;
    while (true) {
      int n = readInt("Enter num: ");
      if (n % 2 == 0)
        sum++;
      if (n == -1)
        break;
    }
    println(sum);
  }
}

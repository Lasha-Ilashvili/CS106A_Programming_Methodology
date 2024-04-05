package Seminar;

import acm.program.ConsoleProgram;

public class problem23 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem23().start();
  }

  public void run() {
    int n = readInt("Enter num: "), sum = 0;
    for (int i = 1; i <= n; i++)
      sum += i;
    println(sum);
  }
}

package Seminar;

import acm.program.ConsoleProgram;

public class problem27 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem27().start();
  }

  public void run() {
    int n = read(), m = read();
    println(myPow(n, m));
  }

  private int myPow(int n, int m) {
    int result = n;
    for (int i = 1; i < m; i++) {
      result *= n;
    }
    return result;
  }

  private int read() {
    int n = readInt("Enter num: ");
    return n;
  }
}

package Seminar;

import acm.program.ConsoleProgram;

public class problem30 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem30().start();
  }

  public void run() {
    int n = readInt("Enter num: ");
    println("reverse: " + reverse(n));
  }

  private int reverse(int n) {
    if (n < 1)
      return ans;
    ans = ans * 10 + n % 10;
    reverse(n / 10);
    return ans;
  }

  int ans = 0;
}

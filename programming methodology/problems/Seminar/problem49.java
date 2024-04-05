package Seminar;

import acm.program.ConsoleProgram;

public class problem49 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem49().start();
  }

  public void run() {
    String numStr = "-23469";
    println(stringToInteger(numStr));
  }

  private int stringToInteger(String numStr) {
    int num = 0, sign = 1;
    for (int i = 0; i < numStr.length(); i++) {
      int temp = 0;
      if (Character.isDigit(numStr.charAt(i)))
        temp = numStr.charAt(i) - '0';
      else
        sign = -1;
      num = num * 10 + temp;
    }
    return num * sign;
  }
}

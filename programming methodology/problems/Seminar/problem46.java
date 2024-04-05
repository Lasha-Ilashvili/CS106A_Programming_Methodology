package Seminar;

import acm.program.ConsoleProgram;

public class problem46 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem46().start();
  }

  public void run() {
    String str = "Let Me Do It For Youuuuu";
    mostCommonChar(str);
  }

  private void mostCommonChar(String str) {
    int max = 0;
    char ans = ' ';
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      int sum = 0;
      for (int j = i; j < str.length(); j++) {
        if (ch == str.charAt(j))
          sum++;
        if (sum > max) {
          max = sum;
          ans = ch;
        }
      }
    }
    println("The most frequently used symbol is " + ans);
  }
}

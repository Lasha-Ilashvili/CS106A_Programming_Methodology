package Seminar;

import acm.program.ConsoleProgram;

public class problem48 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem48().start();
  }

  public void run() {
    String str = "please help meeee";
    checkAllChars(str);
  }

  private void checkAllChars(String str) {
    String used = "";
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (used.indexOf(ch) == -1) {
        println("Symbol - \"" + ch + "\" is used " + count(str, i) + " time(s).");
        used += ch;
      }
    }
  }

  private int count(String str, int i) {
    int sum = 0;
    for (int j = i; j < str.length(); j++) {
      if (str.charAt(i) == str.charAt(j))
        sum++;
    }
    return sum;
  }

}

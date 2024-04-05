package Exam;

import acm.program.ConsoleProgram;

public class upBlow extends ConsoleProgram {
  public static void main(String[] args) {
    new upBlow().start();
  }

  public void run() {
    String str = "12xafaf2has122f3";
    println(stringblow(str));
  }

  private String stringblow(String str) {
    String result = "";
    for (int i = 1; i < str.length(); i++) {
      char prev_Ch = str.charAt(i - 1);
      char ch = str.charAt(i);
      if (Character.isLetter(ch)) {
        result += ch;
        if (Character.isDigit(prev_Ch)) {
          for (int j = 0; j < prev_Ch - '0'; j++)
            result += ch;
        }
      }
    }
    return result;
  }
}

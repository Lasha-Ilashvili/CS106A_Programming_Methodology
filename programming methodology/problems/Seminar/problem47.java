package Seminar;

import acm.program.ConsoleProgram;

public class problem47 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem47().start();
  }

  public void run() {
    String str = "racecar";
    println("palindrome status: " + isPalindrom(str));
  }

  private boolean isPalindrom(String str) {
    String invert = "";
    for (int i = 0; i < str.length(); i++) {
      invert = str.charAt(i) + invert;
    }
    return str.equals(invert);
  }
}

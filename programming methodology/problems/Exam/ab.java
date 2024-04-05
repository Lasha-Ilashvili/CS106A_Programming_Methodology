package Exam;

import acm.program.ConsoleProgram;

public class ab extends ConsoleProgram {
  public static void main(String[] args) {
    new ab().start();
  }

  public void run() {
    String test = "aababbl";
    println(abCheck(test));
  }

  private boolean abCheck(String test) {
    return test.lastIndexOf('a') < test.indexOf('b');
  }
}

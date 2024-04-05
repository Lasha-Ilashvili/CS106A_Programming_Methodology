package Seminar;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class problem60 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem60().start();
  }

  public void run() {
    input = new ArrayList<>();
    readInput();
    reverse();
  }

  private void reverse() {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = input.size() - 1; i >= 0; i--) {
      result.add(input.get(i));
    }
    println(result);
  }

  private void readInput() {
    while (true) {
      int n = readInt("Enter num: ");
      if (n == -1)
        break;
      input.add(n);
    }
  }

  private ArrayList<Integer> input;
}

package Seminar;

import java.util.HashMap;

import acm.program.ConsoleProgram;

public class problem62 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem62().start();
  }

  public void run() {
    HashMap<String, Integer> names = new HashMap<>();
    println(countNames(names).toString());
  }

  private HashMap<String, Integer> countNames(HashMap<String, Integer> names) {
    while (true) {
      String name = readLine("Enter a name: ");
      if (name.equals(""))
        break;
      if (names.containsKey(name))
        names.put(name, names.get(name) + 1);
      else
        names.put(name, 1);
    }
    return names;
  }
}

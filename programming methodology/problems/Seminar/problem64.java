package Seminar;

import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class problem64 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem64().start();
  }

  public void run() {
    HashMap<String, ArrayList<String>> friends = new HashMap<>();
    countFriends(friends);
    printFriends(friends);
  }

  private void countFriends(HashMap<String, ArrayList<String>> friends) {
    while (true) {
      String input = readLine("Add a friend to a person (A-->b): ");
      if (input.equals(""))
        break;
      String[] split = input.split(" ");
      if (!friends.containsKey(split[1]))
        friends.put(split[1], new ArrayList<>());
      friends.get(split[1]).add(split[0]);
    }
  }

  private void printFriends(HashMap<String, ArrayList<String>> friends) {
    for (String person : friends.keySet()) {
      println(person + " " + friends.get(person));
    }
  }
}

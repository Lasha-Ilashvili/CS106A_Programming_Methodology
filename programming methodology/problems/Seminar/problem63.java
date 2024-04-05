package Seminar;

import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class problem63 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem63().start();
  }

  public void run() {
    HashMap<String, ArrayList<String>> friends = new HashMap<>();
    countFriends(friends);
    println(mostFriends(friends) + " has most friends.");
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

  private String mostFriends(HashMap<String, ArrayList<String>> friends) {
    int max = 0;
    String result = "";
    for (String person : friends.keySet()) {
      int size = friends.get(person).size();
      if (size > max) {
        max = size;
        result = person;
      }
    }
    return result;
  }
}

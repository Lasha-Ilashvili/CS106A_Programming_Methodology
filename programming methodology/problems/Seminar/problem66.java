package Seminar;

import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class problem66 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem66().start();
  }

  public void run() {
    HashMap<String, ArrayList<String>> friends = new HashMap<>();
    countFriends(friends);
    println(nonCommon(friends) + " have no common friends.");
  }

  private ArrayList<String> nonCommon(HashMap<String, ArrayList<String>> friends) {
    for (String person1 : friends.keySet()) {
      for (String person2 : friends.keySet()) {
        if (!person1.equals(person2)) {
          friends.get(person1).sort(null);
          friends.get(person2).sort(null);
          if (!friends.get(person1).equals(friends.get(person2))) {
            ArrayList<String> result = new ArrayList<>();
            result.add(person1);
            result.add(person2);
            return result;
          }
        }
      }
    }
    return null;
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
}

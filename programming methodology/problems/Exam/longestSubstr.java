package Exam;

import java.util.HashSet;

import acm.program.ConsoleProgram;

public class longestSubstr extends ConsoleProgram {
  public static void main(String[] args) {
    new longestSubstr().start();
  }

  public void run() {
    String str = "bbbbabebgb";
    substr(str);
  }

  private void substr(String str) {
    HashSet<Character> set = new HashSet<>();
    int maxLength = 0;
    for (int left = 0, right = 0; right < str.length(); right++) {

      if (!set.contains(str.charAt(right))) {
        set.add(str.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);

      } else {
        while (str.charAt(left) != str.charAt(right)) {
          set.remove(str.charAt(left));
          left++;
        }
        set.remove(str.charAt(left));
        left++;
        set.add(str.charAt(right));
      }
    }
    println(maxLength);
  }
}

package Seminar;

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class problem57 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem57().start();
  }

  public void run() {
    String str1 = "qatami";
    String str2 = "imatqa";
    println(isAnagram(str1, str2));
  }

  private boolean isAnagram(String str1, String str2) {
    int size = str1.length();
    if (size != str2.length())
      return false;

    char[] ch1 = new char[size], ch2 = new char[size];
    for (int i = 0; i < size; i++) {
      ch1[i] = str1.charAt(i);
      ch2[i] = str2.charAt(i);
    }
    Arrays.sort(ch1);
    Arrays.sort(ch2);
    return Arrays.toString(ch1).equals(Arrays.toString(ch2));
  }
}

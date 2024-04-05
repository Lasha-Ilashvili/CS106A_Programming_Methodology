package Exam;

public class checkStud {
  public static void main(String[] args) {
    String line = "student name: Joseph Stalin, course name: Marxism, mark: 51";
    String[] split = line.split(", ");
    split[0] = split[0].substring(split[0].indexOf(": ") + 2);
    split[2] = split[2].substring(split[2].indexOf(" ") + 1);
    System.out.println(split[0] + " " + split[2]);
  }
}

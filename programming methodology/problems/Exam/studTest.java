package Exam;

import java.util.Iterator;

import acm.program.ConsoleProgram;

public class studTest extends ConsoleProgram {
  public static void main(String[] args) {
    new studTest().start();
  }

  public void run() {
    StudRecords studs = new StudRecords("flname.txt");
    println(studs.getStudentAverage("Joseph Stalin"));
    Iterator<String> it = studs.getStudentsWithMark("Journalism", 45);
    while (it.hasNext())
      println(it.next());
    println(studs.getCoursesWithMark(88).toString());
  }
}

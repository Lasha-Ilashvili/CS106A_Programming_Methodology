package Seminar;

import java.util.Iterator;

import acm.program.ConsoleProgram;

public class problem71 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem71().start();
  }

  public void init() {
    school = new School();
  }

  public void run() {
    school.addTeacher("Tamila");
    school.addTeacher("Luka");
    school.addTeacher("VAXTANGI");
    //
    school.addSubject("Tamila", "Istoria");
    school.addSubject("Luka", "MATEMATIKA");
    school.addSubject("VAXTANGI", "FIZIKA");
    school.addSubject("VAXTANGI", "Qartuli");
    //
    school.addPupil("Givi", "MATEMATIKA");
    school.addPupil("Givi", "Istoria");
    school.addPupil("Givi", "Qartuli");
    school.addPupil("Lasha", "FIZIKA");
    school.addPupil("Merabi", "Istoria");
    //
    Iterator<String> it = school.getPupils("VAXTANGI");
    while (it.hasNext())
      println(it.next());
    //
    println("\n");
    //
    it = school.getTeachers("Givi");
    while (it.hasNext())
      println(it.next());
    //
    println("\n");
    //
  }

  School school;
}

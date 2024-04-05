package Exam;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

import acm.program.ConsoleProgram;
import acm.util.ErrorException;

public class prerequisite extends ConsoleProgram {
  public static void main(String[] args) {
    new prerequisite().start();
  }

  public void run() {
    println(courses("Unicourses.txt"));
  }

  private int courses(String fileName) {
    int minSemesters = 0;
    readFile(fileName);

    for (String subject : Subj_prerequisites.keySet()) {
      for (String prereq : Subj_prerequisites.get(subject)) {
        if (!Subj_prerequisites.containsKey(prereq)) {
          Subj_prerequisites.get(subject).remove(prereq);
          minSemesters++;
        }

      }

    }
    return minSemesters;
  }

  private void readFile(String fileName) {
    try {
      BufferedReader input = new BufferedReader(new FileReader(fileName));
      while (true) {
        String line = input.readLine();
        if (line == null)
          break;
        String[] split = line.split(":");

        if (!Subj_prerequisites.containsKey(split[1]))
          Subj_prerequisites.put(split[1], new HashSet<String>());
        Subj_prerequisites.get(split[1]).add(split[0]);
      }
      input.close();
    } catch (IOException xp) {
      throw new ErrorException(xp);
    }
  }

  private HashMap<String, HashSet<String>> Subj_prerequisites = new HashMap<>();
}

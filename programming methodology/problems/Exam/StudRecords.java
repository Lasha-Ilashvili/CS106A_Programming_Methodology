package Exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import acm.util.ErrorException;

public class StudRecords {
  public StudRecords(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      while (true) {
        String line = reader.readLine();
        if (line == null || line.equals(""))
          break;

        String[] split = line.split(", ");
        split[0] = manageSplit(split[0]);
        split[1] = manageSplit(split[1]);
        split[2] = manageSplit(split[2]);

        storeData(split[0], split[1], split[2]); // Stud courses
      }
      reader.close();
    } catch (IOException xp) {
      throw new ErrorException(xp);
    }
  }

  private void storeData(String stud, String course, String mark) {
    if (!studentCourse.containsKey(stud)) {
      studentCourse.put(stud, new HashMap<String, Integer>());
    }
    if (!studentCourse.get(stud).containsKey(course))
      studentCourse.get(stud).put(course, Integer.parseInt(mark));
  }

  private String manageSplit(String split) {
    return split = split.substring(split.indexOf(": ") + 2);
  }

  public int getStudentMarkInCourse(String stud, String course) {
    if (studentCourse.containsKey(stud) && studentCourse.get(stud).containsKey(course))
      return studentCourse.get(stud).get(course);
    return -1;
  }

  public double getStudentAverage(String stud) {
    int sum = 0, marks = 0;
    if (studentCourse.containsKey(stud)) {
      for (String course : studentCourse.get(stud).keySet()) {
        marks += studentCourse.get(stud).get(course);
        sum++;
      }
      return (double) marks / sum;
    }
    return 0;
  }

  public Iterator<String> getStudentsWithMark(String course, int mark) {
    ArrayList<String> students = new ArrayList<>();
    for (String student : studentCourse.keySet()) {
      if (studentCourse.get(student).containsKey(course) && studentCourse.get(student).get(course) == mark)
        students.add(student);
    }
    return students.iterator();
  }

  public Map<String, ArrayList<String>> getCoursesWithMark(int mark) {
    Map<String, ArrayList<String>> allCoursesWithMArk = new HashMap<>();
    for (String student : studentCourse.keySet()) {
      ArrayList<String> courses = getCourses(student, mark);
      if (!courses.isEmpty())
        allCoursesWithMArk.put(student, courses);
    }
    return allCoursesWithMArk;
  }

  private ArrayList<String> getCourses(String student, int mark) {
    ArrayList<String> courses = new ArrayList<>();
    for (String course : studentCourse.get(student).keySet()) {
      if (studentCourse.get(student).get(course) == mark)
        courses.add(course);
    }
    return courses;
  }

  private Map<String, HashMap<String, Integer>> studentCourse = new HashMap<>();
}

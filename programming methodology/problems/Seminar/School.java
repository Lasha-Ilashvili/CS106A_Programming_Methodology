package Seminar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class School {
  public School() {
    teacherSubjects = new HashMap<>();
    subjectTeachers = new HashMap<>();
    //
    subjectPupils = new HashMap<>();
    pupilSubjects = new HashMap<>();
  }

  public void addTeacher(String teacher) {
    if (!teacherSubjects.containsKey(teacher))
      teacherSubjects.put(teacher, new HashSet<String>());
  }

  public void addSubject(String teacher, String subject) {
    if (teacherSubjects.containsKey(teacher)) {
      if (!subjectTeachers.containsKey(subject))
        subjectTeachers.put(subject, new HashSet<String>());

      teacherSubjects.get(teacher).add(subject);
      subjectTeachers.get(subject).add(teacher);
    }
  }

  public void addPupil(String pupil, String subject) {
    if (!subjectPupils.containsKey(subject))
      subjectPupils.put(subject, new HashSet<String>());

    if (!pupilSubjects.containsKey(pupil))
      pupilSubjects.put(pupil, new HashSet<String>());

    subjectPupils.get(subject).add(pupil);
    pupilSubjects.get(pupil).add(subject);
  }

  public Iterator<String> getTeachers(String pupil) {
    if (!pupilSubjects.containsKey(pupil))
      return null;
    HashSet<String> teachers = new HashSet<>();
    for (String subject : pupilSubjects.get(pupil)) {
      for (String teacher : subjectTeachers.get(subject)) {
        teachers.add(teacher);
      }
    }
    return teachers.iterator();
  }

  public Iterator<String> getPupils(String teacher) {
    if (!teacherSubjects.containsKey(teacher))
      return null;
    HashSet<String> pupils = new HashSet<>();
    for (String subject : teacherSubjects.get(teacher)) {
      if (subjectPupils.containsKey(subject)) {
        for (String pupil : subjectPupils.get(subject)) {
          pupils.add(pupil);
        }
      }
    }
    return pupils.iterator();
  }

  public void removeTeacher(String teacher) {
    for (String subject : teacherSubjects.get(teacher))
      subjectTeachers.remove(subject, teacher);
    teacherSubjects.remove(teacher);
  }

  private HashMap<String, HashSet<String>> teacherSubjects;
  private HashMap<String, HashSet<String>> subjectTeachers;
  private HashMap<String, HashSet<String>> subjectPupils;
  private HashMap<String, HashSet<String>> pupilSubjects;
}

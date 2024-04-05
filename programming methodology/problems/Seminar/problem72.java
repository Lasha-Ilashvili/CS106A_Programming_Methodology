package Seminar;

import javax.swing.*;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class problem72 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem72().start();
  }

  public void init() {
    add(new JLabel("Teach:"), NORTH);
    add(teach, NORTH);
    //
    add(new JLabel("Subj:"), NORTH);
    add(subj, NORTH);
    //
    add(new JLabel("Pupil:"), NORTH);
    add(pupil, NORTH);
    //
    add(new JButton("Add Teach"), SOUTH);
    add(new JLabel("    "), SOUTH);
    add(new JButton("Add Subj"), SOUTH);
    add(new JLabel("    "), SOUTH);
    add(new JButton("Add Pupil"), SOUTH);
    add(new JLabel("    "), SOUTH);
    add(new JButton("Display Pupils"), SOUTH);
    add(new JLabel("    "), SOUTH);
    add(new JButton("Display Teachers"), SOUTH);
    add(new JLabel("    "), SOUTH);
    //
    addActionListeners();
  }

  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    String teachName = teach.getText();
    String subjName = subj.getText();
    String pupilName = pupil.getText();
    switch (cmd) {
      case "Add Teach":
        if (!teachName.equals(""))
          school.addTeacher(teachName);
        break;
      case "Add Subj":
        if (!teachName.equals("") && !subjName.equals(""))
          school.addSubject(teachName, subjName);
        break;
      case "Add Pupil":
        if (!subjName.equals("") && !pupilName.equals(""))
          school.addPupil(pupilName, subjName);
        break;
      case "Display Pupils":
        if (!teachName.equals(""))
          display(school.getPupils(teachName));
        clear(teach);
        break;
      case "Display Teachers":
        if (!pupilName.equals(""))
          display(school.getTeachers(pupilName));
        clear(pupil);
        break;
    }
  }

  private void display(Iterator<String> it) {
    removeAll();
    int sum = 1;
    while (it.hasNext()) {
      GLabel name = new GLabel(it.next());
      add(name, 0, name.getHeight() * sum);
      sum++;
    }
  }

  private void clear(JTextField text) {
    text.setText("");
  }

  private School school = new School();
  private JTextField teach = new JTextField(10);
  private JTextField subj = new JTextField(10);
  private JTextField pupil = new JTextField(10);
}

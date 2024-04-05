package Seminar;

import java.awt.event.*;
import javax.swing.*;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import acm.util.ErrorException;

public class problem67 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem67().start();
  }

  public void run() {
    add(new JLabel("Add Image"), NORTH);
    add(imageName, NORTH);

    imageName.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    addImage(imageName.getText());
  }

  private void addImage(String text) {
    try {
      GImage image = new GImage(text);
      removeAll();
      add(image, (getWidth() - image.getWidth()) / 2, (getHeight() -
          image.getHeight()) / 2);
    } catch (ErrorException ex) {
      throw new ErrorException(ex);
    }
  }

  private JTextField imageName = new JTextField(10);
}

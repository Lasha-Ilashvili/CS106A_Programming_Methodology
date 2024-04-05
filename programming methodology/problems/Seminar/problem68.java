package Seminar;

import java.awt.event.*;
import javax.swing.*;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class problem68 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem68().start();
  }

  public void run() {
    add(new JLabel("Send"), SOUTH);
    add(chat, SOUTH);
    add(new JButton("Enter"), SOUTH);
    //
    chat.addActionListener(this);
    addActionListeners();
  }

  public void actionPerformed(ActionEvent e) {
    updateChat(chat.getText());
    chat.setText("");
  }

  private void updateChat(String text) {
    if (!text.equals("")) {
      GLabel message = new GLabel(text);
      add(message, 2, indentation * message.getHeight());
      indentation++;
    }
  }

  private JTextField chat = new JTextField(20);
  private int indentation = 1;
}

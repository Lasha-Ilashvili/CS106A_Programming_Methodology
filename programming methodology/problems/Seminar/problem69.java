package Seminar;

import java.awt.event.*;
import javax.swing.*;

import acm.program.Program;

public class problem69 extends Program {
  public static void main(String[] args) {
    new problem69().start();
  }

  public void run() {
    textArea = new JTextArea();
    textArea.setEditable(false);
    //
    add(textArea);
    add(new JScrollPane(textArea));
    //
    add(new JLabel("Send"), SOUTH);
    add(chat, SOUTH);
    add(new JButton("Enter"), SOUTH);
    //
    chat.addActionListener(this);
    addActionListeners();
  }

  public void actionPerformed(ActionEvent e) {
    String text = chat.getText();
    if (!text.equals(""))
      textArea.append(text + "\n");
    chat.setText("");
  }

  private JTextField chat = new JTextField(20);
  private JTextArea textArea;

}

package Exam;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

public class Nim extends GraphicsProgram {
  public static void main(String[] args) {
    new Nim().start();
  }

  private static final int NUM = 11;
  private static final int INDENT = 20;
  private static final int SPACE = 15;

  public void run() {
    drawCircles();
    addMouseListeners();
  }

  public void mouseClicked(MouseEvent e) {
    GOval oval = (GOval) getElementAt(e.getX(), e.getY());
    if (oval != null) {
      int index = ovals.indexOf(oval);
      if (index > ovals.size() - 4) {
        int size = ovals.size();
        for (int i = index; i < size; i++) {
          remove(ovals.get(index));
          ovals.remove(index);
        }
        if (ovals.isEmpty()) {
          String player = "";
          if (firstPlayer)
            player = "1";
          else
            player = "2";
          GLabel winLabel = new GLabel("Player " + player + " wins!");
          add(winLabel, 50, 50);
        }
        if (firstPlayer)
          firstPlayer = false;
        else
          firstPlayer = true;
      }
    }
  }

  private void drawCircles() {
    double size = (getWidth() - 2 * INDENT - SPACE * (NUM + 1)) / NUM;
    for (int i = 0; i < NUM; i++) {
      double x = SPACE + (size + SPACE) * i;
      GOval oval = new GOval(size, size);
      oval.setFillColor(Color.GRAY);
      oval.setFilled(true);
      add(oval, x + INDENT, (getHeight() - size) / 2);
      ovals.add(oval);
    }
  }

  private ArrayList<GOval> ovals = new ArrayList<>();
  private boolean firstPlayer = true;
}

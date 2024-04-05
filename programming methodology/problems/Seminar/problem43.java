package Seminar;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

public class problem43 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem43().start();
  }

  private GOval oval;

  public void run() {
    oval = new GOval(50, 50);
    add(oval, getWidth() / 2 - 25, getHeight() / 2 - 25);
    addMouseListeners();
  }

  public void mouseDragged(MouseEvent e) {
    if (getElementAt(e.getX(), e.getY()) == oval)
      oval.setLocation(e.getX() - 25, e.getY() - 25);
  }
}

package Seminar;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

public class problem41 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem41().start();
  }

  public void run() {
    addMouseListeners();
  }

  public void mouseMoved(MouseEvent e) {
    int radius = 10;
    GOval oval = new GOval(radius, radius);
    oval.setFilled(true);
    add(oval, e.getX() - radius / 2, e.getY() - radius / 2);
  }
}

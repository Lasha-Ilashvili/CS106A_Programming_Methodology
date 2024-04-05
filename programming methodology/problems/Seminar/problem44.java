package Seminar;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

public class problem44 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem44().start();
  }

  private GOval oval;

  public void run() {
    addMouseListeners();
    oval = new GOval(50, 50);
    while (true) {
      oval.move(0, 5);
      pause(10);
      if (oval.getY() > getHeight())
        remove(oval);
    }

  }

  public void mouseClicked(MouseEvent e) {
    add(oval, e.getX() - 25, e.getY() - 25);
  }
}

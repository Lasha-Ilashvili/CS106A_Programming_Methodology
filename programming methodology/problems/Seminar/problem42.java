package Seminar;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

public class problem42 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem42().start();
  }

  private GLine line;
  private boolean clicked = false;

  public void run() {
    addMouseListeners();
  }

  public void mouseClicked(MouseEvent e) {
    if (!clicked) {
      line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
      add(line);
      clicked = true;
    } else
      clicked = false;
  }

  public void mouseMoved(MouseEvent e) {
    if (clicked)
      line.setEndPoint(e.getX(), e.getY());
  }
}

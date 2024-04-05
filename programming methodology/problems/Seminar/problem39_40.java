package Seminar;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class problem39_40 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem39_40().start();
  }

  public void run() {
    int radius = 20;
    int y = (getHeight() - radius) / 2;
    GOval oval = new GOval(radius, radius);
    add(oval, 0, y);
    int vx = 5;
    while (true) {
      oval.move(vx, 0);
      pause(10);
      if (oval.getX() + radius > getWidth() || oval.getX() < 0)
        vx = -vx;
    }
  }
}

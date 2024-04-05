package Seminar;

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class problem34 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem34().start();
  }

  public void run() {
    for (int i = 0; i < 1000; i++) {
      int radius = rgen.nextInt(300);
      int coordinateX = rgen.nextInt(getWidth() - radius);
      int coordinateY = rgen.nextInt(getHeight() - radius);
      Color color = rgen.nextColor();
      GOval oval = new GOval(radius, radius);
      oval.setColor(color);
      oval.setFilled(true);
      add(oval, coordinateX, coordinateY);
    }
  }

  private RandomGenerator rgen = RandomGenerator.getInstance();
}

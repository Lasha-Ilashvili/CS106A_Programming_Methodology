package Seminar;

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class problem33 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem33().start();
  }

  public void run() {
    double radius = rgen.nextDouble(5, 40);
    Color color = rgen.nextColor();
    GOval oval = new GOval(radius, radius);
    oval.setColor(color);
    oval.setFilled(true);
    add(oval, getWidth() / 2, getHeight() / 2);
  }

  private RandomGenerator rgen = RandomGenerator.getInstance();
}

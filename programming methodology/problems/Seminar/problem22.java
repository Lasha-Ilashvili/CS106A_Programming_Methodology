package Seminar;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class problem22 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem22().start();
  }

  private static final double grid = 8.0;

  public void run() {
    double cubeWidth = getWidth() / grid;
    double cubeHeight = getHeight() / grid;

    for (int i = 0; i < grid; i++) {
      for (int j = 0; j < grid; j++) {
        GRect rect = new GRect(cubeWidth, cubeHeight);
        rect.setFilled((i + j) % 2 != 0);
        add(rect, i * cubeWidth, j * cubeHeight);
      }
    }
  }
}

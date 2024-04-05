package Seminar;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class problem21 extends GraphicsProgram {
  public static void main(String[] args) {
    new problem21().start();
  }

  private static final int Nline = 10;

  public void run() {
    double rowSpace = getHeight() / Nline;
    double columnSpace = getWidth() / Nline;
    for (int i = 0; i < Nline - 1; i++) {
      GLine row = new GLine(0, rowSpace * (i + 1), getWidth(), rowSpace * (i + 1));
      GLine column = new GLine(columnSpace * (i + 1), 0, columnSpace * (i + 1), getHeight());
      add(row);
      add(column);
    }
  }
}

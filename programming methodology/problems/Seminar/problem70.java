package Seminar;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class problem70 extends GraphicsProgram implements ComponentListener {
  public static void main(String[] args) {
    new problem70().start();
  }

  private static final int LINE_NUM = 10;

  public void init() {
    addComponentListener(this);
  }

  public void run() {
    drawLines();
  }

  private void drawLines() {
    double COLUMN = getWidth() / LINE_NUM;
    double ROW = getHeight() / LINE_NUM;
    for (int i = 0; i < LINE_NUM - 1; i++) {
      GLine line_row = new GLine(0, ROW * (i + 1), getWidth(), ROW * (i + 1));
      GLine line_column = new GLine(COLUMN * (i + 1), 0, COLUMN * (i + 1), getHeight());
      add(line_row);
      add(line_column);
    }
  }

  @Override
  public void componentResized(ComponentEvent e) {
    removeAll();
    drawLines();
  }

  @Override
  public void componentMoved(ComponentEvent e) {

  }

  @Override
  public void componentShown(ComponentEvent e) {

  }

  @Override
  public void componentHidden(ComponentEvent e) {

  }
}
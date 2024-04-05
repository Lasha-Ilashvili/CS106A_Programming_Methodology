package Exam;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JTextField;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.event.MouseEvent;

public class rock extends GraphicsProgram implements ComponentListener {
  public static void main(String[] args) {
    new rock().start();
  }

  private static final int grid = 8;

  public void init() {
    direction = new JTextField(10);
    add(direction, SOUTH);
    addActionListeners(this);
    addComponentListener(this);
  }

  public void run() {
    draw();
  }

  private void draw() {
    drawGrid();
    drawRock();
    addMouseListeners();
  }

  public void mouseClicked(MouseEvent e) {
    comp.setLocation(current.getX(), current.getY());
  }

  private void drawGrid() {
    cubeWidth = getWidth() / (double) grid;
    cubeHeight = getHeight() / (double) grid;
    for (int i = 0; i < grid; i++) {
      for (int j = 0; j < grid; j++) {
        GRect rect = new GRect(cubeWidth, cubeHeight);
        add(rect, i * cubeWidth, j * cubeHeight);
        rects[j][i] = rect;
      }
    }
  }

  private void drawRock() {
    GOval oval = new GOval(cubeWidth, cubeHeight);
    oval.setColor(Color.RED);
    oval.setFilled(true);
    double rectWidth = oval.getWidth() * 0.7;
    double rectHeight = oval.getHeight() * 0.7;
    GRect rect = new GRect(rectWidth, rectHeight);
    rect.setColor(Color.GREEN);
    rect.setFilled(true);
    current = rects[4][4];
    // add(oval, current.getX(), current.getY());
    // add(rect, oval.getX() + (oval.getWidth() - rectWidth) / 2, oval.getY() +
    // (oval.getHeight() - rectHeight) / 2);
    comp.add(oval);
    comp.add(rect, oval.getX() + (oval.getWidth() - rectWidth) / 2, oval.getY() + (oval.getHeight() - rectHeight) / 2);
    add(comp, current.getX(), current.getY());
  }

  public void componentResized(ComponentEvent e) {
    removeAll();
    draw();
  }

  public void componentMoved(ComponentEvent e) {
  }

  public void componentShown(ComponentEvent e) {
  }

  public void componentHidden(ComponentEvent e) {
  }

  private JTextField direction;
  private double cubeWidth;
  private double cubeHeight;
  private GRect[][] rects = new GRect[8][8];
  private GRect current;
  GCompound comp = new GCompound();
}

/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class ProgramHierarchy extends GraphicsProgram {

	// width of every box in this program
	private static final int rectW = 180;

	// height of every box in this program
	private static final int rectH = 60;

	public void run() {
		programHierarchyProgram();
	}

	private void programHierarchyProgram() {
		allLines();
		program();
		consoleProgram();
		dialogProgram();
		graphicsProgram();
	}

	private void allLines() {
		consoleLine();
		dialogLine();
		graphicsLine();
	}

	private void consoleLine() {
		double x = getWidth() / 2;
		double y1 = getHeight() / 2 - 40;
		double y2 = getHeight() / 2 + 40;
		GLine consoleLine = new GLine(x, y1, x, y2);
		add(consoleLine);
	}

	private void dialogLine() {
		double x = getWidth() / 2;
		double y1 = getHeight() / 2 - 40;
		double x2 = x + 1.5 * rectW;
		double y2 = getHeight() / 2 + 40;
		GLine dialogLine = new GLine(x, y1, x2, y2);
		add(dialogLine);
	}

	private void graphicsLine() {
		double x = getWidth() / 2;
		double y1 = getHeight() / 2 - 40;
		double x2 = x - 1.5 * rectW;
		double y2 = getHeight() / 2 + 40;
		GLine graphicsLine = new GLine(x, y1, x2, y2);
		add(graphicsLine);
	}

	private void program() {
		programRect();
	}

	private void programRect() {
		double x = getWidth() / 2 - rectW / 2;
		double line = getHeight() / 2 - 40;
		GRect programRect = new GRect(rectW, rectH);
		add(programRect, x, line - rectH);

		GLabel programLabel = new GLabel("Program");
		programLabel.setFont("-15");
		add(programLabel, getWidth() / 2 - programLabel.getWidth() / 2, getHeight() / 2 - 80
				+ programLabel.getHeight() / 2 - programLabel.getDescent() + programLabel.getAscent());
	}

	private void consoleProgram() {
		consoleRect();
	}

	private void consoleRect() {
		double x = getWidth() / 2 - rectW / 2;
		double line = getHeight() / 2 + 40;
		GRect consoleRect = new GRect(rectW, rectH);
		add(consoleRect, x, line);

		GLabel consoleLable = new GLabel("ConsoleProgram");
		consoleLable.setFont("-15");
		add(consoleLable, getWidth() / 2 - consoleLable.getWidth() / 2, getHeight() / 2 + 60
				+ consoleLable.getHeight() / 2 - consoleLable.getDescent() + consoleLable.getAscent());
	}

	private void dialogProgram() {
		dialogRect();
	}

	private void dialogRect() {
		double x = getWidth() / 2 + rectW;
		double line = getHeight() / 2 + 40;
		GRect dialogRect = new GRect(rectW, rectH);
		add(dialogRect, x, line);

		GLabel dialogLable = new GLabel("DialogProgram");
		dialogLable.setFont("-15");
		add(dialogLable, (x + rectW / 2) - dialogLable.getWidth() / 2, getHeight() / 2 + 60
				+ dialogLable.getHeight() / 2 - dialogLable.getDescent() + dialogLable.getAscent());
	}

	private void graphicsProgram() {
		graphicsRect();
	}

	private void graphicsRect() {
		double x = getWidth() / 2 - 2 * rectW;
		double line = getHeight() / 2 + 40;
		GRect graphicsRect = new GRect(rectW, rectH);
		add(graphicsRect, x, line);

		GLabel graphicsLabel = new GLabel("GraphicsProgram");
		graphicsLabel.setFont("-15");
		add(graphicsLabel, (x + rectW / 2) - graphicsLabel.getWidth() / 2, getHeight() / 2 + 60
				+ graphicsLabel.getHeight() / 2 - graphicsLabel.getDescent() + graphicsLabel.getAscent());
	}
}

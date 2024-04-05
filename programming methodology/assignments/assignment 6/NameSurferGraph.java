/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;

public class NameSurferGraph extends GCanvas implements NameSurferConstants, ComponentListener {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {
		addComponentListener(this);
		// You fill in the rest //
	}

	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		names.clear(); // clears stored names
		update();
	}

	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		names.add(entry);
	}

	/**
	 * Updates the display image by deleting all the graphical objects
	 * from the canvas and then reassembling the display according to
	 * the list of entries. Your application must call update after
	 * calling either clear or addEntry; update is also called whenever
	 * the size of the canvas changes.
	 */
	public void update() {
		removeAll(); // cleans up a canvas
		graphSetUp();
		makeGraph();
	}

	private void graphSetUp() {
		lines();
		labels();
	}

	private void lines() {
		horizontal();
		vertical();
	}

	/*
	 * Precondition: canvas is blank
	 * Postcondition: There are two upper and lower lines drown on the canvas
	 */
	private void horizontal() {
		GLine upperLine = new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE);
		add(upperLine);
		int bottomY = getHeight() - GRAPH_MARGIN_SIZE;
		GLine bottomLine = new GLine(0, bottomY, getWidth(), bottomY);
		add(bottomLine);
	}

	/*
	 * Precondition: There are two upper and lower lines drown on the canvas
	 * Postcondition: 10 vertical lines are added, thus creating 11 window for the decades 
	 */
	private void vertical() {
		space = getWidth() / NDECADES;
		for (int i = 0; i < NDECADES - 1; i++) {
			GLine vertLine = new GLine((i + 1) * space, 0, (i + 1) * space, getHeight());
			add(vertLine);
		}
	}

	private void labels() {
		for (int i = 0; i < NDECADES; i++) {
			String value = "" + (START_DECADE + (10 * i));
			GLabel label = new GLabel(value);
			// label is spaced and a bit offset from the lines
			add(label, (space * i) + label.getWidth() / 8, getHeight() - label.getDescent());
		}

	}

	private void makeGraph() {
		for (int i = 0; i < names.size(); i++) {
			dataLines(names.get(i), i);
		}

	}

	private void dataLines(NameSurferEntry name, int i) {
		for (int j = 0; j < NDECADES - 1; j++) {
			int lineYo = GRAPH_MARGIN_SIZE + name.getRank(j) * getHeight() / MAX_RANK;
			int lineY1 = GRAPH_MARGIN_SIZE + name.getRank(j + 1) * getHeight() / MAX_RANK;
			GLine line = new GLine(space * j, lineYo, (j + 1) * space, lineY1);
			lineColoring(i, line);
			add(line);
		}
	}

	private void lineColoring(int i, GLine line) {
		switch (i % 4) {
		case 0:
			line.setColor(Color.BLACK);
			break;
		case 1:
			line.setColor(Color.RED);
			break;
		case 2:
			line.setColor(Color.BLUE);
			break;
		case 3:
			line.setColor(Color.YELLOW);
			break;
		}

	}

	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) {
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentResized(ComponentEvent e) {
		update();
	}

	public void componentShown(ComponentEvent e) {
	}

	// private instance variables
	private double space;
	private ArrayList<NameSurferEntry> names = new ArrayList<NameSurferEntry>();
}

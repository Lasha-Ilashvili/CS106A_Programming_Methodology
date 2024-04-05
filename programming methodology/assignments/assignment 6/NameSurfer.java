/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.program.Program;

public class NameSurfer extends Program implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the bottom of the window.
	 */
	public void init() {
		graph = new NameSurferGraph();
		add(graph); // adding canvas

		// declaring interactors
		name = new JTextField(20); // sets a size of the text field

		// adding interactors
		add(new JLabel("Name"), SOUTH); // adds label
		add(name, SOUTH); // adds text field
		// adds buttons
		add(new JButton("Graph"), SOUTH);
		add(new JButton("Clear"), SOUTH);

		// sets up listeners
		addActionListeners();
		name.addActionListener(this);
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		NameSurferDataBase dt = new NameSurferDataBase(NAMES_DATA_FILE);
		NameSurferEntry ent = dt.findEntry(name.getText());
		String cmd = e.getActionCommand();
		if (cmd.equals("Graph") || e.getSource() == name) { // if either button clicked or enter typed
			println(dt.findEntry(name.getText()));
			graph.addEntry(ent);
			graph.update();
		} else if (cmd.equals("Clear")) {
			println("Clear");
			graph.clear();
			graph.update();
		}
	}

	// Private instance variables
	private JTextField name;
	private NameSurferGraph graph;
}

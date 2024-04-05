/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/*
 * This program draws a pyramid, every constant is editable 
 * While not disturbing given construction
 */

public class Pyramid extends GraphicsProgram {

	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;

	public void run() {
		// pyramid(); // main method
		addMouseListeners();
	}

	public void mouseDragged(MouseEvent e) {

		for (int bricks_In_Column = BRICKS_IN_BASE; bricks_In_Column > 0; bricks_In_Column--) {// column for loop

			// bricks_In_Column starts with a value of 14, nBricks is used to leave less
			// bricks in a row on every upper column
			int nBricks = BRICKS_IN_BASE - bricks_In_Column;

			for (int bricks_In_Row = 0; bricks_In_Row <= 14; bricks_In_Row++) { // row for loop

				int x = BRICK_WIDTH * nBricks; // after we assigned nBricks variable, we use it for our needs

				int y = BRICK_HEIGHT * bricks_In_Column; // every column is taller than previous one by one brick height

				// brick height isn't changed, but bricks in rows change from 14 to 1.
				// because two for loops work differently we subtracted them and
				// added 1 final brick
				GRect pyramid = new GRect(BRICK_WIDTH * (bricks_In_Row - bricks_In_Column + 1), BRICK_HEIGHT);
				add(pyramid, (getWidth() - x) / 2, getHeight() - y); // adding pyramid to its coordinates on canvas
			}
		}

	}
}
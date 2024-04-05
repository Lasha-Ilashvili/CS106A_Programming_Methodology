/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.SuperKarel;

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			makeColumn();
			moveToNextTower();
		}
		makeColumn(); // prevents off-by-one error
	}

	private void makeColumn() {
		// this function has karel build vertical row of beepers
		turnLeft();
		distributeBeepers();
		turnLeft();
	}

	/*
	 * precondition: karel is facing north
	 * postcondition: karel has returned to the same spot,
	 * row of beepers is built, facing south
	 */
	private void distributeBeepers() {
		moveToTheWall();
		turnAround();
		moveToTheWall();
	}

	private void moveToTheWall() {
		// moves all way to the wall, puts beepers if needed
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
	}

	private void moveToNextTower() {
		// repeated amount of moves for proper indentation between towers
		if (frontIsClear()) {
			for (int i = 0; i < 4; i++) {
				move();
			}
		}
	}
}

/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.SuperKarel;

public class MidpointFindingKarel extends SuperKarel {
	public void run() {
		makeCheckers();
		gatherAllBeepers();
		findMidpoint();
		turnLeft();
		// method for 1x1 world
		if (leftIsBlocked()) {
			putBeeper();
		}
	}

	/*
	 * turned out that checkered pattern 
	 * is useful for finding a mid point.
	 * 
	 * preconditions: karel is standing in 1x1 block facing east
	 * postcondition: front is blocked, karel has placed
	 * beepers on every even block
	 */
	private void makeCheckers() {
		smartMove();
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}

	/*
	 * preconditions: karel just placed checkers and now is facing east
	 * postcoinditions: karel gathered all beeepers and is standing
	 * towards the western wall
	 */
	private void gatherAllBeepers() {
		turnAround();
		smartMove();
		while (frontIsClear()) {
			// karel will move until beeper is in the way
			collectOneBeeper();
		}
		goBack();
	}

	private void collectOneBeeper() {
		// picks one beeper at a time and puts it in the eastern corner
		if (beepersPresent()) {
			pickBeeper();
			goBack();
			putBeeper();
		}
		move();
	}

	private void findMidpoint() {
		while (frontIsClear()) {
			// picks additional beeper, essential for the method to work
			if (beepersPresent()) {
				pickBeeper();
			}
			makePathToTheCenter();
			/* this "move" line combined with
			 * "pickBeeper" is very important.
			 * in the end it helps karel collect remained
			 * path of beepers and successfully find a midpoint
			 */
			move();
			stay();
		}
	}

	private void makePathToTheCenter() {
		while (beepersPresent()) {
			pickBeeper();
			moveToMidpoint();
			putBeeper();
			goBack();
		}
	}

	// this method stops infinite loop and makes karel stay still
	private void stay() {
		if (noBeepersPresent()) {
			putBeeper();
			turnLeft();// loop break is possible by blocking the front
		}
	}

	/*
	 * turns around and moves to the eastern wall 
	 * where all beepers are gathered
	 */
	private void goBack() {
		turnAround();
		moveToTheWall();
		turnAround();
	}

	private void moveToTheWall() {
		while (frontIsClear()) {
			move();
		}
	}

	private void moveToMidpoint() {
		move();
		while (beepersPresent()) {
			move();
		}
	}

	private void smartMove() {
		if (frontIsClear()) {
			move();
		}
	}
}
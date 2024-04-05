/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.SuperKarel;

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			makeCheckers();
			avoidCrash();
		}
		/*
		 * specially made method for vertical world
		 * also works on 1x1
		 */
		if (notFacingNorth()) {
			verticalWorld();
		}
	}

	/*
	 * karel places beepers in a way that creates checkered pattern
	 * stops when front is blocked
	 */
	private void makeCheckers() {
		while (frontIsClear()) {
			smartBeeper();
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
		}
	}

	/*
	 * preconditions: karel faces wall and front is blocked
	 * postconditions: karel successfully overcame the wall
	 * and now can freely continue putting beepers
	 */
	private void avoidCrash() {
		faceNorth();
		if (frontIsClear()) {
			// this part considers both odd and even worlds

			if (noBeepersPresent()) {
				orientation();
			} else {
				orientation();
				move();
			}
		}
	}

	private void faceNorth() {
		while (notFacingNorth()) {
			turnLeft();
		}
	}

	/*
	 * this is a generalized method for orientation
	 * for either western and eastern walls
	 */
	private void orientation() {
		move();
		if (rightIsBlocked()) {
			turnLeft();
		} else if (leftIsBlocked()) {
			turnRight();
		}
	}

	private void verticalWorld() {
		faceNorth();
		if (frontIsClear()) {
			makeCheckers();
		} else {
			smartBeeper(); // "else" clause is made for 1x1 world
		}
	}

	private void smartBeeper() {
		// karel puts beeper only when needed

		if (noBeepersPresent()) {
			putBeeper();
		}
	}
}

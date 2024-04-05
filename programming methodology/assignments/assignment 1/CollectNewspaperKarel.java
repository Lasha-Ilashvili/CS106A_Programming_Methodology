/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.SuperKarel;

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		collectNewspaper();
		goBack();
	}

	private void collectNewspaper() {
		// This function has Karel find beeper and pick it
		moveToTheWall();
		findBeeper();
		pickBeeper();
	}

	/*
	 * precondition: karel is either standing 
	 * in the upper left corner facing east
	 * or already has picked beeper and stands towards the west
	 * postcondition: karel just moved all way to the wall
	 * and furthermore adjusted itself for the upcoming moves  
	 */
	private void moveToTheWall() {
		while (frontIsClear()) {
			move();
		}
		/*this part is a necessary adjustment 
		that prepares karel for the next steps
		*/
		turnRight();
		move();
	}

	private void findBeeper() {
		turnLeft();
		move();
	}

	private void goBack() {
		// returns to the beginning corner
		turnAround();
		moveToTheWall();
		turnRight();
	}
}
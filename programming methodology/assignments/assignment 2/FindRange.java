/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.ConsoleProgram;

/*
 * This program finds the largest and the smallest numbers
 * out of user's input.
 */

public class FindRange extends ConsoleProgram {
	private static final int SENTINEL = 0; // constant value

	public void run() {
		println("This program finds the largest and smallest numbers."); // heading of a program
		int smallestNum = 0; // assigning starting
		int largestNum = 0; // values to integers
		// loop for finding smallest and largest numbers

		while (true) {
			int n = readInt(" ? ");
			if (n == SENTINEL) {
				break; // using 0 to end user's input
			}
			/*
			 *  assigning n to our integers
			 *  couldn't done this operation earlier
			 *  because of the life span of variables
			 */
			if (smallestNum == SENTINEL && largestNum == SENTINEL) {
				smallestNum = n;
				largestNum = n;
			}

			if (n < smallestNum) { // every smaller value will be used
				smallestNum = n; // for smallestNum
			} else if (n > largestNum) {
				largestNum = n; // every larger value will be used for largestNum
			}
		}
		// last part, writing our values on the screen
		if (largestNum == SENTINEL) { // this could be smallestNum as well
			// special message for the user if 0 was inserted right away
			println("Special  symbol(0) was used");
		} else {
			println("smallest: " + smallestNum);
			println("largest: " + largestNum);
		}
	}
}
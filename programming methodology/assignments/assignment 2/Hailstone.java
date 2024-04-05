/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.ConsoleProgram;

/*
 * This program calculates Hailstone sequence for the given integer n
 */
public class Hailstone extends ConsoleProgram {
	public void run() {
		int total = 0; // assigning start point of steps
		int n = readInt("Enter a number: ");

		// works for even numbers, stops when n=1
		while (n % 2 == 0) {
			println(n + " is even so I take half: " + even(n));
			n = even(n);
			total++;
			if (n == 1) {
				break;
			}
		}

		// works for odd numbers and only if their value !=1
		while (n % 2 != 0 && n != 1) {
			println(n + " is odd, so I make 3n + 1: " + odd(n));
			n = odd(n);
			total++;
			while (n % 2 == 0) { // continues sequence if odd number becomes even
				println(n + " is even so I take half: " + even(n));
				n = even(n);
				total++;// total++ is used in several places and i used for counting steps
			}

			if (n == 1) {
				break;
			}
		}
		println("The process took " + total + " to reach 1");
	}

	private int odd(int n) { // return method for odd integer
		n *= 3;
		return n + 1;
	}

	private int even(int n) { // return method for even integer
		return n / 2;
	}

}

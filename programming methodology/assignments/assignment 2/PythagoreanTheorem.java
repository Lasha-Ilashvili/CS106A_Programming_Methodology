/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.ConsoleProgram;

/*
 * This program uses
 * Pythagorean theorem in order to find the hypotenuse 
 * We simply take the square root of both sides of the equation a² + b² = c² 
 * When doing so, we get c = √(a² + b²) 
 */

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		// letting user know what this program does
		println("Enter values to compute Pythagorean theorem.");
		int cathetus1 = readInt("a: ");
		int cathetus2 = readInt("b: ");
		println("c = " + hypotenuse(cathetus1, cathetus2));
	}

	/*
	 * First we calculate squares of our cathetus by using Math.pow()
	 * Then we add up those numbers and  
	 * Lastly,calculating square root with Math,sqrt()
	 */
	private double hypotenuse(int a, int b) {
		double squareSum = Math.pow(a, 2) + Math.pow(b, 2);
		double c = Math.sqrt(squareSum);
		return c;
	}
}
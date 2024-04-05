/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/*
 * In this program we need three different sized circles. 
 * First has a radius of 2.54cm (72 pixels). 
 * Second is 1.65cm, 1.65 * 72 / 2.54 pixels.
 * Same method is used for the last circle which has a radius of 0.76 cm.
 */
public class Target extends GraphicsProgram {

	// declaring constants of circles' radiuses
	private static final double radiusB = 72;
	private static final double radiusM = 1.65 * 72 / 2.54;
	private static final double radiusS = 0.76 * 72 / 2.54;

	public void run() {
		// dividing whole program into 3 part, 3 circles
		bigCircle();
		middleCircle();
		smallCircle();
	}

	/*
	 * In functions of every circle, in order to calculate its width and height,
	 * we multiply radius by 2
	 * width and height ratios are the same.
	 */

	private void bigCircle() {
		// draws outer red circle
		GOval bigC = new GOval(radiusB * 2, radiusB * 2);
		bigC.setColor(Color.RED);
		bigC.setFilled(true);
		add(bigC, getWidth() / 2 - radiusB, getHeight() / 2 - radiusB);
	}

	private void middleCircle() {
		// draws middle white circle
		GOval middleC = new GOval(radiusM * 2, radiusM * 2);
		middleC.setColor(Color.WHITE);
		middleC.setFilled(true);
		add(middleC, getWidth() / 2 - radiusM, getHeight() / 2 - radiusM);
	}

	private void smallCircle() {
		// draws inner red circle
		GOval smallC = new GOval(radiusS * 2, radiusS * 2);
		smallC.setColor(Color.RED);
		smallC.setFilled(true);
		add(smallC, getWidth() / 2 - radiusS, getHeight() / 2 - radiusS);
	}
}
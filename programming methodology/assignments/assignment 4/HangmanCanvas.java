/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;

public class HangmanCanvas extends GCanvas {

	/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		incorrect = "";
		sum = 0;
		double scafX = getWidth() / 2 - BEAM_LENGTH;
		double scafYo = getHeight() / 2 - BODY_LENGTH - HEAD_RADIUS - ROPE_LENGTH; // radius*2 places scaffold too high
		GLine scaf = new GLine(scafX, scafYo, scafX, scafYo + SCAFFOLD_HEIGHT);
		add(scaf);
		GLine beam = new GLine(scafX, scafYo, scafX + BEAM_LENGTH, scafYo);
		add(beam);
		GLine rope = new GLine(getWidth() / 2, scafYo, getWidth() / 2, scafYo + ROPE_LENGTH);
		add(rope);
	}

	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game. The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens.
	 */
	public void displayWord(String word) {
		GLabel hidden = new GLabel(word);
		hidden.setFont("-BOLD-28");
		double labelx = getWidth() / 8;
		double labely = getHeight() - hidden.getAscent() * 1.5;
		if (getElementAt(labelx, labely) != null) {
			remove(getElementAt(labelx, labely));
		}
		add(hidden, labelx, labely);
	}

	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user. Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
	public void noteIncorrectGuess(char letter) {
		double noteX = getWidth() / 8;
		double noteY = getHeight() - ROPE_LENGTH;
		GLabel note = new GLabel(incorrect + letter, noteX, noteY);
		note.setFont("-14");
		if (incorrect.indexOf(letter) == -1) {
			add(note);
			incorrect += letter;
		}
		sum++;

		switch (sum) {
		case 1:
			head();
			break;
		case 2:
			body();
			break;
		case 3:
			leftArm();
			break;
		case 4:
			rightArm();
			break;
		case 5:
			leftLeg();
			break;
		case 6:
			rightLeg();
			break;
		case 7:
			leftFoot();
			break;
		case 8:
			rightFoot();
			break;
		}
	}

	private void head() {
		GOval head = new GOval(getWidth() / 2 - HEAD_RADIUS, getHeight() / 2 - BODY_LENGTH - HEAD_RADIUS,
				HEAD_RADIUS * 2, HEAD_RADIUS * 2);
		add(head);
	}

	private void body() {
		GLine body = new GLine(getWidth() / 2, getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS, getWidth() / 2,
				getHeight() / 2 + HEAD_RADIUS);
		add(body);
	}

	private void leftArm() {
		GLine upperArm = new GLine(getWidth() / 2, getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2 - UPPER_ARM_LENGTH, getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		add(upperArm);
		GLine lowerArm = new GLine(getWidth() / 2 - UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2 - UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(lowerArm);
	}

	private void rightArm() {
		GLine upperArm = new GLine(getWidth() / 2, getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2 + UPPER_ARM_LENGTH, getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		add(upperArm);
		GLine lowerArm = new GLine(getWidth() / 2 + UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2 + UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH + HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		add(lowerArm);
	}

	private void leftLeg() {
		GLine hip = new GLine(getWidth() / 2, getHeight() / 2 + HEAD_RADIUS, getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 + HEAD_RADIUS);
		add(hip);
		GLine leg = new GLine(getWidth() / 2 - HIP_WIDTH, getHeight() / 2 + HEAD_RADIUS, getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 + HEAD_RADIUS + LEG_LENGTH);
		add(leg);

	}

	private void rightLeg() {
		GLine hip = new GLine(getWidth() / 2, getHeight() / 2 + HEAD_RADIUS, getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 + HEAD_RADIUS);
		add(hip);
		GLine leg = new GLine(getWidth() / 2 + HIP_WIDTH, getHeight() / 2 + HEAD_RADIUS, getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 + HEAD_RADIUS + LEG_LENGTH);
		add(leg);
	}

	private void leftFoot() {
		GLine foot = new GLine(getWidth() / 2 - HIP_WIDTH, getHeight() / 2 + HEAD_RADIUS + LEG_LENGTH,
				getWidth() / 2 - HIP_WIDTH - FOOT_LENGTH, getHeight() / 2 + HEAD_RADIUS + LEG_LENGTH);
		add(foot);
	}

	private void rightFoot() {
		GLine foot = new GLine(getWidth() / 2 + HIP_WIDTH, getHeight() / 2 + HEAD_RADIUS + LEG_LENGTH,
				getWidth() / 2 + HIP_WIDTH + FOOT_LENGTH, getHeight() / 2 + HEAD_RADIUS + LEG_LENGTH);
		add(foot);

	}

	private String incorrect;
	private int sum;

	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}

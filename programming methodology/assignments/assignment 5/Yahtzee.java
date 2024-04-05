/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.Arrays;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {

	public static void main(String[] args) {
		new Yahtzee().start(args);
	}

	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		initialize();

		while (true) {

			for (int player = 1; player <= nPlayers; player++) {

				display.waitForPlayerToClickRoll(player);

				makeTurn(dice);

				int category = display.waitForPlayerToSelectCategory();
				boolean validCategory = checkCategory(dice, category);

				if (validCategory && categoryList[player - 1][category - 1] == -1) {
					int score = getScore(dice, category);
					display.updateScorecard(category, player, score);
					categoryList[player - 1][category - 1] = score;
				} else if (!validCategory) {
					display.updateScorecard(category, player, 0);
				}

			}

		}
	}

	private void initialize() {
		dice = new int[N_DICE];
		categoryList = new int[nPlayers][N_CATEGORIES];

		for (int player = 0; player < nPlayers; player++) {
			for (int category = 0; category < N_CATEGORIES; category++) {
				categoryList[player][category] = -1;
			}
		}
	}

	private void makeTurn(int[] dice) {
		for (int i = 0; i < 3; i++) {

			randomizeDice(dice, i);

			display.displayDice(dice);

			if (i < 2) {
				display.waitForPlayerToSelectDice();
			}

		}
	}

	private void randomizeDice(int[] dice, int i) {
		for (int j = 0; j < N_DICE; j++) {
			if (display.isDieSelected(j) || i == 0) {
				dice[j] = rgen.nextInt(1, 6);
			}
		}
	}

	private boolean checkCategory(int[] dice, int category) {
		if (ONES <= category && category <= SIXES || category == CHANCE) {
			return true;
		}

		boolean result = false;

		switch (category) {
			case THREE_OF_A_KIND:
			case FOUR_OF_A_KIND:
				result = checkConsecutives(dice, 3, 4, false);
				break;
			case FULL_HOUSE:
				result = checkConsecutives(dice, 2, 3, true);
				break;
			case YAHTZEE:
				result = checkConsecutives(dice, 5, 5, false);
				break;
			case SMALL_STRAIGHT:
				result = checkStraights(dice, true);
				break;
			case LARGE_STRAIGHT:
				result = checkStraights(dice, false);
				break;
		}

		return result;
	}

	private boolean checkConsecutives(int[] dice, int target1, int target2, boolean checkFullHouse) {
		int[] counter = new int[N_DICE + 1];
		boolean answ1 = false, answ2 = false;

		for (int n : dice) {
			counter[n - 1]++;
		}

		for (int n : counter) {
			if (n == target1) {
				answ1 = true;
			} else if (n == target2) {
				answ2 = true;
			}
		}

		return (!checkFullHouse && (answ1 || answ2)) || (checkFullHouse && answ1 && answ2);
	}

	private boolean checkStraights(int[] dice, boolean chance) {
		Arrays.sort(dice);

		for (int i = 1; i < N_DICE; i++) {
			if (i <= i - 1 && !chance) {
				return false;
			} else if (i <= i - 1 && chance) {
				chance = false;
			}
		}
		return true;
	}

	private int getScore(int[] dice, int category) {
		int score = 0;

		if (ONES <= category && category <= SIXES) {
			for (int n : dice) {
				score += (n == category) ? n : 0;
			}
		} else if (category == CHANCE || category == THREE_OF_A_KIND || category == FOUR_OF_A_KIND) {
			for (int n : dice) {
				score += n;
			}
		} else if (category == FULL_HOUSE) {
			score = 25;
		} else if (category == SMALL_STRAIGHT) {
			score = 30;
		} else if (category == LARGE_STRAIGHT) {
			score = 40;
		} else {
			score = 50;
		}

		return score;
	}

	/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	private int[] dice;
	private int[][] categoryList;
}
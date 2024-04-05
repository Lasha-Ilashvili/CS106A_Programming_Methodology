import acm.util.ErrorException;

/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

public class HangmanLexicon {

	/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10; // evaluates number of words in the file
	}

	/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
		case 0:
			return "MEDAL";
		case 1:
			return "COMPUTER";
		case 2:
			return "FOOTBALL";
		case 3:
			return "GRAVITY";
		case 4:
			return "TELEVISION";
		case 5:
			return "KITCHEN";
		case 6:
			return "NATION";
		case 7:
			return "UNIMPRESSIVE";
		case 8:
			return "BEVERAGE";
		case 9:
			return "DEGREE";
		default:
			throw new ErrorException("getWord: Illegal index");
		}
	}
}
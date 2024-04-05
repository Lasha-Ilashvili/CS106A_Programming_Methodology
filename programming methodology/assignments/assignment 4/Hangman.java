/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Hangman extends ConsoleProgram {
	public void init() { // initializes canvas
		canvas = new HangmanCanvas();
		add(canvas);
	}

	public void run() {
		hangman();
	}

	private void hangman() {
		gameSetUp();
		gamePlay();
	}

	private void gameSetUp() {
		canvas.reset();
		lexicon();
		println("Welcome to Hangman!");
		println("The word now looks like this: " + dashes()); // only dashes without letters
		canvas.displayWord(hidden);
	}

	private void lexicon() {
		HangmanLexicon lex = new HangmanLexicon();
		word = lex.getWord(rgen.nextInt(lex.getWordCount()));
	}

	// Postcondition: returns sum of dashes according to word's length
	private String dashes() {
		hidden = "";
		for (int i = 0; i < word.length(); i++) {
			hidden += "-";
		}
		return hidden;
	}

	private void gamePlay() {
		while (true) {
			println("You have " + count + " guesses left.");
			letter = readLetter();
			lives();
			wordAppearance();
			if (count == 0) { // If no more lives left
				println("You're completely hung.\nThe word was: " + word + "\nYou lose.");
				break;
			} else if (hidden.equals(word)) { // If we guessed the word
				println("You guessed the word: " + word + "\nYou win.");
				break;
			}
		}
		newGame(); // starts new game
	}

	private char readLetter() {
		while (true) {
			String guess = readLine("Your guess: ").toUpperCase(); // reads user's input and converts to upper case

			if (guess.equals("")) {
				continue;
			}
			char engLetter = guess.charAt(0); // converting to char type
			/*  only if input is in the range of English alphabet and only if one symbol is typed */
			if (guess.length() == 1 && engLetter >= 'A' && engLetter <= 'Z') {
				// if guessed letter is typed again, it displays a message
				if (engLetter == letter && hidden.indexOf(letter) != -1)
					println("ALREADY GUESSED");
				else
					return engLetter; // returns letter

			} else {
				println("Enter one English letter!"); // if non alphabetic or more than one symbols are typed
			}
		}
	}

	private void lives() {
		if (word.indexOf(letter) == -1) { // If typed letter is not a part of given word
			println("There are no " + letter + "'s in the word.");
			count--; // counts remained lives
			canvas.noteIncorrectGuess(letter); // displays incorrect guess only once
		} else {
			println("That guess is correct.");
		}
	}

	/*
	 * Precondition: given word is hidden with dashes
	 * Postcondition: every successful guess adds up one letter to hidden word
	 */
	private void wordAppearance() {
		for (int i = 0; i < word.length(); i++) {
			if (letter == word.charAt(i)) { // checks if input is present in a word
				hidden = hidden.substring(0, i) + letter + hidden.substring(i + 1);
			}
		}
		// if user wins or loses program won't display this message
		if (count != 0 && hidden.equals(word) == false) {
			println("The word now looks like this: " + hidden);
		}
		canvas.displayWord(hidden);
	}

	// Based on user's answer starts new game or ends where it was
	private void newGame() {
		while (true) {
			String question = readLine("Do you want to play again: ").toUpperCase();
			if (question.startsWith("Y")) {
				println("Ok");
				count = 8;
				hangman();
			} else if (question.startsWith("N")) {
				println("Your loss :/");
				break;
			}
		}
	}

	// instance variables
	private String word;
	private String hidden;
	private char letter;
	private int count = 8;
	private HangmanCanvas canvas;
	private RandomGenerator rgen = RandomGenerator.getInstance();

}

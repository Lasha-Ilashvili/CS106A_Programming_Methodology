import java.util.StringTokenizer;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

public class NameSurferEntry implements NameSurferConstants {

	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears
	 * in the data file. Each line begins with the name, which is
	 * followed by integers giving the rank of that name for each
	 * decade.
	 */
	public NameSurferEntry(String line) {
		name = line.substring(0, line.indexOf(" ")); // separating name from numbers
		line = line.substring(line.indexOf(" ") + 1); // line of numbers only
		// reads and adds numbers to array using Tokenizer
		StringTokenizer tk = new StringTokenizer(line);
		ranks = new int[tk.countTokens()]; // sets length of array
		for (int i = 0; tk.hasMoreTokens(); i++) {
			ranks[i] = Integer.parseInt(tk.nextToken()); // converting from string to int
		}
	}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular
	 * decade. The decade value is an integer indicating how many
	 * decades have passed since the first year in the database,
	 * which is given by the constant START_DECADE. If a name does
	 * not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		return ranks[decade];
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */
	public String toString() {
		String ranking = "";
		for (int i = 0; i < ranks.length; i++) {
			if (i == ranks.length - 1) // if statement to avoid last spacing
				ranking += ranks[i];
			else
				ranking += ranks[i] + " ";
		}
		return name + " [" + ranking + "]";
	}

	// private instance variables
	private String name;
	private int[] ranks;
}

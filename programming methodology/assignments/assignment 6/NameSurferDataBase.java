import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import acm.util.ErrorException;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {

	/* Constructor: NameSurferDataBase(filename) */
	/**
	 * Creates a new NameSurferDataBase and initializes it using the
	 * data in the specified file. The constructor throws an error
	 * exception if the requested file does not exist or if an error
	 * occurs as the file is being read.
	 */
	public NameSurferDataBase(String filename) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				NameSurferEntry tr = new NameSurferEntry(line);
				names.put(tr.getName(), tr); // This HashMap stores names and data from NameSurferEntry class
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}

	/* Method: findEntry(name) */
	/**
	 * Returns the NameSurferEntry associated with this name, if one
	 * exists. If the name does not appear in the database, this
	 * method returns null.
	 */
	public NameSurferEntry findEntry(String name) {
		char ch = Character.toUpperCase(name.charAt(0));// we need only first letter to be upper case
		name = ch + name.substring(1).toLowerCase(); // if name is written in upper case converts it
		return names.get(name); // returns data if name exists, else returns null.
	}

	// private instance variables
	private Map<String, NameSurferEntry> names = new HashMap<String, NameSurferEntry>();
}

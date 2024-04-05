/*
 * File: FacePamphletProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the FacePamphlet social network.  Each profile contains a
 * name, an image (which may not always be set), a status (what 
 * the person is currently doing, which may not always be set),
 * and a list of friends.
 */

import java.util.ArrayList;
import java.util.Iterator;

import acm.graphics.GImage;

public class FacePamphletProfile implements FacePamphletConstants {

	/**
	 * Constructor
	 * This method takes care of any initialization needed for
	 * the profile.
	 */
	public FacePamphletProfile(String name) {
		identity = name;
		bio = "";
		ages = "";
		educations = "";
	}

	/** This method returns the name associated with the profile. */
	public String getName() {
		return identity;
	}

	/**
	 * This method returns the image associated with the profile.
	 * If there is no image associated with the profile, the method
	 * returns null.
	 */
	public GImage getImage() {
		return picture;
	}

	/** This method sets the image associated with the profile. */
	public void setImage(GImage image) {
		picture = image;
	}

	/**
	 * This method returns the status associated with the profile.
	 * If there is no status associated with the profile, the method
	 * returns the empty string ("").
	 */
	public String getStatus() {
		return bio;
	}

	/** This method sets the status associated with the profile. */
	public void setStatus(String status) {
		bio = status;
	}

	public String getAge() {
		return ages;
	}

	public void setAge(String age) {
		ages = age;
	}

	public String getEducation() {
		return educations;
	}

	public void setEducation(String education) {
		educations = education;
	}

	/**
	 * This method adds the named friend to this profile's list of
	 * friends. It returns true if the friend's name was not already
	 * in the list of friends for this profile (and the name is added
	 * to the list). The method returns false if the given friend name
	 * was already in the list of friends for this profile (in which
	 * case, the given friend name is not added to the list of friends
	 * a second time.)
	 */
	public boolean addFriend(String friend) {
		/* checks that new friend isn't added already and is not the same person as
		current profile */
		if (!friendList.contains(friend) && !identity.equals(friend)) {
			friendList.add(friend);
			return true;
		}
		return false;
	}

	/**
	 * This method removes the named friend from this profile's list
	 * of friends. It returns true if the friend's name was in the
	 * list of friends for this profile (and the name was removed from
	 * the list). The method returns false if the given friend name
	 * was not in the list of friends for this profile (in which case,
	 * the given friend name could not be removed.)
	 */
	public boolean removeFriend(String friend) {
		return friendList.remove(friend);
	}

	/**
	 * This method returns an iterator over the list of friends
	 * associated with the profile.
	 */
	public Iterator<String> getFriends() {
		return friendList.iterator();
	}

	public boolean addFamily(String family) {
		/* checks that new family member isn't added already and is not the same person as
		current profile */
		if (!familyList.contains(family) && !identity.equals(family)) {
			familyList.add(family);
			return true;
		}
		return false;
	}

	public boolean removeFamily(String family) {
		return familyList.remove(family);
	}

	public Iterator<String> getFamily() {
		return familyList.iterator();
	}

	/**
	 * This method returns a string representation of the profile.
	 * This string is of the form: "name (status): list of friends",
	 * where name and status are set accordingly and the list of
	 * friends is a comma separated list of the names of all of the
	 * friends in this profile.
	 * 
	 * For example, in a profile with name "Alice" whose status is
	 * "coding" and who has friends Don, Chelsea, and Bob, this method
	 * would return the string: "Alice (coding): Don, Chelsea, Bob"
	 */
	public String toString() {
		String friends = "";
		for (int i = 0; i < friendList.size(); i++) {
			friends += friendList.get(i);
			if (i < friendList.size() - 1) // to avoid comma after the last string
				friends += ", ";
		}
		return identity + " (" + bio + "): " + friends;
	}

	/* Private instance variables */
	private String identity;
	private String bio;
	private String ages;
	private String educations;
	private GImage picture;
	private ArrayList<String> friendList = new ArrayList<>();
	private ArrayList<String> familyList = new ArrayList<>();
}

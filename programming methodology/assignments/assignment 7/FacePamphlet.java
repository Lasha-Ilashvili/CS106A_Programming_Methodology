import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.GImage;
import acm.program.Program;
import acm.util.ErrorException;

/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

public class FacePamphlet extends Program implements FacePamphletConstants {

	public static void main(String[] args) {
		FacePamphlet.start(args);
	}

	/**
	 * This method has the responsibility for initializing the
	 * interactors in the application, and taking care of any other
	 * initialization that needs to be performed.
	 */
	public void init() {
		canvas = new FacePamphletCanvas();
		add(canvas); // adding canvas

		// setting up two bars of interactors
		upperBar();
		leftBar();
		addActionListeners();
	}

	private void upperBar() {
		// adding interactors
		add(new JLabel("Name"), NORTH); // adds label
		add(name, NORTH); // adds text field

		// adds buttons
		add(new JButton("Add"), NORTH);
		add(new JButton("Delete"), NORTH);
		add(new JButton("Lookup"), NORTH);
		add(new JButton("Clear"), NORTH);
	}

	private void leftBar() {
		// naming text fields
		status.setActionCommand("Change Status");
		age.setActionCommand("Age");
		education.setActionCommand("Education");
		picture.setActionCommand("Change Picture");
		addFriend.setActionCommand("Add Friend");
		addFamily.setActionCommand("Add Family");

		// adding interactors and empty labels for spaces
		add(status, WEST);
		add(new JButton("Change Status"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);

		add(age, WEST);
		add(new JButton("Age"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);

		add(education, WEST);
		add(new JButton("Education"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);

		add(picture, WEST);
		add(new JButton("Change Picture"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);

		add(addFriend, WEST);
		add(new JButton("Add Friend"), WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);

		add(addFamily, WEST);
		add(new JButton("Add Family"), WEST);

		// sets up listeners
		status.addActionListener(this);
		age.addActionListener(this);
		education.addActionListener(this);
		picture.addActionListener(this);
		addFriend.addActionListener(this);
		addFamily.addActionListener(this);
	}

	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked or interactors are used, so you will have to add code
	 * to respond to these actions.
	 */
	public void actionPerformed(ActionEvent e) {
		// setup
		String cmd = e.getActionCommand();
		String profName = name.getText();
		FacePamphletProfile prof = dataBase.getProfile(profName);
		//
		switch (cmd) { // does actions depending on which button was clicked
			case "Clear":
				clear();
				break;
			case "Add":
				addProfile(profName, prof);
				break;
			case "Delete":
				deleteProfile(profName);
				break;
			case "Lookup":
				lookupProfile(profName, prof);
				break;
			case "Change Status":
				changeStatus();
				break;
			case "Age":
				age();
				break;
			case "Education":
				education();
				break;
			case "Change Picture":
				changePicture();
				break;
			case "Add Friend":
				addFriend();
				break;
			case "Add Family":
				addFamily();
				break;
		}
	}

	// clears all JTextFields
	private void clear() {
		name.setText("");
		status.setText("");
		age.setText("");
		education.setText("");
		picture.setText("");
		addFriend.setText("");
		addFamily.setText("");
	}

	/*
	 * Precondition: canvas is blank
	 * Postcondition: new profile added. If user wants to
	 * add same profile again, program will display a message
	 */
	private void addProfile(String profName, FacePamphletProfile prof) {
		if (!dataBase.containsProfile(profName)) {
			if (!profName.equals("")) {// in case user just clicks the button
				dataBase.addProfile(new FacePamphletProfile(profName)); // stores profile in dataBase
				currentProfile = dataBase.getProfile(profName);
				update();
				canvas.showMessage("New profile created");
			}
		} else {
			canvas.showMessage("A profile with the name " + profName + " already exists");
			currentProfile = dataBase.getProfile(profName);
		}
	}

	/*
	 * Precondition: there's an existing profile
	 * Postcondition: previously existing profile is deleted.
	 * If user tries to delete already removed profile, a message will be displayed
	 */
	private void deleteProfile(String profName) {
		if (dataBase.containsProfile(profName)) {
			dataBase.deleteProfile(profName); // deletes profile from dataBase
			canvas.removeAll();
			canvas.showMessage("Profile of " + profName + " deleted");
			currentProfile = null;
		} else {
			canvas.removeAll();
			canvas.showMessage(notFound(profName));
			currentProfile = null;
		}
	}

	/*
	 * Precondition: canvas is blank or current profile is displayed
	 * Postcondition: other profile is searched and displayed.
	 * If user searches for inexistent profile, a message will be displayed
	 */
	private void lookupProfile(String profName, FacePamphletProfile prof) {
		if (dataBase.containsProfile(profName)) {
			currentProfile = dataBase.getProfile(profName);
			update();
			canvas.showMessage("Displaying " + profName);
		} else {
			canvas.removeAll();
			canvas.showMessage(notFound(profName));
			currentProfile = null;
		}
	}

	private String notFound(String profName) {
		return "A profile with the name " + profName + " does not exist";
	}

	/*
	 * Precondition: status is set to "No current status"
	 * Postcondition: new status is added under a photo
	 */
	private void changeStatus() {
		if (currentProfile != null) {
			if (!status.getText().equals("")) {
				currentProfile.setStatus(status.getText());
				update();
				canvas.showMessage("Status updated to " + status.getText());
			}
		} else
			canvas.showMessage("Please select a profile to change status");
	}

	private void age() {
		if (currentProfile != null) {
			if (!age.getText().equals("")) {
				currentProfile.setAge(age.getText());
				update();
				canvas.showMessage("Age updated to " + age.getText());
			}
		} else
			canvas.showMessage("Please select a profile to change age");
	}

	private void education() {
		if (currentProfile != null) {
			if (!education.getText().equals("")) {
				currentProfile.setEducation(education.getText());
				update();
				canvas.showMessage("Education updated to " + education.getText());
			}
		} else
			canvas.showMessage("Please select a profile to change education");
	}

	/*
	 * Precondition: image is either empty rectangle or already added picture
	 * Postcondition: if given file exists program removes everything and adds
	 * picture
	 */
	private void changePicture() {
		if (currentProfile != null) {
			GImage image = null;
			try {
				image = new GImage(picture.getText());
				if (!picture.getText().equals("")) { // in case user just clicks the button
					currentProfile.setImage(image);
					update();
					canvas.showMessage("Picture updated");
				}
			} catch (ErrorException ex) {
				canvas.showMessage("Unable to open image file: \"" + picture.getText() + "\"");
			}
		} else
			canvas.showMessage("Please select a profile to change picture");
	}

	/*
	 * Precondition: given name isn't current profile's friend
	 * Postcondition: if given name's profile exists, it is added as a friend
	 */
	private void addFriend() {
		String name = addFriend.getText();
		if (currentProfile != null) {
			if (dataBase.containsProfile(name)) {
				if (currentProfile.addFriend(name)) {
					// if above conditions are met, new friend is added
					dataBase.getProfile(name).addFriend(currentProfile.getName()); // mutual friendship
					update();
					canvas.showMessage(name + " added as a friend");
					//
				} else
					canvas.showMessage(currentProfile.getName() + " already has " + name + " as a friend");
			} else
				canvas.showMessage(name + " does not exist.");
		} else
			canvas.showMessage("Please select a profile to add friend");
	}

	private void addFamily() {
		String name = addFamily.getText();
		if (currentProfile != null) {
			if (dataBase.containsProfile(name)) {
				if (currentProfile.addFamily(name)) {
					// if above conditions are met, new family member is added
					dataBase.getProfile(name).addFamily(currentProfile.getName()); // mutual
					update();
					canvas.showMessage(name + " added as a family member");
					//
				} else
					canvas.showMessage(currentProfile.getName() + " already has " + name + " as a family member");
			} else
				canvas.showMessage(name + " does not exist.");
		} else
			canvas.showMessage("Please select a profile to add family member");
	}

	// clears up a canvas and updates profile
	private void update() {
		canvas.removeAll();
		canvas.displayProfile(currentProfile);
	}

	/* Private instance variables */
	private FacePamphletCanvas canvas;
	private FacePamphletProfile currentProfile;
	private FacePamphletDatabase dataBase = new FacePamphletDatabase();
	// sets sizes of text fields
	private JTextField name = new JTextField(TEXT_FIELD_SIZE);
	private JTextField status = new JTextField(TEXT_FIELD_SIZE);
	private JTextField age = new JTextField(TEXT_FIELD_SIZE);
	private JTextField education = new JTextField(TEXT_FIELD_SIZE);
	private JTextField picture = new JTextField(TEXT_FIELD_SIZE);
	private JTextField addFriend = new JTextField(TEXT_FIELD_SIZE);
	private JTextField addFamily = new JTextField(TEXT_FIELD_SIZE);
}

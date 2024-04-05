/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Iterator;

import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class FacePamphletCanvas extends GCanvas implements FacePamphletConstants, ComponentListener {

	/**
	 * Constructor
	 * This method takes care of any initialization needed for
	 * the display
	 */
	public FacePamphletCanvas() {
		addComponentListener(this);

	}

	/**
	 * This method displays a message string near the bottom of the
	 * canvas. Every time this method is called, the previously
	 * displayed message (if any) is replaced by the new message text
	 * passed in.
	 */
	public void showMessage(String msg) {
		saveMsg = msg;
		if (message != null) // checks and removes an old message if exists
			remove(message);
		// adds passed string as a label message near the bottom of the canvas
		message = new GLabel(msg);
		// label coordinates
		double x = (getWidth() - message.getWidth()) / 2;
		double y = getHeight() - BOTTOM_MESSAGE_MARGIN;
		//
		message.setFont(MESSAGE_FONT);
		add(message, x, y);
	}

	/**
	 * This method displays the given profile on the canvas. The
	 * canvas is first cleared of all existing items (including
	 * messages displayed near the bottom of the screen) and then the
	 * given profile is displayed. The profile display includes the
	 * name of the user from the profile, the corresponding image
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		prof = profile; // assigning value to instance variable
		margin = getWidth() / 32; // changing profile's left section margins to my own variant
		//
		GLabel username = name();
		add(username, margin, margin + username.getAscent());
		//
		double picY = username.getY() + margin;
		addPfp(picY);
		//
		double statusY = picY + IMAGE_HEIGHT + margin;
		addBio(statusY, "No current status", " is ", prof.getStatus());
		//
		double ageY = statusY + margin;
		addBio(ageY, "No current age", " is ", prof.getAge());
		//
		double educationY = statusY + margin * 2;
		addBio(educationY, "No current education", " went to ", prof.getEducation());
		//
		addRelations(prof.getFriends(), picY, "Friends:", 0);
		//
		String family = "Family Members:";
		GLabel width = new GLabel(family);
		addRelations(prof.getFamily(), picY, family, width.getWidth() * 1.5);
	}

	private GLabel name() {
		GLabel label = new GLabel(prof.getName());
		label.setColor(Color.blue);
		label.setFont(PROFILE_NAME_FONT);
		return label;
	}

	private void addPfp(double picY) {
		GImage picture;
		double imageX = getWidth() / 3;
		if (prof.getImage() == null) {
			// adds empty rectangle
			GRect rect = new GRect(imageX, IMAGE_HEIGHT);
			add(rect, margin, picY);
			//
			GLabel noPic = new GLabel("No Image");
			// label coordinates
			double centerX = rect.getWidth() / 2 - noPic.getWidth();
			double centerY = rect.getHeight() / 2 + noPic.getDescent();
			//
			noPic.setFont(PROFILE_IMAGE_FONT);
			add(noPic, rect.getX() + centerX, rect.getY() + centerY);
		} else {
			// adds actual image
			picture = prof.getImage();
			picture.setSize(imageX, IMAGE_HEIGHT);
			add(picture, margin, picY);
		}
	}

	private void addBio(double y, String status, String str, String text) {
		GLabel label;
		if (text.equals(""))
			label = new GLabel(status);
		else
			label = new GLabel(prof.getName() + str + text);
		label.setFont(PROFILE_STATUS_FONT);
		add(label, margin, y + label.getAscent());
	}

	private void addRelations(Iterator<String> it, double picY, String type, double width) {
		// setup
		int sum = 1;
		//
		GLabel relations = new GLabel(type);
		relations.setFont(PROFILE_FRIEND_LABEL_FONT);
		add(relations, getWidth() / 2 + width, picY);
		//
		while (it.hasNext()) {
			GLabel list = new GLabel(it.next());
			list.setFont(PROFILE_FRIEND_FONT);
			add(list, relations.getX(), picY + list.getHeight() * sum);
			sum++;
		}
	}

	public void componentResized(ComponentEvent e) {
		removeAll();
		showMessage(saveMsg);
		displayProfile(prof);
	}

	public void componentMoved(ComponentEvent e) {
	}

	public void componentShown(ComponentEvent e) {
	}

	public void componentHidden(ComponentEvent e) {
	}

	/* Private instance variables */
	private FacePamphletProfile prof;
	private GLabel message;
	private String saveMsg;
	private double margin;
}

package edu.webapde.beans;

import java.io.Serializable;

public class Review implements Serializable{

	public static final String TABLE_NAME = "reviews";
	public static final String COLUMN_REVIEWEDBY = "reviewedBy";
	public static final String COLUMN_REVIEWEE = "reviewee";
	public static final String COLUMN_RATING = "rating";
	public static final String COLUMN_MESSAGE = "message";
	public static final String COLUMN_EVENTID = "eventID";
	public static final String COLUMN_REVIEWDATE = "reviewDate";
	
	private String reviewedBy;
	private int reviewee;
	private int rating;
	private String message;	
	private int eventID;
	private String reviewDate;
	
	public Review(String reviewedBy, int reviewee, int rating, String message, int eventID, String reviewDate) {
		super();
		this.reviewedBy = reviewedBy;
		this.reviewee = reviewee;
		this.rating = rating;
		this.message = message;
		this.eventID = eventID;
		this.reviewDate = reviewDate;
	}

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public String getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public int getReviewee() {
		return reviewee;
	}
	public void setReviewee(int reviewee) {
		this.reviewee = reviewee;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
}


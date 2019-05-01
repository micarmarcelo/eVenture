package edu.webapde.beans;

import java.io.Serializable;

public class Event implements Serializable{
	
	public static final String TABLE_NAME = "event_service";
	public static final String COLUMN_EVENTID = "eventID";
	public static final String COLUMN_USERID = "userID";
	public static final String COLUMN_EVENTNAME = "eventName";
	public static final String COLUMN_CATEGORYID = "categoryID";
	public static final String COLUMN_LOCATION = "eventLocation";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_PACKAGES = "packages";
	public static final String COLUMN_WEBSITES = "websites";
	public static final String COLUMN_AVGRATING = "avgRating";
	public static final String COLUMN_FLOORRATING = "floorRating";
	
	private String eventID;
	private String userID;
	private String eventName;
	private String categoryID;
	private String eventLocation;
	private String description;
	private String packages;
	private String websites;
	private float avgRating;
	private int floorRating;
	
	/*INSERT INTO event_service (userID, eventName, categoryID, eventLocation, description, packages, websites)
	 *VALUES (1, "Den's Photography", 1, "Marikina City", "Pictures say everything!", 
	 *"debut photoshoot = P20 000", "http://facebook.com/Den'sPhotography/");*/
	
	/*
	 * String sql = "INSERT INTO " + EventService.TABLE_NAME + " (" + EventService.COLUMN_USERID + ", " +
	 * 
	 */
	

	public Event(String eventID, String userID, String eventName, String categoryID, String eventLocation,
			String description, String packages, String websites, float avgRating) {
		
		super();
		this.eventID = eventID;
		this.userID = userID;
		this.eventName = eventName;
		this.categoryID = categoryID;
		this.eventLocation = eventLocation;
		this.description = description;
		this.packages = packages;
		this.websites = websites;
		this.avgRating = avgRating;
	}
	
	public Event(){
		
	}
	
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getWebsites() {
		return websites;
	}
	public void setWebsites(String websites) {
		this.websites = websites;
	}
	
	public float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(float avgRating) {
		this.avgRating = avgRating;
	}

	public int getFloorRating() {
		return floorRating;
	}

	public void setFloorRating(int floorRating) {
		this.floorRating = floorRating;
	}

	
}

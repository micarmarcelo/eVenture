package edu.webapde.beans;

public class EventCategory {

	public static final String TABLE_NAME = "event_category";
	public static final String COLUMN_CATEGORYID = "categoryID";
	public static final String COLUMN_CATEGORYNAME = "categoryName";
	
	private int categoryID;
	private String categoryName;
	
	public EventCategory(int categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}


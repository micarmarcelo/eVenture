package edu.webapde.beans;

import java.io.Serializable;

public class RegisteredUser implements Serializable{
	//RULES IN CREATING JAVA BEANS
	//1.implements serializable
	//2.construct getters and setters for every POJO
	//3.generate an empty constructor
	
	/** DATABASE INFORMATION **/
	public static final String TABLE_NAME = "users";
	public static final String COLUMN_USERID = "userID";
	public static final String COLUMN_USERNAME = "username";
	public static final String COLUMN_PASSWORD = "password";
	public static final String COLUMN_LASTNAME = "lastName";
	public static final String COLUMN_FIRSTNAME = "firstName";
	public static final String COLUMN_EMAILADDRESS = "emailAddress";
	public static final String COLUMN_GENDER = "gender";
	public static final String COLUMN_AGE = "age";

	public static final String COLUMN_CONTACTNUM = "contactNum";
	public static final String COLUMN_LOCATION = "location";
	public static final String COLUMN_BIO = "bio";
	
	private String userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	private String gender;
	private int age;
	private String contactNum;
	private String location;
	private String bio;
	
	public RegisteredUser(){
		
	}
	
	public RegisteredUser(String username, String password, String lastName, 
						  String firstName, String emailAddress, String gender, int age, String contactNum,
						  String location, String bio){
		this.username = username;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		
		
		this.gender = gender;
		this.age = age;
		this.contactNum = contactNum;
		this.location = location;
		this.bio = bio;

	}
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
}

package edu.webapde.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.webapde.beans.RegisteredUser;
import edu.webapde.db.DBPool;

public class UsersService {
	//this is a service class that contains
	//all the database helper methods for "users" Table
	
	//dbhelper method add user
	
	public static void addUser(RegisteredUser user){
		//INSERT INTO user(username, password, lastName, firstName, email)
		//VALUES (?,?,?,?,?
		String sql = "INSERT INTO " + RegisteredUser.TABLE_NAME + "(" +
					  RegisteredUser.COLUMN_USERNAME + "," + RegisteredUser.COLUMN_PASSWORD+ "," +
					  RegisteredUser.COLUMN_LASTNAME + "," + RegisteredUser.COLUMN_FIRSTNAME + "," +
					  RegisteredUser.COLUMN_EMAILADDRESS + "," + RegisteredUser.COLUMN_GENDER + "," +
					  RegisteredUser.COLUMN_AGE + "," + RegisteredUser.COLUMN_CONTACTNUM + "," +
					  RegisteredUser.COLUMN_LOCATION + "," + RegisteredUser.COLUMN_BIO
					  +")" + " VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		String schema="eventure";
		String username = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		// use this to prevent sql injection
		try {
			 pstat = conn.prepareStatement(sql);
			 pstat.setString(1, user.getUsername());
			 pstat.setString(2, user.getPassword());
			 pstat.setString(3, user.getLastName());
			 pstat.setString(4, user.getFirstName());
			 pstat.setString(5, user.getEmailAddress());
			 pstat.setString(6, "");
			 pstat.setInt(7, 0);
			 pstat.setString(8, "");
			 pstat.setString(9, "");
			 pstat.setString(10, "");
			
			 
			 
			 pstat.executeUpdate();
			 System.out.println("User is added succesfully in DB!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				pstat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		
	}
	
	public static boolean validateUser(String username, String password){
		boolean isValid = false;
		
		String sql = "SELECT * FROM users where username = ? and password = ?";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, username);
			pstat.setString(2, password);
			rs = pstat.executeQuery();
			isValid = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				pstat.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isValid;
	}
	
	public static boolean isExisting(String email, String username){
		
		String sql = "SELECT * FROM " + RegisteredUser.TABLE_NAME + " WHERE " + 
						RegisteredUser.COLUMN_EMAILADDRESS + " = '" + email + "'"
						+ " OR " + RegisteredUser.COLUMN_USERNAME + " = '" + username + "'";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idMember = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				idMember = Integer.parseInt(rs.getString(RegisteredUser.COLUMN_USERID));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			try{
				pstmt.close();
				conn.close();
				rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		if(idMember==0)
			return false;
		else
			return true;	
	}
	
	public static RegisteredUser getUser(String username){
		RegisteredUser user = null;
		
		String sql = "SELECT * FROM " + RegisteredUser.TABLE_NAME + " WHERE " + RegisteredUser.COLUMN_USERNAME
					 + " = '" + username + "'";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				user = new RegisteredUser();
				user.setUserID(rs.getString(RegisteredUser.COLUMN_USERID));
				user.setUsername(rs.getString(RegisteredUser.COLUMN_USERNAME));
				user.setPassword(rs.getString(RegisteredUser.COLUMN_PASSWORD));
				user.setLastName(rs.getString(RegisteredUser.COLUMN_LASTNAME));
				user.setFirstName(rs.getString(RegisteredUser.COLUMN_FIRSTNAME));
				user.setEmailAddress(rs.getString(RegisteredUser.COLUMN_EMAILADDRESS));
				user.setGender(rs.getString(RegisteredUser.COLUMN_GENDER));
				user.setAge(Integer.parseInt(rs.getString(RegisteredUser.COLUMN_AGE)));
				user.setContactNum(rs.getString(RegisteredUser.COLUMN_CONTACTNUM));
				user.setLocation(rs.getString(RegisteredUser.COLUMN_LOCATION));
				user.setBio(rs.getString(RegisteredUser.COLUMN_BIO));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}
	
	public static boolean updateUser(RegisteredUser user){
		boolean isUpdateSuccess = false;
		
		/** Get all new info of the user**/
		String newLastName = user.getLastName();
		String newFirstName = user.getFirstName();
		String newEmail = user.getEmailAddress();
		String newGender = user.getGender();
		int newAge = user.getAge();
		String newContactNum = user.getContactNum();
		String newLocation = user.getLocation();
		String newBio = user.getBio();
		
		String sql = "UPDATE "+ RegisteredUser.TABLE_NAME + " SET " + RegisteredUser.COLUMN_LASTNAME + "=?, " +
					 RegisteredUser.COLUMN_FIRSTNAME + "=?, " +
					 RegisteredUser.COLUMN_EMAILADDRESS + "=?, " + 
					 RegisteredUser.COLUMN_GENDER + "=?, " + 
					 RegisteredUser.COLUMN_AGE + "=?, " +
					 RegisteredUser.COLUMN_CONTACTNUM + "=?, "+
					 RegisteredUser.COLUMN_LOCATION + "=?, " +
					 RegisteredUser.COLUMN_BIO + "=?"+ " WHERE " +
					 RegisteredUser.COLUMN_USERID + "=? ";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, newLastName);
			pstat.setString(2, newFirstName);
			pstat.setString(3, newEmail);
			pstat.setString(4, newGender);
			pstat.setInt(5, newAge);
			pstat.setString(6, newContactNum);
			pstat.setString(7, newLocation);
			pstat.setString(8, newBio);
			pstat.setString(9, user.getUserID());
			
			pstat.executeUpdate();
			
			System.out.println("UPDATE IN DB::SUCCESS!");
			isUpdateSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isUpdateSuccess;
		
		
		
	}
	
	public static String getUsersFullName(String userID){
		String fullName = "";
		
		String sql = "SELECT "+ RegisteredUser.COLUMN_FIRSTNAME + ", " + RegisteredUser.COLUMN_LASTNAME 
				 	+ " FROM " + RegisteredUser.TABLE_NAME + " WHERE " + RegisteredUser.COLUMN_USERID  + " = ?";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;

		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, userID);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				fullName += rs.getString(RegisteredUser.COLUMN_FIRSTNAME) + " ";
				fullName += rs.getString(RegisteredUser.COLUMN_LASTNAME);
			}
			System.out.println("GOT USER'S FULLNAME::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return fullName;
	}
	
	public static RegisteredUser getUserByID(String userID){
		RegisteredUser user = null;
		
		String sql = "SELECT * FROM " + RegisteredUser.TABLE_NAME + " WHERE " + RegisteredUser.COLUMN_USERID
					 + " = ?";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, userID);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				user = new RegisteredUser();
				user.setUserID(rs.getString(RegisteredUser.COLUMN_USERID));
				user.setUsername(rs.getString(RegisteredUser.COLUMN_USERNAME));
				user.setPassword(rs.getString(RegisteredUser.COLUMN_PASSWORD));
				user.setLastName(rs.getString(RegisteredUser.COLUMN_LASTNAME));
				user.setFirstName(rs.getString(RegisteredUser.COLUMN_FIRSTNAME));
				user.setEmailAddress(rs.getString(RegisteredUser.COLUMN_EMAILADDRESS));
				user.setGender(rs.getString(RegisteredUser.COLUMN_GENDER));
				user.setAge(Integer.parseInt(rs.getString(RegisteredUser.COLUMN_AGE)));
				user.setContactNum(rs.getString(RegisteredUser.COLUMN_CONTACTNUM));
				user.setLocation(rs.getString(RegisteredUser.COLUMN_LOCATION));
				user.setBio(rs.getString(RegisteredUser.COLUMN_BIO));
			}
			
			System.out.println("GOT A USER::SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}
	public static ArrayList<RegisteredUser> searchUser(String name){
		ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
		
		/*SELECT *
			FROM users
			WHERE username LIKE '%Danica%' or firstName LIKE '%Danica%' or lastName LIKE '%Danica%';*/
		
		String sql = "SELECT * FROM " + RegisteredUser.TABLE_NAME + " WHERE " + RegisteredUser.COLUMN_USERNAME
				   + " LIKE '%" + name + "%' OR " + RegisteredUser.COLUMN_FIRSTNAME + " LIKE '%" + name + "%' OR "
				   + RegisteredUser.COLUMN_LASTNAME + " LIKE '%" + name + "%'";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				RegisteredUser user = new RegisteredUser();
				user.setUserID(rs.getString(RegisteredUser.COLUMN_USERID));
				user.setUsername(rs.getString(RegisteredUser.COLUMN_USERNAME));
				user.setPassword(rs.getString(RegisteredUser.COLUMN_PASSWORD));
				user.setLastName(rs.getString(RegisteredUser.COLUMN_LASTNAME));
				user.setFirstName(rs.getString(RegisteredUser.COLUMN_FIRSTNAME));
				user.setEmailAddress(rs.getString(RegisteredUser.COLUMN_EMAILADDRESS));
				user.setGender(rs.getString(RegisteredUser.COLUMN_GENDER));
				user.setAge(Integer.parseInt(rs.getString(RegisteredUser.COLUMN_AGE)));
				user.setContactNum(rs.getString(RegisteredUser.COLUMN_CONTACTNUM));
				user.setLocation(rs.getString(RegisteredUser.COLUMN_LOCATION));
				user.setBio(rs.getString(RegisteredUser.COLUMN_BIO));
				
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstat.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return users;
	}
}

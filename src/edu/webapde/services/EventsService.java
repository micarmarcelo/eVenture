package edu.webapde.services;

import java.sql.*;
import java.util.ArrayList;

import edu.webapde.beans.Event;
import edu.webapde.beans.RegisteredUser;
import edu.webapde.beans.Review;
import edu.webapde.db.DBPool;

public class EventsService {
	
	public static void addEventService(Event ae){
		/*INSERT INTO event_service (userID, eventName, categoryID, eventLocation, description, packages, websites)
		 *VALUES (1, "Den's Photography", 1, "Marikina City", "Pictures say everything!", 
		 *"debut photoshoot = P20 000", "http://facebook.com/Den'sPhotography/");*/
		
		String sql = "INSERT INTO " + Event.TABLE_NAME + " (" + Event.COLUMN_USERID + ", "
					+ Event.COLUMN_EVENTNAME + ", " + Event.COLUMN_CATEGORYID + ", "
					+ Event.COLUMN_LOCATION + ", " + Event.COLUMN_DESCRIPTION + ", " 
					+ Event.COLUMN_PACKAGES + ", " + Event.COLUMN_WEBSITES + ") "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		String schema="eventure";
		String username = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		System.out.println("Yow" + ae.getUserID());
		System.out.println("Wew" + ae.getCategoryID());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(ae.getUserID()));
			pstmt.setString(2, ae.getEventName());
			pstmt.setInt(3, Integer.parseInt(ae.getCategoryID()));
			pstmt.setString(4, ae.getEventLocation());
			pstmt.setString(5, ae.getDescription());
			pstmt.setString(6, ae.getPackages());
			pstmt.setString(7, ae.getWebsites());
			pstmt.executeUpdate();
			
			System.out.println("ADVERTISE EVENT SERVICE::SUCCESS!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static ArrayList<Event> getUserEventServices(int userID){
		ArrayList<Event> events = new ArrayList<>();
		
		/*SELECT *
		 *FROM event_service
		 *WHERE userID = ?;
		*/
		String sql = "SELECT *, ROUND(AVG(R.rating), 1) AS avgRating, FLOOR(ROUND(AVG(R.rating), 1)) AS floorRating"
				+ "	FROM " + Event.TABLE_NAME + " ES LEFT JOIN " + Review.TABLE_NAME + " R " 
				+ "ON R." + Review.COLUMN_EVENTID + " = ES." + Event.COLUMN_EVENTID + " WHERE " + Event.COLUMN_USERID + "=?"
				+ " GROUP BY ES." + Event.COLUMN_EVENTID; 
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Event ae = new Event();
				ae.setEventID(rs.getString(Event.COLUMN_EVENTID));
				ae.setUserID(rs.getString(Event.COLUMN_USERID));
				ae.setEventName(rs.getString(Event.COLUMN_EVENTNAME));
				ae.setCategoryID(rs.getString(Event.COLUMN_CATEGORYID));
				ae.setEventLocation(rs.getString(Event.COLUMN_LOCATION));
				ae.setDescription(rs.getString(Event.COLUMN_DESCRIPTION));
				ae.setPackages(rs.getString(Event.COLUMN_PACKAGES));
				ae.setWebsites(rs.getString(Event.COLUMN_WEBSITES));
				ae.setAvgRating(rs.getFloat(Event.COLUMN_AVGRATING));
				ae.setFloorRating(rs.getInt(Event.COLUMN_FLOORRATING));
				events.add(ae);
				System.out.println("GOT USER'S EVENT SERVICES::SUCCESS");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return events;
	}
	
	public static Event getEventService(int eventID){
		Event event = new Event();
		
		/*SELECT *
		 *FROM event_service
		 *WHERE userID = ?;
		*/
		
		String sql = "SELECT * FROM " + Event.TABLE_NAME + " WHERE " + Event.COLUMN_EVENTID + "=? ";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, eventID);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				event = new Event();
				event.setEventID(rs.getString(Event.COLUMN_EVENTID));
				event.setUserID(rs.getString(Event.COLUMN_USERID));
				event.setEventName(rs.getString(Event.COLUMN_EVENTNAME));
				event.setCategoryID(rs.getString(Event.COLUMN_CATEGORYID));
				event.setEventLocation(rs.getString(Event.COLUMN_LOCATION));
				event.setDescription(rs.getString(Event.COLUMN_DESCRIPTION));
				event.setPackages(rs.getString(Event.COLUMN_PACKAGES));
				event.setWebsites(rs.getString(Event.COLUMN_WEBSITES));
				
			}
			System.out.println("VIEW-EVENT-SERVICE::SUCCESS");
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

		return event;
	}
	
	public static ArrayList<Event> getEventServicesByCategory(int categoryID){
		ArrayList<Event> events = new ArrayList<>();
		/*
		String sql = "SELECT * FROM " + Event.TABLE_NAME + " WHERE " + Event.COLUMN_CATEGORYID + "=? " 
					 + "ORDER BY " + Event.COLUMN_EVENTNAME;
					 
		SELECT *, ROUND(AVG(R.rating), 1)AS aveRating
		FROM event_service ES, reviews R
		WHERE R.eventID = ES.eventID
		GROUP BY ES.eventID;

		*/
		String sql = "SELECT *, ROUND(AVG(R.rating), 1) AS avgRating, FLOOR(ROUND(AVG(R.rating), 1)) AS floorRating"
					+ "	FROM " + Event.TABLE_NAME + " ES LEFT JOIN " + Review.TABLE_NAME + " R " 
					+ "ON R." + Review.COLUMN_EVENTID + " = ES." + Event.COLUMN_EVENTID + " WHERE " + Event.COLUMN_CATEGORYID + "=?"
					+ " GROUP BY ES." + Event.COLUMN_EVENTID; 
		
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		

		try {
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, categoryID);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				Event event = new Event();
				event.setEventID(rs.getString(Event.COLUMN_EVENTID));
				event.setUserID(rs.getString(Event.COLUMN_USERID));
				event.setEventName(rs.getString(Event.COLUMN_EVENTNAME));
				event.setCategoryID(rs.getString(Event.COLUMN_CATEGORYID));
				event.setEventLocation(rs.getString(Event.COLUMN_LOCATION));
				event.setDescription(rs.getString(Event.COLUMN_DESCRIPTION));
				event.setPackages(rs.getString(Event.COLUMN_PACKAGES));
				event.setWebsites(rs.getString(Event.COLUMN_WEBSITES));
				event.setAvgRating(rs.getFloat(Event.COLUMN_AVGRATING));
				event.setFloorRating(rs.getInt(Event.COLUMN_FLOORRATING));
				
				events.add(event);
				System.out.println("AVG: " + rs.getFloat(Event.COLUMN_AVGRATING));
				System.out.println("FLOOR AVG: " + rs.getFloat(Event.COLUMN_FLOORRATING));
			}
			System.out.println("VIEW-EVENT-SERVICE::SUCCESS");
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
		
		return events;
	}

	public static ArrayList<Event> getTopPerCategory(int categoryID){
		ArrayList<Event> events = new ArrayList<>();
		/*
		SELECT *, ROUND(AVG(R.rating), 1)AS aveRating
		FROM event_service ES, reviews R
		WHERE R.eventID = ES.eventID and ES.categoryID = 1
        GROUP BY ES.eventID
        HAVING ROUND(AVG(R.rating), 1) = ANY (SELECT DISTINCT ROUND(AVG(R.rating), 1)AS aveRating
															FROM event_service ES, reviews R
															WHERE R.eventID = ES.eventID and ES.categoryID = 1
															GROUP BY ES.eventID
															ORDER BY aveRating DESC
                                                            
															)
		
        ORDER BY aveRating DESC;
        */

		String sql = "SELECT ES.eventID, ES.eventName, ROUND(AVG(R.rating), 1) AS avgRating"
					+ "	FROM " + Event.TABLE_NAME + " ES, " + Review.TABLE_NAME + " R " 
					+ " WHERE R." + Review.COLUMN_EVENTID + " = ES." + Event.COLUMN_EVENTID + " AND ES." + Event.COLUMN_CATEGORYID + "=?"
					+ " GROUP BY ES." + Event.COLUMN_EVENTID +
					" HAVING ROUND(AVG(R.rating), 1) = ANY (SELECT DISTINCT ROUND(AVG(R.rating), 1)AS avgRating"
															+ " FROM event_service ES, reviews R"
															+ " WHERE R.eventID = ES.eventID and ES.categoryID = ?"
															+ " GROUP BY ES.eventID"
															+ " ORDER BY avgRating DESC)"
															+ " ORDER BY avgRating DESC";
		
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		

		try {
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, categoryID);
			pstat.setInt(2, categoryID);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				Event event = new Event();
				event.setEventID(rs.getString(Event.COLUMN_EVENTID));
				event.setEventName(rs.getString(Event.COLUMN_EVENTNAME));
				event.setAvgRating(rs.getFloat(Event.COLUMN_AVGRATING));
				
				events.add(event);
				System.out.println("AVG: " + rs.getFloat(Event.COLUMN_AVGRATING));
			}
			System.out.println("GENERATED TOP-RATING FOR CATEGORY " + categoryID + " ::SUCCESS");
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
		
		
		return events;
	}
	
	public static ArrayList<Event> getEventServicesByPeople(String name){
		ArrayList<Event> events = new ArrayList<>();
		
		String searchName = "\""+ "%" + name+ "%" + "\"";
		
		String sql = "SELECT * FROM " + Event.TABLE_NAME + " WHERE " + Event.COLUMN_EVENTNAME + " LIKE " + searchName;
		
		
			
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();

			while(rs.next()){
				Event event = new Event();
				event.setUserID(rs.getString(Event.COLUMN_USERID));
				event.setEventName(rs.getString(Event.COLUMN_EVENTNAME));
				event.setCategoryID(rs.getString(Event.COLUMN_CATEGORYID));
				event.setEventLocation(rs.getString(Event.COLUMN_LOCATION));
				event.setDescription(rs.getString(Event.COLUMN_DESCRIPTION));
				event.setPackages(rs.getString(Event.COLUMN_PACKAGES));
				event.setWebsites(rs.getString(Event.COLUMN_WEBSITES));
				
				events.add(event);
				
				
			}
			System.out.println("FILTER EVENT SERVICES BY PEOPLE::SUCCESS");
			
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
		
		return events;
	}
	
	public static ArrayList<Event> getEventServicesByLocation(String location){
	ArrayList<Event> events = new ArrayList<>();
		
		String sql = "SELECT * FROM " + Event.TABLE_NAME + " WHERE " + Event.COLUMN_LOCATION + " LIKE '%" + location + "%' " 
					 + "ORDER BY " + Event.COLUMN_EVENTNAME;
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;
		

		try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			while(rs.next()){
				Event event = new Event();
				event.setUserID(rs.getString(Event.COLUMN_USERID));
				event.setEventName(rs.getString(Event.COLUMN_EVENTNAME));
				event.setCategoryID(rs.getString(Event.COLUMN_CATEGORYID));
				event.setEventLocation(rs.getString(Event.COLUMN_LOCATION));
				event.setDescription(rs.getString(Event.COLUMN_DESCRIPTION));
				event.setPackages(rs.getString(Event.COLUMN_PACKAGES));
				event.setWebsites(rs.getString(Event.COLUMN_WEBSITES));
				
				events.add(event);
				
				
			}
			System.out.println("FILTER EVENT SERVICES BY LOCATION::SUCCESS");
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
		
		return events;
	}
}

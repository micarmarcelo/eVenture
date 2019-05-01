package edu.webapde.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.webapde.beans.Event;
import edu.webapde.beans.RegisteredUser;
import edu.webapde.beans.Review;
import edu.webapde.db.DBPool;


public class ReviewService {

	public static void addReview(Review r, Event e, RegisteredUser u){
		
		/*INSERT INTO reviews (reviewedBy, reviewee, rating, message, eventID, reviewDate)
			VALUES ( (SELECT CONCAT(U.firstName , " ", U.lastName)
			FROM user U WHERE U.userID = 2), 
            (SELECT ES.userID 
            FROM event_service ES 
            WHERE ES.eventID = 1), 5, "You're so great", 1, CURDATE());*/
		
		String sql = "INSERT INTO " + Review.TABLE_NAME
				   + " (" + Review.COLUMN_REVIEWEDBY + ", " + Review.COLUMN_REVIEWEE + ", " 
				   + Review.COLUMN_RATING + ", " + Review.COLUMN_MESSAGE + ", " + Review.COLUMN_EVENTID + ", "
				   + Review.COLUMN_REVIEWDATE +")"
				   + " VALUES ( (SELECT CONCAT(?,' ',?) FROM " + RegisteredUser.TABLE_NAME + " WHERE " 
				   + RegisteredUser.COLUMN_USERID + " = ?)," + " (SELECT " + Event.COLUMN_USERID + " FROM "
				   + Event.TABLE_NAME + " WHERE " + Event.COLUMN_EVENTID + " = ?), ?, ?, ?, CURDATE());";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getFirstName());
			pstmt.setString(2, u.getLastName());
			pstmt.setString(3, u.getUserID());
			pstmt.setString(4, e.getEventID());
			pstmt.setInt(5, r.getRating());
			pstmt.setString(6, r.getMessage());
			pstmt.setString(7, e.getEventID());
			pstmt.executeUpdate();
			
			System.out.println("ADD REVIEW:: SUCCESS!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		

	}
	
	public static ArrayList<Review> getAllReviews(int eventID){
		ArrayList<Review> reviewList = new ArrayList<>();
		
		/*SELECT *
		 * FROM event_service
		 * WHERE eventID = ?
		 */
		
		String sql = "SELECT * FROM " + Review.TABLE_NAME + " WHERE eventID = ? ORDER BY " 
						+ Review.COLUMN_REVIEWDATE + " DESC";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Review r = new Review();
				r.setReviewedBy(rs.getString(Review.COLUMN_REVIEWEDBY));
				r.setReviewee(rs.getInt(Review.COLUMN_REVIEWEE));
				r.setRating(rs.getInt(Review.COLUMN_RATING));
				r.setMessage(rs.getString(Review.COLUMN_MESSAGE));
				r.setEventID(rs.getInt(Review.COLUMN_EVENTID));
				r.setReviewDate(rs.getString(Review.COLUMN_REVIEWDATE));
				reviewList.add(r);
				System.out.println(r.getMessage());
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
		
		
		return reviewList;
	}
	
	
}


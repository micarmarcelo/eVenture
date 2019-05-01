package edu.webapde.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.webapde.beans.EventCategory;
import edu.webapde.db.DBPool;


public class EventCategoryService {

	public static String getCategoryName(int categoryID){
		String categoryName = "";
		
		String sql = "SELECT categoryName FROM " + EventCategory.TABLE_NAME + " WHERE categoryID = ?";
		
		Connection conn = DBPool.getInstance().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryID);
			rs = pstmt.executeQuery();
			while(rs.next()){
				categoryName = rs.getString(EventCategory.COLUMN_CATEGORYNAME);
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
		
		return categoryName;
		
	}
}

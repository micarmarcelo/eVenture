package edu.webapde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.webapde.beans.Event;
import edu.webapde.beans.EventCategory;
import edu.webapde.beans.RegisteredUser;
import edu.webapde.beans.Review;
import edu.webapde.services.EventCategoryService;
import edu.webapde.services.EventsService;
import edu.webapde.services.ReviewService;
import edu.webapde.services.UsersService;

/**
 * Servlet implementation class ViewEventServiceServlet
 */
@WebServlet("/ViewEventServiceServlet")
public class ViewEventServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEventServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Get Event's Info
		System.out.println(request.getParameter(Event.COLUMN_EVENTID));
		int eventID;
		if(request.getParameter(Event.COLUMN_EVENTID) != ""){
			eventID = Integer.parseInt(request.getParameter(Event.COLUMN_EVENTID));
		}else{
			eventID = Integer.parseInt((String)request.getAttribute(Event.COLUMN_EVENTID));
		}
		Event event = EventsService.getEventService(eventID);
		request.setAttribute("eventOwner", event.getUserID());
		
		request.setAttribute("categoryID", event.getCategoryID());
		//Convert categoryID and user ID to Category Name and Owner Name
		event.setCategoryID(EventCategoryService.getCategoryName(Integer.parseInt(event.getCategoryID())));

		request.setAttribute("event", event);
		
		//Get Event's Reviews
		ArrayList<Review> reviewList = ReviewService.getAllReviews(Integer.parseInt(request.getParameter(Review.COLUMN_EVENTID)));
		
		System.out.println("reviewlist: " + reviewList);
		request.setAttribute("reviewList", reviewList);
		
		//Get ID and Gender of the currently log in user
		HttpSession session = request.getSession();
		int userID = Integer.parseInt((String)session.getAttribute(RegisteredUser.COLUMN_USERID));
		String gender = (String)session.getAttribute(RegisteredUser.COLUMN_GENDER);
		
		
		request.setAttribute("currUserID", userID);
		request.setAttribute("currUserGender", gender);
		request.setAttribute("fullName", UsersService.getUsersFullName(event.getUserID()));
		request.getRequestDispatcher("view_event_service.jsp").forward(request, response);
	}

}

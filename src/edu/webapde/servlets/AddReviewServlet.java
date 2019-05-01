package edu.webapde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.webapde.beans.Event;
import edu.webapde.beans.RegisteredUser;
import edu.webapde.beans.Review;
import edu.webapde.services.EventsService;
import edu.webapde.services.ReviewService;
import edu.webapde.services.UsersService;

/**
 * Servlet implementation class AddReviewServlet
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
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
		
		RegisteredUser user = UsersService.getUserByID(request.getParameter("userID"));
		System.out.println("event id from add review servlet " + request.getParameter("eventID"));
		Event event = EventsService.getEventService(Integer.parseInt(request.getParameter("eventID")));
		
		
		String message = request.getParameter("message");
		int rating = 0;
		if(request.getParameter("rating") != null){ //if may rating iparse
			rating = Integer.parseInt(request.getParameter("rating"));
			request.setAttribute("getAlert", "review");
		}
		
		Review review = new Review();
		review.setMessage(message);
		review.setRating(rating);
		
		if(message != "" || rating > 0){
			ReviewService.addReview(review, event, user);
			request.setAttribute("getAlert", "review");
		}else if(message == "" && rating == 0){
			request.setAttribute("getAlert", "error");
		}
		
		
		request.setAttribute("eventID", request.getParameter("eventID"));
		request.getRequestDispatcher("ViewEventServiceServlet").forward(request, response);
		
		
	}

}

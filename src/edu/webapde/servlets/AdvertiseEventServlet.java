package edu.webapde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.webapde.beans.Event;
import edu.webapde.services.EventsService;

/**
 * Servlet implementation class AdvertiseEventServlet
 */
@WebServlet("/AdvertiseEventServlet")
public class AdvertiseEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvertiseEventServlet() {
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
		HttpSession session = request.getSession();
		//get inputs from the user, make it an Event object
		Event event = new Event();
		event.setUserID((String)session.getAttribute("userID"));
		event.setEventName(request.getParameter("eventName"));
		event.setCategoryID(request.getParameter("categoryID"));
		event.setEventLocation(request.getParameter("eventLocation"));
		event.setDescription(request.getParameter("description"));
		event.setPackages(request.getParameter("packages"));
		event.setWebsites(request.getParameter("website"));
		
		//tell the service to add event service
		EventsService.addEventService(event);
		
		//redirect to profile
		request.setAttribute("getAlert", "advertise");
		request.getRequestDispatcher("GetUsersEventServicesServlet").forward(request, response);
	}

}

package edu.webapde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.webapde.beans.Event;
import edu.webapde.beans.RegisteredUser;
import edu.webapde.services.EventsService;
import edu.webapde.services.UsersService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Event> events = new ArrayList<Event>();
		ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
		
		String searchInput = request.getParameter("search");
		System.out.println("FILTER BY: " + request.getParameter("filter"));
		int filter = Integer.parseInt(request.getParameter("filter"));
		System.out.println("SEARCH: " + searchInput);
		System.out.println("FILTER BY: " + filter);
		
		if(filter == 1){
			System.out.println("WEW");
			users = UsersService.searchUser(searchInput);
			System.out.println("WEW SIZE: " + users.size());
		}
		else if(filter == 2){
			System.out.println("HI");
			events = EventsService.getEventServicesByPeople(searchInput);
			System.out.println("HI SIZE: " + events.size());
		}
		else if(filter == 3){
			System.out.println("HELLO");
			events = EventsService.getEventServicesByLocation(searchInput);
			System.out.println("HELLO SIZE: " + events.size());
		}
		if(filter == 1){
			request.setAttribute("users", users);
			request.setAttribute("categoryName", "Results from " + searchInput);
			request.getRequestDispatcher("eventure.jsp").forward(request, response);
		}
		else if( (filter == 2) || (filter == 3) ){
			request.setAttribute("events", events);
			request.setAttribute("categoryName", "Results from " + searchInput);
			request.getRequestDispatcher("eventure.jsp").forward(request, response);
		}
		
		
	}

}

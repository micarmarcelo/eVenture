package edu.webapde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.webapde.beans.Event;
import edu.webapde.beans.EventCategory;
import edu.webapde.services.EventCategoryService;
import edu.webapde.services.EventsService;

/**
 * Servlet implementation class SearchByCategServlet
 */
@WebServlet("/SearchByCategServlet")
public class SearchByCategServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByCategServlet() {
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
	 
		int categoryID = Integer.parseInt(request.getParameter(Event.COLUMN_CATEGORYID));
		System.out.println("CATEGORY ID: " + categoryID);
		ArrayList<Event> events = EventsService.getEventServicesByCategory(categoryID);
		String categoryName = EventCategoryService.getCategoryName(categoryID);
		
		request.setAttribute("events", events);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("categoryID", categoryID);
		request.getRequestDispatcher("eventure.jsp").forward(request,response);
	}

}

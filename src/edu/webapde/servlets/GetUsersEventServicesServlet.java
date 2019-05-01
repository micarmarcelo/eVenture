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
import edu.webapde.services.EventsService;

/**
 * Servlet implementation class GetUsersEventServicesServlet
 */
@WebServlet("/GetUsersEventServicesServlet")
public class GetUsersEventServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUsersEventServicesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get array of event services from service
		HttpSession session= request.getSession();
		ArrayList<Event> eventServices = EventsService.getUserEventServices(Integer.parseInt((String)session.getAttribute("userID")));
		
		//give data to myprofile
		request.setAttribute("eventslist", eventServices);
		System.out.println("Papunta na po ng my profile...");	
		request.getRequestDispatcher("myprofile.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
	}

}

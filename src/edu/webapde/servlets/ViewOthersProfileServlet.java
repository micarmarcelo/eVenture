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
import edu.webapde.beans.RegisteredUser;
import edu.webapde.services.EventsService;
import edu.webapde.services.UsersService;

/**
 * Servlet implementation class ViewOthersProfileServlet
 */
@WebServlet("/ViewOthersProfileServlet")
public class ViewOthersProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOthersProfileServlet() {
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

		//get array of event services from service
		HttpSession session= request.getSession();
		ArrayList<Event> eventServices = EventsService.getUserEventServices(Integer.parseInt(request.getParameter(RegisteredUser.COLUMN_USERID)));
		
		//give data to myprofile
		request.setAttribute("eventslist", eventServices);
		RegisteredUser user = UsersService.getUserByID(request.getParameter(RegisteredUser.COLUMN_USERID));
		if(user.getAge() == 0){
			user.setAge(Integer.parseInt(""));
		}
		request.setAttribute("user", user);
		System.out.println("Papunta na po ng profile ng iba");
		request.getRequestDispatcher("othersprofile.jsp").forward(request, response);
	}

}

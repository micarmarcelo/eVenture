package edu.webapde.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.webapde.beans.Event;
import edu.webapde.services.EventsService;

/**
 * Servlet implementation class TopRatingServlet
 */
@WebServlet("/TopRatingServlet")
public class TopRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopRatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Event> top1 = EventsService.getTopPerCategory(1);
		ArrayList<Event> top2 = EventsService.getTopPerCategory(2);
		ArrayList<Event> top3 = EventsService.getTopPerCategory(3);
		ArrayList<Event> top4 = EventsService.getTopPerCategory(4);
		ArrayList<Event> top5 = EventsService.getTopPerCategory(5);
		
		request.setAttribute("top1", top1);
		request.setAttribute("top2", top2);
		request.setAttribute("top3", top3);
		request.setAttribute("top4", top4);
		request.setAttribute("top5", top5);
		
		request.getRequestDispatcher("toprating.jsp").forward(request, response);
		
	}

}

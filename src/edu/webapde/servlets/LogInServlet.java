package edu.webapde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import edu.webapde.beans.RegisteredUser;
import edu.webapde.services.UsersService;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Username entered:" + username);
		System.out.println("Password entered:" + password);
		
		if(UsersService.validateUser(username, password)){
			Cookie usernameCookie = new Cookie("username", username);
			usernameCookie.setMaxAge(60*60*24);
			usernameCookie.setHttpOnly(true);
			response.addCookie(usernameCookie);
			
			HttpSession session = request.getSession();
			
			//put the user's info into session's attributes
			RegisteredUser user = UsersService.getUser(username);
			System.out.println(user.getUserID());
			if(session.getAttribute("username") == null){
				session.setAttribute("username", username);
				
				session.setAttribute("userID", user.getUserID());

				session.setAttribute("lastName", user.getLastName());
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("emailAddress", user.getEmailAddress());
				session.setAttribute("gender", user.getGender());
				
				if(user.getAge() != 0){
					session.setAttribute("age", user.getAge());
				}else{
					session.setAttribute("age", "");
				}
				
				session.setAttribute("contactNum", user.getContactNum());
				session.setAttribute("location", user.getLocation());
				session.setAttribute("bio", user.getBio());
			}
			
			System.out.println("Log-In::SUCCESS");
			request.setAttribute("getAlert", "login");
			request.getRequestDispatcher("TopRatingServlet").forward(request, response);
		}
		else{
			System.out.println("Log-In::FAILED");
			request.setAttribute("getAlert", "failed");
			request.getRequestDispatcher("homepage.jsp").forward(request,response);
		}
		
	}

}

package edu.webapde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.webapde.beans.RegisteredUser;
import edu.webapde.services.UsersService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		//get the input of the user
		//create Registered User from the input
		RegisteredUser user = new RegisteredUser();
		user.setUsername(request.getParameter(RegisteredUser.COLUMN_USERNAME));
		user.setPassword(request.getParameter(RegisteredUser.COLUMN_PASSWORD));
		user.setLastName(request.getParameter(RegisteredUser.COLUMN_LASTNAME));
		user.setFirstName(request.getParameter(RegisteredUser.COLUMN_FIRSTNAME));
		user.setEmailAddress(request.getParameter(RegisteredUser.COLUMN_EMAILADDRESS));
		
		if(UsersService.isExisting(user.getEmailAddress(), user.getUsername())== false){
			//tell the service to add user
			UsersService.addUser(user);
			RegisteredUser newUser = UsersService.getUser(user.getUsername());
			
			//make a session
			HttpSession session = request.getSession();
			session.setAttribute("username", newUser.getUsername());
			session.setAttribute("userID", newUser.getUserID());
			session.setAttribute("lastName", newUser.getLastName());
			session.setAttribute("firstName", newUser.getFirstName());
			session.setAttribute("emailAddress", newUser.getEmailAddress());
			session.setAttribute("gender", "");
			session.setAttribute("age", "");
			session.setAttribute("contactNum", "");
			session.setAttribute("location", "");
			session.setAttribute("bio", "");
			
			System.out.println("SIGN-UP::SUCCESS");
	
			//redirect to profile
			request.setAttribute("getAlert", "signup");
			request.getRequestDispatcher("myprofile.jsp").forward(request, response);
		}else{
			System.out.println("Sign-up::FAILED");
			request.setAttribute("getAlert", "taken");
			request.getRequestDispatcher("homepage.jsp").forward(request,response);
		}
	}

}

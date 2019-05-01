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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		user.setUserID((String)request.getSession().getAttribute("userID"));
		user.setLastName(request.getParameter(RegisteredUser.COLUMN_LASTNAME));
		user.setFirstName(request.getParameter(RegisteredUser.COLUMN_FIRSTNAME));
		user.setEmailAddress(request.getParameter(RegisteredUser.COLUMN_EMAILADDRESS));
		user.setGender(request.getParameter(RegisteredUser.COLUMN_GENDER));
		user.setAge(Integer.parseInt(request.getParameter(RegisteredUser.COLUMN_AGE))); 
		user.setContactNum(request.getParameter(RegisteredUser.COLUMN_CONTACTNUM));
		user.setLocation(request.getParameter(RegisteredUser.COLUMN_LOCATION));
		user.setBio(request.getParameter(RegisteredUser.COLUMN_BIO));
		
		//if updating is successful, update also sessions attributes
		HttpSession session= request.getSession();
		if(UsersService.updateUser(user)){
			session.setAttribute("lastName", user.getLastName());
			session.setAttribute("firstName", user.getFirstName());
			session.setAttribute("emailAddress", user.getEmailAddress());
			session.setAttribute("gender", user.getGender());
			session.setAttribute("age", user.getAge());
			session.setAttribute("contactNum", user.getContactNum());
			session.setAttribute("location", user.getLocation());
			session.setAttribute("bio", user.getBio());
			
			//redirect to profile
			request.setAttribute("getAlert", "update");
			request.getRequestDispatcher("GetUsersEventServicesServlet").forward(request,response);
		}
		
	}

}

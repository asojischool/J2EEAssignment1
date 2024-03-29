package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import models.UserService;

/**
 * Servlet implementation class verifyUser
 */
@WebServlet("/verifyUser")
public class verifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public verifyUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserService userService = new UserService();
		
		if(session.getAttribute("sessID") != null) {
			int userID = (int) session.getAttribute("sessID");
			User tempUser = userService.getUserByID(userID);
			if(tempUser.getRole() == "admin") {
				response.sendRedirect("admin.jsp"); 
				return;
			}
			else {
				response.sendRedirect("home.jsp"); 
				return;
			}
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// validate input
		if (username == null || username.equals("") || password == null || password.equals("")) {
			request.setAttribute("err", "Please enter your ID/Password");
			request.setAttribute("tempUsername", username);
			request.setAttribute("tempPassword", password);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		// authenticate
		User user = userService.verifyUser(username, password);
		
		if (user == null) {
			// log err entries
			System.out.println("invalid " + username + ", " + password);
			
			request.setAttribute("err", "You have entered an Invalid ID/Password");
			request.setAttribute("tempUsername", username);
			request.setAttribute("tempPassword", password);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		if (user != null) {
			String userRole = user.getRole();
			Integer userID = user.getUser_id();
			request.setAttribute("successMsg", "Login Successful");
			
			if (userRole.equals("admin")) {
				session.setAttribute("sessID", userID);
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
				return;
			} else if (userRole.equals("member")) {
				session.setAttribute("sessID", userID);
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

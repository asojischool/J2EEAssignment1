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
		UserService userService = new UserService();
		User user = userService.verifyUser(username, password);
		
		if (user == null) {
			System.out.println("invalid " + username + ", " + password);
			
			request.setAttribute("err", "You have entered an Invalid ID/Password");
			request.setAttribute("tempUsername", username);
			request.setAttribute("tempPassword", password);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
			
//			session.setAttribute("tempUsername", username);
//			session.setAttribute("tempPassword", password);
//			response.sendRedirect("login.jsp?errCode=invalidLogin");
		}
		
		if (user != null) {
			String userRole = user.getRole();
			
			if (userRole.equals("admin")) {
				session.setAttribute("sessUser", user);
				session.setAttribute("authorized", true);
				response.sendRedirect("admin.jsp");
			} else if (userRole.equals("member")) {
				session.setAttribute("sessUser", user);
				session.setAttribute("authorized", true);
				response.sendRedirect("home.jsp");
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

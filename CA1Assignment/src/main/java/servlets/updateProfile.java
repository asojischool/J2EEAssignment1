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
 * Servlet implementation class updateProfile
 */
@WebServlet("/updateProfile")
public class updateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserService userService = new UserService();
		Integer userID = (Integer) session.getAttribute("sessID");
		User user = userService.getUserByID(userID);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		if(username == null || password == null || email == null || username.equals("") || password.equals("") || email.equals("")) {
			request.setAttribute("err", "Please enter your username/password/email");
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
			return;
		}
		
		if(username.equals(user.getUsername()) && password.equals(user.getPassword()) && email.equals(user.getEmail())) {
			request.setAttribute("err", "Nothing is updated");
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
			return;
		}
		
		int numRowsAffected = userService.updateUser(username, password, email, userID);
		
		if(numRowsAffected > 0) {
			request.setAttribute("success", "Profile Update Successful");
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
			return;
		} else if(numRowsAffected == 0) {
			request.setAttribute("err", "Profile Update Unsuccessful");
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
			return;
		} else {
			request.setAttribute("err", "Unknown Error");
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
			return;
		}
	}

}

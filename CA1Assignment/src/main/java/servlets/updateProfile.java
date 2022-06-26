package servlets;

import java.io.IOException;
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
		User user = (User) session.getAttribute("sessUser");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int userID = user.getUser_id();
		
		UserService userService = new UserService();
		int numRowsAffected = userService.updateUser(username, password, email, userID);
		
		if(numRowsAffected > 0) {
			user = userService.getUser(userID);
			session.setAttribute("sessUser", user);
			response.sendRedirect("home.jsp");
		}
		else {
			response.sendRedirect("profile.jsp??errCode=invalidUpdate");
		}
	}

}

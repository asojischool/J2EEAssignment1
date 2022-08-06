package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserService;

/**
 * Servlet implementation class registerCust
 */
@WebServlet("/registerCust")
public class registerCust extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerCust() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = "member";
		String email = request.getParameter("email");
		String area = request.getParameter("area");
		
		if (username.equals("") || password.equals("") || email.equals("") || area.equals("") || username == null || password == null || email == null || area == null) {
			request.setAttribute("err", "Please fill in all fields");
			request.setAttribute("tempUsername", username);
			request.setAttribute("tempPassword", password);
			request.setAttribute("tempEmail", email);
			request.setAttribute("tempArea", area);
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}
		
		String areaStr = area.toLowerCase();
		
		UserService userService = new UserService();
		int numRowsAffected = userService.registerUser(username, password, role, email, areaStr);
		
		if(numRowsAffected > 0) {
			request.setAttribute("successMsg", "Register Successful");
			RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			request.setAttribute("err", "Register Failed");
			RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

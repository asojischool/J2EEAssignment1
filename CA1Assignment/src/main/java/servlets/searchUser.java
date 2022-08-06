package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AdminService;
import models.User;

/**
 * Servlet implementation class searchTour
 */
@WebServlet("/searchUser")
public class searchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String button = request.getParameter("submit");
		String search = request.getParameter("search");
		if (search.equals("") || search == null) {
			request.setAttribute("err", "Please fill in search bar");
			RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
			rd.forward(request, response);
			return;
		}
		search = search.toLowerCase();
		if (button.equals("Search By Name")) {
			AdminService adminService = new AdminService();
			ArrayList<User> users = adminService.searchUserByName(search);
			if (users.size() <= 0) {
				request.setAttribute("err", "User not found");
				RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
				rd.forward(request, response);
				return;
			}
			String display = "";
			for(int i = 0; i < users.size(); i++) {
				display += "<div class=\"col-md-4 container\">"
						+ "<div class=\"card shadow-sm\">"
						+ "<div class=\"card-body\">"
						+ "<p class=\"card-text\">User ID:" + users.get(i).getUser_id() + "</p>"
						+ "<p class=\"card-text\">Username:" + users.get(i).getUsername() + "</p>"
						+ "<p class=\"card-text\">Email:" + users.get(i).getEmail() + "</p>"
						+ "<p class=\"card-text\">Role:" + users.get(i).getRole() + "</p>"
						+ "<p class=\"card-text\">Residential Area:" + users.get(i).getResidentialArea() + "</p>"
						+ "<form action=\"custEdit.jsp?id=" + users.get(i).getUser_id()
						+ "&username=" + users.get(i).getUsername() 
						+ "&password=" + users.get(i).getPassword() 
						+ "&role=" + users.get(i).getRole() 
						+ "&email=" + users.get(i).getEmail() 
						+ "&area=" + users.get(i).getResidentialArea()
						+ "\" method=\"post\"><input class=\"btn-success\" type=\"submit\" value=\"edit\"></form>"
						+ "</div></div></div>";
			}
			request.setAttribute("str", display);
			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			AdminService adminService = new AdminService();
			ArrayList<User> users = adminService.searchUserByArea(search);
			if (users.size() <= 0) {
				request.setAttribute("err", "No users at staying " + search);
				RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
				rd.forward(request, response);
				return;
			}
			String display = "";
			for(int i = 0; i < users.size(); i++) {
				display += "<div class=\"col-md-4 container\">"
						+ "<div class=\"card shadow-sm\">"
						+ "<div class=\"card-body\">"
						+ "<p class=\"card-text\">User ID: " + users.get(i).getUser_id() + "</p>"
						+ "<p class=\"card-text\">Username: " + users.get(i).getUsername() + "</p>"
						+ "<p class=\"card-text\">Email: " + users.get(i).getEmail() + "</p>"
						+ "<p class=\"card-text\">Role: " + users.get(i).getRole() + "</p>"
						+ "<p class=\"card-text\">Residential Area: " + users.get(i).getResidentialArea() + "</p>"
						+ "<form action=\"custEdit.jsp?id=" + users.get(i).getUser_id()
						+ "&username=" + users.get(i).getUsername() 
						+ "&password=" + users.get(i).getPassword() 
						+ "&role=" + users.get(i).getRole() 
						+ "&email=" + users.get(i).getEmail() 
						+ "&area=" + users.get(i).getResidentialArea()
						+ "\" method=\"post\"><input class=\"btn-success\" type=\"submit\" value=\"edit\"></form>"
						+ "</div></div></div>";
			}
			request.setAttribute("str", display);
			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
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

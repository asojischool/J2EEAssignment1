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
import models.Tour;
import models.User;

/**
 * Servlet implementation class searchTour
 */
@WebServlet("/searchTour")
public class searchTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchTour() {
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
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
			return;
		}
		search = search.toLowerCase();
		if (button.equals("Search By Tour Name")) {
			AdminService adminService = new AdminService();
			ArrayList<Tour> tours = adminService.searchTourByName(search);
			if (tours.size() <= 0) {
				request.setAttribute("err", "Tour not found");
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
				return;
			}
			String display = "";
			for(int i = 0; i < tours.size(); i++) {
				display += "<div class=\"col-md-4 container\">"
						+ "<div class=\"card shadow-sm\">"
						+ "<div class=\"card-body\">"
						+ "<p class=\"card-text\">Tour ID:" + tours.get(i).getTourID() + "</p>"
						+ "<p class=\"card-text\">Tour Name:" + tours.get(i).getTourName() + "</p>"
						+ "<p class=\"card-text\">Brief Description:" + tours.get(i).getBriefDescription() + "</p>"
						+ "<p class=\"card-text\">Price:" + tours.get(i).getPrice() + "</p>"
						+ "<p class=\"card-text\">Available Slots:" + tours.get(i).getAvailableSlots() + "</p>"
						+ "<form action=\"adminEdit.jsp?id=" + tours.get(i).getTourID()
						+ "&name=" + tours.get(i).getTourName() 
						+ "&brief=" + tours.get(i).getBriefDescription()
						+ "&full=" + tours.get(i).getFullDescription()
						+ "&start=" + tours.get(i).getStartDate() 
						+ "&end=" + tours.get(i).getEndDate()
						+ "&location=" + tours.get(i).getLocation()
						+ "&price=" + tours.get(i).getPrice()
						+ "&slots=" + tours.get(i).getAvailableSlots()
						+ "&bought=" + tours.get(i).getToursBought()
						+ "&catID=" + tours.get(i).getCategoryID()
						+ "&image=" + tours.get(i).getImage()
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

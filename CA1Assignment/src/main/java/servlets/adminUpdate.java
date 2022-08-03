package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AdminService;

/**
 * Servlet implementation class adminUpdate
 */
@WebServlet("/adminUpdate")
public class adminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = request.getParameter("name");
		String briefDescription = request.getParameter("briefDescription");
		String fullDescription = request.getParameter("fullDescription");
		String priceStr = request.getParameter("price");
		String slotsStr = request.getParameter("slots");
		String catIDStr = request.getParameter("catID");
		String image = request.getParameter("image");
		
		if (name.equals("") || briefDescription.equals("") || fullDescription.equals("") || priceStr.equals("") || slotsStr.equals("") || catIDStr.equals("") || image.equals("")|| name == null || briefDescription == null || fullDescription == null || priceStr == null || slotsStr == null || catIDStr == null || image == null) {
			request.setAttribute("err", "Tour Update Failed");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
			return;
		}
		
		double price = Double.parseDouble(priceStr);
		int slots = Integer.parseInt(slotsStr);
		int catID = Integer.parseInt(catIDStr);
		
		AdminService adminService = new AdminService();
		int numRowsAffected = adminService.adminUpdate(id, name, briefDescription, fullDescription, price, slots, catID, image);
		
		if(numRowsAffected > 0) {
			request.setAttribute("successMsg", "Tour Successsfully Updated");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			request.setAttribute("err", "Tour Update Failed");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
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

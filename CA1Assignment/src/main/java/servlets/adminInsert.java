package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AdminService;

/**
 * Servlet implementation class adminInsert
 */
@WebServlet("/adminInsert")
public class adminInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("name");
		String briefDescription = request.getParameter("briefDescription");
		String fullDescription = request.getParameter("fullDescription");
		String priceStr = request.getParameter("price");
		int price = Integer.parseInt(priceStr);
		String slotsStr = request.getParameter("slots");
		int slots = Integer.parseInt(slotsStr);
		String catIDStr = request.getParameter("catID");
		int catID = Integer.parseInt(catIDStr);
		String image = request.getParameter("image");
		
		AdminService adminService = new AdminService();
		int numRowsAffected = adminService.adminInsert(name, briefDescription, fullDescription, price, slots, catID, image);
		
		response.sendRedirect("admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

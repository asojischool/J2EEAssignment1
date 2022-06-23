package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Tour;
import models.TourService;

/**
 * Servlet implementation class getTours
 */
@WebServlet("/getTours")
public class getTours extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTours() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryID = Integer.parseInt(request.getParameter("categoryID"));
		/*
		 * TourService tourService = new TourService(); ArrayList<Tour> tours =
		 * tourService.getToursByCategory(categoryID);
		 */

		HttpSession session = request.getSession();
		/* session.setAttribute("sessTours", tours); */
		session.setAttribute("sessCategoryID", categoryID);
		response.sendRedirect("tours.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

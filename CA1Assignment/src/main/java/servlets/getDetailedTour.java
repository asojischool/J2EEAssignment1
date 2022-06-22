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
 * Servlet implementation class getSingleTour
 */
@WebServlet("/getDetailedTour")
public class getDetailedTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDetailedTour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tourID = Integer.parseInt(request.getParameter("tourID"));
		TourService tourService = new TourService();
		Tour tour = tourService.getDetailedTour(tourID);

		HttpSession session = request.getSession();
		session.setAttribute("sessDetailedTour", tour);
		session.setAttribute("sessTourID", tourID);
		response.sendRedirect("detailedTour.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

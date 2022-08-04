package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartItem;
import models.TourService;

/**
 * Servlet implementation class updateCartQuantity
 */
@WebServlet("/updateCartQuantity")
public class updateCartQuantity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCartQuantity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		TourService tourService = new TourService();
		
		//check if user is logged in
		Integer userID = (Integer) session.getAttribute("sessID");
		if (userID == null) {
			request.setAttribute("err", "Please login to use the cart");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		String action = request.getParameter("action");
		String tempCartIdx = request.getParameter("id");
		@SuppressWarnings("unchecked")
		ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
		int cartIdx = Integer.parseInt(tempCartIdx);
		
		// check if cart exist
		if(cart == null || cart.size() == 0) {
			response.sendRedirect("cart.jsp");
			return;
		}
		
		// check if tour exist
		if(tourService.getDetailedTour(cart.get(cartIdx).getTourID()) == null) {
			// if tour not exist, delete
			cart.remove(cartIdx);
			request.setAttribute("errMsg", "Tour is not found! Removed tour from cart");
			RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
			rd.forward(request, response);
			return;
		}
		
		// check cartItem exist
		if(cart.get(cartIdx) == null) {
			response.sendRedirect("cart.jsp");
		}
		
		if (action != null && cartIdx >= 0) {
			if (action.equals("inc")) {
				CartItem cartItem = cart.get(cartIdx);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cart.set(cartIdx, cartItem);
			}

			if (action.equals("dec")) {
				CartItem cartItem = cart.get(cartIdx);
				
				if(cartItem.getQuantity() <= 1) {
					// make sure item does not go below 1
				} else {
					cartItem.setQuantity(cartItem.getQuantity() - 1);
					cart.set(cartIdx, cartItem);
				}
			}
			response.sendRedirect("cart.jsp");
			
		} else {
			response.sendRedirect("cart.jsp");
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

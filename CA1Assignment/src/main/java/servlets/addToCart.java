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
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		TourService tourService = new TourService();
		
		// check if user is login
		Integer userID = (Integer) session.getAttribute("sessID");
		if (userID == null) {
			request.setAttribute("err", "Please login to use the cart");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		
		int tourID = 0;
		int quantity = 0;
		
		try {
			tourID = Integer.parseInt((String) request.getParameter("tourID"));
		} catch (NumberFormatException e) {
			response.sendRedirect("cart.jsp");
			return;
		}
		
		try {
			quantity = Integer.parseInt((String) request.getParameter("quantity"));
		} catch (NumberFormatException e) {
			response.sendRedirect("cart.jsp");
			return;
		}
		
		Boolean dup = false;
		int cartIdx = 0;
		
		// check if tour is available or not
		if(tourService.getDetailedTour(tourID) == null) {
			request.setAttribute("errMsg", "Tour not found");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			return;
		}
		
		// CartItem cartItem = new CartItem(tourID, quantity);
		if (session.getAttribute("cart") == null) {
			ArrayList<CartItem> cart = new ArrayList<CartItem>();
			cart.add(new CartItem(tourID, quantity));
			session.setAttribute("cart", cart);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
			for (int i = 0; i < cart.size(); i++) {
				if(cart.get(i).getTourID() == tourID) {
					dup = true;
					cartIdx = i;
					break;
				}
			}
			if(dup) {
				CartItem cartItem = cart.get(cartIdx);
				cartItem.setQuantity(cart.get(cartIdx).getQuantity() + quantity);
				cart.set(cartIdx, cartItem);
				session.setAttribute("cart", cart);
			} else {
				cart.add(new CartItem(tourID, quantity));
				session.setAttribute("cart", cart);
			}
		}
		response.sendRedirect("detailedTour.jsp?tourID=" + tourID);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

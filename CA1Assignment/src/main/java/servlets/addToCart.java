package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartItem;

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
		
//		String tourID = request.getParameter("tourID");
//		String quantity = request.getParameter("quantity");
//		System.out.println("Tour ID: " + tourID + ", Quantity: " + quantity);
		
		Integer tourID = Integer.parseInt((String) request.getParameter("tourID"));
		Integer quantity = Integer.parseInt((String) request.getParameter("quantity"));
		
		// CartItem cartItem = new CartItem(tourID, quantity);
		if (session.getAttribute("cart") == null) {
			ArrayList<CartItem> cart = new ArrayList<CartItem>();
			cart.add(new CartItem(tourID, quantity));
			session.setAttribute("cart", cart);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
			cart.add(new CartItem(tourID, quantity));
			session.setAttribute("cart", cart);
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

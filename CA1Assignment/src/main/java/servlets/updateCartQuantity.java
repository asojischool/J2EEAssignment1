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
		
		String action = request.getParameter("action");
		String tempCartIdx = request.getParameter("id");
		ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
		int cartIdx = Integer.parseInt(tempCartIdx);
		
		if (action != null && cartIdx >= 0) {
			if (action.equals("inc")) {
				CartItem cartItem = cart.get(cartIdx);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cart.set(cartIdx, cartItem);
			}

			if (action.equals("dec")) {
				CartItem cartItem = cart.get(cartIdx);
				cartItem.setQuantity(cartItem.getQuantity() - 1);
				cart.set(cartIdx, cartItem);
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

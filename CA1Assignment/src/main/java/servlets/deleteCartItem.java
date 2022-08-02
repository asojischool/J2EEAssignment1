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
 * Servlet implementation class deleteCartItem
 */
@WebServlet("/deleteCartItem")
public class deleteCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteCartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();
		String tempCartIdx = request.getParameter("cartIdx");
		
		if (tempCartIdx != null) {
			ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
			if (cart != null) {
				int cartIdx = Integer.parseInt(tempCartIdx);
				cart.remove(cartIdx);
			}
			response.sendRedirect("cart.jsp");

		} else {
			response.sendRedirect("cart.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import models.CartItem;
import models.Order;
import models.OrderService;
import models.Tour;
import models.TourService;
import models.User;
import models.UserService;

/**
 * Servlet implementation class handleCheckOut
 */
@WebServlet("/handleCheckOut")
public class handleCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public handleCheckOut() {
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

		HttpSession httpsession = request.getSession();

		// check if user is login
		Integer userID = (Integer) httpsession.getAttribute("sessID");
		if (userID == null) {
			request.setAttribute("err", "Please login to use the cart");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}

		Stripe.apiKey = "sk_test_51LT20rCy5NbdsQbiphBWyagbPUthyZoFH33NjjAyM7319NHcVz7aKzCB4EVRrxp3Ps7w8n4ETsgDqMTWCcr0I61l00BPlFJRcL";
		Session session = null;
		try {
			session = Session.retrieve((String) httpsession.getAttribute("stripeID"));
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(session == null) {
			response.sendRedirect("cart.jsp");
			return;
		}
		if (session.getPaymentStatus() == "paid" || session.getPaymentStatus().equalsIgnoreCase("paid")) {
			ArrayList<CartItem> cart = (ArrayList<CartItem>) httpsession.getAttribute("cart");
			TourService tourService = new TourService();
			UserService userService = new UserService();
			OrderService orderService = new OrderService();
			Order order = new Order();

			for (int i = 0; i < cart.size(); i++) {
				CartItem cartItem = cart.get(i);
				Tour tour = tourService.getDetailedTour(cartItem.getTourID());
				User user = userService.getUserByID(userID);
				
				order.setTourID(cartItem.getTourID());
				order.setUserID(user.getUser_id());
				order.setTourName(tour.getTourName());
				order.setUserName(user.getUsername());
				order.setPrice(tour.getPrice());
				order.setQuantity(cartItem.getQuantity());
				orderService.insertOrder(order);
			}
			
			httpsession.removeAttribute("cart");
			httpsession.removeAttribute("stripeID");
			request.setAttribute("successMsg", "Payment Successful");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			return;
		} else {
			response.sendRedirect("cart.jsp");
			return;
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

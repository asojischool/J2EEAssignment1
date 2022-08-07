package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData.Recurring;

/**
 * Servlet implementation class checkOut
 */
@WebServlet("/checkOut")
public class checkOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// make requests
			HttpSession httpsession = request.getSession();
			
			Stripe.apiKey = "sk_test_51LT20rCy5NbdsQbiphBWyagbPUthyZoFH33NjjAyM7319NHcVz7aKzCB4EVRrxp3Ps7w8n4ETsgDqMTWCcr0I61l00BPlFJRcL";
			System.out.println("making request");

			String YOUR_DOMAIN = "http://localhost:8080";
			
			System.out.println(request.getContextPath());
			
			String currency = request.getParameter("currency");
			String totalCost = request.getParameter("totalCost");
			
			long price = 0L;
			
			if(currency == null || totalCost == null) {
				response.sendRedirect("cart.jsp");
				return;
			} else {
				try {
					price = (long) (Double.parseDouble(totalCost) * 100) ;
				} catch (Exception e) {
					response.sendRedirect("cart.jsp");
					return;
				}
			}

			SessionCreateParams params = SessionCreateParams.builder().setMode(SessionCreateParams.Mode.PAYMENT)
					.setSuccessUrl(YOUR_DOMAIN + request.getContextPath() + "/handleCheckOut").setCancelUrl(
							YOUR_DOMAIN + request.getContextPath() + "/cart.jsp")
					.addLineItem(
							SessionCreateParams.LineItem.builder().setQuantity(1L)
									.setPriceData(
											SessionCreateParams.LineItem.PriceData.builder().setCurrency(currency)
													.setUnitAmount(price)
													.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
															.builder().setName("Tour").build())
													.build())
									.build())
					.build();
			Session session = Session.create(params);

			httpsession.setAttribute("stripeID", session.getId());
			
			response.sendRedirect(session.getUrl());
			return;

		} catch (Exception e) {
			e.printStackTrace();
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

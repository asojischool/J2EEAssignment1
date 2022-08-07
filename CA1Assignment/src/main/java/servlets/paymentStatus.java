package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonSyntaxException;
import com.stripe.Stripe;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;

/**
 * Servlet implementation class paymentStatus
 */
@WebServlet("/paymentStatus")
public class paymentStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public paymentStatus() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		Stripe.apiKey = "sk_test_51LT20rCy5NbdsQbiphBWyagbPUthyZoFH33NjjAyM7319NHcVz7aKzCB4EVRrxp3Ps7w8n4ETsgDqMTWCcr0I61l00BPlFJRcL";
		String endpointSecret = "whsec_f1ee47e5c686efbf01e8d75d3243b1deb1c21f99f1666f2b0264fd964fb27d5e";
		
		BufferedReader payload = request.getReader();
		String line = payload.lines().collect(Collectors.joining());
//		System.out.println(payload.toString());
		System.out.println("Got payload: " + line);

		String sigHeader = request.getHeader("Stripe-Signature");
		
		System.out.println(sigHeader);
		
		Event event = null;

		try {
			event = Webhook.constructEvent(line, sigHeader, endpointSecret);
		} catch (JsonSyntaxException e) {
			// Invalid payload
			response.setStatus(400);
			return;
		} catch (SignatureVerificationException e) {
			// Invalid signature
			response.setStatus(400);
			return;
		}

		response.setStatus(200);
		return;
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

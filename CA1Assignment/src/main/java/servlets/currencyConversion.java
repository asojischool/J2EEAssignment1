package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.*;

/**
 * Servlet implementation class currencyConversion
 */
@WebServlet("/currencyConversion")
public class currencyConversion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public currencyConversion() {
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
		
		String selectedCurrency = request.getParameter("selectCurrency");
		String totalValue = request.getParameter("totalValue");
		
		String amount = "1000";
		String to = "USD";
		String from = "SGD";
		String api_key = "mE4FTDJmCLLzRaVYEZ4ZPqs4pgWJY508";
		
		if(selectedCurrency == null) {
			response.sendRedirect("cart.jsp");
			return;
		} else {
			to = selectedCurrency.toUpperCase();
		}
		
		if(totalValue == null) {
			response.sendRedirect("cart.jsp");
			return;
		} else {
			amount = totalValue;
		}
		
		Client client = ClientBuilder.newClient();
		String restUrl = "https://api.apilayer.com/exchangerates_data";
		WebTarget target = client.target(restUrl).path("convert").queryParam("to", to).queryParam("from", from).queryParam("amount", amount);
		
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON).header("apikey", api_key);
		Response resp = invocationBuilder.get();
		System.out.println("status: " + resp.getStatus());
		
		// https://stackoverflow.com/questions/18086621/read-response-body-in-jax-rs-client-from-a-post-request 
		if (resp.getStatus() == Response.Status.OK.getStatusCode()) {
			System.out.println("success");
			
			String result = (String)resp.readEntity(String.class);
			
			JSONObject jsonObject = new JSONObject(result);
			double convertedMoney = jsonObject.getDouble("result");
			JSONObject info = jsonObject.getJSONObject("info");
			double rates = info.getDouble("rate");
			
			System.out.println(convertedMoney);
			System.out.println(rates);
			
			session.setAttribute("currency", to);
			session.setAttribute("rates", rates);
			response.sendRedirect("cart.jsp");
		} else {
			System.out.println("failed");
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

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AdminService;
import models.Order;
import models.OrderService;
import models.Spending;
import models.User;

/**
 * Servlet implementation class userInquiry
 */
@WebServlet("/userInquiry")
public class userInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userInquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		AdminService adminService = new AdminService();
		ArrayList<User> users = adminService.userList();
		OrderService orderService = new OrderService();
		ArrayList<Spending> spendings = new ArrayList<Spending>();
		String display = "";
		for (int i = 0; i < users.size(); i++) {
			double total = 0;
			int uid = users.get(i).getUser_id();
			ArrayList<Order> orders = orderService.getSalesHistory(uid);
			Spending spending = new Spending();
			String username = users.get(i).getUsername();
			if (orders.size() > 0) {
				for (int j = 0; j < orders.size(); j++) {
					total += orders.get(j).getPrice() * orders.get(j).getQuantity();
					spending.setSpending(total);
				}
				spending.setUserID(uid);
				spending.setUsername(username);
				spendings.add(spending);
			}
		}
		for (int i= 0; i < spendings.size(); i++) {
			
			display +=  "<div class=\"col-md-4 container\">"
					+ "<div class=\"card shadow-sm\">"
					+ "<div class=\"card-body\">"
					+ "<p class=\"card-text\">User ID:" + spendings.get(i).getUserID() + "</p>"
					+ "<p class=\"card-text\">Username:" + spendings.get(i).getUsername() + "</p>"
					+ "<p class=\"card-text\">Total Spent:$" + spendings.get(i).getSpending() + "</p>"
					+ "</div></div></div>";
		}
		request.setAttribute("str", display);
		RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

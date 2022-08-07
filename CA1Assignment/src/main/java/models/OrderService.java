package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderService {
	public ArrayList<Order> getSalesHistory(int userID) {

		ArrayList<Order> orders = new ArrayList<Order>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);

			String sqlStr = "SELECT * FROM orders WHERE user_id=?"; 
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();

			// check resultset

			while (rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbUserID = rs.getString("user_id");
				String dbTourName = rs.getString("tour_name");
				double dbPrice = rs.getDouble("price");
				int dbQuantity = rs.getInt("quantity");
				String dbDate = rs.getString("date");
				
				Order order = new Order();
				order.setTourName(dbTourName);
				order.setPrice(dbPrice);
				order.setDate(dbDate);
				order.setQuantity(dbQuantity);
				orders.add(order);
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		
		return orders;
	}
}

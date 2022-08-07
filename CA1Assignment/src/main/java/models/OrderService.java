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
				String dbDate = rs.getString("created_at");
				
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
	
	public int insertOrder(Order order) {

		int rowsAffected = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);

			
			String sqlStr = "INSERT INTO orders (tour_id, user_id, tour_name, user_name, price, quantity) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setInt(1, order.getTourID());
			ps.setInt(2, order.getUserID());
			ps.setString(3, order.getTourName());
			ps.setString(4, order.getUserName());
			ps.setDouble(5, order.getPrice());
			ps.setInt(6, order.getQuantity());
			rowsAffected = ps.executeUpdate();

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		
		return rowsAffected;
	}
}

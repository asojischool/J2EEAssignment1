package models;

import java.sql.*;
import java.util.ArrayList;

public class AdminService {
	public String adminView() {
		ArrayList<Tour> tours = new ArrayList<Tour>();
		String tourStr = "<table class=\"row d-flex justify-content-center height height align-content-center\"><tr><td class=\"box shadow bg-white p-4\">Tour ID</td><td class=\"box shadow bg-white p-4\">Tour Name</td><td class=\"box shadow bg-white p-4\">Edit</td>";
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM tour";
			
			ResultSet rs = stmt.executeQuery(sqlStr);
			while (rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbName = rs.getString("tour_name");
				String dbBriefDescription = rs.getString("brief_description");
				String dbFullDescription = rs.getString("detail_description");
				int dbPrice = rs.getInt("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				tours.add(new Tour(dbID, dbName, dbBriefDescription, dbFullDescription, dbPrice, dbAvailableSlots,
						dbCategoryID, dbImage));
				tourStr += "<tr><td class=\"box shadow bg-white p-4\">" + dbID + "</td><td class=\"box shadow bg-white p-4\">" + dbName +
						"</td><td class=\"box shadow bg-white p-4\"><form action=\"adminEdit.jsp?id=" + 
						dbID + "&name=" + dbName + "\" method=\"post\"><input type=\"submit\" value=\"edit\"></form></td></tr>";
			}
			tourStr += "</table>";
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return tourStr;
	}
	public int adminDelete(int id) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "DELETE FROM tour WHERE tour_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setInt(1, id);
			numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				System.out.print("success");
			}
			conn.close();	
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return numRowsAffected;
	}
	public int adminUpdate(int id, String name, String briefDescription, String fullDescription, int price, int slots, int catID, String image) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "Update tour SET tour_name=?, brief_description=?, detail_description=?, price=?, available_slots=?, tour_category_id=?, image_location=? WHERE tour_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1,name);
			ps.setString(2,briefDescription);
			ps.setString(3,fullDescription);
			ps.setInt(4,price);
			ps.setInt(5,slots);
			ps.setInt(6,catID);
			ps.setString(7,image);
			ps.setInt(8,id);
			numRowsAffected = ps.executeUpdate();
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return numRowsAffected;
	}
	public int adminInsert(String name, String briefDescription, String fullDescription, int price, int slots, int catID, String image) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "INSERT INTO tour (tour_name, brief_description, detail_description, price, available_slots, tour_category_id, image_location) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1, name);
			ps.setString(2, briefDescription);
			ps.setString(3, fullDescription);
			ps.setInt(4, price);
			ps.setInt(5, slots);
			ps.setInt(6, catID);
			ps.setString(7, image);
			numRowsAffected = ps.executeUpdate();
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return numRowsAffected;
	}
}

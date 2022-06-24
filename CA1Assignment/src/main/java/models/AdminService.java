package models;

import java.sql.*;
import java.util.ArrayList;

public class AdminService {
	public String adminView() {
		ArrayList<Tour> tours = new ArrayList<Tour>();
		String tourStr = "<table><tr><td>Tour ID</td><td>Tour Name</td><td>Edit</td>";
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
				tourStr += "<tr><td>" + dbID + "</td><td>" + dbName +
						"</td><td><form action=\"adminEdit.jsp?id=" + 
						dbID + "&name=" + dbName + "\" method=\"post\"><input type=\"submit\" value=\"edit\"></form></td></tr>";
			}
			tourStr += "</table>";
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return tourStr;
	}
}

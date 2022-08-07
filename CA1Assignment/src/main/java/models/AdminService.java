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
				double dbPrice = rs.getDouble("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
//				tours.add(new Tour(dbID, dbName, dbBriefDescription, dbFullDescription, dbPrice, dbAvailableSlots,
//						dbCategoryID, dbImage));
				tourStr += "<tr><td class=\"box shadow bg-white p-4\">" + dbID + "</td><td class=\"box shadow bg-white p-4\">" + dbName +
						"</td><td class=\"box shadow bg-white p-4\"><form action=\"adminEdit.jsp?id=" + 
						dbID + "&name=" + dbName + "&brief=" + dbBriefDescription + "&full=" + dbFullDescription + 
						"&price=" + dbPrice + "&slots=" + dbAvailableSlots + "&catID=" + dbCategoryID + "&image=" + dbImage +
						"\" method=\"post\"><input type=\"submit\" value=\"edit\"></form></td></tr>";
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
	public int adminUpdate(int id, String name, String briefDescription, String fullDescription, String start, String end, String location, double price, int slots, int bought, int catID, String image) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "Update tour SET tour_name=?, brief_description=?, detail_description=?, start_date=?, end_date=?, location=?, price=?, available_slots=?, tour_bought=?, tour_category_id=?, image_location=? WHERE tour_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1,name);
			ps.setString(2,briefDescription);
			ps.setString(3,fullDescription);
			ps.setString(4,start);
			ps.setString(5,end);
			ps.setString(6,location);
			ps.setDouble(7,price);
			ps.setInt(8,slots);
			ps.setInt(9,bought);
			ps.setInt(10,catID);
			ps.setString(11,image);
			ps.setInt(12,id);
			numRowsAffected = ps.executeUpdate();
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return numRowsAffected;
	}
	public int adminInsert(String name, String briefDescription, String fullDescription, String start, String end, String location, double price, int slots, int bought, int catID, String image) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "INSERT INTO tour (tour_name, brief_description, detail_description, start_date, end_date, location, price, available_slots, tours_bought, tour_category_id, image_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1, name);
			ps.setString(2, briefDescription);
			ps.setString(3, fullDescription);
			ps.setString(4, start);
			ps.setString(5, end);
			ps.setString(6, location);
			ps.setDouble(7, price);
			ps.setInt(8, slots);
			ps.setInt(9, bought);
			ps.setInt(10, catID);
			ps.setString(11, image);
			numRowsAffected = ps.executeUpdate();
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return numRowsAffected;
	}
	
	public String allUser () {
		ArrayList<User> users = new ArrayList<User>();
		String userStr = "<table class=\"row d-flex justify-content-center height height align-content-center\"><tr><td class=\"box shadow bg-white p-4\">User ID</td><td class=\"box shadow bg-white p-4\">User Name</td><td class=\"box shadow bg-white p-4\">Edit</td>";
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sqlStr);
			while (rs.next()) {
				int dbID = rs.getInt("user_id");
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");
				String dbRole = rs.getString("role");
				String dbEmail = rs.getString("email");
				String dbArea = rs.getString("residential_area");
//				users.add(new User(dbID, dbUsername, dbPassword, dbRole, dbEmail, dbArea)); 
				userStr += "<tr><td class=\"box shadow bg-white p-4\">" + dbID + "</td><td class=\"box shadow bg-white p-4\">" + dbUsername +
						"</td><td class=\"box shadow bg-white p-4\"><form action=\"custEdit.jsp?id=" + 
						dbID + "&username=" + dbUsername + "&password=" + dbPassword + "&role=" + dbRole + 
						"&email=" + dbEmail + "&area=" + dbArea + "\" method=\"post\"><input type=\"submit\" value=\"edit\"></form></td></tr>";
			}
			userStr += "</table>";
			conn.close();
			} catch (Exception e) {
				System.err.println("Error :" + e);
			}
			return userStr;
		}
	
	public int deleteUser (int id) {
		int numRowsAffected = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "DELETE FROM user WHERE user_id=?";
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
	
	public int updateUser(int id, String username, String password, String role, String email) {
		int numRowsAffected = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "Update user SET username=?, password=?, role=?, email=? WHERE user_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,role);
			ps.setString(4,email);
			ps.setInt(5,id);
			numRowsAffected = ps.executeUpdate();
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		
		return numRowsAffected;
	}
	
	public ArrayList<User> searchUserByName(String search) {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM user where username=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1,search);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int dbID = rs.getInt("user_id");
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");
				String dbRole = rs.getString("role");
				String dbEmail = rs.getString("email");
				String dbArea = rs.getString("residential_area");
				User user = new User();
				user.setUser_id(dbID);
				user.setUsername(dbUsername);
				user.setPassword(dbPassword);
				user.setRole(dbRole);
				user.setEmail(dbEmail);
				user.setResidentialArea(dbArea);
				users.add(user);
			}
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		
		return users;
	}
	
	public ArrayList<User> searchUserByArea(String search) {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM user where residential_area=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1,search);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int dbID = rs.getInt("user_id");
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");
				String dbRole = rs.getString("role");
				String dbEmail = rs.getString("email");
				String dbArea = rs.getString("residential_area");
				User user = new User();
				user.setUser_id(dbID);
				user.setUsername(dbUsername);
				user.setPassword(dbPassword);
				user.setRole(dbRole);
				user.setEmail(dbEmail);
				user.setResidentialArea(dbArea);
				users.add(user);
			}
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		
		return users;
	}
	
	public ArrayList<Tour> searchTourByName(String search) {
		ArrayList<Tour> tours = new ArrayList<Tour>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM tour where tour_name=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1,search);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbName = rs.getString("tour_name");
				String dbBrief = rs.getString("brief_description");
				String dbFull = rs.getString("detail_description");
				String dbStart = rs.getString("start_date");
				String dbEnd = rs.getString("end_date");
				String dbLocation = rs.getString("location");
				Double dbPrice = rs.getDouble("price");
				int dbSlots = rs.getInt("available_slots");
				int dbBought = rs.getInt("tours_bought");
				int dbCatID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				Tour tour = new Tour();
				tour.setTourID(dbID);
				tour.setTourName(dbName);
				tour.setBriefDescription(dbBrief);
				tour.setFullDescription(dbFull);
				tour.setStartDate(dbStart);
				tour.setEndDate(dbEnd);
				tour.setLocation(dbLocation);
				tour.setPrice(dbPrice);
				tour.setAvailableSlots(dbSlots);
				tour.setToursBought(dbBought);
				tour.setCategoryID(dbCatID);
				tour.setImage(dbImage);
				tours.add(tour);
			}
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		
		return tours;
	}
	
	public ArrayList<Tour> popularTour() {
		ArrayList<Tour> tours = new ArrayList<Tour>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM tour ORDER BY tours_bought DESC";
			PreparedStatement ps = conn.prepareStatement(sqlStr);;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbName = rs.getString("tour_name");
				String dbBrief = rs.getString("brief_description");
				String dbFull = rs.getString("detail_description");
				String dbStart = rs.getString("start_date");
				String dbEnd = rs.getString("end_date");
				String dbLocation = rs.getString("location");
				Double dbPrice = rs.getDouble("price");
				int dbSlots = rs.getInt("available_slots");
				int dbBought = rs.getInt("tours_bought");
				int dbCatID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				Tour tour = new Tour();
				tour.setTourID(dbID);
				tour.setTourName(dbName);
				tour.setBriefDescription(dbBrief);
				tour.setFullDescription(dbFull);
				tour.setStartDate(dbStart);
				tour.setEndDate(dbEnd);
				tour.setLocation(dbLocation);
				tour.setPrice(dbPrice);
				tour.setAvailableSlots(dbSlots);
				tour.setToursBought(dbBought);
				tour.setCategoryID(dbCatID);
				tour.setImage(dbImage);
				tours.add(tour);
			}
			conn.close();
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		
		return tours;
	}
	
	public ArrayList<User> userList() {
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			String sqlStr = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sqlStr);
			while (rs.next()) {
				int dbID = rs.getInt("user_id");
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");
				String dbRole = rs.getString("role");
				String dbEmail = rs.getString("email");
				String dbArea = rs.getString("residential_area");
				User user = new User();
				user.setUser_id(dbID);
				user.setUsername(dbUsername);
				user.setPassword(dbPassword);
				user.setRole(dbRole);
				user.setEmail(dbEmail);
				user.setResidentialArea(dbArea);
				users.add(user);
			}
			conn.close();
			} catch (Exception e) {
				System.err.println("Error :" + e);
			}
		return users;
	}
}

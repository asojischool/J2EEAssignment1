package models;

import java.sql.*;
import java.util.ArrayList;

public class UserService {
	public User verifyUser(String username, String password) {
		
		User user = null;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			conn = DriverManager.getConnection(connURL);
	
	        String sqlStr = "SELECT * FROM user WHERE username=? AND password=?";
	        PreparedStatement ps = conn.prepareStatement(sqlStr);
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();
	        
	        int dbID = 0;
	        String dbName = "";
	        String dbPassword = "";
	        String dbRole = "";
	        String dbEmail = "";
	        
	        // check resultset
	        if(rs.next()){
	        	dbID = rs.getInt("user_id");
	        	dbName = rs.getString("username");
	        	dbPassword = rs.getString("password");
	        	dbRole = rs.getString("role");
	        	dbEmail = rs.getString("email");
	        }
	        
	        if(username.equals(dbName) && password.equals(dbPassword)) {
	        	user = new User(dbID, dbName, dbPassword, dbRole, dbEmail);
	        }
		} catch (Exception e) {
			System.out.println("Error :" + e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Error :" + e);
			}
		}
		
		return user;
	}
	
	public int registerUser(String username, String password, String role, String email) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			String sqlStr = "INSERT INTO User(username, password, role, email) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, role);
			ps.setString(4, email);
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
	
	public int updateUser(String username, String password, String email, int userID) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			String sqlStr = "UPDATE user SET username=?, password=?, email=? WHERE user_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setInt(4, userID);
			numRowsAffected = ps.executeUpdate();
//			if(numRowsAffected > 0) {
				System.out.println(numRowsAffected);
//			}
			conn.close();
			
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return numRowsAffected;
	}
	
	public User getUserByID (int userID) {
		
		User loggedInUser = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			
	        String sqlStr = "SELECT * FROM user WHERE user_id=?";
	        PreparedStatement ps = conn.prepareStatement(sqlStr);
	        ps.setInt(1, userID);
	        
	        ResultSet rs = ps.executeQuery();
	        int dbID = 0;
	        String dbName = "";
	        String dbPassword = "";
	        String dbRole = "";
	        String dbEmail = "";
	        
	        // check resultset
	        if(rs.next()){
	        	dbID = rs.getInt("user_id");
	        	dbName = rs.getString("username");
	    	    dbPassword = rs.getString("password");
	    	    dbRole = rs.getString("role");
	    	    dbEmail = rs.getString("email");
	    	    loggedInUser = new User(dbID, dbName, dbPassword, dbRole, dbEmail);
	        }
	        
	        conn.close();
	        
		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		
		return loggedInUser;
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
				users.add(new User(dbID, dbUsername, dbPassword, dbRole, dbEmail));
				userStr += "<tr><td class=\"box shadow bg-white p-4\">" + dbID + "</td><td class=\"box shadow bg-white p-4\">" + dbUsername +
						"</td><td class=\"box shadow bg-white p-4\"><form action=\"custEdit.jsp?id=" + 
						dbID + "&username=" + dbUsername + "&password=" + dbPassword + "&role=" + dbRole + 
						"&email=" + dbEmail + "\" method=\"post\"><input type=\"submit\" value=\"edit\"></form></td></tr>";
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
	
	public int custUpdate(int id, String username, String password, String role, String email) {
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
}
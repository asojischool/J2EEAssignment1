package models;

import java.sql.*;

public class UserService {
	public User verifyUser(String username, String password) {
		
		User loggedInUser = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
	
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
	        	System.out.println("correctCredential");
	        	loggedInUser = new User(dbID, dbName, dbPassword, dbRole, dbEmail);
	        } else {
	        	System.out.println("wrongCredential");
	        	//error page
	        }
	        
	        conn.close();
	        
		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		
		return loggedInUser;
	}
	
	public int registerUser(String username, String password, String role, String email) {
		int numRowsAffected = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
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
			if(numRowsAffected > 0) {
				System.out.print("success");
			}
			conn.close();
			
			} catch (Exception e) {
			System.err.println("Error :" + e);
			}
		return numRowsAffected;
	}
	
	public User getUser (int userID) {
		
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
}
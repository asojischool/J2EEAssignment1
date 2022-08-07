 package models;

import java.sql.*;
import java.util.ArrayList;

public class CategoryService {
	public ArrayList<Category> getCategories() {

		ArrayList<Category> categories = new ArrayList<Category>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			
			Statement stmt = conn.createStatement();
			
			String sqlStr = "SELECT * FROM category";

			ResultSet rs = stmt.executeQuery(sqlStr);
			int dbCategoryID = 0;
			String dbCategoryName = "";
			String dbCategoryDescription = "";
			String dbCategoryImage = "";

			// check resultset
			
			while (rs.next()) {
				dbCategoryID = rs.getInt("category_id");
				dbCategoryName = rs.getString("category_name");
				dbCategoryDescription = rs.getString("category_description");
				dbCategoryImage = rs.getString("category_image");
				categories.add(new Category(dbCategoryID, dbCategoryName, dbCategoryDescription, dbCategoryImage));
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return categories;
	}
	
	public Category getDetailedCategory(int categoryID) {

		Category detailedCategory = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			
			String sqlStr = "SELECT * FROM category WHERE category_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setInt(1, categoryID);
			ResultSet rs = ps.executeQuery();

			// check resultset
			
			if (rs.next()) {
				int dbCategoryID = rs.getInt("category_id");
				String dbCategoryName = rs.getString("category_name");
				String dbCategoryDescription = rs.getString("category_description");
				String dbCategoryImage = rs.getString("category_image");
				detailedCategory = new Category(dbCategoryID, dbCategoryName, dbCategoryDescription, dbCategoryImage);
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return detailedCategory;
	}
	
	public String getCategoryName(int categoryID) {
		String dbCategoryName = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);
			
			String sqlStr = "SELECT category_name FROM category WHERE category_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setInt(1, categoryID);
			ResultSet rs = ps.executeQuery();

			// check resultset
			
			if (rs.next()) {
				dbCategoryName = rs.getString("category_name");
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return dbCategoryName;
	}
	
	public String capitalizeWord(String str){  
	    String words[] = str.split("\\s");  
	    String capitalizeWord="";  
	    for(String w:words){  
	        String first=w.substring(0,1);  
	        String afterfirst=w.substring(1);  
	        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
	    }  
	    return capitalizeWord.trim();  
	}  
}

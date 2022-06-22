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
}

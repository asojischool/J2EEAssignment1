package models;

import java.sql.*;
import java.util.ArrayList;

public class TourService {
	public ArrayList<Tour> getAllTours() {

		ArrayList<Tour> tours = new ArrayList<Tour>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);

			Statement stmt = conn.createStatement();

			String sqlStr = "SELECT * FROM tours";

			ResultSet rs = stmt.executeQuery(sqlStr);
			// check resultset

			while (rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbName = rs.getString("tour_name");
				String dbBriefDescription = rs.getString("brief_description");
				String dbFullDescription = rs.getString("detail_description");
				double dbPrice = rs.getDouble("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				tours.add(new Tour(dbID, dbName, dbBriefDescription, dbFullDescription, dbPrice, dbAvailableSlots,
						dbCategoryID, dbImage));
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return tours;
	}

	public ArrayList<Tour> getToursByCategory(int categoryID) {

		ArrayList<Tour> tours = new ArrayList<Tour>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);

			String sqlStr = "SELECT * FROM tour WHERE tour_category_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setInt(1, categoryID);
			ResultSet rs = ps.executeQuery();

			// check resultset

			while (rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbName = rs.getString("tour_name");
				String dbBriefDescription = rs.getString("brief_description");
				String dbFullDescription = rs.getString("detail_description");
				double dbPrice = rs.getDouble("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				tours.add(new Tour(dbID, dbName, dbBriefDescription, dbFullDescription, dbPrice, dbAvailableSlots,
						dbCategoryID, dbImage));
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return tours;
	}
	
	public Tour getDetailedTour(int tourID) {

		Tour detailedTour = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connURL = "jdbc:mysql://localhost/tours?user=root&password=696969&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(connURL);

			String sqlStr = "SELECT * FROM tour WHERE tour_id=?";
			PreparedStatement ps = conn.prepareStatement(sqlStr);
			ps.setInt(1, tourID);
			ResultSet rs = ps.executeQuery();

			// check resultset

			if (rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbName = rs.getString("tour_name");
				String dbBriefDescription = rs.getString("brief_description");
				String dbFullDescription = rs.getString("detail_description");
				double dbPrice = rs.getDouble("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				detailedTour = new Tour(dbID, dbName, dbBriefDescription, dbFullDescription, dbPrice, dbAvailableSlots,
						dbCategoryID, dbImage);
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}

		return detailedTour;
	}
}

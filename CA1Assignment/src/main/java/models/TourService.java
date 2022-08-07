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

			String sqlStr = "SELECT * FROM tour";

			ResultSet rs = stmt.executeQuery(sqlStr);
			// check resultset

			while (rs.next()) {
				int dbID = rs.getInt("tour_id");
				String dbName = rs.getString("tour_name");
				String dbBriefDescription = rs.getString("brief_description");
				String dbFullDescription = rs.getString("detail_description");
				String dbStartDate = rs.getString("start_date");
				String dbEndDate = rs.getString("end_date");
				String dbLocation = rs.getString("location");
				double dbPrice = rs.getDouble("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbToursBought = rs.getInt("tours_bought");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				
				Tour tour = new Tour();
				tour.setTourID(dbID);
				tour.setTourName(dbName);
				tour.setBriefDescription(dbBriefDescription);
				tour.setFullDescription(dbFullDescription);
				tour.setStartDate(dbStartDate);
				tour.setEndDate(dbEndDate);
				tour.setLocation(dbLocation);
				tour.setPrice(dbPrice);
				tour.setAvailableSlots(dbAvailableSlots);
				tour.setToursBought(dbToursBought);
				tour.setCategoryID(dbCategoryID);
				tour.setImage(dbImage);
				
				tours.add(tour);
				System.out.println(tour.getTourID());
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
				String dbStartDate = rs.getString("start_date");
				String dbEndDate = rs.getString("end_date");
				String dbLocation = rs.getString("location");
				double dbPrice = rs.getDouble("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbToursBought = rs.getInt("tours_bought");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				
				Tour tour = new Tour();
				tour.setTourID(dbID);
				tour.setTourName(dbName);
				tour.setBriefDescription(dbBriefDescription);
				tour.setFullDescription(dbFullDescription);
				tour.setStartDate(dbStartDate);
				tour.setEndDate(dbEndDate);
				tour.setLocation(dbLocation);
				tour.setPrice(dbPrice);
				tour.setAvailableSlots(dbAvailableSlots);
				tour.setToursBought(dbToursBought);
				tour.setCategoryID(dbCategoryID);
				tour.setImage(dbImage);
				
				tours.add(tour);
			}

			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		
		return tours;
	}
	
	public Tour getDetailedTour(int tourID) {

		Tour detailedTour = new Tour();

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
				String dbStartDate = rs.getString("start_date");
				String dbEndDate = rs.getString("end_date");
				String dbLocation = rs.getString("location");
				double dbPrice = rs.getDouble("price");
				int dbAvailableSlots = rs.getInt("available_slots");
				int dbToursBought = rs.getInt("tours_bought");
				int dbCategoryID = rs.getInt("tour_category_id");
				String dbImage = rs.getString("image_location");
				
				detailedTour.setTourID(dbID);
				detailedTour.setTourName(dbName);
				detailedTour.setBriefDescription(dbBriefDescription);
				detailedTour.setFullDescription(dbFullDescription);
				detailedTour.setStartDate(dbStartDate);
				detailedTour.setEndDate(dbEndDate);
				detailedTour.setLocation(dbLocation);
				detailedTour.setPrice(dbPrice);
				detailedTour.setAvailableSlots(dbAvailableSlots);
				detailedTour.setToursBought(dbToursBought);
				detailedTour.setCategoryID(dbCategoryID);
				detailedTour.setImage(dbImage);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("Error :" + e);
		}
		return detailedTour;
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

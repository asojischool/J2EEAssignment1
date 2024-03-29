package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Tour {
	private int tourID;
	private String tourName;
	private String briefDescription;
	private String fullDescription;
	private String startDate;
	private String endDate;
	private String location;
	private double price;
	private int availableSlots;
	private int toursBought;
	private int categoryID;
	private String image;
	
	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}

	public int getToursBought() {
		return toursBought;
	}

	public void setToursBought(int toursBought) {
		this.toursBought = toursBought;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getDuration() {
		long daysDiff = 0;
		int days = 0;
		try {
		    LocalDate dateBefore = LocalDate.parse(this.getStartDate());
		    LocalDate dateAfter = LocalDate.parse(this.getEndDate());

		    // Approach 1
		    daysDiff = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		    days = (int)daysDiff;
		    
		}catch(Exception e){
		    e.printStackTrace();
		}
		
		return days;
	}
}

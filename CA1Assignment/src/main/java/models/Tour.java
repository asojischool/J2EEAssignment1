package models;

public class Tour {
	private int tour_id;
	private String tour_name;
	private String breifDescription;
	private String fullDescription;
	private int price;
	private int availableSlots;
	private int categoryID;
	private String image;
	
	public Tour(int tour_id, String tour_name, String breifDescription, String fullDescription, int price,
			int availableSlots, int categoryID, String image) {
		super();
		this.tour_id = tour_id;
		this.tour_name = tour_name;
		this.breifDescription = breifDescription;
		this.fullDescription = fullDescription;
		this.price = price;
		this.availableSlots = availableSlots;
		this.categoryID = categoryID;
		this.image = image;
	}

	public int getTour_id() {
		return tour_id;
	}

	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}

	public String getTour_name() {
		return tour_name;
	}

	public void setTour_name(String tour_name) {
		this.tour_name = tour_name;
	}

	public String getBreifDescription() {
		return breifDescription;
	}

	public void setBreifDescription(String breifDescription) {
		this.breifDescription = breifDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
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
	
	
	
}

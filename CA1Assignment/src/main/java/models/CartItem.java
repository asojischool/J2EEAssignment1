package models;

public class CartItem {
	private int tourID;
	private int quantity;
	
	public CartItem(int tourID, int quantity) {
		super();
		this.tourID = tourID;
		this.quantity = quantity;
	}

	public int getTourID() {
		return tourID;
	}

	public void setTourID(int tourID) {
		this.tourID = tourID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

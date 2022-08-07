package models;

public class Spending implements Comparable{
	int userID;
	double spending;
	String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getSpending() {
		return spending;
	}
	public void setSpending(double spending) {
		this.spending = spending;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

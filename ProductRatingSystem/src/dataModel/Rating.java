package dataModel;


public class Rating {

	// field
	private String consumerID, productID;
	private double rating;
	private int timestamp;

	//constructor
	public Rating( String consumerID, String productID, double rating, int timestamp ){
		this.consumerID = consumerID;
		this.productID = productID;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	public String getConsumerID() {
		return consumerID;
	}


	public void setConsumerID(String consumerID) {
		this.consumerID = consumerID;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public int getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	

}

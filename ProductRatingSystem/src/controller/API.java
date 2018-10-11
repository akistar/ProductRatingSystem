package controller;

import java.util.List;

public interface API {
	
	public int addConsumer(String consumerID);
	public int addProduct(String productID);
	public int addRating(String consumerID, String productID, double rating, int timestamp);
	// the products rated by a consumer
	public List<String> productsByAConsumer(String consumerID);
	// the consumers rated a product
	public List<String> consumersByAProduct(String productID);
	//the average rating of a consumer
	public double consumerAverageRating(String consumerID);

}

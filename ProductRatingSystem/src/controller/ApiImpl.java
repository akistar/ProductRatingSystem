package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataModel.Consumer;
import dataModel.Rating;
import dataModel.Product;


public class ApiImpl implements API {
	private Map<String, Consumer> consumers; //Indexed by consumerID
	private Map<String, Product> products;//Indexed by productID
	private Map<String, Rating> ratings; //Indexed by "consumerID-productID"

	@Override
	public int addConsumer(String consumerID) {
		if( consumers == null ) consumers = new HashMap<String, Consumer>();
		if(!consumers.containsKey(consumerID)) {
			Consumer consumer = new Consumer(consumerID);
			consumers.put(consumerID, consumer);

		}
		return consumers.size();
	}
	@Override
	public int addProduct(String productID) {
		if(products == null) products = new HashMap<String, Product>();
		if(!products.containsKey(productID)) {
			Product product = new Product(productID);
			products.put(productID, product);}
		return products.size();
	}

	@Override
	public int addRating(String consumerID, String productID, double ratingNum, int timestamp) {
		if(ratings == null) ratings = new HashMap<String, Rating>();
		String ratingId = consumerID+"-"+productID;
		Rating rating = new Rating(consumerID, productID, ratingNum, timestamp);
		ratings.put(ratingId, rating);
		return ratings.size();
	}
	
	@Override
	public List<String> productsByAConsumer(String consumerID) {
		List<String> products = new ArrayList<String>();
		for(String ratingKey: ratings.keySet()) {
			String pID = ratings.get(ratingKey).getProductID();
			String cID = ratings.get(ratingKey).getConsumerID();
			if(cID.equals(consumerID)) {
				products.add(pID);
			}
		}

		return products;
	}

	@Override
	public List<String> consumersByAProduct(String productID) {
		List<String> consumers = new ArrayList<String>();
		for(String ratingKey: ratings.keySet()) {
			String pID = ratings.get(ratingKey).getProductID();
			String cID = ratings.get(ratingKey).getConsumerID();
			if(pID.equals(productID)) {
				consumers.add(cID);
			}
		}
		return consumers;
	}

	@Override
	public double consumerAverageRating(String consumerID) {
		double sum = 0;
		double n = 0;
		for(String ratingKey: ratings.keySet()) {
			String cID = ratings.get(ratingKey).getConsumerID();
			double rNum = ratings.get(ratingKey).getRating();
			if(cID.equals(consumerID)) {
				sum = sum+rNum;
				n++;
			}
		}
		return sum/n;
	}



}

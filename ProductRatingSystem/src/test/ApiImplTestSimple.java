package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import controller.API;
import controller.ApiImpl;

public class ApiImplTestSimple {
	private Object[][] ratings=  {{"consumer1","product1", 5.0, 10001},
			{"consumer1","product2", 2.0, 10002},
			{"consumer1","product3", 3.0, 10003},
			{"consumer1","product4", 4.0, 10004},
			{"consumer1","product5", 5.0, 10005},
			{"consumer2","product1", 5.0, 10006},
			{"consumer3","product2", 5.0, 10007},
			{"consumer4","product2", 5.0, 10008}
			};
	private API api = new ApiImpl();
	@Test
	public void addRatingTest() {
		int ratingNum = -1;
		for(int i = 0; i< ratings.length; i++) {
			ratingNum = api.addRating((String)ratings[i][0], (String)ratings[i][1], (double)ratings[i][2], (int)ratings[i][3]);
			System.out.println(ratingNum);
		}
		assertTrue(ratingNum == 8);
	}
	
	@Test 
	public void productByAConsumerTest() {
		for(int i = 0; i< ratings.length; i++) {
			api.addRating((String)ratings[i][0], (String)ratings[i][1], (double)ratings[i][2], (int)ratings[i][3]);
		}
		List<String> result = api.productsByAConsumer("consumer1");
		String[] expected = new String[] {"product1","product2","product3","product4","product5"};
		boolean isAllContains = false;
		for(String r: result) {
			isAllContains = Arrays.asList(expected).contains(r);
		}
		boolean equalLength = result.size()==expected.length;

		assertEquals(true, isAllContains&&equalLength);
	}
	
	@Test
	public void consumersByAProductTest() {
		for(int i = 0; i< ratings.length; i++) {
			api.addRating((String)ratings[i][0], (String)ratings[i][1], (double)ratings[i][2], (int)ratings[i][3]);
		}
		List<String> result = api.consumersByAProduct("product2");
		String[] expected = new String[] {"consumer1","consumer3","consumer4"};
		boolean isAllContains = false;
		for(String r: result) {
			isAllContains = Arrays.asList(expected).contains(r);
		}
		boolean equalLength = result.size()==expected.length;
		assertEquals(true, isAllContains&&equalLength);
	}
	
	@Test
	public void consumerAverageRatingTest() {
		for(int i = 0; i< ratings.length; i++) {
			api.addRating((String)ratings[i][0], (String)ratings[i][1], (double)ratings[i][2], (int)ratings[i][3]);
		}
		double result = api.consumerAverageRating("consumer1");

		System.out.println(result);
		double expected = 3.8;
		
		assertTrue(result == expected);
	}

}

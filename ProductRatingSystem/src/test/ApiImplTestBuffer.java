package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import controller.API;
import controller.ApiImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiImplTestBuffer {

	private final static String fileName = "testResources/ratings_product.txt";

	private static API api = new ApiImpl();


	@Test 
	public void addRatingTest() {
		int ratingNum = DatasetBuffer.addFile(fileName, "rating", api);
		int linesNum = DatasetBuffer.getNumberOfFileLines( fileName );	
		assertTrue(linesNum == ratingNum);
	}

	@Test
	public void addConsumerTest() {
		int consumersNum = DatasetBuffer.addFile(fileName,"consumers", api);
		assertEquals(consumersNum,826767);
	}

	@Test
	public void addProductTest() {
		int productNum = DatasetBuffer.addFile(fileName, "products", api);
		assertEquals(productNum, 50210);
	}

	@Test
	public void productByAConsumerTest() {
		DatasetBuffer.addFile(fileName, "rating", api);
		List<String> result = api.productsByAConsumer("A3LEQOLIXQU7KS");
		String[] expected = new String[] {"B00IUHNLZG","B00LA7IBOY","B00JAQFVJK","B00JAQFXCU","B00HK3RDPK","B00KQYCHJM",
				"B00IK5URPU","B00LIWF1GW","B00KB2PGT2","B00HNFLDL0","B009VJJIBI","B00LA8EFAW","B00JRMPL8I","B00KRHWVTY",
				"B00KGBQD5E","B00L45HS50","B00HNGGYPE","B00J4SYXPC","B00I9AZ7L0"};
		boolean isAllContains = false;
		for(String r: result) {
			isAllContains = Arrays.asList(expected).contains(r);
		}
		boolean equalLength = result.size()==expected.length;
		assertEquals(true, isAllContains&&equalLength);
	}

	@Test 
	public void consumersByAProductTest() {
		DatasetBuffer.addFile(fileName, "rating", api);
		List<String> result = api.consumersByAProduct("B00LGBJIQ4");
		String[] expected = new String[]{"AEEMJX418B5RC","A265KF0CQ058RZ","A20J2PMC9ZPD4F","”A3HMVWAGUCNA1K”"};
		boolean isAllContains = false;
		for(String r: result) {
			isAllContains = Arrays.asList(expected).contains(r);
		}
		boolean equalLength = result.size()==expected.length;
		assertEquals(true, isAllContains&&equalLength);
	}

	@Test
	public void consumerAverageRatingTest() {
		DatasetBuffer.addFile(fileName, "rating", api);
		double result = api.consumerAverageRating("A3LEQOLIXQU7KS");
		double expected = 3.4210526315789473;
		assertTrue(result==expected);
	}


}

package ca.ece.ubc.cpen221.mp5.restaurants.tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.junit.Test;

import ca.ece.ubc.cpen221.mp5.Restaurant;
import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class RestaurantDBTest {

//	@Test
//	public void constructRestaurantDBTest() {
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		assertEquals(true, true);
//	}
//	
//	@Test
//	public void getRestaurantTest() {
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		String restaurantJSONString = myRestaurantDB.getRestaurant("gclB3ED6uk6viWlolSb_uA");
//		assertEquals(true, restaurantJSONString.contains("gclB3ED6uk6viWlolSb_uA"));
//	}
//	
//	@Test
//	public void getRandomReviewTest() {
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		String reviewJSONString = myRestaurantDB.getRandomReview("Cafe 3");
//		assertEquals(true, reviewJSONString.contains("gclB3ED6uk6viWlolSb_uA"));
//	}
//	
//	@Test
//	public void addRestaurantTest() {
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		
//		try {
//			File file = new File("data/" + "addRestaurantTest.json");
//			FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			String line = bufferedReader.readLine();
//			myRestaurantDB.addRestaurant(line);
//			
//			fileReader.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		String restaurantJSONString = myRestaurantDB.getRestaurant("business_id");
//		assertEquals(true, restaurantJSONString.contains("business_id"));
//	}
//	
//	@Test
//	//Test if RestaurantDB doesn't add restaurant if restaurant is already added
//	public void addExistingRestaurantTest() {
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		
//		try {
//			File file = new File("data/" + "restaurants.json");
//			FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			String line = bufferedReader.readLine();
//			// Re-add line
//			assertEquals(false, myRestaurantDB.addRestaurant(line));
//			fileReader.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void getRestaurantsByNameTest() {
//		String name = "Jasmine Thai";
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		assertEquals(true, myRestaurantDB.getRestaurantsByName(name).get(0).contains(name));
//	}
//	
//	@Test
//	public void getRestaurantsByCategoryTest() {
//		String category = "Chinese";
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		for (Restaurant restaurant : myRestaurantDB.getRestaurantsByCategory(category)) {
//			System.out.println(restaurant.getJSONString());
//		}
//	}
	
//	@Test
//	public void getRestaurantsByNeighborhoodTest() {
//		String neighborhood = "Telegraph Ave";
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		System.out.println(myRestaurantDB.getRestaurantsByNeighborhood(neighborhood));
//	}
//	
//	@Test
//	public void getRestaurantsByPriceTest() {
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		System.out.println(myRestaurantDB.getRestaurantsByPrice(2, 4));
//	}
//	
//	@Test
//	public void getRestaurantsByRatingTest() {
//		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
//		System.out.println(myRestaurantDB.getRestaurantsByRating(2.0, 4.0));
//	}

	
	/*
	@Test
	public void queryTestIn() {
		String queryString = "in(\"Telegraph Ave\")";
		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
		Set<Restaurant> results = myRestaurantDB.query(queryString);
	}
	
	@Test
	public void queryTestCategory() {
		String queryString = "category(\"Thai\")";
		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
		Set<Restaurant> results = myRestaurantDB.query(queryString);
	}
	
	@Test
	public void queryTestName() {
		String queryString = "name(\"Cafe 3\")";
		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
		Set<Restaurant> results = myRestaurantDB.query(queryString);
	}
	
	@Test
	public void queryTestPrice() {
		String queryString = "price(1..2)";
		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
		Set<Restaurant> results = myRestaurantDB.query(queryString);
	}
	
	@Test
	public void queryTestRating() {
		String queryString = "rating(1..2)";
		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
		Set<Restaurant> results = myRestaurantDB.query(queryString);
	}
	*/
	
	@Test
	public void queryTestAnd() {
		String queryString = "in(\"UC Campus Area\") && price(2..5) && rating(2..4)";
		RestaurantDB myRestaurantDB = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
		Set<Restaurant> results = myRestaurantDB.query(queryString);
		for (Restaurant result : results) {
			System.out.println(result.getJSONString());
		}
	}
	
	
}

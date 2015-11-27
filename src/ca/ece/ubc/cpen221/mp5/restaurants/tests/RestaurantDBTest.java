package ca.ece.ubc.cpen221.mp5.restaurants.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.ece.ubc.cpen221.mp5.RestaurantDB;

public class RestaurantDBTest {

	@Test
	public void test() {
		RestaurantDB retaurantdb = new RestaurantDB("restaurants.json", "reviews.json", "users.json" );
		assertEquals(true, true);
	}

}

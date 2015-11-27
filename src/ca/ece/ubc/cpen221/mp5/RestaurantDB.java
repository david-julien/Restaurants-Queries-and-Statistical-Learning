package ca.ece.ubc.cpen221.mp5;

import java.io.*;
import java.util.*;

import org.json.simple.*;
// TODO: This class represents the Restaurant Database.
// Define the internal representation and 
// state the rep invariant and the abstraction function.

public class RestaurantDB {
	
	private List<Restaurant> restaurants;
	private List<Review> reviews;
	private List<User> users;

	/**
	 * Create a database from the Yelp dataset given the names of three files:
	 * <ul>
	 * <li>One that contains data about the restaurants;</li>
	 * <li>One that contains reviews of the restaurants;</li>
	 * <li>One that contains information about the users that submitted reviews.
	 * </li>
	 * </ul>
	 * The files contain data in JSON format.
	 * 
	 * @param restaurantJSONfilename
	 *            the filename for the restaurant data
	 * @param reviewsJSONfilename
	 *            the filename for the reviews
	 * @param usersJSONfilename
	 *            the filename for the users
	 */
	public RestaurantDB(String restaurantJSONfilename, String reviewsJSONfilename, String usersJSONfilename) {
		this.restaurants = new ArrayList<Restaurant>();
		
		parseRestaurants(restaurantJSONfilename);
		parseReviews(reviewsJSONfilename);
		parseUsers(usersJSONfilename);
	}

	public Set<Restaurant> query(String queryString) {
		// TODO: Implement this method
		// Write specs, etc.
		return null;
	}

	/**
	 * This method will read the file named in the argument and create a Restaurant object based on each JSON object
	 */
	private void parseRestaurants(String filename) {
		
		try {
			File file = new File("data/" + filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				JSONObject restaurantJSON = (JSONObject)JSONValue.parse(line);
				this.restaurants.add(new Restaurant(restaurantJSON));
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * This method will read the file named in the argument and create a Review object based on each JSON object
	 */
	private void parseReviews(String filename) {
		try {
			File file = new File("data/" + filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				JSONObject reviewJSON = (JSONObject)JSONValue.parse(line);
				this.reviews.add(new Review(reviewJSON));
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will read the file named in the argument and create a User object based on each JSON object
	 */
	private void parseUsers(String filename) {
		
	}

}

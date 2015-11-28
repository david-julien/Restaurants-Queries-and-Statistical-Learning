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
		this.users = new ArrayList<User>();
		this.reviews = new ArrayList<Review>();

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
	 * This method will read the file named in the argument and create a
	 * Restaurant object based on each JSON object
	 */
	private void parseRestaurants(String filename) {

		try {
			File file = new File("data/" + filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				addRestaurant(line);
			}
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will read the file named in the argument and create a Review
	 * object based on each JSON object
	 */
	private void parseReviews(String filename) {
		try {
			File file = new File("data/" + filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				addReview(line);
			}
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will read the file named in the argument and create a User
	 * object based on each JSON object
	 */
	private void parseUsers(String filename) {
		try {
			File file = new File("data/" + filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				addUser(line);
			}
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will add a restaurant to the database given the details in
	 * restaurant
	 * 
	 * @param restaurantJSON
	 *            containing the details about the restaurant to be added
	 * @return
	 */
	private void addRestaurant(String restaurant) {
		JSONObject restaurantJSON = (JSONObject) JSONValue.parse(restaurant);
		this.restaurants.add(new Restaurant(restaurantJSON));
	}
	
	/**
	 * This method will add a review to the database given the details in review
	 * 
	 * @param review
	 *            containing the details about the review to be added
	 * @return
	 */
	private void addReview(String review) {
		JSONObject reviewJSON = (JSONObject) JSONValue.parse(review);
		this.reviews.add(new Review(reviewJSON));
	}

	/**
	 * This method will add a user to the database given the details in user
	 * 
	 * @param user
	 *            containing the details about the user to be added
	 * @return
	 */
	private void addUser(String user) {
		JSONObject userJSON = (JSONObject) JSONValue.parse(user);
		this.users.add(new User(userJSON));
	}
	
	private Restaurant getRestaurant(String business_id) {
		for ()
	}

}

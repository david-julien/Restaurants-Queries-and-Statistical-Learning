package ca.ece.ubc.cpen221.mp5;

import java.io.*;
import java.util.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.RuleContext;
import org.json.simple.*;

// TODO: This class represents the Restaurant Database.
// Define the internal representation and 
// state the rep invariant and the abstraction function.

public class RestaurantDB {

	private final List<Restaurant> restaurants;
	private final List<Review> reviews;
	private final List<User> users;

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
		this.restaurants = Collections.synchronizedList(new ArrayList<Restaurant>());
		this.users = Collections.synchronizedList(new ArrayList<User>());
		this.reviews = Collections.synchronizedList(new ArrayList<Review>());

		parseRestaurants(restaurantJSONfilename);
		parseReviews(reviewsJSONfilename);
		parseUsers(usersJSONfilename);
	}

	public Set<Restaurant> query(String queryString) {
//		System.out.println("Query string is " + queryString);
		CharStream stream = new ANTLRInputStream(queryString);
		FormulaLexer lexer = new FormulaLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		FormulaParser parser = new FormulaParser(tokens);
		
		ParseTree tree = parser.root();
		System.out.println(tree.toStringTree(parser));
		
		ParseTreeWalker walker = new ParseTreeWalker();
		FormulaListener_FormulaCreator listener = new FormulaListener_FormulaCreator(this);
		FormulaPrintEverything printEverything = new FormulaPrintEverything();
		walker.walk(listener, tree);
//		walker.walk(printEverything, tree);
		
		((RuleContext)tree).inspect(parser);
		
		while (true) {
			
		}
		
//		return listener.getFormula();
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
	 * @param restaurant
	 *            containing the details about the restaurant to be added in
	 *            JSON format
	 * @return false if add unsuccessful, true otherwise
	 */
	public boolean addRestaurant(String restaurantJSONString) {
		Restaurant addedRestaurant = new Restaurant(restaurantJSONString);

		synchronized (this.restaurants) {
			for (Restaurant currentRestaurant : this.restaurants) {
				if (currentRestaurant.equals(addedRestaurant))
					return false;
			}
			this.restaurants.add(addedRestaurant);
			return true;
		}
	}

	/**
	 * This method will add a review to the database given the details in review
	 * 
	 * @param review
	 *            containing the details about the review to be added in JSON
	 *            format
	 * @return false if add unsuccessful, true otherwise
	 */
	public boolean addReview(String review) {
		JSONObject reviewJSON = (JSONObject) JSONValue.parse(review);
		Review addedReview = new Review(reviewJSON);

		synchronized (this.reviews) {
			for (Review currentReview : this.reviews) {
				if (currentReview.equals(addedReview))
					return false;
			}
			this.reviews.add(addedReview);
			return true;
		}
	}

	/**
	 * This method will add a user to the database given the details in user
	 * 
	 * @param user
	 *            containing the details about the user to be added in JSON
	 *            format
	 * @return false if add unsuccessful, true otherwise
	 */
	public boolean addUser(String user) {
		JSONObject userJSON = (JSONObject) JSONValue.parse(user);
		User addedUser = new User(userJSON);

		synchronized (this.users) {
			for (User currentUser : this.users) {
				if (currentUser.equals(addedUser))
					return false;
			}
			this.users.add(addedUser);
			return true;
		}
	}

	/**
	 * This thread-safe method returns a restaurant's JSON string given a
	 * business ID. Will return null if restaurant is not found.
	 * 
	 * @param business_id
	 *            that is the business id of the target restaurant
	 * @return the JSON string of the restaurant if found, null otherwise
	 */
	public Restaurant getRestaurant(String business_id) {
		synchronized (this.restaurants) {
			for (Restaurant restaurant : restaurants) {
				if (restaurant.getBusiness_id().equals(business_id)) {
					return new Restaurant(restaurant.getJSONString());
				}
			}
			return null;
		}
	}

	/**
	 * This thread-safe method returns a review's JSON string given a business
	 * ID. Will return null if restaurant is not found.
	 * 
	 * @param restaurantName
	 *            that is the restaurant name of the target restaurant
	 * @return the JSON string of the review if found, null otherwise
	 */
	public String getRandomReview(String restaurantName) {
		List<String> matches = Collections.synchronizedList(new ArrayList<String>());

		synchronized (this.reviews) {
			for (Review review : reviews) {
				Restaurant restaurant = this.getRestaurant(review.getBusiness_id());
				if (restaurant.getName().equals(restaurantName)) {
					matches.add(review.getJSONString());
				}
			}
		}

		if (!matches.isEmpty()) {
			Random r = new Random();
			int low = 0;
			int high = matches.size();
			int result = r.nextInt(high - low) + low;
			String random_review = matches.get(result);
			return random_review;
		} else {
			return null;
		}
	}

	/**
	 * This method returns a list of all the restaurants that have the name
	 * given by the argument to this method
	 * 
	 * @param name
	 *            of the target restaurants
	 * @return a list containing all the restaurants with the name of name
	 */
	public synchronized List<Restaurant> getRestaurantsByName(String name) {
		List<Restaurant> matches = new ArrayList<Restaurant>();
		
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getName().equals(name)) {
				matches.add(new Restaurant(restaurant.getJSONString()));
			}
		}
		return matches;
	}

	/**
	 * This method returns a list of all the restaurants that have the category
	 * given by the argument to this method
	 * 
	 * @param category
	 *            of the target restaurants
	 * @return a list containing all the restaurants with the category of
	 *         category
	 */
	public synchronized List<Restaurant> getRestaurantsByCategory(String category) {
		System.out.println(category);
		List<Restaurant> matches = new ArrayList<Restaurant>();
		
		for (Restaurant restaurant : restaurants) {
			if (restaurant.containsCategory(category)) {
				matches.add(new Restaurant(restaurant.getJSONString()));
			}
		}
		return matches;
	}

	/**
	 * This method returns a list of all the restaurants that are in the neighborhood
	 * given by the argument to this method
	 * 
	 * @param neighbourhood
	 *            of the target restaurants
	 * @return a list containing all the restaurants in the neighborhood of
	 *         neighborhood
	 */
	public synchronized List<Restaurant> getRestaurantsByNeighborhood(String neighborhood) {
		List<Restaurant> matches = new ArrayList<Restaurant>();
		
		for (Restaurant restaurant : restaurants) {
			if (restaurant.containsNeighborhood(neighborhood)) {
				matches.add(new Restaurant(restaurant.getJSONString()));
			}
		}
		
		return matches;
	}
	
	/**
	 * This method returns a list of all the restaurants that have the price
	 * given by the arguments to this method
	 * 
	 * @param low
	 *            the starting point of the price range
	 * @param high
	 *            the ending point of the price range
	 * 
	 * @return a list containing all the restaurants with the price given by the
	 *         arguments
	 */
	public synchronized List<Restaurant> getRestaurantsByPrice(long low, long high) {
		List<Restaurant> matches = new ArrayList<Restaurant>();
		
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getPrice() >= low && restaurant.getPrice() <= high)
				matches.add(new Restaurant(restaurant.getJSONString()));
		}
		
		return matches;
	}

	/**
	 * This method returns a list of all the restaurants that have the rating
	 * given by the arguments to this method
	 * 
	 * @param low
	 *            the starting point of the rating range
	 * @param high
	 *            the ending point of the rating range
	 * 
	 * @return a list containing all the restaurants with the rating given by
	 *         the arguments
	 */
	public synchronized List<Restaurant> getRestaurantsByRating(double low, double high) {
		List<Restaurant> matches = new ArrayList<Restaurant>();
		
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getStars() >= low && restaurant.getStars() <= high)
				matches.add(new Restaurant(restaurant.getJSONString()));
		}
		
		return matches;
	}

}

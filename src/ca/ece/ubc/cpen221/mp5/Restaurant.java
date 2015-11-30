package ca.ece.ubc.cpen221.mp5;

import java.util.*;

import org.json.simple.*;

/**
 * The Restaurant class represents a single restaurant as represented in the
 * Yelp. A Restaurant has public getters that retrieves a restaurant's
 * properties
 * 
 * Rep Invariant: Restaurant properties have to be valid according to their
 * definition. eg. state is a valid state in the US, price's range is from 1-5,
 * etc
 */
public class Restaurant {

	// Private constants that are restaurant properties
	private final boolean isOpen;
	private final String url;
	private final double longitude;
	private final List<String> neighborhoods;
	private final String business_id;
	private final String name;
	private final List<String> categories;
	private final String state;
	private final String type;
	private final double stars;
	private final String city;
	private final String fullAddress;
	private final long review_count;
	private final String photo_url;
	private final List<String> schools;
	private final double latitude;
	private final long price;
	
	private final String JSONData;

	// TODO: Change constructor argument
	Restaurant(String restaurantJSONString) {
		JSONObject restaurantJSON = (JSONObject) JSONValue.parse(restaurantJSONString);
		
		this.isOpen = (boolean) restaurantJSON.get("open");
		this.url = restaurantJSON.get("url").toString();
		this.longitude = (double) restaurantJSON.get("longitude");
		this.neighborhoods = Collections.synchronizedList((ArrayList<String>) restaurantJSON.get("neighborhoods"));
		this.business_id = restaurantJSON.get("business_id").toString();
		this.name = restaurantJSON.get("name").toString();
		this.categories = Collections.synchronizedList((ArrayList<String>) restaurantJSON.get("categories"));
		this.state = restaurantJSON.get("state").toString();
		this.type = restaurantJSON.get("type").toString();
		this.stars = (double) restaurantJSON.get("stars");
		this.city = restaurantJSON.get("city").toString();
		this.fullAddress = restaurantJSON.get("full_address").toString();
		this.review_count = (long) restaurantJSON.get("review_count");
		this.photo_url = restaurantJSON.get("photo_url").toString();
		this.schools = (ArrayList<String>) restaurantJSON.get("schools");
		this.latitude = (double) restaurantJSON.get("latitude");
		this.price = (long) restaurantJSON.get("price");
		this.JSONData = restaurantJSONString;
	}
	
	public String getJSONString() {
		return this.JSONData;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public String getUrl() {
		return url;
	}

	public double getLongitude() {
		return longitude;
	}

	private List<String> getNeighborhoods() {
		return neighborhoods;
	}

	public String getBusiness_id() {
		return business_id;
	}

	public String getName() {
		return name;
	}

	private List<String> getCategories() {
		return categories;
	}

	public String getState() {
		return state;
	}

	public String getType() {
		return type;
	}

	public double getStars() {
		return stars;
	}

	public String getCity() {
		return city;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public long getReview_count() {
		return review_count;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public List<String> getSchools() {
		return schools;
	}

	public double getLatitude() {
		return latitude;
	}

	public long getPrice() {
		return price;
	}
	
	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof Restaurant)) return false;
		Restaurant otherRestaurant = (Restaurant) otherObject;
		if (this.name.equals(otherRestaurant.getName()) 
				&& this.business_id.equals(otherRestaurant.getBusiness_id()) 
				&& this.latitude == otherRestaurant.getLatitude()
				&& this.longitude == otherRestaurant.getLongitude())
			return true;
		return false;
	}
	
	public int hashCode() {
		return (int) (this.longitude + this.latitude + this.stars + this.review_count + this.price);
	}
	
	public boolean containsCategory(String category) {
		return (this.getCategories().contains(category));
	}
	
	public boolean containsNeighborhood(String neighborhood) {
		return (this.getNeighborhoods().contains(neighborhood));
	}
}

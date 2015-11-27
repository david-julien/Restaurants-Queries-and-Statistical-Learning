package ca.ece.ubc.cpen221.mp5;

import java.util.*;
import org.json.simple.*;

// TODO: Use this class to represent a Yelp review.

public class Review {
	private final String type;
	private final String business_id;
	private final HashMap<String, Long> votes;
	private final String review_id;
	private final String text;
	private final long stars;
	private final String user_id;
	private final String date;
	
	public Review(JSONObject reviewJSON) {
		this.type = reviewJSON.get("type").toString();
		this.business_id = reviewJSON.get("business_id").toString();
		
		JSONObject votes = (JSONObject) reviewJSON.get("votes");
		this.votes = new HashMap<String, Long>();
		this.votes.put("cool", (long) votes.get("cool"));
		this.votes.put("useful", (long) votes.get("useful"));
		this.votes.put("funny", (long) votes.get("funny"));
		
		this.review_id = reviewJSON.get("review_id").toString();
		this.text = reviewJSON.get("text").toString();
		this.stars = (long) reviewJSON.get("stars");
		this.user_id = reviewJSON.get("user_id").toString();
		this.date = reviewJSON.get("date").toString();
	}

	public String getType() {
		return type;
	}

	public String getBusiness_id() {
		return business_id;
	}

	public HashMap<String, Long> getVotes() {
		return votes;
	}

	public String getReview_id() {
		return review_id;
	}

	public String getText() {
		return text;
	}

	public long getStars() {
		return stars;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getDate() {
		return date;
	}
}

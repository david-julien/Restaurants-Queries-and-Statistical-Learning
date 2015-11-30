package ca.ece.ubc.cpen221.mp5;

import java.util.*;
import org.json.simple.*;

public class User {
	private final String url;
	private final Map<String, Long> votes;
	private final long review_count;
	private final String type;
	private final String user_id;
	private final String name;
	private final double average_stars;
	
	User(JSONObject userJSON) {
		this.url = userJSON.get("url").toString();
		
		this.votes = new HashMap<String, Long>();
		JSONObject userVotesJSON = (JSONObject)JSONValue.parse(userJSON.get("votes").toString());
		votes.put("funny", (long)userVotesJSON.get("funny"));
		votes.put("useful", (long)userVotesJSON.get("useful"));
		votes.put("cool", (long)userVotesJSON.get("cool"));
		
		this.review_count = (long)userJSON.get("review_count");
		this.type = userJSON.get("type").toString();
		this.user_id = userJSON.get("user_id").toString();
		this.name = userJSON.get("name").toString();
		this.average_stars = (double)userJSON.get("average_stars");
	}
	
	public String getUrl() {
		return url;
	}
	
	public Map<String, Long> getVotes() {
		return votes;
	}
	
	public String getType() {
		return type;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAverage_stars() {
		return average_stars;
	}
	
	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof User)) return false;
		User otherUser = (User) otherObject;
		if (user_id.equals(otherUser.getUser_id()))
			return true;
		return false;
	}
	
	public int hashCode() {
		return (int)(this.average_stars + this.votes.get("funny") + this.votes.get("useful") + this.votes.get("cool"));
	}
	
}


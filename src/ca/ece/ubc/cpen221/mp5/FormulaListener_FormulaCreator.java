package ca.ece.ubc.cpen221.mp5;

import java.util.*;

import org.antlr.v4.runtime.tree.TerminalNode;

public class FormulaListener_FormulaCreator extends FormulaBaseListener {
	// Stack contains lists of matches from the given query
	Stack<List<Restaurant>> stack = new Stack<List<Restaurant>>();
	RestaurantDB restaurantDB;
	
	public FormulaListener_FormulaCreator(RestaurantDB restaurantDB) {
		this.restaurantDB = restaurantDB;
	}
	
	public void exitRoot(FormulaParser.RootContext ctx) {
		assert stack.size() == 1;
	}
	
	public Set<Restaurant> getFormula() {
		return new HashSet<Restaurant>(stack.get(0));
	}
	
	public void exitAtom(FormulaParser.AtomContext ctx) {
		if (stack.size() >= 2) {
			List<Restaurant> list_1	 = stack.pop();
			List<Restaurant> list_2 = stack.pop();
			List<Restaurant> result = this.intersection(list_1, list_2);
			this.stack.push(result);
		}
	}

	public void exitOrexpr(FormulaParser.OrexprContext ctx) {
		
	}
	
	public void exitAndexpr(FormulaParser.AndexprContext ctx) {
		//System.out.println(ctx.start.getType());
		System.out.println(ctx.AND());
	}
	
	public void exitIn(FormulaParser.InContext ctx) {
		TerminalNode token = ctx.STRING();
        String query = token.getText();
        query = query.replaceAll("^\"|\"$", "");
        List<Restaurant> restaurants = restaurantDB.getRestaurantsByNeighborhood(query);
        stack.push(restaurants);
	}
	
	
	public void exitCategory(FormulaParser.CategoryContext ctx) {
		TerminalNode token = ctx.STRING();
        String query = token.getText();
        query = query.replaceAll("^\"|\"$", "");
        List<Restaurant> restaurants = restaurantDB.getRestaurantsByCategory(query);
        stack.push(restaurants);
	}

	
	public void exitName(FormulaParser.NameContext ctx) {
		TerminalNode token = ctx.STRING();
        String query = token.getText();
        query = query.replaceAll("^\"|\"$", "");
        List<Restaurant> restaurants = restaurantDB.getRestaurantsByName(query);
        stack.push(restaurants);
	}
	
	
	public void exitRating(FormulaParser.RatingContext ctx) {
		TerminalNode token = ctx.RANGE();
        String query = token.getText();
        double rating_low = Double.parseDouble(Character.toString(query.charAt(0)));
        double rating_high = Double.parseDouble(Character.toString(query.charAt(3)));
        List<Restaurant> restaurants = restaurantDB.getRestaurantsByRating(rating_low, rating_high);
        stack.push(restaurants);
	}
	
	public void exitPrice(FormulaParser.PriceContext ctx) {
		TerminalNode token = ctx.RANGE();
        String query = token.getText();
        long price_low = Character.getNumericValue(query.charAt(0));
        long price_high = Character.getNumericValue(query.charAt(3));
        List<Restaurant> restaurants = restaurantDB.getRestaurantsByPrice(price_low, price_high);
        stack.push(restaurants); 
	}
	
	private List<Restaurant> intersection(List<Restaurant> list_1, List<Restaurant> list_2) {
		List<Restaurant> result = new ArrayList<Restaurant>();
		
//		System.out.println("List 1:\n");
//		for (Restaurant restaurant : list_1) {
//			System.out.println(restaurant.getJSONString());
//		}
//		
//		System.out.println("\n\nList 2:\n");
//		for (Restaurant restaurant : list_2) {
//			System.out.println(restaurant.getJSONString());
//		}
		
		for (Restaurant restaurant : list_1) {
			for (Restaurant restaurant_2 : list_2) {
				if (restaurant.equals(restaurant_2)) {
					result.add(restaurant_2);
				}
			}
		}
		
		return result;
	}
}

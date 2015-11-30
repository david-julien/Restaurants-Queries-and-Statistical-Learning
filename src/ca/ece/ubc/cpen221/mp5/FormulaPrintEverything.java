package ca.ece.ubc.cpen221.mp5;

public class FormulaPrintEverything extends FormulaBaseListener {
	public void enterRoot(FormulaParser.RootContext ctx) {
		System.err.println("entering root");
	}
	
	public void exitRoot(FormulaParser.RootContext ctx) {
		System.err.println("exiting root");
	}
	
	public void enterAtom(FormulaParser.AtomContext ctx) {
		System.err.println("entering atom");
	}
	
	public void exitAtom(FormulaParser.AtomContext ctx) {
		System.err.println("exiting atom");
	}
	
	public void enterOrexpr(FormulaParser.OrexprContext ctx) {
		System.err.println("entering orexpr");
	}
	
	public void exitOrexpr(FormulaParser.OrexprContext ctx) {
		System.err.println("exiting orexpr");
	}
	
	public void enterAndexpr(FormulaParser.AndexprContext ctx) {
		System.err.println("entering andexpr");
	}
	
	public void exitAndexpr(FormulaParser.AndexprContext ctx) {
		System.err.println("exiting andexpr");
	}
	
	public void enterIn(FormulaParser.InContext ctx) {
		System.err.println("entering in");
	}
	
	public void exitIn(FormulaParser.InContext ctx) {
		System.err.println("exiting in");
	}
	
	public void enterCategory(FormulaParser.CategoryContext ctx) {
		System.err.println("entering category");
	}
	
	public void exitCategory(FormulaParser.CategoryContext ctx) {
		System.err.println("exiting category");
	}
	
	public void enterName(FormulaParser.NameContext ctx) {
		System.err.println("entering name");
	}
	
	public void exitName(FormulaParser.NameContext ctx) {
		System.err.println("exiting name");
	}
	
	public void enterRating(FormulaParser.RatingContext ctx) {
		System.err.println("entering rating");
	}
	
	public void exitRating(FormulaParser.RatingContext ctx) {
		System.err.println("exiting rating");
	}
	
	public void enterPrice(FormulaParser.PriceContext ctx) {
		System.err.println("entering price");
	}
	
	public void exitPrice(FormulaParser.PriceContext ctx) {
		System.err.println("exiting price");
	}
}

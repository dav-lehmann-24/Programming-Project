public class Income {
	// Attributes of an income
	private String category;
	private double amount;
	private String description;
	
	// Constructor of an income
	public Income(String category, double amount, String description) {
		this.category = category;
		this.amount = amount;
		this.description = description;
	}
	
	// Returns the category
	public String getCategory() {
		return category;
	}
	
	// Returns the amount
	public double getAmount() {
		return amount;
	}
	
	// Returns the description
	public String getDescription() {
		return description;
	}
}

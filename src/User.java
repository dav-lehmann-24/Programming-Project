// Import libraries
import java.util.List;
import java.util.ArrayList;


public class User {
	// Attributes of an user
	String name;
	double startingBalance;
	double currentBalance;
	double savingGoal;
	List<Expense> expenses;
	List<Income> incomes;
	
	// Constructor of an user
	public User(String name, double startingBalance) {
		this.name = name;
		this.startingBalance = startingBalance;
		this.currentBalance = startingBalance;
		this.savingGoal = 0;
		this.expenses = new ArrayList<>();
		this.incomes = new ArrayList<>();
	}
	
	// Adds an expense and subtracts it from the current balance
	public void addExpense(String category, double amount, String description) {
		expenses.add(new Expense(category, amount, description));
		currentBalance -= amount;
	}
	
	// Sets a saving goal for an user
	public void setSavingGoal(double goal) {
		this.savingGoal = goal;
	}
	
	// Removes an expense according to the description, if there is any
	public boolean removeExpense(String description) {
		return expenses.removeIf(expense -> expense.getDescription().equalsIgnoreCase(description));
	}
	
	// Returns list of expenses of an user
	public List<Expense> getExpenses() {
		return expenses;
	}
	
	// Returns name of the user
	public String getName() {
		return name;
	}
	
	// Setting the current balance
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	// Returns the current balance
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	// Calculate the sum of all expenses of the user
	public double getTotalExpenses() {
		return expenses.stream().mapToDouble(Expense::getAmount).sum();
	}
	
	// Return the list of incomes of an user
	public List<Income> getIncomes() {
		return incomes;
	}
	
	// Adds an income and adds it to the current balance
	public void addIncome(String category, double amount, String description) {
		incomes.add(new Income(category, amount, description));
		currentBalance += amount;
	}
	
	// Removes an income according to the description, if there is any
	public boolean removeIncome(String description) {
		return incomes.removeIf(income -> income.getDescription().equalsIgnoreCase(description));
	}
	
	// Calculate the sum of all incomes of the user
	public double getTotalIncomes() {
		return incomes.stream().mapToDouble(Income::getAmount).sum();
	}
}

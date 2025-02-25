// Import libraries
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.util.List;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User chosenUser;
	private UserLogic logic;
	private JButton btnAddExpense;
	private JButton btnSetGoal;
	private JButton btnShowExpenses;
	private JLabel lblDetails;
	private JLabel lblCurrentUser;
	private JLabel lblCurrentBalance;
	private JLabel lblSavingGoal;
	private JLabel lblStartingBalance;
	private JLabel lblMoneyRemaining;
	private JButton btnDeleteExpense;
	private JButton btnAddIncome;
	private JButton btnDeleteIncome;
	private JButton btnShowIncomes;
	private JButton btnShowPieCharts;
	
	
	
	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	// Create the frame and design the GUI.
	public GUI() {
		logic = new UserLogic();
		setTitle("CashCompass");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Welcome to CashCompass!\r\n");
		lblTitle.setForeground(Color.RED);
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setBounds(0, 10, 784, 30);
		contentPane.add(lblTitle);
		
		JLabel lblSelect = new JLabel("Choose an action:");
		lblSelect.setForeground(Color.BLACK);
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setVerticalAlignment(SwingConstants.TOP);
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelect.setBounds(10, 60, 151, 30);
		contentPane.add(lblSelect);
		
		btnAddExpense = new JButton("Add expense");
		btnAddExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAddExpenseDialog();
			}
		});
		btnAddExpense.setForeground(Color.BLACK);
		btnAddExpense.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddExpense.setBounds(16, 453, 200, 30);
		btnAddExpense.setVisible(false);
		contentPane.add(btnAddExpense);
		
		btnSetGoal = new JButton("Set saving goal");
		btnSetGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openSetSavingGoalDialog();
			}
		});
		btnSetGoal.setForeground(Color.BLACK);
		btnSetGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSetGoal.setBounds(16, 253, 200, 30);
		btnSetGoal.setVisible(false);
		contentPane.add(btnSetGoal);
		
		JButton btnAddUser = new JButton("Add user");
		btnAddUser.setForeground(Color.BLACK);
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAddUserDialog();
			}
		});
		btnAddUser.setBounds(16, 93, 200, 30);
		contentPane.add(btnAddUser);
		
		JButton btnLoadUser = new JButton("Load user");
		btnLoadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLoadUserDialog();
			}
		});
		btnLoadUser.setForeground(Color.BLACK);
		btnLoadUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLoadUser.setBounds(16, 133, 200, 30);
		contentPane.add(btnLoadUser);
		
		lblCurrentUser = new JLabel("Current user:");
		lblCurrentUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentUser.setVerticalAlignment(SwingConstants.TOP);
		lblCurrentUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentUser.setForeground(Color.BLACK);
		lblCurrentUser.setBounds(374, 153, 400, 20);
		lblCurrentUser.setVisible(false);
		contentPane.add(lblCurrentUser);
		
		lblCurrentBalance = new JLabel("Current balance:");
		lblCurrentBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentBalance.setVerticalAlignment(SwingConstants.TOP);
		lblCurrentBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentBalance.setForeground(Color.BLACK);
		lblCurrentBalance.setBounds(374, 213, 400, 20);
		lblCurrentBalance.setVisible(false);
		contentPane.add(lblCurrentBalance);
		
		lblDetails = new JLabel("Details");
		lblDetails.setForeground(Color.BLACK);
		lblDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDetails.setBounds(374, 93, 400, 30);
		lblDetails.setVisible(false);
		contentPane.add(lblDetails);
		
		lblSavingGoal = new JLabel("Saving goal:");
		lblSavingGoal.setHorizontalAlignment(SwingConstants.LEFT);
		lblSavingGoal.setForeground(Color.BLACK);
		lblSavingGoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSavingGoal.setBounds(374, 243, 400, 20);
		lblSavingGoal.setVisible(false);
		contentPane.add(lblSavingGoal);
		
		lblStartingBalance = new JLabel("Starting balance:");
		lblStartingBalance.setVerticalAlignment(SwingConstants.TOP);
		lblStartingBalance.setForeground(Color.BLACK);
		lblStartingBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblStartingBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStartingBalance.setBounds(374, 183, 400, 20);
		lblStartingBalance.setVisible(false);
		contentPane.add(lblStartingBalance);
		
		btnShowExpenses = new JButton("Show expenses");
		btnShowExpenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showExpensesDialog();
			}
		});
		btnShowExpenses.setForeground(Color.BLACK);
		btnShowExpenses.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowExpenses.setBounds(496, 453, 200, 30);
		btnShowExpenses.setVisible(false);
		contentPane.add(btnShowExpenses);
		
		JButton btnShowUsers = new JButton("Show users");
		btnShowUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUserDialog();
			}
		});
		btnShowUsers.setForeground(Color.BLACK);
		btnShowUsers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowUsers.setBounds(16, 173, 200, 30);
		contentPane.add(btnShowUsers);
		
		JButton btnDeleteUser = new JButton("Delete user");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDeleteUserDialog();
			}
		});
		btnDeleteUser.setForeground(Color.BLACK);
		btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteUser.setBounds(16, 213, 200, 30);
		contentPane.add(btnDeleteUser);
		
		lblMoneyRemaining = new JLabel("Money remaining:");
		lblMoneyRemaining.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoneyRemaining.setForeground(Color.BLACK);
		lblMoneyRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMoneyRemaining.setBounds(374, 273, 400, 20);
		lblMoneyRemaining.setVisible(false);
		contentPane.add(lblMoneyRemaining);
		
		btnDeleteExpense = new JButton("Delete expense");
		btnDeleteExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDeleteExpenseDialog();
			}
		});
		btnDeleteExpense.setForeground(Color.BLACK);
		btnDeleteExpense.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteExpense.setBounds(256, 453, 200, 30);
		btnDeleteExpense.setVisible(false);
		contentPane.add(btnDeleteExpense);
		
		btnAddIncome = new JButton("Add income");
		btnAddIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAddIncomeDialog();
			}
		});
		btnAddIncome.setForeground(Color.BLACK);
		btnAddIncome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddIncome.setBounds(16, 503, 200, 30);
		btnAddIncome.setVisible(false);
		contentPane.add(btnAddIncome);
		
		btnDeleteIncome = new JButton("Delete income");
		btnDeleteIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDeleteIncomeDialog();
			}
		});
		btnDeleteIncome.setForeground(Color.BLACK);
		btnDeleteIncome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteIncome.setBounds(256, 503, 200, 30);
		btnDeleteIncome.setVisible(false);
		contentPane.add(btnDeleteIncome);
		
		btnShowIncomes = new JButton("Show incomes");
		btnShowIncomes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIncomesDialog();
			}
		});
		btnShowIncomes.setForeground(Color.BLACK);
		btnShowIncomes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowIncomes.setBounds(496, 503, 200, 30);
		btnShowIncomes.setVisible(false);
		contentPane.add(btnShowIncomes);
		
		btnShowPieCharts = new JButton("Show Pie Charts");
		btnShowPieCharts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chosenUser != null) {
					PieCharts.showExpenseChart(chosenUser);
					PieCharts.showIncomeChart(chosenUser);
				}
				else {
					JOptionPane.showMessageDialog(null, "No user selected!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnShowPieCharts.setForeground(Color.BLACK);
		btnShowPieCharts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowPieCharts.setBounds(16, 293, 200, 30);
		btnShowPieCharts.setVisible(false);
		contentPane.add(btnShowPieCharts);
	}
	
	
	
	// ActionListener functions
	// Function adding user
	private void openAddUserDialog() {
		JDialog dialog = new JDialog(this, "Add user", true);
		dialog.setSize(300, 200);
		dialog.getContentPane().setLayout(null);
		dialog.setLocationRelativeTo(this);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 20, 80, 25);
		dialog.getContentPane().add(lblName);
		
		JTextField txtName = new JTextField();
		txtName.setBounds(100, 20, 150, 25);
		dialog.getContentPane().add(txtName);

		JLabel lblBalance = new JLabel("Starting balance:");
		lblBalance.setBounds(20, 60, 80, 25);
		dialog.getContentPane().add(lblBalance);

		JTextField txtBalance = new JTextField();
		txtBalance.setBounds(100, 60, 150, 25);
		dialog.getContentPane().add(txtBalance);

		JButton btnSubmit = new JButton("Add");
		btnSubmit.setBounds(100, 100, 80, 30);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				try {
					double balance = Double.parseDouble(txtBalance.getText());
					logic.addUser(name, balance);
					chosenUser = logic.getUser(name);
					btnAddExpense.setVisible(true);
					btnSetGoal.setVisible(true);
					btnDeleteExpense.setVisible(true);
					btnShowExpenses.setVisible(true);
					btnAddIncome.setVisible(true);
					btnDeleteIncome.setVisible(true);
					btnShowIncomes.setVisible(true);
					btnShowPieCharts.setVisible(true);
					lblCurrentUser.setText("Current user: " + name);
					lblStartingBalance.setText("Starting balance: " + String.format("%.2f", balance) + "€");
					lblCurrentBalance.setText("Current balance: " + String.format("%.2f", balance) + "€");
					lblSavingGoal.setText("Saving goal: -");
					lblMoneyRemaining.setText("Money remaining: " + String.format("%.2f", balance) + "€");
					lblDetails.setVisible(true);
					lblCurrentUser.setVisible(true);
					lblStartingBalance.setVisible(true);
					lblCurrentBalance.setVisible(true);
					lblSavingGoal.setVisible(true);
					lblMoneyRemaining.setVisible(true);
					dialog.dispose();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(dialog, "Invalid balance!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		dialog.getContentPane().add(btnSubmit);
		dialog.setVisible(true);
	}
	
	// Function loading user
	private void openLoadUserDialog() {
		String name = JOptionPane.showInputDialog(this, "Enter username:", "Load User", JOptionPane.PLAIN_MESSAGE);
		if (name != null && !name.trim().isEmpty()) {
			User user = logic.getUser(name.trim());
			if (user != null) {
				chosenUser = user;
				btnAddExpense.setVisible(true);
				btnSetGoal.setVisible(true);
				btnDeleteExpense.setVisible(true);
				btnShowExpenses.setVisible(true);
				btnAddIncome.setVisible(true);
				btnDeleteIncome.setVisible(true);
				btnShowIncomes.setVisible(true);
				btnShowPieCharts.setVisible(true);
				lblCurrentUser.setText("Current user: " + user.name);
				lblStartingBalance.setText("Starting balance: " + String.format("%.2f", user.startingBalance) + "€");
				lblCurrentBalance.setText("Current balance: " + String.format("%.2f", user.currentBalance) + "€");
				lblSavingGoal.setText("Saving goal: " + (user.savingGoal > 0 ? String.format("%.2f", user.savingGoal) + "€" : "-"));
				lblMoneyRemaining.setText("Money remaining: " + String.format("%.2f", (user.currentBalance - user.savingGoal)) + "€");
				lblDetails.setVisible(true);
				lblCurrentUser.setVisible(true);
				lblStartingBalance.setVisible(true);
				lblCurrentBalance.setVisible(true);
				lblSavingGoal.setVisible(true);
				lblMoneyRemaining.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Function adding expense to an user
	private void openAddExpenseDialog() {
		if (chosenUser == null) {
			JOptionPane.showMessageDialog(this, "No user selected!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JDialog dialog = new JDialog(this, "Add Expense", true);
		dialog.setSize(300, 250);
		dialog.getContentPane().setLayout(null);
		dialog.setLocationRelativeTo(this);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(20, 20, 80, 25);
		dialog.getContentPane().add(lblCategory);

		String[] categories = {"Food", "Transport", "Entertainment", "Bills", "Other"};
		JComboBox<String> comboCategory = new JComboBox<>(categories);
		comboCategory.setBounds(100, 20, 150, 25);
		dialog.getContentPane().add(comboCategory);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(20, 60, 80, 25);
		dialog.getContentPane().add(lblAmount);

		JTextField txtAmount = new JTextField();
		txtAmount.setBounds(100, 60, 150, 25);
		dialog.getContentPane().add(txtAmount);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(20, 100, 80, 25);
		dialog.getContentPane().add(lblDescription);

		JTextField txtDescription = new JTextField();
		txtDescription.setBounds(100, 100, 150, 25);
		dialog.getContentPane().add(txtDescription);

		JButton btnSubmit = new JButton("Add");
		btnSubmit.setBounds(100, 140, 80, 30);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = (String) comboCategory.getSelectedItem();
				String description = txtDescription.getText();
				try {
					double amount = Double.parseDouble(txtAmount.getText());
					logic.addExpenseToUser(chosenUser, category, amount, description);
					lblCurrentBalance.setText("Current balance: " + String.format("%.2f", chosenUser.currentBalance) + "€");
					lblMoneyRemaining.setText("Money remaining: " + String.format("%.2f", (chosenUser.currentBalance - chosenUser.savingGoal)) + "€");
					dialog.dispose();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(dialog, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		dialog.getContentPane().add(btnSubmit);
		dialog.setVisible(true);
	}
	
	// Function setting saving goal for an user
	private void openSetSavingGoalDialog() {
		if (chosenUser == null) {
			JOptionPane.showMessageDialog(this, "No user loaded!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JDialog dialog = new JDialog(this, "Set Saving Goal", true);
		dialog.setSize(300, 150);
		dialog.getContentPane().setLayout(null);
		dialog.setLocationRelativeTo(this);

		JLabel lblGoal = new JLabel("Saving Goal:");
		lblGoal.setBounds(20, 20, 100, 25);
		dialog.getContentPane().add(lblGoal);

		JTextField txtGoal = new JTextField();
		txtGoal.setBounds(120, 20, 150, 25);
		dialog.getContentPane().add(txtGoal);

		JButton btnSubmit = new JButton("Set Goal");
		btnSubmit.setBounds(100, 60, 100, 30);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double goalAmount = Double.parseDouble(txtGoal.getText());
					chosenUser.setSavingGoal(goalAmount);
					logic.setUserSavingGoal(chosenUser.getName(), goalAmount);
					lblSavingGoal.setText("Saving goal: " + String.format("%.2f", goalAmount) + "€");
					lblMoneyRemaining.setText("Money remaining: " + String.format("%.2f", (chosenUser.currentBalance - chosenUser.savingGoal)) + "€");
					dialog.dispose();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(dialog, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		dialog.getContentPane().add(btnSubmit);
		dialog.setVisible(true);
	}
	
	// Function showing expenses of an user
	private void showExpensesDialog() {
		if (chosenUser == null || chosenUser.getExpenses().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No expenses recorded!", "Expenses", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		StringBuilder expenseText = new StringBuilder("<html><body><h3>Expenses:</h3>");
		for (Expense expense : chosenUser.getExpenses()) {
			expenseText.append("<p><b>Category:</b> ").append(expense.getCategory())
				       .append(" | <b>Amount:</b> ").append(expense.getAmount()).append("€")
				       .append(" | <b>Description:</b> ").append(expense.getDescription()).append("</p>");
		}
		expenseText.append("</body></html>");
		
		JDialog dialog = new JDialog(this, "User Expenses", true);
		dialog.setSize(400, 300);
		dialog.setLocationRelativeTo(this);
		JLabel lblExpenses = new JLabel(expenseText.toString());
		dialog.getContentPane().add(lblExpenses);
		dialog.setVisible(true);
	}
	
	// Function showing all users
	private void showUserDialog() {
		List<String> users = logic.getAllUserNames();
		
		if (users.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No users available!", "User List", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		StringBuilder userText = new StringBuilder("<html><body><h3>Registered users:</h3><ul>");
		for (String user : users) {
			userText.append("<li>").append(user).append("</li>");
		}
		userText.append("</ul></body></html>");
		
		JDialog dialog = new JDialog(this, "User List", true);
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(this);
		JLabel lblUsers = new JLabel(userText.toString());
		dialog.getContentPane().add(lblUsers);
		dialog.setVisible(true);
	}
	
	// Function deleting an user
	private void openDeleteUserDialog() {
		String name = JOptionPane.showInputDialog(this, "Enter username to delete:", "Delete user", JOptionPane.WARNING_MESSAGE);
		if (name != null && !name.trim().isEmpty()) {
			boolean deleted = logic.deleteUser(name.trim());
			if (deleted) {
				JOptionPane.showMessageDialog(this, "User " + name + " has been deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				btnSetGoal.setVisible(false);
				btnShowPieCharts.setVisible(false);
				btnAddExpense.setVisible(false);
				btnDeleteExpense.setVisible(false);
				btnShowExpenses.setVisible(false);
				btnAddIncome.setVisible(false);
				btnDeleteIncome.setVisible(false);
				btnShowIncomes.setVisible(false);
				lblDetails.setVisible(false);
				lblCurrentUser.setVisible(false);
				lblStartingBalance.setVisible(false);
				lblCurrentBalance.setVisible(false);
				lblSavingGoal.setVisible(false);
				lblMoneyRemaining.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this, "User not found!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Function deleting an expense of an user
	private void openDeleteExpenseDialog() {
		if (chosenUser == null) {
			JOptionPane.showMessageDialog(this, "No user selected!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		List<Expense> expenses = chosenUser.getExpenses();
		if (expenses.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No expenses to delete!", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		String[] expenseOptions = expenses.stream()
				.map(expense -> expense.getDescription() + " - " + expense.getAmount() + "€")
				.toArray(String[]::new);
		
		String selectedExpense = (String) JOptionPane.showInputDialog(this, "Select an expense to delete:", "Delete Expense", JOptionPane.QUESTION_MESSAGE, null, expenseOptions, expenseOptions[0]);
		
		if (selectedExpense != null) {
			String expenseDescription = selectedExpense.split(" - ")[0];
			boolean success = logic.deleteExpenseFromUser(chosenUser.getName(), expenseDescription);
			
			if (success) {
				JOptionPane.showMessageDialog(this, "Expense has been deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				lblCurrentBalance.setText("Current balance: " + String.format("%.2f", chosenUser.getCurrentBalance()) + "€");
				lblMoneyRemaining.setText("Money remaining: " + String.format("%.2f", (chosenUser.getCurrentBalance() - chosenUser.savingGoal)) + "€");
			}
			else {
				JOptionPane.showMessageDialog(this, "Error deleting expense!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	// Function adding an income to an user
	private void openAddIncomeDialog() {
		if (chosenUser == null) {
			JOptionPane.showMessageDialog(this, "No user selected!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JDialog dialog = new JDialog(this, "Add Income", true);
	    dialog.setSize(300, 250);
	    dialog.getContentPane().setLayout(null);
	    dialog.setLocationRelativeTo(this);

	    JLabel lblCategory = new JLabel("Category:");
	    lblCategory.setBounds(20, 20, 80, 25);
	    dialog.getContentPane().add(lblCategory);

	    String[] categories = {"Salary", "Freelance", "Investments", "Gifts", "Other"};
	    JComboBox<String> categoryBox = new JComboBox<>(categories);
	    categoryBox.setBounds(100, 20, 150, 25);
	    dialog.getContentPane().add(categoryBox);

	    JLabel lblAmount = new JLabel("Amount:");
	    lblAmount.setBounds(20, 60, 80, 25);
	    dialog.getContentPane().add(lblAmount);

	    JTextField txtAmount = new JTextField();
	    txtAmount.setBounds(100, 60, 150, 25);
	    dialog.getContentPane().add(txtAmount);

	    JLabel lblDescription = new JLabel("Description:");
	    lblDescription.setBounds(20, 100, 80, 25);
	    dialog.getContentPane().add(lblDescription);

	    JTextField txtDescription = new JTextField();
	    txtDescription.setBounds(100, 100, 150, 25);
	    dialog.getContentPane().add(txtDescription);

	    JButton btnSubmit = new JButton("Add");
	    btnSubmit.setBounds(100, 140, 80, 30);
	    btnSubmit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String category = (String) categoryBox.getSelectedItem();
	            String description = txtDescription.getText();
	            try {
	                double amount = Double.parseDouble(txtAmount.getText());
	                logic.addIncomeToUser(chosenUser, category, amount, description);
	                chosenUser = logic.getUser(chosenUser.getName());
	                lblCurrentBalance.setText("Current balance: " + String.format("%.2f", chosenUser.getCurrentBalance()) + "€");
	                lblMoneyRemaining.setText("Money remaining: " + String.format("%.2f", (chosenUser.getCurrentBalance() - chosenUser.savingGoal)) + "€");
	                dialog.dispose();
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(dialog, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });
	    dialog.getContentPane().add(btnSubmit);
	    dialog.setVisible(true);
	}
	
	// Function deleting an income of an user
	private void openDeleteIncomeDialog() {
		if (chosenUser == null) {
			JOptionPane.showMessageDialog(this, "No user selected!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		List<Income> incomes = chosenUser.getIncomes();
	    if (incomes.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "No incomes to delete!", "Info", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    String[] incomeOptions = incomes.stream()
	            .map(income -> income.getDescription() + " - " + income.getAmount() + "€")
	            .toArray(String[]::new);

	    String selectedIncome = (String) JOptionPane.showInputDialog(this, "Select an income to delete:", "Delete Income", JOptionPane.QUESTION_MESSAGE, null, incomeOptions, incomeOptions[0]);

	    if (selectedIncome != null) {
	        String incomeDescription = selectedIncome.split(" - ")[0];
	        boolean success = logic.deleteIncomeFromUser(chosenUser.getName(), incomeDescription);

	        if (success) {
	            chosenUser = logic.getUser(chosenUser.getName());
	            lblCurrentBalance.setText("Current balance: " + String.format("%.2f", chosenUser.getCurrentBalance()) + "€");
	            lblMoneyRemaining.setText("Money remaining: " + String.format("%.2f", (chosenUser.getCurrentBalance() - chosenUser.savingGoal)) + "€");
	        } 
	        else {
	            JOptionPane.showMessageDialog(this, "Error deleting income!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	
	// Function showing incomes of an user
	private void showIncomesDialog() {
		if (chosenUser == null || chosenUser.getIncomes().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No incomes recorded!", "Incomes", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		StringBuilder incomeText = new StringBuilder("<html><body><h3>Incomes:</h3>");
		for (Income income : chosenUser.getIncomes()) {
			incomeText.append("<p><b>Category:</b> ").append(income.getCategory())
				       .append(" | <b>Amount:</b> ").append(income.getAmount()).append("€")
				       .append(" | <b>Description:</b> ").append(income.getDescription()).append("</p>");
		}
		incomeText.append("</body></html>");
		
		JDialog dialog = new JDialog(this, "User Expenses", true);
		dialog.setSize(400, 300);
		dialog.setLocationRelativeTo(this);
		JLabel lblExpenses = new JLabel(incomeText.toString());
		dialog.getContentPane().add(lblExpenses);
		dialog.setVisible(true);
	}
}

// Import libraries
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class PieCharts {
    
    public static void showExpenseChart(User user) {
    	// If there is no user or no expenses, a message will say that there is nothing to display
        if (user == null || user.getExpenses().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No expenses to display!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Initialize the dataset for the pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Double> categoryTotals = new HashMap<>();
        double totalAmount = 0;
        
        // Sums up the expenses for each category
        for (Expense expense : user.getExpenses()) {
            categoryTotals.put(expense.getCategory(), categoryTotals.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
            totalAmount += expense.getAmount();
        }
        
        // Adds the calculated values to the dataset, including its percentage
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            double percentage = (entry.getValue() / totalAmount) * 100;
            dataset.setValue(entry.getKey() + " (" + String.format("%.2f", percentage) + "%)", entry.getValue());
        }
        
        // Create the pie chart with JFreeChart
        JFreeChart chart = ChartFactory.createPieChart(
                "Expense Breakdown",
                dataset,
                true,
                true,
                false
        );
        
        // Customize the design of the pie chart
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        
        // Create a panel for the pie chart
        ChartPanel chartPanel = new ChartPanel(chart);
        
        // Create a new frame to display the chart
        JFrame frame = new JFrame("Expense Chart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.add(chartPanel);
        frame.setVisible(true);
    }

    public static void showIncomeChart(User user) {
    	// If there is no user or no income, a message will say that there is nothing to display
        if (user == null || user.getIncomes().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No incomes to display!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Initialize the dataset for the pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Double> categoryTotals = new HashMap<>();
        double totalAmount = 0;
        
        // Sums up the incomes for each category
        for (Income income : user.getIncomes()) {
            categoryTotals.put(income.getCategory(), categoryTotals.getOrDefault(income.getCategory(), 0.0) + income.getAmount());
            totalAmount += income.getAmount();
        }

        // Adds the calculated values to the dataset, including its percentage
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            double percentage = (entry.getValue() / totalAmount) * 100;
            dataset.setValue(entry.getKey() + " (" + String.format("%.2f", percentage) + "%)", entry.getValue());
        }
        
        // Create the pie chart with JFreeChart
        JFreeChart chart = ChartFactory.createPieChart(
                "Income Breakdown",
                dataset,
                true,
                true,
                false
        );
        
        // Customize the design of the pie chart
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        
        // Create a panel for the pie chart
        ChartPanel chartPanel = new ChartPanel(chart);
        
        // Create a new frame to display the chart
        JFrame frame = new JFrame("Income Chart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.add(chartPanel);
        frame.setVisible(true);
    }
}

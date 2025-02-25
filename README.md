# Programming-Project: CashCompass

## Overview
__CashCompass__ is a simple Java-based application that helps users track their financial transactions and situation. Users can add, delete, and view their __expenses and incomes__, set a __saving goal__, and analyze their situation with __pie charts__. The data is __persistently stored__ using JSON. 


## Installation & Setup
### Requirements
- Be sure to have __Java 8+__ installed
- Be sure to have the __JFreeChart__ library for visualizations
- Be sure to have the __Gson__ library for JSON data storage
- Have any Java-supported IDE (e.g. IntelliJ IDEA, Eclipse, ...)

### Running the Application
1. Clone or download this repository
2. Add __JFreeChart__ and __Gson__ dependencies to the project
3. Compile and run the GUI.java
   
   ```
   javac GUI.java
   java GUI
   ```


## How it works
1. User Management:
   - Add a new user with a starting balance
   - Select an existing user to manage finances
   - Delete an user, removing all associated data
2. Expense & Income Management:
   - Add expenses and incomes, categorized into predefined groups (e.g., Food, Salary, Bills, ...)
   - Delete expenses and incomes, updating the balance accordingly
   - View total expenses and incomes
3. Saving Goals:
   - Set a saving goal for an user
   - See the remaining balance needed to reach the goal
4. Data Persistence:
   - All data is stored in a users.json file using Gson
   - The application loads the data on startup
5. Visual Analysis:
   - View pie charts for expenses and incomes categorized by percentage
   - Uses JFreeChart for graphical representation


## Features
- Add and remove users
- Track expenses and incomes with categories
- Saving goal management
- Data persistence with JSON
- Pie charts for expenses and incomes
- User-friendly GUI


## Limitations
- No user authentication: Anyone can add or delete users
- No currency selection: Only supports Euro
- No advanced filtering: Expenses and incomes are not sortable or searchable
- No option to include due dates or deadlines for expenses / incomes
- Simple GUI: The GUI is very simple and has a lot room for improvement
- File-based storage: No database integration


## Future Improvements
- User authentication
- Database integration (e.g. with MySQL, ...)
- Enhanced filtering & sorting options
- Support for multiple currencies
- More appealing GUI
- Convert from Java application to a web-based application
- Having a calendar and (due) dates to plan more into the future


### For feedback or improvements, feel free to contribute!

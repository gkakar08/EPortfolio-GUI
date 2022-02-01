The general problem to be solved with this program is that the code from Assignment Two was not user friendly as it involved taking command line input for the entire user interface. This isn't ideal as the average user will not know how to intuitively use that program. To solve that issue, I've developed a complete graphical user interface (or GUI) for the purpose of promoting an intuitive user experience, where anyone who hasn't used the program before can fairly quickly pick it up.

One of the limitations of my code is that it still must be accessed using a command line in Java to run it. One thing I could do is generate an executable using my java files so that this program can reliably be run on any Windows computer, without having to work with a command line to run the program.

A user can compile my program using the line "javac *.java" when inside the directory. They can then run the program, after going one directory up, by entering "java.ePortfolio.Portfolio fileName.txt" into the command line on a system with Java installed. "fileName.txt" represents a file with stored data from another session. They can then use any of the given menu options, beginning with "buy." From there, they can update the price, sell a stock/fund, calculate their gain on paper, search for a given stock/fund based on symbol, keyword, or price range.

The program is tested for correctness using the given Test Plan:

Test Case 1:

Functionality: Buy
Input: Type of investment is not a stock or fund
Output: "Please input either stock or mutual fund" and is reprompted to enter type of investment
Test Case 2:

Functionality: Buy
Input: Entered stock/fund symbol is already in the system
Output: User is not prompted for name, only quantity and price
Test Case 3:

Functionality: Buy
Input: Entered stock/fund symbol is not already in the system
Output: User is prompted for name, quantity and price
Test Case 4:

Functionality: Sell
Input: Entered a stock/fund symbol not in the system
Output: "Please enter a valid symbol" and is reprompted for a valid symbol
Test Case 5:

Functionality: Sell
Input: Entered a stock/fund symbol in the system
Output: User is prompted for quantity and price
Test Case 6:

Functionality: Sell
Input: Quantity entered is greater than quantity available to sell
Output: "Please enter a quantity no greater than X" with X representing the available quantity and is reprompted for quantity
Test Case 7:

Functionality: Sell
Input: Quantity entered is greater than quantity available to sell
Output: "Please enter a quantity no greater than X" with X representing the available quantity and is reprompted for quantity
Test Case 8:

Functionality: Sell
Input: All fields for symbol, keyword, and range are left empty
Output: Return all stocks and funds
Test Case 9:

Functionality: Sell
Input: Symbol matching a stock/fund is entered and other fields are left blank
Output: Return matching stock/fund
Test Case 10:

Functionality: Sell
Input: Keywords matching the name of a stock/fund are inputted
Output: All stocks/funds with all matching keywords are outputted, regardless of order or case sensitivity
Test Case 11:

Functionality: Sell
Input: A single number for price range is inputted
Output: Any stock/fund with price matching that value are returned
Test Case 12:

Functionality: Sell
Input: A range of form "X-Y" with X being lower bounds and Y being upper bounds of price are entered
Output: All stocks/funds within that price range are outputted
Test Case 12:

Functionality: Sell
Input: A range of form "X-" with X being lower bounds is entered
Output: All stocks/funds with at least X price are returned
Test Case 13:

Functionality: Sell
Input: A range of form "-X" with X being lower bounds is entered
Output: All stocks/funds with at most X price are returned
Test Case 14:

Functionality: Command Loop
Input: An input not matching any of the functions is entered
Output: "Please enter one of the options [1,6]"
Test Case 15:

Functionality: File Loading, filename "investments.txt"

Input:

  type = "stock"
  symbol = "YEET"
  name = "Yeet Inc."
  quantity = "10"
  price = "25.0"
  bookValue = "259.99"

  type = "stock"
  symbol = "AAPL"
  name = "Apple Inc."
  quantity = "500"
  price = "142.23"
  bookValue = "55049.99"
Function: Entered all data successfully

Test Case 16:

Functionality: File Outputting, filename "investments.txt"

Input: Through buy,

  type = "stock"
  symbol = "YEAX"
  name = "Yeaxamellon Inc."
  quantity = "10"
  price = "25.0"
  bookValue = "259.99"

  type = "stock"
  symbol = "AAPL"
  name = "Apple Inc."
  quantity = "500"
  price = "142.23"
  bookValue = "55049.99"

  type = "mutualfund"
  symbol = "DELL"
  name = "Dell Inc."
  quantity = "99"
  price = "250"
  bookValue = "55049.99"
Function: Returned file output (should be identical):

  type = "stock"
  symbol = "YEAX"
  name = "Yeaxamellon Inc."
  quantity = "10"
  price = "25.0"
  bookValue = "259.99"

  type = "stock"
  symbol = "AAPL"
  name = "Apple Inc."
  quantity = "500"
  price = "142.23"
  bookValue = "55049.99"

  type = "mutualfund"
  symbol = "DELL"
  name = "Dell Inc."
  quantity = "99"
  price = "250"
  bookValue = "55049.99"
Test Case 17:

Functionality: Buy page, reset button
Input: Button is pressed
Output: All fields are cleared, with type changed to default of Stock
Test Case 18:

Functionality: Sell page, reset button
Input: Button is pressed
Output: All fields are cleared
Test Case 19:

Functionality: Update page, next button
Input: Button is pressed
Output: Button is disabled when there's only one entry in total or there's no entries remaining to go forward
Test Case 20:

Functionality: Update page, prev button
Input: Button is pressed
Output: Button is disabled when there's only one entry in total or there's no entries remaining to go back
Test Case 21:

Functionality: Search page, reset button
Input: Button is pressed
Output: All fields are cleared
If I had extra time available, I would:
Program a function to change the commision values
Create functionality to change a stock or fund name after it was created
Generate an executable to be distributed


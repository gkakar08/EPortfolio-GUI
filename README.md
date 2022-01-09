
README FILE

GENERAL PROBLEM - Create a GUI Portfolio which allows user to buy, sell , search , update and calculate gains amongst two types
                  of investments Stock and Mutual Fund in GUI. Also I used an array list to manage both the invetsments.
                  The program was further managed by using one parental class i.e. Investment which is further 
                  extended by two classes i.e. Stock and Mutual Fund.Also, add exception handling so 
                  that the system will be more robust and user-friendly.
 
ASSUMPTIONS    -  Manually giving the prices and values for all required investments.
                  All basic assumptions requiered for the assignment.
                  Considering gains from completely sold stocks and current stock.    

LIMITATIONS -    The search functionality works perfectly for all individual enteries but not for multiple enteries except price range and symbol.
                 Otherwise, None beacuse I met all the conditions as per the requirment of the program
                 for the assignment.        

1) The general problem I was trying to solve was specifically that I encountered while doing the code was 
   that there was a lot of redudancy of code so for that a solution I have desribed in the follwing point 2.
  
2)  The problem of reusing the code again and again or the redudancy of code was solved using an extend statement 
   followed by an @override command to avoid duplicacy of code and unneccesary wastage of time. 

3) The user can build and test my programm through the following commands :
   1) javac eportfolio/*.java ( For Compiling)
   2) java eportfolio.EPortfolioGUI (To Run)

4) TEST PLAN 
   My program can be tested by entering any of the inputs including the ones given by
   the professor in the assignment which have been already tested by me.

   For example, if we initially buy 500 shares of AAPL stock at the price of $110.08 per share, the quantity will be 500, 
   and the bookValue will be 500 × 110.08 + 9.99 = $55,049.99. Later on, if the price is changed to $142.23 per share, 
   the gain will be (500 × 142.23 – 9.99) – 55,049.99 = 71,105.01 – 55,049.99 = $16,055.02. 
   Alternatively, if we sell 200 shares of this stock at $142.23 per share, the payment received will be 200 × 142.23 – 9.99 = $28,436.01, 
   the quantity will be reduced to 300, and bookValue will be adjusted to 55,049.99 × 300/500 = $33,029.99.

   For each mutual fund, we do not pay any fee if we buy certain units of the fund, but if we sell certain units of the fund, 
   we need to pay a redemption fee of $45. For instance, if we initially buy 450 units of SSETX at $53.26 per unit, 
   the quantity will be 450 and the bookValue will be 450 × 53.26 = $23,967.00. Later on, if the price goes down to $42.21 per unit, 
   the gain will be (450 × 42.21 – 45.00) – 23,967.00 = 18,949.50 – 23,967.00 = –$5,017.50. 
   Alternatively, if we sell 150 units of this fund at $42.21 per unit, the payment received will be 150 × 42.21 – 45.00 =
   $6,286.50, the quantity will be reduced to 300, and the bookValue will be changed to 23,967.00×300/450 = $15,978.00.
   
   For search,a search request may just contain a symbol (e.g., AAPL) and in this case, only the investment with this symbol will be returned. 
   If a search request contains the keywords “Growth Fund”, then all investments whose names contain these keywords will be retured. 
   If a search request contains more fields, e.g., “AAPL” as the symbol and “10.00-100.00” as the price range, 
   then simply matching the symbol AAPL is not enough; the price of the investment should also fall within the given price range.
   
   Also ran search cases for the 4 major conditions i.e. the given element is not on the list, the given element is at the start of the
   list, the given element is at the end of the list and lastly the given element is somewhere between the two ends in the list.
   The searched aligned up showed the working of Hash Maps and searching them respectively.   

5) Possible improvements
   I would have loved to work more on the search function for price range and try more sets of possible combination for self-satisfaction.
   Could have presented a more professional style of coding.






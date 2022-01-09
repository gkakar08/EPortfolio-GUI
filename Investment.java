package eportfolio;
// represents a class of investment
public class Investment {

    public String symbol;
    public String name;
    public int quantity;
    public double price;
    public double bookValue;
    /**
     * 
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     */

    public Investment(String symbol, String name, int quantity, double price) {
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    /**
     * 
     * @return
     */
    
    
    public String getSymbol() {
        return symbol;
    }
    /**
     * 
     * @param symbol
     */

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    /**
     * 
     * @return
     */

    public String getName() {
        return name;
    }
    /**
     * 
     * @param name
     */

    public void setName(String name) {
    	this.name = name;
    }
    /**
     * 
     * @return
     */

    public int getQuantity() {
        return quantity;
    }
    /**
     * 
     * @param quantity
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * 
     * @return
     */
    public double getPrice() {
        return price;
    }
    /**
     * 
     * @param price
     */


    public void setPrice(double price) {
    	this.price = price;
    }



}

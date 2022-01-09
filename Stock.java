package eportfolio;
// represents a class of Stock

public class Stock extends Investment {

    private double commission;
    /**
     * 
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     * @param commission
     */

    public Stock(String symbol, String name, int quantity, double price, double commission) {
        super(symbol, name, quantity, price);
        this.commission = commission;
    }
    /**
     * 
     * @return
     */

    public double getBookValue() {
        return bookValue;
    }
    /**
     * 
     * @param bookValue
     */

    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }
    /**
     * 
     * @return
     */

    public double getCommission() {
        return commission;
    }
    /**
     * 
     * @param commission
     */

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String toString() {
        return "type = \"stock\"\n"
                + "symbol = \"" + symbol + "\"\n"
                + "name = \"" + name + "\"\n"
                + "quantity = \"" + quantity + "\"\n"
                + "price = \"" + price + "\"\n"
                + "bookValue = \"" + bookValue + "\"\n";
    }

}

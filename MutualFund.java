package eportfolio;
//represents a class of mutual fund

public class MutualFund extends Investment {
    /**
     * 
     * @param symbol
     * @param name
     * @param quantity
     * @param price
     */

    public MutualFund(String symbol, String name, int quantity, double price) {
        super(symbol, name, quantity, price);
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
        super.bookValue = bookValue;
    }

    public String toString() {
        return "type = \"mutualfund\"\n"
                + "symbol = \"" + symbol + "\"\n"
                + "name = \"" + name + "\"\n"
                + "quantity = \"" + quantity + "\"\n"
                + "price = \"" + price + "\"\n"
                + "bookValue = \"" + bookValue + "\"\n";
    }

}

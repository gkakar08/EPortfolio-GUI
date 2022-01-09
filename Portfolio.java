package eportfolio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// represents a class of Portfolio

public class Portfolio {

    private ArrayList<Investment> investments;
    private Map<String, ArrayList<Integer>> nameKeywordindex;

    public Portfolio() {
    }
/**
 * 
 * @return
 */
    public ArrayList<Investment> getInvestments() {
        return investments;
    }
    /**
     * 
     * @param investment
     * @return
     */

    public boolean addInvestment(Investment investment) {
        if (investments == null) {
            investments = new ArrayList<>();
        }

        String[] strArr = investment.getName().split(" ");
        for (String str : strArr) {
            addKeyword(str);
        }

       return investments.add(investment);
    }
    /**
     * 
     * @param keyword
     */

    private void addKeyword(String keyword) {
        if (nameKeywordindex == null) {
            nameKeywordindex = new HashMap<>();  //implemnting the basics of hash maps as required 
        }
        if (nameKeywordindex.containsKey(keyword)) {
            ArrayList<Integer> val = nameKeywordindex.get(keyword);
            val.add(investments.size() - 1);
            nameKeywordindex.replace(keyword, val);
        } else {
            ArrayList<Integer> val = new ArrayList<>();
            val.add(investments.size() - 1);
            nameKeywordindex.put(keyword, val);
        }
    }
    /**
     * 
     * @param symbol
     * @return
     */

    public Investment checkIfInvestmentExistBySymbol(String symbol) { //checking the existence of symbol
        if (investments != null) {
            for (Investment investment : investments) {
                if (investment.getSymbol().equalsIgnoreCase(symbol)) {
                    return investment;
                }
            }
        }
        return null;
    }
    /**
     * 
     * @param name
     * @return
     */

    public ArrayList<Investment> searchByKeyword(String name) {
        String[] keywordArr = name.split(" ");

        ArrayList<Investment> investmentList = new ArrayList<>(); //creating an array list
        if (investments != null) {
            for (Investment investment : investments) {
                String[] investmentKeywordArr = investment.getName().split(" ");
                boolean allMatched = true;

                for (String keyword : keywordArr) {
                    boolean oneMatched = false;
                    for (String stockKeyword : investmentKeywordArr) {
                        if (stockKeyword.equalsIgnoreCase(keyword)) {
                            oneMatched = true;
                            break;
                        }
                    }
                    allMatched = oneMatched;
                }
                if (allMatched) {
                    investmentList.add(investment);
                }
            }
        }
        return investmentList;
    }

    ArrayList<Investment> searchBySymbolAndPriceRange(String symbol, String price) {
        ArrayList<Investment> investments = new ArrayList<>();

        if (price.charAt(0) == '-') {       //implelmenting the function of search through various inputs
            double value = Double.parseDouble(price.substring(1));
            if (getInvestments() != null) {
                Investment investment = checkIfInvestmentExistBySymbol(symbol);
                if (investment != null) {
                    if (investment.getPrice() <= value) {
                        investments.add(investment);
                    }
                }
            }
        } else if (price.charAt(price.length() - 1) == '-') {
            double value = Double.parseDouble(price.substring(0, price.length() - 1));
            if (getInvestments() != null) {
                Investment investment = checkIfInvestmentExistBySymbol(symbol);

                if (investment != null) {
                    if (investment.getPrice() >= value) {
                        investments.add(investment);
                    }
                }
            }
        } else {
            String[] priceArr = price.split("-");
            if (getInvestments() != null) {
                if (priceArr.length == 2) {
                    Investment investment = checkIfInvestmentExistBySymbol(symbol);
                    if (investment != null) {
                        double lowerValue = Double.parseDouble(priceArr[0]);
                        double upperValue = Double.parseDouble(priceArr[1]);
                        if (investment.getPrice() >= lowerValue && investment.getPrice() <= upperValue) {
                            investments.add(investment);
                        }
                    }
                } else {
                    Investment investment = checkIfInvestmentExistBySymbol(symbol);

                    if (investment != null) {
                        double value = Double.parseDouble(priceArr[0]);
                        if (investment.getPrice() == value) {
                            investments.add(investment);
                        }
                    }
                }
            }
        }

        return investments;
    }

}

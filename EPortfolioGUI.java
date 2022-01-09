package eportfolio;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/*
represents the main eportfolio graphic user intefrace
*/

public class EPortfolioGUI extends JFrame implements ActionListener {

	Portfolio portfolio;
	JMenu menu;
	JMenuItem buy, sell, update, getGain, search, quit;

	int position = 0;

	public EPortfolioGUI() {
		portfolio = new Portfolio();   //creating a new portfolio
	}

	public void createAndShowGUI() {
		setTitle("EPortfolio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		JMenuBar mb = new JMenuBar();  // creating a menu bar 
		menu = new JMenu("Menu");
		buy = new JMenuItem("Buy");
		sell = new JMenuItem("Sell");
		update = new JMenuItem("Update");
		getGain = new JMenuItem("Get Gain");
		search = new JMenuItem("Search");
		quit = new JMenuItem("Quit");
		menu.add(buy);
		menu.add(sell);
		menu.add(update);
		menu.add(getGain);
		menu.add(search);
		menu.add(quit);
		mb.add(menu);

		buy.addActionListener(this);
		sell.addActionListener(this);
		update.addActionListener(this);
		getGain.addActionListener(this);
		search.addActionListener(this);
		quit.addActionListener(this);

		setJMenuBar(mb);

		setBounds(200, 100, 600, 400);  //setting the boundary for menubar
		setVisible(true);

		showHomePanel();
	}
	/*
	represents the main home panel
	*/
	/*
	*class is implemented with private attributes thus privacy leak protection is taken care of
	*
	*/

	private void showHomePanel() {
		JPanel panel = new JPanel(); //creating a new panel

		JLabel welcomeText = new JLabel(
				"<html>Welcome to ePortfolio."
						+ "<br/> <br/> <br/>Choose a command from the commands menu to buy or sell"
						+ "<br/>an investment, update prices for all investments,get gain for the<br/>"
						+ "portfolio, search for relavant investments, or quit the program</html>",
				SwingConstants.CENTER);
		welcomeText.setFont(new Font("Serif", Font.PLAIN, 18));
		// setContentPane(welcomeText);

		getContentPane();

		panel.setLayout(null);
		panel.add(welcomeText);
		welcomeText.setBounds(30, 50, 500, 200);  //setting the bounds for panel
		add(panel);

		setVisible(true);
	}
	/*
	represents the gui panel for buy command
	*/

	private void showBuyPanel() {
		JPanel buyPanel = new JPanel();

		JPanel p1 = new JPanel();  //creating a new buy panel interface

		p1.setLayout(null);

		JLabel title = new JLabel("Buying an investment");
		title.setBounds(10, 5, 200, 50);

		JLabel type = new JLabel("Type");
		type.setBounds(20, 50, 50, 20);

		String country[] = { "Stock", "Mutual Fund" };  //setting diff boundary for diff commands 
		JComboBox typeComboBox = new JComboBox(country);
		typeComboBox.setBounds(80, 50, 150, 20);

		JLabel symbol = new JLabel("Symbol");
		symbol.setBounds(20, 80, 50, 20);
		JTextField symbolText = new JTextField();
		symbolText.setBounds(80, 80, 150, 20);

		JLabel name = new JLabel("Name");
		name.setBounds(20, 110, 50, 20);
		JTextField nameText = new JTextField();
		nameText.setBounds(80, 110, 200, 20);

		JLabel quantity = new JLabel("Quantity");
		quantity.setBounds(20, 140, 50, 20);
		JTextField quantityText = new JTextField();
		quantityText.setBounds(80, 140, 100, 20);

		JLabel price = new JLabel("Price");
		price.setBounds(20, 170, 50, 20);
		JTextField priceText = new JTextField();
		priceText.setBounds(80, 170, 100, 20);

		p1.add(title);
		p1.add(type);
		p1.add(typeComboBox);
		p1.add(symbol);
		p1.add(symbolText);
		p1.add(name);
		p1.add(nameText);
		p1.add(quantity);
		p1.add(quantityText);
		p1.add(price);
		p1.add(priceText);

		getContentPane().removeAll();

		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);  //inserting a seperator with a required bound size
		sep.setBounds(0, 210, 600, 10);

		JSeparator sep1 = new JSeparator(SwingConstants.VERTICAL);
		sep1.setBounds(400, 0, 10, 210);

		buyPanel.add(sep);
		buyPanel.add(sep1);

		JPanel p2 = new JPanel();
		p2.setLayout(null);

		JButton resetBtn = new JButton("Reset");  //implementing the reset button
		resetBtn.setBounds(80, 60, 120, 20);

		JButton buyBtn = new JButton("Buy");
		buyBtn.setBounds(80, 120, 120, 20);

		p2.add(resetBtn);
		p2.add(buyBtn);

		JPanel p3 = new JPanel();
		p3.setLayout(null);

		JLabel message = new JLabel("Message");  //showing the message panel to the user with req setbound
		message.setBounds(5, 5, 100, 20);

		JTextArea messageArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(messageArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  //inserting a scroll bar in the message interface
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(5, 30, 580, 90);

		p3.add(message);
		p3.add(scroll);

		buyPanel.setLayout(null);
		buyPanel.add(p1);
		buyPanel.add(p2);
		buyPanel.add(p3);
		p1.setBounds(0, 0, 300, 200);
		p2.setBounds(350, 0, 200, 150);
		p3.setBounds(0, 210, 600, 150);
		add(buyPanel);

		invalidate();
		validate();

		resetBtn.addActionListener(new ActionListener() {

			@Override                                    //efective use of the override command 
			public void actionPerformed(ActionEvent e) {
				symbolText.setText("");
				nameText.setText("");
				quantityText.setText("");
				priceText.setText("");
				messageArea.setText("");
			}
		});

		buyBtn.addActionListener(new ActionListener() {
		/*
		truly overriding commands 
		*/
		/**
		 * 
		 * @param e
		 */

			@Override
			/**
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				int investmentType = typeComboBox.getSelectedIndex();
				String symbolStr = symbolText.getText();
				String nameStr = nameText.getText();
				int qnt = Integer.parseInt(quantityText.getText());
				double price = Double.parseDouble(priceText.getText());
				if (investmentType == 0) {
					Investment investment = portfolio.checkIfInvestmentExistBySymbol(symbolStr);
					if (investment == null) {
						String result = buyStock(symbolStr, nameStr, qnt, price);
						messageArea.setText(result);
						symbolText.setText("");
						nameText.setText("");
						quantityText.setText("");
						priceText.setText("");
					} else if (investment instanceof Stock) {
						Stock stock = (Stock) investment;
						double bookValue = ((price * qnt) + stock.getCommission()) + stock.getBookValue();
						int newQnt = stock.getQuantity() + qnt;
						double newPrice = (stock.getPrice() + price) / 2;
						stock.setQuantity(newQnt);
						stock.setBookValue(bookValue);
						stock.setPrice(newPrice);
						messageArea.setText(                 //represnting the updated part in mssg box
								"Quantity updated successfully.\n*****Stock details*****\n" + stock.toString());

						symbolText.setText("");
						nameText.setText("");
						quantityText.setText("");
						priceText.setText("");
					} else {
						messageArea.setText("entered symbol is mutual fund!");
					}

				} else if (investmentType == 1) {
					Investment investment = portfolio.checkIfInvestmentExistBySymbol(symbolStr);
					if (investment == null) {
						String result = buyMutualFund(symbolStr, nameStr, qnt, price);
						messageArea.setText(result);
						symbolText.setText("");
						nameText.setText("");
						quantityText.setText("");
						priceText.setText("");
					} else if (investment instanceof MutualFund) {
						MutualFund mutualFund = (MutualFund) investment;

						double bookValue = ((price * qnt) + mutualFund.getBookValue());
						int newQnt = mutualFund.getQuantity() + qnt;
						double newPrice = (mutualFund.getPrice() + price) / 2;
						mutualFund.setQuantity(newQnt);
						mutualFund.setBookValue(bookValue);
						mutualFund.setPrice(newPrice);
						messageArea.setText("Quantity updated successfully.\n*****Mutualfund details*****\n"
								+ mutualFund.toString());
						symbolText.setText("");
						nameText.setText("");
						quantityText.setText("");
						priceText.setText("");
					} else {
						messageArea.setText("entered symbol is stock.");
					}
				}

			}
		});

	}
	/*
	represents the string for buy stock*/

	private String buyStock(String symbol, String name, int qnt, double price) {
		if (qnt <= 0) {
			return "Quantity can not be less then equals to 0, please try again!";   //validity check 
		}

		if (price <= 0) {
			return "Price can not be less then equals to 0, please try again!";
		}
		double commision = 9.99;

		Stock stock = new Stock(symbol, name, qnt, price, commision);

		stock.setBookValue((price * qnt) + commision);

		if (portfolio.addInvestment(stock)) {
			return "Investment buying successfully.\n*****Stock details*****\n" + stock.toString();
		}
		return "Something went wrong, please try again!";
	}
	/*
	represents the string for buy mutualfund
	*/

	private String buyMutualFund(String symbol, String name, int qnt, double price) {

		if (qnt <= 0) {
			return "Quantity can not be less then equals to 0, please try again!";  //error checking 
		}

		if (price <= 0) {
			return "Price can not be less then equals to 0, please try again!";
		}

		MutualFund mutualFund = new MutualFund(symbol, name, qnt, price);

		mutualFund.setBookValue(price * qnt);

		if (portfolio.addInvestment(mutualFund)) {
			return "Investment buying successfully.\n*****Mutualfund details*****\n" + mutualFund.toString();
		}

		return "Something went wrong, please try again!";

	}
	/*
	represents the gui for sellpanel
	*/
	

	private void showSellPanel() {
		JPanel sellPanel = new JPanel();

		JPanel p1 = new JPanel();

		p1.setLayout(null);

		JLabel title = new JLabel("Selling an investment");
		title.setBounds(10, 5, 200, 50);

		JLabel symbol = new JLabel("Symbol");
		symbol.setBounds(20, 60, 50, 20);
		JTextField symbolText = new JTextField();
		symbolText.setBounds(80, 60, 150, 20);

		JLabel quantity = new JLabel("Quantity");
		quantity.setBounds(20, 100, 50, 20);
		JTextField quantityText = new JTextField();
		quantityText.setBounds(80, 100, 100, 20);

		JLabel price = new JLabel("Price");
		price.setBounds(20, 140, 50, 20);
		JTextField priceText = new JTextField();
		priceText.setBounds(80, 140, 100, 20);

		p1.add(title);
		p1.add(symbol);
		p1.add(symbolText);
		p1.add(quantity);
		p1.add(quantityText);
		p1.add(price);
		p1.add(priceText);

		getContentPane().removeAll();

		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
		sep.setBounds(0, 210, 600, 10);

		JSeparator sep1 = new JSeparator(SwingConstants.VERTICAL);
		sep1.setBounds(400, 0, 10, 210);

		sellPanel.add(sep);
		sellPanel.add(sep1);

		JPanel p2 = new JPanel();
		p2.setLayout(null);

		JButton resetBtn = new JButton("Reset");
		resetBtn.setBounds(80, 60, 120, 20);

		JButton sellBtn = new JButton("Sell");
		sellBtn.setBounds(80, 120, 120, 20);

		p2.add(resetBtn);
		p2.add(sellBtn);

		JPanel p3 = new JPanel();
		p3.setLayout(null);

		JLabel message = new JLabel("Message");
		message.setBounds(5, 5, 100, 20);

		JTextArea messageArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(messageArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(5, 30, 580, 90);

		p3.add(message);
		p3.add(scroll);

		sellPanel.setLayout(null);
		sellPanel.add(p1);
		sellPanel.add(p2);
		sellPanel.add(p3);
		p1.setBounds(0, 0, 300, 200);
		p2.setBounds(350, 0, 200, 150);
		p3.setBounds(0, 210, 600, 150);
		add(sellPanel);

		invalidate();
		validate();

		resetBtn.addActionListener(new ActionListener() {

			@Override                      //true overriding methods 
			public void actionPerformed(ActionEvent e) {
				symbolText.setText("");
				quantityText.setText("");
				priceText.setText("");
				messageArea.setText("");
			}
		});

		sellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String symbolStr = symbolText.getText();
				int qnt = Integer.parseInt(quantityText.getText());
				double price = Double.parseDouble(priceText.getText());

				Investment investment = portfolio.checkIfInvestmentExistBySymbol(symbolStr);
				if (investment != null && investment instanceof Stock) {
					String result = sellStock((Stock) investment, qnt, price);
					messageArea.setText(result);
					symbolText.setText("");
					quantityText.setText("");
					priceText.setText("");
				} else if (investment instanceof MutualFund) {         //proper use of abstract class and methods 
					String result = sellMutualFund((MutualFund) investment, qnt, price);
					messageArea.setText(result);
					symbolText.setText("");
					quantityText.setText("");
					priceText.setText("");
				} else {
					System.out.println("No investment found!");
				}
			}
		});

	}

	private String sellStock(Stock stock, int quantity, double price) {
		if (price <= 0) {
			return "Price can not be less then equals to 0, please try again!";
		}

		if (quantity <= 0) {
			return "Quantity can not be less then equals to 0, please try again!";
		}
		if (quantity <= stock.getQuantity()) {
			int newQnt = stock.getQuantity() - quantity;
			if (newQnt > 0) {
				double bookValue = stock.getBookValue() * newQnt / stock.getQuantity();
				stock.setBookValue(bookValue);
				stock.setQuantity(newQnt);
			} else {
				portfolio.getInvestments().remove(stock);
			}
			return "Sell stock successfully.\n*****Stock details*****\n" + stock.toString();
		} else {
			return "You don't have enough quantity to sell!";
		}

	}
	/*
	represents sell mutual funds phase 
	*/

	private String sellMutualFund(MutualFund mutualFund, int quantity, double price) {
		if (price <= 0) {
			return "Price can not be less then equals to 0, please try again!";
		}

		if (quantity <= 0) {
			return "Quantity can not be less then equals to 0, please try again!";
		}

		if (quantity <= mutualFund.getQuantity()) {
			int newQnt = mutualFund.getQuantity() - quantity;
			if (newQnt > 0) {
				double bookValue = mutualFund.getBookValue() * newQnt / mutualFund.getQuantity();
				mutualFund.setBookValue(bookValue);
				mutualFund.setQuantity(newQnt);
			} else {
				portfolio.getInvestments().remove(mutualFund);
			}
			return "Sell mutualfund success.\n*****Mutualfund details*****\n" + mutualFund.toString();
		} else {
			return "You don't have enough quantity to sell!";
		}
	}
	/*
	represents the update panel in gui
	*/

	private void showUpdatePanel() {
		JPanel updatePanel = new JPanel();

		JPanel p1 = new JPanel();

		p1.setLayout(null);

		JLabel title = new JLabel("Updating investments");
		title.setBounds(10, 5, 200, 50);

		JLabel symbol = new JLabel("Symbol");
		symbol.setBounds(20, 60, 50, 20);
		JTextField symbolText = new JTextField();
		symbolText.setBounds(80, 60, 150, 20);

		JLabel name = new JLabel("Name");
		name.setBounds(20, 100, 50, 20);
		JTextField nameText = new JTextField();
		nameText.setBounds(80, 100, 200, 20);

		JLabel price = new JLabel("Price");
		price.setBounds(20, 140, 50, 20);
		JTextField priceText = new JTextField();
		priceText.setBounds(80, 140, 100, 20);

		p1.add(title);
		p1.add(symbol);
		p1.add(symbolText);
		p1.add(name);
		p1.add(nameText);
		p1.add(price);
		p1.add(priceText);

		getContentPane().removeAll();

		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
		sep.setBounds(0, 210, 600, 10);

		JSeparator sep1 = new JSeparator(SwingConstants.VERTICAL);
		sep1.setBounds(400, 0, 10, 210);

		updatePanel.add(sep);
		updatePanel.add(sep1);

		JPanel p2 = new JPanel();
		p2.setLayout(null);

		JButton prevBtn = new JButton("Prev");
		prevBtn.setBounds(80, 60, 120, 20);

		JButton nextBtn = new JButton("Next");
		nextBtn.setBounds(80, 90, 120, 20);

		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(80, 120, 120, 20);

		p2.add(prevBtn);
		p2.add(nextBtn);
		p2.add(saveBtn);

		JPanel p3 = new JPanel();
		p3.setLayout(null);

		JLabel message = new JLabel("Message");
		message.setBounds(5, 5, 100, 20);

		JTextArea messageArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(messageArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(5, 30, 580, 90);

		p3.add(message);
		p3.add(scroll);

		updatePanel.setLayout(null);
		updatePanel.add(p1);
		updatePanel.add(p2);
		updatePanel.add(p3);
		p1.setBounds(0, 0, 300, 200);
		p2.setBounds(350, 0, 200, 150);
		p3.setBounds(0, 210, 600, 150);
		add(updatePanel);

		invalidate();
		validate();

		List<Investment> investments = portfolio.getInvestments();  
		if (investments != null) {
			Investment investment = investments.get(position);
			if (investment != null) {
				symbolText.setText(investment.getSymbol());
				nameText.setText(investment.getName());
				priceText.setText(investment.getPrice() + "");
			}
		}

		prevBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (position == 0) {
					return;
				}
				position--;

				Investment investment = investments.get(position);
				symbolText.setText(investment.getSymbol());
				nameText.setText(investment.getName());
				priceText.setText(investment.getPrice() + "");
			}
		});

		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (position == investments.size() - 1) {
					return;
				}
				position++;
				if (investments == null | investments.size() == 0) {
					return;
				}
				Investment investment = investments.get(position);
				if (investment == null) {
					return;
				}
				symbolText.setText(investment.getSymbol());
				nameText.setText(investment.getName());
				priceText.setText(investment.getPrice() + "");
			}
		});

		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Investment investment = investments.get(position);
				if (investment != null) {
					double price = Double.parseDouble(priceText.getText());
					messageArea.setText(update(investment, price));
				} else {
					messageArea.setText("No investment found!");
				}
			}
		});

	}

	private String update(Investment investment, double price) {  //privacy leak protetction
		investment.setPrice(price);
		return "Investment updated succfully.";
	}
	/*
	represents the panel for getgain to the user 
	*/

	private void showGetGainPanel() {
		JPanel buyPanel = new JPanel();

		JPanel p1 = new JPanel();

		p1.setLayout(null);

		JLabel title = new JLabel("Geting total gain");  //setting the components boundary 
		title.setBounds(10, 5, 200, 50);

		JLabel totalGain = new JLabel("Total gain");
		totalGain.setBounds(20, 50, 60, 20);
		JTextField totalGainText = new JTextField();
		totalGainText.setBounds(100, 50, 150, 20);

		p1.add(title);
		p1.add(totalGain);
		p1.add(totalGainText);

		getContentPane().removeAll();

		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
		sep.setBounds(0, 100, 600, 10);

		buyPanel.add(sep);

		JPanel p2 = new JPanel();
		p2.setLayout(null);

		JLabel message = new JLabel("Individual gains");  //representing the individual gain for each investment 
		message.setBounds(5, 5, 100, 20);

		JTextArea individualTextArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(individualTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(5, 30, 580, 200);  //setting bounds for scroll bar

		p2.add(message);
		p2.add(scroll);

		buyPanel.setLayout(null);
		buyPanel.add(p1);
		buyPanel.add(p2);
		p1.setBounds(0, 0, 200, 80);
		p2.setBounds(0, 100, 600, 300);
		add(buyPanel);

		invalidate();
		validate();

		if (portfolio.getInvestments() != null) {
			double totalGainAmt = 0.0;
			String gainStr = "";
			for (Investment investment : portfolio.getInvestments()) {
				if (investment instanceof Stock) {
					Stock stock = (Stock) investment;
					gainStr += stock.toString() + "\n";
					double gainValue = ((stock.getQuantity() * stock.getPrice()) - stock.getCommission())
							- stock.getBookValue();

					gainStr += "Gain for this stock is : " + gainValue + "\n\n";
					totalGainAmt += gainValue;
				} else if (investment instanceof MutualFund) {
					MutualFund mutualFund = (MutualFund) investment;
					gainStr += mutualFund.toString() + "\n";
					double gainValue = ((mutualFund.getQuantity() * mutualFund.getPrice()) - 45.00)  //implementing the formula for getgain
							- mutualFund.getBookValue();

					gainStr += "Gain for this mutualfund is : " + gainValue + "\n\n";
					totalGainAmt += gainValue;
				}
			}
			individualTextArea.setText(gainStr);
			totalGainText.setText(totalGainAmt + "");
		}

	}
	/*
	represents the search panel interface 
	*/

	private void showSearchPanel() {
		JPanel buyPanel = new JPanel();

		JPanel p1 = new JPanel();

		p1.setLayout(null);

		JLabel title = new JLabel("Searching investments");
		title.setBounds(10, 5, 200, 50);

		JLabel symbol = new JLabel("Symbol");
		symbol.setBounds(20, 50, 50, 20);
		JTextField symbolText = new JTextField();
		symbolText.setBounds(100, 50, 150, 20);

		JLabel name = new JLabel("<html>Name<br/>Keywords</html>"); //effective use of html to display texts 
		name.setBounds(20, 80, 50, 50);
		JTextField nameText = new JTextField();
		nameText.setBounds(100, 90, 200, 20);

		JLabel lowPrice = new JLabel("Low Price");
		lowPrice.setBounds(20, 130, 60, 20);
		JTextField lowPriceText = new JTextField();
		lowPriceText.setBounds(100, 130, 100, 20);

		JLabel highPrice = new JLabel("High Price");
		highPrice.setBounds(20, 160, 60, 20);
		JTextField highPriceText = new JTextField();
		highPriceText.setBounds(100, 160, 100, 20);

		p1.add(title);
		p1.add(symbol);
		p1.add(symbolText);
		p1.add(name);
		p1.add(nameText);
		p1.add(lowPrice);
		p1.add(lowPriceText);
		p1.add(highPrice);
		p1.add(highPriceText);

		getContentPane().removeAll();

		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
		sep.setBounds(0, 210, 600, 10);

		JSeparator sep1 = new JSeparator(SwingConstants.VERTICAL);
		sep1.setBounds(400, 0, 10, 210);

		buyPanel.add(sep);
		buyPanel.add(sep1);

		JPanel p2 = new JPanel();
		p2.setLayout(null);

		JButton resetBtn = new JButton("Reset");
		resetBtn.setBounds(80, 60, 120, 20);

		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				symbolText.setText("");
				nameText.setText("");
				lowPriceText.setText("");
				highPriceText.setText("");
			}
		});

		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(80, 120, 120, 20);

		p2.add(resetBtn);
		p2.add(searchBtn);

		JPanel p3 = new JPanel();
		p3.setLayout(null);

		JLabel message = new JLabel("Search results");  //setting the search button functionality according to the acceptance of GUI
		message.setBounds(5, 5, 100, 20);

		JTextArea messageArea = new JTextArea();

		JScrollPane scroll = new JScrollPane(messageArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(5, 30, 580, 90);

		p3.add(message);
		p3.add(scroll);

		buyPanel.setLayout(null);
		buyPanel.add(p1);
		buyPanel.add(p2);
		buyPanel.add(p3);
		p1.setBounds(0, 0, 300, 200);
		p2.setBounds(350, 0, 200, 150);
		p3.setBounds(0, 210, 600, 150);
		add(buyPanel);

		invalidate();
		validate();    //relayout all sizes 

		resetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				symbolText.setText("");
				nameText.setText("");
				lowPriceText.setText("");
				highPriceText.setText("");
				messageArea.setText("");
			}
		});
		/*
		implementing the search functionality
		*/

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String symbolStr = symbolText.getText();
				String nameStr = nameText.getText();
				String lowPrice = lowPriceText.getText();
				String highPrice = highPriceText.getText();

				if ((symbolStr != null && symbolStr.length() > 0) && (nameStr == null | nameStr.length() == 0)
						&& (lowPrice == null | lowPrice.length() == 0)
						&& (highPrice == null | highPrice.length() == 0)) {
					System.out.println("1");
					Investment investment = portfolio.checkIfInvestmentExistBySymbol(symbolStr);
					if (investment != null) {
						if (investment instanceof Stock) {
							messageArea.setText(((Stock) investment).toString());
						} else {
							messageArea.setText(((MutualFund) investment).toString());
						}
					} else {
						messageArea.setText("No investment found!");
					}
				} else if ((symbolStr == null | symbolStr.length() == 0) && (nameStr != null && nameStr.length() > 0)
						&& (lowPrice == null | lowPrice.length() == 0)
						&& (highPrice == null | highPrice.length() == 0)) {
					System.out.println("2");
					ArrayList<Investment> investments = portfolio.searchByKeyword(nameStr);
					if (investments != null && investments.size() > 0) {
						String result = "";
						for (Investment i : investments) {
							if (i instanceof Stock) {
								result += ((Stock) i).toString() + "\n";
							} else {
								result += ((MutualFund) i).toString() + "\n";
							}
						}
						if (result.length() > 0) {
							messageArea.setText(result);
						} else {
							messageArea.setText("");
						}
					} else {
						messageArea.setText("No investment found!");
					}

				} else if ((symbolStr != null && symbolStr.length() > 0) && (nameStr == null | nameStr.length() == 0)
						&& (lowPrice != null && lowPrice.length() > 0)
						&& (highPrice != null && highPrice.length() > 0)) {

					System.out.println("3");
					ArrayList<Investment> investments = portfolio.searchBySymbolAndPriceRange(symbolStr,
							lowPrice + "-" + highPrice);
					if (investments != null && investments.size() > 0) {
						String result = "";
						for (Investment i : investments) {
							if (i instanceof Stock) {
								result += ((Stock) i).toString() + "\n";
							} else {
								result += ((MutualFund) i).toString() + "\n";
							}
						}
						messageArea.setText(result);
					} else {
						messageArea.setText("No investment found!");
					}
				} else {
					messageArea.setText("No investment found!");
				}
			}
		});

	}

	@Override                     //true overriding methods 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buy)
			showBuyPanel();
		if (e.getSource() == sell)
			showSellPanel();
		if (e.getSource() == update)
			showUpdatePanel();
		if (e.getSource() == getGain)
			showGetGainPanel();
		if (e.getSource() == search)
			showSearchPanel();
		if (e.getSource() == quit)
			System.exit(0);                  //exiting from the system

	}
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EPortfolioGUI().createAndShowGUI();   // creating and showing the graphic user ineterface 

			}
		});

	}

}

package com.raingxm.finances;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.raingxm.finances.domain.Dollars;
import com.raingxm.finances.domain.InterestRate;
import com.raingxm.finances.domain.StockMarket;
import com.raingxm.finances.domain.TaxRate;
import com.raingxm.finances.domain.Year;
import com.raingxm.finances.ui.StockMarketTableModel;


public class Application extends JFrame {
	private static final long serialVersionUID = 1L;

	public Application() {
		this.setSize(1000, 400);
		this.setLocation(400, 300);
		
		Container container = this.getContentPane();
		container.add(table());
	}

	private JScrollPane table() {
		StockMarketTableModel model = new StockMarketTableModel(stockMarket());
		JTable table = new JTable(model);
		return new JScrollPane(table);
	}

	private StockMarket stockMarket() {
		Year startingYear = new Year(2010);
		Year endingYear = new Year(2050);
		Dollars startingBalance = new Dollars(10000);
		Dollars startingPrincipal = new Dollars(7000);
		InterestRate interestRate = new InterestRate(10);
		TaxRate capitalGainsTaxRate = new TaxRate(25);
		return new StockMarket(startingYear, endingYear, startingBalance, startingPrincipal, interestRate, capitalGainsTaxRate, new Dollars(0));
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
		System.out.println("Hello,world!");
	}
}

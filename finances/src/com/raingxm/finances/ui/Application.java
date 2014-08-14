package com.raingxm.finances.ui;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.raingxm.finances.domain.Dollars;
import com.raingxm.finances.domain.InterestRate;
import com.raingxm.finances.domain.StockMarket;
import com.raingxm.finances.domain.TaxRate;


public class Application extends JFrame {
	private static final long serialVersionUID = 1L;

	public Application() {
		this.setSize(1000, 400);
		this.setLocation(400, 300);
		
		Container container = this.getContentPane();
		container.add(table());
	}

	private JScrollPane table() {
		StockMarket market = new StockMarket(2010, 2050, new Dollars(10000), new Dollars(7000), new InterestRate(10), new TaxRate(25));
		StockMarketTableModel model = new StockMarketTableModel(market);
		JTable table = new JTable(model);
		return new JScrollPane(table);
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
		System.out.println("Hello,world!");
	}
}

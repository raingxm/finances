package com.raingxm.finances;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Application extends JFrame {
	private static final long serialVersionUID = 1L;

	public Application() {
		this.setSize(1000, 400);
		this.setLocation(400, 300);
		
		Container container = this.getContentPane();
		container.add(table());
	}

	private JScrollPane table() {
		StockMarketTableModel model = new StockMarketTableModel(2010, new Dollars(10000), new Dollars(7000), new InterestRate(10), new TaxRate(25));
		JTable table = new JTable(model);
		return new JScrollPane(table);
	}
	
	public static void main(String[] args) {
		new Application().setVisible(true);
		System.out.println("Hello,world!");
	}
}

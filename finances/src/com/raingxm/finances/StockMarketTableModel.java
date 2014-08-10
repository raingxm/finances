package com.raingxm.finances;

import javax.swing.table.AbstractTableModel;

public class StockMarketTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_TITLES = { "Year", "Starting Balance","Starting Principal", 
					"Withdrawals", "Appreciation", "Deposits", "Ending Balance" };
	
	private int year;
	private Dollars startingBalance;
	private Dollars startingPrincipal;
	private StockMarketYear marketYear;

	public StockMarketTableModel(int year, Dollars startingBalance, Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
		this.year = year;
		this.marketYear = new StockMarketYear(startingBalance, startingPrincipal, interestRate, capitalGainsTaxRate);
		this.startingBalance = startingBalance;
		this.startingPrincipal = startingPrincipal;
	}

	@Override
	public int getColumnCount() {
		return COLUMN_TITLES.length;
	}

	@Override
	public String getColumnName(int column) {
		return COLUMN_TITLES[column];
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0: return year;
			case 1: return marketYear.startingBalance();
			case 2: return marketYear.startingPrincipal(); 
			case 3: return marketYear.totalWithdrawn();
			default: return "";
		}
	}

}

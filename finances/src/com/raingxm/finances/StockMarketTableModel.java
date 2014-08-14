package com.raingxm.finances;

import javax.swing.table.AbstractTableModel;

public class StockMarketTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_TITLES = { "Year", "Starting Balance",
			"Starting Principal", "Withdrawals", "Appreciation",
			"Ending Balance" };
	private StockMarket market;
	
	public StockMarketTableModel(StockMarket market) {
		this.market = market;
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
		return market.numberOfYears();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return market.getStartingYear() + rowIndex;
		case 1:
			return market.getYear(rowIndex).startingBalance();
		case 2:
			return market.getYear(rowIndex).startingPrincipal();
		case 3:
			return market.getYear(rowIndex).totalWithdrawn();
		case 4:
			return market.getYear(rowIndex).appreciation();
		case 5:
			return market.getYear(rowIndex).endingBalance();
		default:
			return "";
		}
	}

}

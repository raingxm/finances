package com.raingxm.finances;

import javax.swing.table.AbstractTableModel;

public class StockMarketTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_TITLES = {"Year", "Starting Balance", "Starting Principal",
								"Withdrawals", "Appreciation", "Deposits", "Ending Balance"};

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
		return columnIndex;
	}

}

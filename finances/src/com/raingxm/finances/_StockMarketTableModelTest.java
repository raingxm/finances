package com.raingxm.finances;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class _StockMarketTableModelTest {

	private static final int YEAR = 2010;
	private static final Dollars STARTING_BALANCE = new Dollars(10000);
	private static final Dollars STARTING_PRINCIPAL = new Dollars(7000);
	private StockMarketTableModel model;

	@Before
	public void setup() {
		model = new StockMarketTableModel(YEAR, STARTING_BALANCE, STARTING_PRINCIPAL, new InterestRate(10), new TaxRate(25));
	}

	@Test
	public void columns() {
		assertEquals(7, model.getColumnCount());
		assertEquals("Year", model.getColumnName(0));
		assertEquals("Starting Balance", model.getColumnName(1));
		assertEquals("Starting Principal", model.getColumnName(2));
	}

	private static final String[] COLUMN_TITLES = { "Year", "Starting Balance","Starting Principal", 
		"Withdrawals", "Appreciation", "Deposits", "Ending Balance" };
	
	@Test
	public void firstRow() {
		assertEquals(YEAR, model.getValueAt(0, 0));
		assertEquals(STARTING_BALANCE, model.getValueAt(0, 1));
		assertEquals(STARTING_PRINCIPAL, model.getValueAt(0, 2));
		assertEquals(new Dollars(0), model.getValueAt(0, 3));
		assertEquals(new Dollars(1000), model.getValueAt(0, 4));
	}

}

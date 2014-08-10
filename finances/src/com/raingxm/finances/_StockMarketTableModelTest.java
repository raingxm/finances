package com.raingxm.finances;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class _StockMarketTableModelTest {

	private StockMarketTableModel model;

	@Before
	public void setup() {
		model = new StockMarketTableModel();
	}

	@Test
	public void columns() {
		assertEquals(7, model.getColumnCount());
		assertEquals("Year", model.getColumnName(0));
		assertEquals("Starting Balance", model.getColumnName(1));
		assertEquals("Starting Principal", model.getColumnName(2));
	}

	@Test
	public void firstRow() {

	}

}

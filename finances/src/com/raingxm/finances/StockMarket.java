package com.raingxm.finances;

public class StockMarket {

	private int startingYear;
	private int endingYear;
	private Dollars startingBalance;
	private Dollars startingPricipal;
	private InterestRate interestRate;
	private TaxRate capitalGainsRate;

	public StockMarket(int startingYear, int endingYear,
			Dollars startingBalance, Dollars startingPricipal,
			InterestRate interestRate, TaxRate capitalGainsRate) {
		this.startingYear = startingYear;
		this.endingYear = endingYear;
		this.startingBalance = startingBalance;
		this.startingPricipal = startingPricipal;
		this.interestRate = interestRate;
		this.capitalGainsRate = capitalGainsRate;

	}

	public StockMarketYear getYear(int offset) {
		StockMarketYear year = new StockMarketYear(startingBalance, startingPricipal, interestRate, capitalGainsRate);
		for(int i = 0; i < offset; i++) {
			year = year.nextYear();
		}
		return year;
	}

	public int numberOfYears() {
		return endingYear - startingYear + 1;
	}

}

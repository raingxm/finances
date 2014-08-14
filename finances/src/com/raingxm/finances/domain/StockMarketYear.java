package com.raingxm.finances.domain;

public class StockMarketYear {

	private Year year;
	private Dollars startingBalance;
	private Dollars startingPrincipal;
	private InterestRate interestRate;
	private TaxRate capitalGainsTaxRate;
	private Dollars totalWithdrawals;
	
	public StockMarketYear(Year year, Dollars startingBalance,Dollars startingPrincipal, InterestRate interestRate, TaxRate capitalGainsTaxRate) {
		this.year = year;
		this.startingBalance = startingBalance;
		this.startingPrincipal  = startingPrincipal;
		this.interestRate = interestRate;
		this.capitalGainsTaxRate = capitalGainsTaxRate;
		this.totalWithdrawals = new Dollars(0);
	}
	
	public Year year() {
		return year;
	}
	
	public Dollars startingBalance() {
		return startingBalance;
	}
	
	public Dollars startingPrincipal() {
		return startingPrincipal;
	}

	public InterestRate interestRate() {
		return interestRate;
	}

	public TaxRate capitalGainsTaxRate() {
		return capitalGainsTaxRate;
	}

	public void withdraw(Dollars amount) {
		this.totalWithdrawals = totalWithdrawals.add(amount);
	}

	private Dollars capitalGainsWithdrawn() {
		return totalWithdrawals.substractToZero(startingPrincipal());
	}

	public Dollars capitalGainsTaxIncurred() {
		return capitalGainsTaxRate.compoundTaxFor(capitalGainsWithdrawn());
	}
	
	public Dollars totalWithdrawn() {
		return totalWithdrawals.add(capitalGainsTaxIncurred());
	}
	
	public Dollars appreciation() {
		return interestRate.interestOn(startingBalance.substract(totalWithdrawn()));
	}

	public Dollars endingBalance() {
		return startingBalance.substract(totalWithdrawn()).add(appreciation());
	}

	public Dollars endingPrincipal() {
		return startingPrincipal.substractToZero(totalWithdrawals);
	}

	public StockMarketYear nextYear() {
		return new StockMarketYear(year.nextYear(), this.endingBalance(), this.endingPrincipal(), this.interestRate(), this.capitalGainsTaxRate());
	}

}
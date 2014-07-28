package com.raingxm.finances;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class _StockMarketYearTest {
	
	@Test
	public void startingValues() {
		StockMarketYear year = new StockMarketYear(10000,3000, 10);
		assertEquals("starting balance", 10000, year.startingBalance());
		assertEquals("starting principal", 3000, year.startingPrincipal());
		assertEquals("interest rate", 10, year.interestRate());
		assertEquals("total withdrawn default", 0, year.totalWithdrawn(25));
	}
	
	@Test
	public void endingPrincipal() {
		StockMarketYear year = new StockMarketYear(10000, 3000, 10);
		year.withdraw(1000);
		assertEquals("ending principal consider withdrawals", 2000, year.endingPrincipal());
		year.withdraw(500);
		assertEquals("ending principal consider totals multiple withdrawals", 1500, year.endingPrincipal());
		year.withdraw(3000);
		assertEquals("ending principal never goes below zero", 0, year.endingPrincipal());
	}

	@Test
	public void interestEarned() {
		StockMarketYear year = new StockMarketYear(10000, 3000, 10);
		assertEquals("basic interest earned", 1000, year.interestEarned(25));
		year.withdraw(2000);
		assertEquals("withdrawals don't earn interest", 800, year.interestEarned(25));
	}
	
	@Test
	public void interestEarnedIsStartingBalanceCombinedWithInterestRate() {
		StockMarketYear year = new StockMarketYear(10000, 3000, 10);
		assertEquals(1000,year.interestEarned(25));
	}
	
	@Test
	public void withdrawingFundsDoNotEarnInterest() {
		StockMarketYear year = newAccount();
		year.withdraw(1000);
		assertEquals(900, year.interestEarned(25));
	}
	
	@Test
	public void totalWithdrawIncludeCapitalGains() {
		StockMarketYear year = new StockMarketYear(10000, 0, 10);
		year.withdraw(1000);
		assertEquals("total withdrawn", 1333, year.totalWithdrawn(25));
	}
	
	@Test
	public void capitalGainsTaxesDoNotEarnInterest() {
		StockMarketYear year = new StockMarketYear(10000, 0, 10);
		year.withdraw(1000);
		assertEquals("capital gains withdrawn", 1000, year.capitalGainsWithdrawn());
		assertEquals("capital gains tax", 333, year.capitalGainsTaxIncurred(25));
		assertEquals("total withdrawn", 1333, year.totalWithdrawn(25));
		assertEquals("interest earned", 866, year.interestEarned(25));
	}
	
	@Test
	public void endingBalanceAppliesInteresRate() {
		assertEquals(11000, newAccount().endingBalance(25));
	}

	@Test
	public void multipleWithdrawalsInAYearAreTotaled() {
		StockMarketYear year = newAccount();
		year.withdraw(1000);
		year.withdraw(2000);
		assertEquals(3000, year.totalWithdrawn(25));
	}
	
	@Test
	public void withdrawingMoreThanPrincipalTakesFromCapitalGains() {
		StockMarketYear year = new StockMarketYear(10000, 3000, 10);
		year.withdraw(1000);
		assertEquals(0, year.capitalGainsWithdrawn());
		year.withdraw(3000);
		assertEquals(1000, year.capitalGainsWithdrawn());
	}
	
	@Test
	public void capitalGainsTaxIncurred_NeedsToCoverCapitalGainsWithdrawn_AND_theAdditionalCapitalGainsWithdrawnToPayCapitalGainsTax() {
		StockMarketYear year = new StockMarketYear(10000, 3000, 10);
		int amountWithdrawn = 5000;
		year.withdraw(amountWithdrawn);
		assertEquals(2000, year.capitalGainsWithdrawn());
		assertEquals(666, year.capitalGainsTaxIncurred(25));
	}
	
	@Test
	public void capitalGainsTaxIsIncludedInEndingBalance() {
		StockMarketYear year = new StockMarketYear(10000, 3000, 10);
		int amountWithdrawn = 5000;
		year.withdraw(amountWithdrawn);
		int expectedCapitalGainsTax = 666;
		assertEquals(expectedCapitalGainsTax,year.capitalGainsTaxIncurred(25));
		int expectedStartingBalanceAfterWithdrawals = 10000 - amountWithdrawn - expectedCapitalGainsTax;
		assertEquals((int)(expectedStartingBalanceAfterWithdrawals * 1.10), year.endingBalance(25));
		// TODO: Need to withdraw enough money to cover capital gains tax; that money will also be taxed.
	}
	
	@Test
	public void nextYear() {
		StockMarketYear thisYear = newAccount();
		StockMarketYear nextYear = thisYear.nextYear(25);
		assertEquals("starting balance", thisYear.endingBalance(25), nextYear.startingBalance());
		assertEquals("starting principal", thisYear.endingPrincipal(),nextYear.startingPrincipal());
		assertEquals(thisYear.interestRate(), nextYear.interestRate());
	}
	
	private StockMarketYear newAccount() {
		StockMarketYear account = new StockMarketYear(10000, 10000, 10);
		return account;
	}
}

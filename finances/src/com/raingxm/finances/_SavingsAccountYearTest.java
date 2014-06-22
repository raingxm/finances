package com.raingxm.finances;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class _SavingsAccountYearTest {
	
	@Test
	public void startingBalanceMatchesConstructor() {
		assertEquals(10000, newAccount().startingBalance());
	}
	
	@Test
	public void interestRateMatchesConstructor() {
		assertEquals(10, newAccount().interestRate());
	}
	
	@Test
	public void endingBalanceAppliesInteresRate() {
		assertEquals(11000, newAccount().endingBalance());
	}
	
	@Test
	public void nextYearStartingBalanceEqualsThisYearsEndingBalance() {
		SavingsAccountYear nextYear = newAccount();
		assertEquals(nextYear.endingBalance(), nextYear.nextYear().startingBalance());
	}	
	
	@Test
	public void nextYearsInterestRateEqualsThisYearsInterestRate() {
		SavingsAccountYear thisYear = newAccount();
		assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
	}
	
	@Test
	public void withdrawingFundsOccursAtTheBeginningOfTheYear() {
		SavingsAccountYear year = new SavingsAccountYear(10000, 10);
		year.withdraw(1000);
		assertEquals(9900, year.endingBalance());
	}
	
	@Test
	public void withdrawingMoreThanPrincipalIncursCapitalGainsTax() {
		SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
		year.withdraw(3000);
		assertEquals(7700, year.endingBalance());
		year.withdraw(5000);
		assertEquals(2000 + 200 - 1250, year.endingBalance());
	}
	
	private SavingsAccountYear newAccount() {
		SavingsAccountYear account = new SavingsAccountYear(10000,10);
		return account;
	}
}
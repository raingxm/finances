package com.raingxm.finances;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class _SavingsAccountYearTest {
	
	@Test
	public void startingBalance(){
		SavingsAccountYear account = new SavingsAccountYear(10000,10);
		assertEquals(10000, account.startingBalance());
	}
	
	@Test
	public void endingBaqlance() {
		SavingsAccountYear account = new SavingsAccountYear(10000,10);
		assertEquals(11000, account.endBalance());
	}
	
	@Test
	public void nextYearStartingBalanceShouldEqualThisYearsEndingBalance() {
		SavingsAccountYear nextYear = new SavingsAccountYear(10000,10);
		assertEquals(nextYear.endBalance(), nextYear.nextYear().startingBalance());
	}	
	
	@Test
	public void nextYearsInterestRateEqualThisYearsInterestRate() {
		SavingsAccountYear thisYear = new SavingsAccountYear(10000,10);
		assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
	}
}

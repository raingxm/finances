package com.raingxm.finances;

import static org.junit.Assert.*;

import org.junit.Test;

public class _TaxRateTest {

	@Test
	public void nothing() {
		TaxRate taxRate = new TaxRate(0);
		assertEquals(new Dollars(0), taxRate.simpleTaxFor(new Dollars(1000)));
		assertEquals(new Dollars(0), taxRate.compoundTaxFor(new Dollars(1000)));
	}
	
	@Test
	public void simpleTaxJustAppliesTaxRateToAmount() {
		TaxRate taxRate = new TaxRate(25);
		assertEquals(new Dollars(250), taxRate.simpleTaxFor(new Dollars(1000)));
	}
	
	@Test
	public void compoundTaxIsTheAmountOfTaxThatIsIncurredIfYouAlsoPayTaxOnTheTax() {
		TaxRate taxRate = new TaxRate(25);
		assertEquals(new Dollars(333), taxRate.compoundTaxFor(new Dollars(1000)));
	}
	
	@Test
	public void valueObject() {
		TaxRate rate1a = new TaxRate(33);
		TaxRate rate1b = new TaxRate(33);
		TaxRate rate2 = new TaxRate(40);
		
		assertEquals("33.0%", rate1a.toString());
		assertTrue("same values should be equal", rate1a.equals(rate1a));
		assertFalse("different values should be false", rate1a.equals(rate2));
		assertTrue("same values have same hash code", rate1a.hashCode() == rate1b.hashCode());
	}
}

package com.raingxm.finances.domain;

public class Dollars {

	private double amount;

	public Dollars(int amount) {
		this.amount = amount;
	}
	
	public Dollars(double amount) {
		this.amount = amount;
	}
	
	public Dollars plus(Dollars dollars) {
		return new Dollars(this.amount + dollars.amount);
	}

	public Dollars minus(Dollars dollars) {
		return new Dollars(this.amount - dollars.amount);
	}

	public Dollars substractToZero(Dollars dollars) {
		double reuslt = this.amount - dollars.amount;
		return new Dollars(Math.max(0, reuslt));
	}

	public Dollars percentage(double percent) {
		return new Dollars(this.amount * percent / 100);
	}

	public Dollars minOfTwoValues(Dollars value2) {
		return new Dollars(Math.min(this.amount, value2.amount));
	}

	private long roundOffPennies() {
		return Math.round(this.amount);
	}

	@Override
	public String toString() {
		return "$" + roundOffPennies();
	}

	@Override
	public int hashCode() {
		return (int)roundOffPennies();
	}

	@Override
	public boolean equals(Object obj) {
		Dollars that = (Dollars)obj;
		return roundOffPennies() == that.roundOffPennies();
	}
}

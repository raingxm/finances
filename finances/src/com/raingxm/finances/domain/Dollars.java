package com.raingxm.finances.domain;

public class Dollars {

	private double amount;

	public Dollars(int amount) {
		this.amount = amount;
	}
	
	public Dollars(double amount) {
		this.amount = amount;
	}
	
	public Dollars add(Dollars dollars) {
		return new Dollars(this.amount + dollars.amount);
	}

	public Dollars substract(Dollars dollars) {
		return new Dollars(this.amount - dollars.amount);
	}

	public Dollars substractToZero(Dollars dollars) {
		double reuslt = this.amount - dollars.amount;
		return new Dollars(Math.max(0, reuslt));
	}

	public Dollars percentage(double percent) {
		return new Dollars((int)(this.amount * percent / 100));
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
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Dollars that = (Dollars)obj;
		return roundOffPennies() == that.roundOffPennies();
	}
}

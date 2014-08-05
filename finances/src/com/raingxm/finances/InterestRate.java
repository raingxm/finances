package com.raingxm.finances;

public class InterestRate {
	
	private double rate;
	
	public InterestRate(int rateAsPercentage) {
		this.rate = rateAsPercentage / 100.0;
	}

	public Dollars interestOn(Dollars amount) {
		return new Dollars((int)(amount.toInt() * rate));
	}

	@Override
	public String toString() {
		return (rate * 100) + "%";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterestRate other = (InterestRate) obj;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		return true;
	}
}

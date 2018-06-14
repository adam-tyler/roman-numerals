package com.el.onboarding.junit.romanNumerals.services;

public class HinduToRomanNumeralConverter {
	private int remainder;
	private String numeral = "";
	
	public String convert(int number) {
		this.remainder = number;
		while (this.remainder > 0) {
			if (this.remainder >= 1000) {
				processStep(1000, "M");
			} else if(this.remainder >= 900) {
				processStep(900, "CM");
			} else if(this.remainder >= 500) {
				processStep(500, "D");
			} else if(this.remainder >= 400) {
				processStep(400, "CD");
			} else if(this.remainder >= 100) {
				processStep(100, "C");
			} else if(this.remainder >= 90) {
				processStep(90, "XC");
			} else if(this.remainder >= 50) {
				processStep(50, "L");
			} else if(this.remainder >= 40) {
				processStep(40, "XL");
			} else if(this.remainder >= 10) {
				processStep(10, "X");
			} else if(this.remainder >= 9) {
				processStep(9, "IX");
			} else if(this.remainder >= 5) {
				processStep(5, "V");
			} else if(this.remainder >= 4) {
				processStep(4, "IV");
			} else {
				numeral = numeral + repeat("I", this.remainder);
				this.remainder = 0;
			}
		}
		return numeral;
	}
	
	private void processStep(int divideBy, String conversion) {
		int q = this.remainder / divideBy;
		this.numeral += repeat(conversion, q);
		this.remainder = this.remainder % divideBy;
	}
	
	private String repeat(String str, int numberOfTimes) {
		String repeated = "";
		for(int i = 0; i < numberOfTimes; i++) {
			repeated+= str;
		}
		return repeated;
	}
}

package com.calculator.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculatorRequest {

	@JsonProperty(value = "number1")
	double number1;
	
	@JsonProperty(value = "number2")
	double number2;

	public double getNumber1() {
		return number1;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalculatorRequest [number1=");
		builder.append(number1);
		builder.append(", number2=");
		builder.append(number2);
		builder.append("]");
		return builder.toString();
	}
	
	
}

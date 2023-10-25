package com.calculator.service;

import org.springframework.stereotype.Component;

@Component
public interface CalculatorService {
	
	public double getAddition(double number1,double number2);
	
	public double getSubstraction(double number1,double number2);

	public double getDivision(double number1,double number2);

	public double getMultiplication(double number1,double number2);

	public double getSquare(String number);

	public double getSquareRoot(String number);

	public double getFactorial(String number);


}

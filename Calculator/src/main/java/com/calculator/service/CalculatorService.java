package com.calculator.service;

import org.springframework.stereotype.Component;

import com.calculator.request.CalculatorRequest;
import com.calculator.response.CalculatorResponse;

@Component
public interface CalculatorService {
	
	public CalculatorResponse getAddition(CalculatorRequest calculatorRequest);
	
	public CalculatorResponse getSubstraction(CalculatorRequest calculatorRequest);

	public CalculatorResponse getDivision(CalculatorRequest calculatorRequest);

	public CalculatorResponse getMultiplication(CalculatorRequest calculatorRequest);

	public CalculatorResponse getSquare(double number);

	public CalculatorResponse getSquareRoot(double number);

	public CalculatorResponse getFactorial(double number);


}

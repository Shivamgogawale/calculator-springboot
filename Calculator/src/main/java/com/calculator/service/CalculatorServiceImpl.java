package com.calculator.service;

import org.springframework.stereotype.Service;

import com.calculator.request.MinMaxRequest;
import com.calculator.response.CalculatorResponse;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public double getAddition(double number1, double number2) {
		return number1+number2;
	}

	@Override
	public double getSubstraction(double number1, double number2) {
		return number1 - number2;
	}

	@Override
	public double getDivision(double number1, double number2) {
		return number1/number2;
	}

	@Override
	public double getMultiplication(double number1, double number2) {
		return number1 *number2 ;
	}

	@Override
	public double getSquare(String number) {
		return Double.parseDouble(number)*Double.parseDouble(number);
	}

	@Override
	public double getSquareRoot(String number) {
		return Math.sqrt(Double.parseDouble(number));
	}

	@Override
	public double getFactorial(String number) {

		double ans=Double.parseDouble(number);
		for(double i=1;i<Double.parseDouble(number);i++)
		{
			ans=ans*i;
		}
		return ans;
	}

	

}

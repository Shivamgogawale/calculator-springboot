package com.calculator.transformer;

import org.springframework.stereotype.Component;

import com.calculator.jpa.CalculatorData;
import com.calculator.response.CalculatorResponse;
import com.calculator.util.Constants;
import com.calculator.util.Util;

@Component("calculatorTransformer")
public class CalculatorTransformer {

	public CalculatorResponse transformToObject(CalculatorData calculatorData)
	{
		CalculatorResponse calculatorResponse=new CalculatorResponse();
		calculatorResponse.setAnswer(Util.getFormattedString(calculatorData.getResult()));
		calculatorResponse.setDetails(getDetailsResponse(calculatorData));
		return calculatorResponse; 		
	}
	
	public String getDetailsResponse(CalculatorData calculatorData)
	{
		if(calculatorData.getOperation().equals(Constants.Addition))
			return Util.getFormattedString(calculatorData.getNumber1())+ " + "+Util.getFormattedString(calculatorData.getNumber2())+" = "+Util.getFormattedString(calculatorData.getResult());
		if(calculatorData.getOperation().equals(Constants.Substraction))
			return Util.getFormattedString(calculatorData.getNumber1())+ " - "+Util.getFormattedString(calculatorData.getNumber2())+" = "+Util.getFormattedString(calculatorData.getResult());
		if(calculatorData.getOperation().equals(Constants.Division))
			return Util.getFormattedString(calculatorData.getNumber1())+ " / "+Util.getFormattedString(calculatorData.getNumber2())+" = "+Util.getFormattedString(calculatorData.getResult());
		if(calculatorData.getOperation().equals(Constants.Multiplication))
			return Util.getFormattedString(calculatorData.getNumber1())+ " * "+Util.getFormattedString(calculatorData.getNumber2())+" = "+Util.getFormattedString(calculatorData.getResult());
		if(calculatorData.getOperation().equals(Constants.Factorial))
			return Util.getFormattedString(calculatorData.getNumber1())+ " ! "+" = "+Util.getFormattedString(calculatorData.getResult());
		if(calculatorData.getOperation().equals(Constants.Square))
			return Constants.Square + " of "+Util.getFormattedString(calculatorData.getNumber1())+" = "+Util.getFormattedString(calculatorData.getResult());
		if(calculatorData.getOperation().equals(Constants.Squareroot))
			return Constants.Squareroot + " of "+Util.getFormattedString(calculatorData.getNumber1())+" = "+Util.getFormattedString(calculatorData.getResult());
		return null;
	}
}

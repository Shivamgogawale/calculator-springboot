package com.calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.request.MinMaxRequest;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;
import com.calculator.service.CalculatorServiceImpl;
import com.calculator.util.Util;

@RestController
@RequestMapping(value = "/calculatorapi/v1")
@ComponentScan(basePackages = "com.calculator")
public class CalculatorController {
	
	 
	CalculatorResponse calculatorResponse=new CalculatorResponse();
	
	@Autowired
	CalculatorServiceImpl calculatorServiceImpl;
	 
	
		@GetMapping(value = "/addition")
		public CalculatorResponse getAddition(@RequestParam double number1 ,@RequestParam double number2)
		{
			calculatorResponse.setAnswer(Util.getFormattedString(calculatorServiceImpl.getAddition(number1, number2)));
			calculatorResponse.setDetails(Util.getFormattedString(number1)+" + "+ Util.getFormattedString(number2) +" = "+Util.getFormattedString(calculatorServiceImpl.getAddition(number1, number2)));
			return calculatorResponse;
		}
		
		@GetMapping(value = "/substraction")
		public CalculatorResponse getSubstraction(@RequestParam double number1,@RequestParam double number2)
		{
			calculatorResponse.setAnswer(Util.getFormattedString(calculatorServiceImpl.getSubstraction(number1, number2)));
			calculatorResponse.setDetails(Util.getFormattedString(number1)+" - "+Util.getFormattedString(number2)+" = "+Util.getFormattedString(calculatorServiceImpl.getSubstraction(number1, number2)));
			return calculatorResponse;
		}
		@GetMapping(value = "/multiplication")
		public CalculatorResponse getmultiplication(@RequestParam double number1 ,@RequestParam double number2)
		{
			calculatorResponse.setAnswer(Util.getFormattedString(calculatorServiceImpl.getMultiplication(number1, number2)));
			calculatorResponse.setDetails(Util.getFormattedString(number1)+" * "+ Util.getFormattedString(number2) +" = "+Util.getFormattedString(calculatorServiceImpl.getMultiplication(number1, number2)));
			return calculatorResponse;
		}
		@GetMapping(value = "/division")
		public CalculatorResponse getDivision(@RequestParam double number1,@RequestParam double number2)
		{
			if(number2 == 0)
			{
				calculatorResponse.setAnswer("undifined");
				calculatorResponse.setDetails("Number Should not be Zero");
				return calculatorResponse;
			}			
			calculatorResponse.setAnswer(Util.getFormattedString(calculatorServiceImpl.getDivision(number1, number2)));
			calculatorResponse.setDetails(Util.getFormattedString(number1)+" / "+Util.getFormattedString(number2) + " = "+Util. getFormattedString(calculatorServiceImpl.getDivision(number1, number2)));
			return calculatorResponse;
			
		}
		 
		@GetMapping(value = "/square/{number}")
		public CalculatorResponse getSquare(@PathVariable String number)
		{
			calculatorResponse.setAnswer(Util.getFormattedString(calculatorServiceImpl.getSquare(number)));
			calculatorResponse.setDetails("Square of "+Util.getFormattedString(Double.parseDouble(number))+" = " +Util.getFormattedString(calculatorServiceImpl.getSquare(number)));
			return calculatorResponse;
		}
		
		@GetMapping(value = "/squareroot/{number}")
		public CalculatorResponse getsquareroot(@PathVariable String number)
		{
			calculatorResponse.setAnswer(Util.getFormattedString(calculatorServiceImpl.getSquareRoot(number)));
			calculatorResponse.setDetails("Squareroot of "+Util.getFormattedString(Double.parseDouble(number))+" = "+Util.getFormattedString(calculatorServiceImpl.getSquareRoot(number)));
			return calculatorResponse;
		}

		@GetMapping(value = "/factorial/{number}")
		public CalculatorResponse getFactorial(@PathVariable String number)
		{
			
			calculatorResponse.setAnswer(Util.getFormattedString(calculatorServiceImpl.getFactorial(number)));
			calculatorResponse.setDetails(Util.getFormattedString(Double.parseDouble(number))+"! = "+Util.getFormattedString(calculatorServiceImpl.getFactorial(number)));
			return calculatorResponse;
		}
		
		@PostMapping(value = "/min-max")
		public MinMaxResponse getminmax(@RequestBody MinMaxRequest list)
		{
			List<Integer> numbers=list.getList();
			MinMaxResponse minmaxres=new MinMaxResponse();
			minmaxres.setMin(numbers.stream().sorted().findFirst().get());
			minmaxres.setMax(numbers.stream().max(Integer::compareTo).orElse(null));
			return minmaxres;
		}
		
		
}

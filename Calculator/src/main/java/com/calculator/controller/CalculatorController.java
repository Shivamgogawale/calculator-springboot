package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.request.CalculatorRequest;
import com.calculator.request.MinMaxRequest;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;
import com.calculator.service.CalculatorServiceImpl;
import com.calculator.util.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/calculatorapi/v1")
@ComponentScan(basePackages = "com.calculator")
@Api(value = "/calculatorapi")
public class CalculatorController {	 
	
	@Autowired
	private CalculatorServiceImpl calculatorServiceImpl;
	 
	
		@GetMapping(value = "/addition")
		@ApiOperation(value = "Add two numbers",notes = "This api uses for adding two numbers")
		public CalculatorResponse getAddition(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
											@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getAddition() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse  = calculatorServiceImpl.getAddition(calculatorRequest);
			log.info("CalculatorController.getAddition() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		
		@GetMapping(value = "/substraction")
		@ApiOperation(value = "Substract two numbers",notes = "This api uses for substracting two numbers")
		public CalculatorResponse getSubstraction(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
				@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getSubstraction() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse = calculatorServiceImpl.getSubstraction(calculatorRequest);
			log.info("CalculatorController.getSubstraction() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		@GetMapping(value = "/multiplication")
		@ApiOperation(value = "multiply two numbers",notes = "This api uses for multipliccation of two numbers")
		public CalculatorResponse getmultiplication(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
				@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getmultiplication() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse = calculatorServiceImpl.getMultiplication(calculatorRequest);
			log.info("CalculatorController.getmultiplication() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		@GetMapping(value = "/division")
		@ApiOperation(value = "Divide two numbers",notes = "This api uses for division of two numbers")
		public CalculatorResponse getDivision(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
				@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getDivision() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse = calculatorServiceImpl.getDivision(calculatorRequest);
			log.info("CalculatorController.getDivision() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
			
		}
		 
		@GetMapping(value = "/square/{number}")
		@ApiOperation(value = "Get square number",notes = "This api uses for square number")
		public CalculatorResponse getSquare(@ApiParam(value = "number",required = true,defaultValue = "0")@PathVariable double number)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getSquare() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			calculatorResponse = calculatorServiceImpl.getSquare(number);
			log.info("CalculatorController.getSquare() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		
		@GetMapping(value = "/squareroot/{number}")
		@ApiOperation(value = "Get squareroot number",notes = "This api uses for get squareroot of number")
		public CalculatorResponse getsquareroot(@ApiParam(value = "number",required = true,defaultValue = "0")@PathVariable double number)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getsquareroot() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			calculatorResponse=calculatorServiceImpl.getSquareRoot(number);
			log.info("CalculatorController.getsquareroot() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}

		@GetMapping(value = "/factorial/{number}")
		@ApiOperation(value = "Get factorial numbers",notes = "This api use for get factorial numbers")
		public CalculatorResponse getFactorial(@ApiParam(value = "number",required = true,defaultValue = "0")@PathVariable double number)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getFactorial() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			
			calculatorResponse= calculatorServiceImpl.getFactorial(number);
			
			log.info("CalculatorController.getFactorial() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		
		@PostMapping(value = "/min-max")
		@ApiOperation(value = "Get Minimum Maximum",notes = "This api uses for getting maximum and minimum numbers")
		public MinMaxResponse getminmax(@RequestBody MinMaxRequest minMaxRequest)
		{
			MinMaxResponse minMaxResponse;
			long startTime=System.currentTimeMillis();
			log.info("CalculatorController.getminmax() start ");
			log.info(Constants.TIME_ELAPSED,startTime);
			minMaxResponse = calculatorServiceImpl.getMinMax(minMaxRequest);
			log.info("CalculatorController.getminmax() End");
			log.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return minMaxResponse;
		}
		
		public CalculatorRequest prepareRequest(double number1,double number2)
		{
			CalculatorRequest calculatorRequest = new CalculatorRequest();
			calculatorRequest.setNumber1(number1);
			calculatorRequest.setNumber2(number2);
			return calculatorRequest;
		}
		
	
}

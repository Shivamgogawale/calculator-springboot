package com.calculator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@RestController
@RequestMapping(value = "/calculatorapi/v1")
@ComponentScan(basePackages = "com.calculator")
@Api(value = "/calculatorapi")
public class CalculatorController {
	
	private static final Logger logger=LoggerFactory.getLogger(CalculatorController.class);
	 
	
	@Autowired
	CalculatorServiceImpl calculatorServiceImpl;
	 
	
		@GetMapping(value = "/addition")
		@ApiOperation(value = "Add two numbers",notes = "This api uses for adding two numbers")
		public CalculatorResponse getAddition(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
											@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getAddition() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse  = calculatorServiceImpl.getAddition(calculatorRequest);
			logger.info("CalculatorController.getAddition() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		
		@GetMapping(value = "/substraction")
		@ApiOperation(value = "Substract two numbers",notes = "This api uses for substracting two numbers")
		public CalculatorResponse getSubstraction(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
				@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getSubstraction() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse = calculatorServiceImpl.getSubstraction(calculatorRequest);
			logger.info("CalculatorController.getSubstraction() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		@GetMapping(value = "/multiplication")
		@ApiOperation(value = "multiply two numbers",notes = "This api uses for multipliccation of two numbers")
		public CalculatorResponse getmultiplication(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
				@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getmultiplication() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse = calculatorServiceImpl.getMultiplication(calculatorRequest);
			logger.info("CalculatorController.getmultiplication() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		@GetMapping(value = "/division")
		@ApiOperation(value = "Divide two numbers",notes = "This api uses for division of two numbers")
		public CalculatorResponse getDivision(@ApiParam(value = "number1",required = true,defaultValue = "0") @RequestParam double number1,
				@ApiParam(value = "number2",required = true,defaultValue = "0")@RequestParam double number2)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getDivision() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			CalculatorRequest calculatorRequest=prepareRequest(number1, number2);
			calculatorResponse = calculatorServiceImpl.getDivision(calculatorRequest);
			logger.info("CalculatorController.getDivision() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
			
		}
		 
		@GetMapping(value = "/square/{number}")
		@ApiOperation(value = "Get square number",notes = "This api uses for square number")
		public CalculatorResponse getSquare(@ApiParam(value = "number",required = true,defaultValue = "0")@PathVariable double number)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getSquare() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			calculatorResponse = calculatorServiceImpl.getSquare(number);
			logger.info("CalculatorController.getSquare() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		
		@GetMapping(value = "/squareroot/{number}")
		@ApiOperation(value = "Get squareroot number",notes = "This api uses for get squareroot of number")
		public CalculatorResponse getsquareroot(@ApiParam(value = "number",required = true,defaultValue = "0")@PathVariable double number)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getAddition() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			calculatorResponse=calculatorServiceImpl.getSquareRoot(number);
			logger.info("CalculatorController.getAddition() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}

		@GetMapping(value = "/factorial/{number}")
		@ApiOperation(value = "Get factorial numbers",notes = "This api use for get factorial numbers")
		public CalculatorResponse getFactorial(@ApiParam(value = "number",required = true,defaultValue = "0")@PathVariable double number)
		{
			CalculatorResponse calculatorResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getAddition() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			calculatorResponse= calculatorServiceImpl.getFactorial(number);
			logger.info("CalculatorController.getAddition() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
			return calculatorResponse;
		}
		
		@PostMapping(value = "/min-max")
		@ApiOperation(value = "Get Minimum Maximum",notes = "This api uses for getting maximum and minimum numbers")
		public MinMaxResponse getminmax(@RequestBody MinMaxRequest minMaxRequest)
		{
			MinMaxResponse minMaxResponse;
			long startTime=System.currentTimeMillis();
			logger.info("CalculatorController.getAddition() start ");
			logger.info(Constants.TIME_ELAPSED,startTime);
			minMaxResponse = calculatorServiceImpl.getMinMax(minMaxRequest);
			logger.info("CalculatorController.getAddition() End");
			logger.info(Constants.TIME_ELAPSED,System.currentTimeMillis()-startTime);
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

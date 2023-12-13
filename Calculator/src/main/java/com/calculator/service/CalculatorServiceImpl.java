package com.calculator.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.calculator.dao.CalculatorDaoImpl;
import com.calculator.jpa.CalculatorData;
import com.calculator.jpa.MinMaxData;
import com.calculator.request.CalculatorRequest;
import com.calculator.request.MinMaxRequest;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;
import com.calculator.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	public CalculatorDaoImpl calculatorDaoImpl;

	
	/**
	 * Calculate the Addition of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	@Cacheable(value = "calculatorCache", key = "'addition:' + #calculatorRequest.number1 + ':' + #calculatorRequest.number2", unless = "#result == null")
	public CalculatorResponse getAddition(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getAddition() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		double result = calculatorRequest.getNumber1() + calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Addition, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		log.info("CalculatorServiceImpl.getAddition() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Substraction of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	@Cacheable(value = "calculatorCache", key = "'substraction:' + #calculatorRequest.number1 + ':' + #calculatorRequest.number2", unless = "#result == null")
	public CalculatorResponse getSubstraction(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getSubstraction() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		double result = calculatorRequest.getNumber1() - calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Substraction, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		log.info("CalculatorServiceImpl.getSubstraction() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Division of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	@Cacheable(value = "calculatorCache", key = "'division:' + #calculatorRequest.number1 + ':' + #calculatorRequest.number2", unless = "#result == null")
	public CalculatorResponse getDivision(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getDivision() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		if (calculatorRequest.getNumber2() == 0) {
			log.error("Division By Zero is not allowed");
			calculatorResponse.setAnswer("undefined");
			calculatorResponse.setDetails("Division by zero is Not Allowed");
			return calculatorResponse;
		}
		double result = calculatorRequest.getNumber1() / calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Division, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		log.info("CalculatorServiceImpl.getDivision() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Multiplication of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	@Cacheable(value = "calculatorCache", key = "'multiplication:' + #calculatorRequest.number1 + ':' + #calculatorRequest.number2", unless = "#result == null")
	public CalculatorResponse getMultiplication(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getMultiplication() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		double result = calculatorRequest.getNumber1() * calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Multiplication, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		log.info("CalculatorServiceImpl.getMultiplication() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Square of given number
	 * 
	 * @param number1
	 * @return CalculatorResponse
	 */
	@Override
	@Cacheable(value = "calculatorCache", key = "'square:' + #number", unless = "#result == null")
	public CalculatorResponse getSquare(double number) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getSquare() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		double result = number * number;
		CalculatorData calculatorData = prepareRequestForOtherOperations(number, Constants.Square, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		log.info("CalculatorServiceImpl.getSquare() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;

	}

	/**
	 * Calculate the Squareroot of given number
	 * 
	 * @param number1
	 * @return CalculatorResponse
	 */
	@Override
	@Cacheable(value = "calculatorCache", key = "'squareroot:' + #number", unless = "#result == null")
	public CalculatorResponse getSquareRoot(double number) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getSquareRoot() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		double result = Math.sqrt(number);
		CalculatorData calculatorData = prepareRequestForOtherOperations(number, Constants.Squareroot, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		log.info("CalculatorServiceImpl.getSquareRoot() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;

	}

	/**
	 * Calculate the factorial of given number
	 * 
	 * @param number1
	 * @return CalculatorResponse
	 */
	@Override
	@Cacheable(value = "calculatorCache", key = "'factorial:' + #number", unless = "#result == null")
	public CalculatorResponse getFactorial(double number) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getFactorial() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		int fact = 1;
		for (int i = 1; i <number ; i++) {
			fact = fact * i;
		}
		CalculatorData calculatorData = prepareRequestForOtherOperations(number, Constants.Factorial, fact);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		log.info("CalculatorServiceImpl.getFactorial() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}
	
	@Override
	@Cacheable(value = "minMaxCache", key = "'minmax:' + #minMaxRequest.getList()", unless = "#result == null")
	public MinMaxResponse getMinMax(MinMaxRequest minMaxRequest) {
		long startTime = System.currentTimeMillis();
		log.info("CalculatorServiceImpl.getMinMax() start ");
		log.info(Constants.TIME_ELAPSED, startTime);
		MinMaxData prepareRequestForMinMax = prepareRequestForMinMax(minMaxRequest);
		MinMaxResponse minmaxres = calculatorDaoImpl.saveMinMax(prepareRequestForMinMax);
		log.info("CalculatorServiceImpl.getMinMax() end ");
		log.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return minmaxres;
	}
	
	/**
	 * Prepare request for getAddition,getSubstraction,getmultiplication,getDivision
	 * 
	 * @param number1
	 * @param number2
	 * @param operation
	 * @param result
	 * @return calculatorData
	 */
	public CalculatorData prepareRequest(CalculatorRequest calculatorRequest, String operation, double result) {
		CalculatorData calculatorData = new CalculatorData();
		calculatorData.setNumber1(calculatorRequest.getNumber1());
		calculatorData.setNumber2(calculatorRequest.getNumber2());
		calculatorData.setOperation(operation);
		calculatorData.setResult(result);
		return calculatorData;
	}
	
	

	/**
	 * Prepare request for getSquare,getSquareRoot and getFactorial methods
	 * 
	 * @param number
	 * @param opeartion
	 * @param result
	 * @return
	 */
	public CalculatorData prepareRequestForOtherOperations(double number, String opeartion, double result) {
		CalculatorData calculatorData = new CalculatorData();
		calculatorData.setNumber1(number);
		calculatorData.setResult(result);
		calculatorData.setOperation(opeartion);
		return calculatorData;
	}

	MinMaxData prepareRequestForMinMax(MinMaxRequest minMaxRequest)
	{
		List<Integer> numbers=minMaxRequest.getList();
		numbers.sort(Comparator.naturalOrder());
		MinMaxData minMaxData=new MinMaxData();
		minMaxData.setMinimum(numbers.get(0));
		minMaxData.setMaximum(numbers.get(numbers.size()-1));
		return minMaxData;
	}
	
}

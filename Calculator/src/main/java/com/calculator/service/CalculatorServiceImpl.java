package com.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculator.dao.CalculatorDaoImpl;
import com.calculator.jpa.CalculatorData;
import com.calculator.request.CalculatorRequest;
import com.calculator.response.CalculatorResponse;
import com.calculator.util.Constants;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorServiceImpl.class);

	@Autowired
	public CalculatorDaoImpl calculatorDaoImpl;

	/**
	 * Calculate the Addition of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	public CalculatorResponse getAddition(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		logger.info("CalculatorServiceImpl.getAddition() start ");
		logger.info(Constants.TIME_ELAPSED, startTime);
		double result = calculatorRequest.getNumber1() + calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Addition, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		logger.info("CalculatorServiceImpl.getAddition() end ");
		logger.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Substraction of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	public CalculatorResponse getSubstraction(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		logger.info("CalculatorServiceImpl.getSubstraction() start ");
		logger.info(Constants.TIME_ELAPSED, startTime);
		double result = calculatorRequest.getNumber1() - calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Substraction, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		logger.info("CalculatorServiceImpl.getSubstraction() end ");
		logger.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Division of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	public CalculatorResponse getDivision(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		long startTime = System.currentTimeMillis();
		logger.info("CalculatorServiceImpl.getDivision() start ");
		logger.info(Constants.TIME_ELAPSED, startTime);
		if (calculatorRequest.getNumber2() == 0) {
			logger.error("Division By Zero is not allowed");
			calculatorResponse.setAnswer("undefined");
			calculatorResponse.setDetails("Division by zero is Not Allowed");
			return calculatorResponse;
		}
		double result = calculatorRequest.getNumber1() / calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Division, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		logger.info("CalculatorServiceImpl.getDivision() end ");
		logger.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Multiplication of given number
	 * 
	 * @param calculatorRequest
	 * @return CalculatorResponse
	 */
	@Override
	public CalculatorResponse getMultiplication(CalculatorRequest calculatorRequest) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		logger.info("CalculatorServiceImpl.getMultiplication() start ");
		logger.info(Constants.TIME_ELAPSED, startTime);
		double result = calculatorRequest.getNumber1() * calculatorRequest.getNumber2();
		CalculatorData calculatorData = prepareRequest(calculatorRequest, Constants.Multiplication, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		logger.info("CalculatorServiceImpl.getMultiplication() end ");
		logger.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
	}

	/**
	 * Calculate the Square of given number
	 * 
	 * @param number1
	 * @return CalculatorResponse
	 */
	@Override
	public CalculatorResponse getSquare(double number) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		logger.info("CalculatorServiceImpl.getSquare() start ");
		logger.info(Constants.TIME_ELAPSED, startTime);
		double result = number * number;
		CalculatorData calculatorData = prepareRequestForOtherOperations(number, Constants.Square, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		logger.info("CalculatorServiceImpl.getSquare() end ");
		logger.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;

	}

	/**
	 * Calculate the Squareroot of given number
	 * 
	 * @param number1
	 * @return CalculatorResponse
	 */
	@Override
	public CalculatorResponse getSquareRoot(double number) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		logger.info("CalculatorServiceImpl.getSquareRoot() start ");
		logger.info(Constants.TIME_ELAPSED, startTime);
		double result = Math.sqrt(number);
		CalculatorData calculatorData = prepareRequestForOtherOperations(number, Constants.Squareroot, result);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		logger.info("CalculatorServiceImpl.getSquareRoot() end ");
		logger.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;

	}

	/**
	 * Calculate the factorial of given number
	 * 
	 * @param number1
	 * @return CalculatorResponse
	 */
	@Override
	public CalculatorResponse getFactorial(double number) {
		CalculatorResponse calculatorResponse;
		long startTime = System.currentTimeMillis();
		logger.info("CalculatorServiceImpl.getFactorial() start ");
		logger.info(Constants.TIME_ELAPSED, startTime);
		double fact = 1;
		for (double i = 1; i < number; i++) {
			fact = fact * i;
		}
		CalculatorData calculatorData = prepareRequestForOtherOperations(number, Constants.Factorial, fact);
		calculatorResponse = calculatorDaoImpl.saveData(calculatorData);
		logger.info("CalculatorServiceImpl.getFactorial() end ");
		logger.info(Constants.TIME_ELAPSED, startTime - System.currentTimeMillis());
		return calculatorResponse;
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
}
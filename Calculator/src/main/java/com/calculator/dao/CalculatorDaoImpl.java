package com.calculator.dao;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.calculator.jpa.CalculatorData;
import com.calculator.jpa.MinMaxData;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;
import com.calculator.transformer.CalculatorTransformer;
import com.calculator.transformer.MinMaxTransformer;
import com.calculator.util.Constants;

@Repository
public class CalculatorDaoImpl{

	@Autowired
	CalculatorRepository calculatorRepository;
	
	@Autowired
	CalculatorTransformer calculatorTransformer;
	
	@Autowired
	MinMaxTransformer minMaxTransformer;
	
	@Autowired
	MinMaxRepository maxRepository;
	
	private static final Logger logger=LoggerFactory.getLogger(CalculatorDaoImpl.class);

	
	/**Save or insert data in Database
	 * @param calculatorData
	 * @return CalculatorResponse
	 */
	public CalculatorResponse saveData(CalculatorData calculatorData)
	{
		long startTime=System.currentTimeMillis();
		CalculatorData save =null;
		CalculatorResponse transformToObject=null;
		logger.info("CalculatorDaoImpl.saveData() start");
		logger.info(Constants.TIME_ELAPSED,startTime);
		try{
			calculatorData.setTimeStamp(LocalDateTime.now());
			save = calculatorRepository.save(calculatorData);
			if(save != null)
			{
				transformToObject = calculatorTransformer.transformToObject(calculatorData);
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("CalculatorDaoImpl.saveData() end");
		logger.info(Constants.TIME_ELAPSED,startTime-System.currentTimeMillis());
		return transformToObject;		
	}
	
	/**
	 * save MinMax data in database
	 * @param minMaxData
	 * @return MinMaxResponse
	 */
	public MinMaxResponse saveMinMax(MinMaxData minMaxData)
	{
		long startTime=System.currentTimeMillis();
		MinMaxData save =null;
		logger.info("CalculatorDaoImpl.saveMinMax() start");
		logger.info(Constants.TIME_ELAPSED,startTime);
		MinMaxResponse transformToObject = null;
		try{
			minMaxData.setTimestamp(LocalDateTime.now());
			save = maxRepository.save(minMaxData);
			if(save != null)
			{
				transformToObject = minMaxTransformer.transformToObject(minMaxData);
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("CalculatorDaoImpl.saveMinMax() end");
		logger.info(Constants.TIME_ELAPSED,startTime-System.currentTimeMillis());
		return transformToObject;		
	}
	
	
}

package com.calculator.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.calculator.jpa.CalculatorData;
import com.calculator.jpa.MinMaxData;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;
import com.calculator.transformer.CalculatorTransformer;
import com.calculator.transformer.MinMaxTransformer;
import com.calculator.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	/**Save or insert data in Database
	 * @param calculatorData
	 * @return CalculatorResponse
	 */
	public CalculatorResponse saveData(CalculatorData calculatorData)
	{
		long startTime=System.currentTimeMillis();
		CalculatorData response =null;
		CalculatorResponse transformToObject=null;
		log.info("CalculatorDaoImpl.saveData() start");
		log.info(Constants.TIME_ELAPSED,startTime);
		try{
			calculatorData.setTimeStamp(LocalDateTime.now());
			response = calculatorRepository.save(calculatorData);
			if(response != null)
			{
				transformToObject = calculatorTransformer.transformToObject(response);
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		log.info("CalculatorDaoImpl.saveData() end");
		log.info(Constants.TIME_ELAPSED,startTime-System.currentTimeMillis());
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
		MinMaxData response =null;
		log.info("CalculatorDaoImpl.saveMinMax() start");
		log.info(Constants.TIME_ELAPSED,startTime);
		MinMaxResponse transformToObject = null;
		try{
			minMaxData.setTimestamp(LocalDateTime.now());
			response = maxRepository.save(minMaxData);
			if(response != null)
			{
				transformToObject = minMaxTransformer.transformToObject(response);
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		log.info("CalculatorDaoImpl.saveMinMax() end");
		log.info(Constants.TIME_ELAPSED,startTime-System.currentTimeMillis());
		return transformToObject;		
	}
	
	
}

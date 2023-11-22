package com.calculator.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculator.jpa.CalculatorData;
import com.calculator.response.CalculatorResponse;
import com.calculator.transformer.CalculatorTransformer;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CalculatorDaoTest {
	
	@Mock
	CalculatorRepository calculatorRepository;
	
	@InjectMocks
	CalculatorDaoImpl calculatorDaoImpl;
	
	@Mock
	CalculatorTransformer calculatorTransformer;
	
	
	@Test
	public void testSaveDataforAddition()
	{
		CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		expCalculatorResponse.setAnswer("15");
		expCalculatorResponse.setDetails("10 + 5 = 15");
		CalculatorData calculatorData=prepareDataForCalculatorData(10.0, 5.0, "Addition", 15.0);
		when(calculatorRepository.save(any(CalculatorData.class))).thenReturn(calculatorData);
		when(calculatorTransformer.transformToObject(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
		CalculatorResponse saveData = calculatorDaoImpl.saveData(calculatorData);
		verify(calculatorRepository).save(any(CalculatorData.class));
		verify(calculatorTransformer).transformToObject(any(CalculatorData.class));
		assertNotNull(saveData);
	}
	
	

	CalculatorData prepareDataForCalculatorData(double number1, double number2, String operation, double result)
	{
		CalculatorData calculatorData=new CalculatorData();
		calculatorData.setNumber1(15);
		calculatorData.setNumber2(20);
		calculatorData.setOperation(operation);
		calculatorData.setResult(result);
		calculatorData.setTimeStamp(LocalDateTime.now());
		return calculatorData;
	    
	}
	
}

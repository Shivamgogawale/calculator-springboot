
package com.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.calculator.dao.CalculatorDaoImpl;
import com.calculator.jpa.CalculatorData;
import com.calculator.jpa.MinMaxData;
import com.calculator.request.CalculatorRequest;
import com.calculator.request.MinMaxRequest;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;

@ExtendWith(MockitoExtension.class)

@SpringBootTest
public class CalculatorServiceTest {

	@InjectMocks
	private CalculatorServiceImpl calculatorServiceImpl;

	@Mock
	private CalculatorDaoImpl calculatorDaoImpl;
	
	private MockMvc mockmvc;
	

	@BeforeEach
	public void setup() {
		mockmvc = MockMvcBuilders.standaloneSetup(calculatorServiceImpl).build();
	}

	@Test
	public void testAddition() throws Exception {
		
	CalculatorResponse expCalculatorResponse=new CalculatorResponse();
	CalculatorRequest calculatorRequest=calculatorRequestObject();
	expCalculatorResponse.setAnswer("30");
	expCalculatorResponse.setDetails("20 + 10 = 30");
	when(calculatorDaoImpl.saveData(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
	CalculatorResponse result=calculatorServiceImpl.getAddition(calculatorRequest);
	verify(calculatorDaoImpl).saveData(any(CalculatorData.class));
	assertEquals(expCalculatorResponse, result);
	}

	
	  @Test
	  public void testSubstraction() throws Exception {
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		  CalculatorRequest calculatorRequest=calculatorRequestObject();
		  expCalculatorResponse.setAnswer("10");
		  expCalculatorResponse.setDetails("20 - 10 = 10");
		  when(calculatorDaoImpl.saveData(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
		  CalculatorResponse result=calculatorServiceImpl.getSubstraction(calculatorRequest);
		  verify(calculatorDaoImpl).saveData(any(CalculatorData.class));
		  assertEquals(expCalculatorResponse, result);
		  }
	 
	  @Test
	  public void testDivision() throws Exception 
	  { 
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		  CalculatorRequest calculatorRequest=calculatorRequestObject();
		  expCalculatorResponse.setAnswer("2");
		  expCalculatorResponse.setDetails("20 / 10 = 2");
		  when(calculatorDaoImpl.saveData(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
		  CalculatorResponse result=calculatorServiceImpl.getDivision(calculatorRequest);
		  verify(calculatorDaoImpl).saveData(any(CalculatorData.class));
		  assertEquals(expCalculatorResponse, result);
	  }
	  
	  
	  
	  @Test
	  public void testMultipication() throws Exception 
	  { 
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		  CalculatorRequest calculatorRequest=calculatorRequestObject();
		  expCalculatorResponse.setAnswer("200");
		  expCalculatorResponse.setDetails("20 * 10 = 200");
		  when(calculatorDaoImpl.saveData(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
		  CalculatorResponse result=calculatorServiceImpl.getMultiplication(calculatorRequest);
		  verify(calculatorDaoImpl).saveData(any(CalculatorData.class));
		  assertEquals(expCalculatorResponse, result);
	  }
	  
	 @Test 
	 public void testsquare() throws Exception 
	 {
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		 double number=5.0;
		  expCalculatorResponse.setAnswer("25");
		  expCalculatorResponse.setDetails("Square of 5 = 25");
		  when(calculatorDaoImpl.saveData(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
		  CalculatorResponse result=calculatorServiceImpl.getSquare(number);
		  verify(calculatorDaoImpl).saveData(any(CalculatorData.class));
		  assertEquals(expCalculatorResponse, result);
	 }
	 
	  @Test 
	  public void testSquareroot() throws Exception 
	  { 
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		  double number=25.0;
		  expCalculatorResponse.setAnswer("5");
		  expCalculatorResponse.setDetails("Squareroot of 25 = 5");
		  when(calculatorDaoImpl.saveData(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
		  CalculatorResponse result=calculatorServiceImpl.getSquareRoot(number);
		  verify(calculatorDaoImpl).saveData(any(CalculatorData.class));
		  assertEquals(expCalculatorResponse, result);
	  }
	  
	  @Test 
	  public void testFactorial() throws Exception
	  { 
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		  double number=5.0;
		  expCalculatorResponse.setAnswer("5");
		  expCalculatorResponse.setDetails("Factorial of 5! = 120");
		  when(calculatorDaoImpl.saveData(any(CalculatorData.class))).thenReturn(expCalculatorResponse);
		  CalculatorResponse result=calculatorServiceImpl.getFactorial(number);
		  verify(calculatorDaoImpl).saveData(any(CalculatorData.class));
		  assertEquals(expCalculatorResponse, result);
	  }
	 
	  @Test
	  public void testMinMax()
	  {
		  MinMaxResponse expminMaxResponse=new MinMaxResponse();
		  MinMaxRequest maxRequest=setMinmaxReq();
		  expminMaxResponse.setMax(19);
		  expminMaxResponse.setMin(-15);
		  when(calculatorDaoImpl.saveMinMax(any(MinMaxData.class))).thenReturn(expminMaxResponse);
		  MinMaxResponse actualResponse=calculatorServiceImpl.getMinMax(maxRequest);
		  verify(calculatorDaoImpl).saveMinMax(any(MinMaxData.class));
		  assertEquals(expminMaxResponse, actualResponse);
		  
	  }
	  
	public CalculatorRequest calculatorRequestObject()
	{
		CalculatorRequest calculatorRequest=new CalculatorRequest();
		calculatorRequest.setNumber1(20.0);
		calculatorRequest.setNumber2(10.0);
		return calculatorRequest;
	}
	
	public MinMaxRequest setMinmaxReq()
	{
		int a[]= {10,-5,7,15,-7,-6,16,19,-15,9};
		List<Integer> list = new ArrayList<>();
        for (int value : a) {
            list.add(value);
        }
        MinMaxRequest minMaxRequest=new MinMaxRequest();
        minMaxRequest.setList((ArrayList<Integer>) list);
        return minMaxRequest;
	}
	
	
}

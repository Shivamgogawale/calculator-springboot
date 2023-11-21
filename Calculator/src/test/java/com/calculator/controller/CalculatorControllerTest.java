
package com.calculator.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.calculator.dao.CalculatorDaoImpl;
import com.calculator.request.MinMaxRequest;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;
import com.calculator.service.CalculatorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CalculatorController.class)
@ComponentScan(basePackages = "com.calculator")
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalculatorServiceImpl calculatorService;

	@MockBean
	private CalculatorDaoImpl calculatorDaoImpl;

	@Test 
	public void testgetAddition() throws Exception {
		double number1=5.0;
		double number2=10.0;
		CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		expCalculatorResponse.setAnswer("15");
		expCalculatorResponse.setDetails("5 + 10 = 15");
		when(calculatorService.getAddition(any())).thenReturn(expCalculatorResponse);
		
		mockMvc.perform(get("/calculatorapi/v1/addition") 
				.param("number1","5")
				.param("number2", "3") 
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()) 
				.andExpect(content().json("{\"answer\":\"15\",\"details\":\"5 + 10 = 15\"}")); 
		
	}

	
	  @Test public void testgetSubstraction() throws Exception 
	  {
		  double number1=15.0;
			double number2=10.0;
			CalculatorResponse expCalculatorResponse=new CalculatorResponse();
			expCalculatorResponse.setAnswer("5");
			expCalculatorResponse.setDetails("15 - 10 = 5");
			when(calculatorService.getSubstraction(any())).thenReturn(expCalculatorResponse);
	
	  mockMvc.perform(get("/calculatorapi/v1/substraction") 
			  .param("number1", "15")
			  .param("number2", "10") .contentType(MediaType.APPLICATION_JSON))
	  		  .andExpect(status().isOk())
	  		  .andExpect(content().json("{\"answer\":\"5\",\"details\":\"15 - 10 = 5\"}")); 
	  }
	  
	  @Test
	  public void testgetMultiplication() throws Exception 
	  {
		  	double number1=5.0;
			double number2=10.0;
			CalculatorResponse expCalculatorResponse=new CalculatorResponse();
			expCalculatorResponse.setAnswer("50");
			expCalculatorResponse.setDetails("5 * 10 = 50");
			when(calculatorService.getMultiplication(any())).thenReturn(expCalculatorResponse);
			mockMvc.perform(get("/calculatorapi/v1/multiplication") 
			  .param("number1","5") 
			  .param("number2", "10") 
			  .contentType(MediaType.APPLICATION_JSON))
	  .andExpect(status().isOk())
	  .andExpect(content().json("{\"answer\":\"50\",\"details\":\"5 * 10 = 50\"}"));
	  }
	  
	  @Test 
	  public void testgetDivision() throws Exception 
	  {
		double number1=5.0;
		double number2=10.0;
		CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		expCalculatorResponse.setAnswer("5");
		expCalculatorResponse.setDetails("15 / 3 = 5");
	  when(calculatorService.getDivision(any())).thenReturn(expCalculatorResponse);	  
	  mockMvc.perform(get("/calculatorapi/v1/division") 
			  .param("number1", "15")
			  .param("number2", "3")
			  .contentType(MediaType.APPLICATION_JSON))
	  		  .andExpect(status().isOk())
	  		  .andExpect(content().json("{\"answer\":\"5\",\"details\":\"15 / 3 = 5\"}"));
	  }
	  

	  
	  @Test 
	  public void testgetSquare() throws Exception 
	  {
			double number=5.0;
			CalculatorResponse expCalculatorResponse=new CalculatorResponse();
			expCalculatorResponse.setAnswer("25");
			expCalculatorResponse.setDetails("Square of 5 = 25");
			when(calculatorService.getSquare(number)).thenReturn(expCalculatorResponse);
			mockMvc.perform(get("/calculatorapi/v1/square/{number}",number)
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().json("{\"answer\":\"25\",\"details\":\"Square of 5 = 25\"}"));
		}
	  
	  @Test 
	  public void testgetSquareRoot() throws Exception
	  { 
		  double number =25.0; 
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		  expCalculatorResponse.setAnswer("5");
		  expCalculatorResponse.setDetails("Squareroot of 25 = 5");
		  when(calculatorService.getSquareRoot(number)).thenReturn(expCalculatorResponse);
		  mockMvc.perform(get("/calculatorapi/v1/squareroot/{number}", number)
	  			 .contentType(MediaType.APPLICATION_JSON))
	  	  		.andExpect(status().isOk())
	  	  		.andExpect(content().json("{\"answer\":\"5\",\"details\":\"Squareroot of 25 = 5\"}"));
	  
	  }
	  
	  @Test 
	  public void testFactorial() throws Exception 
	  { 
		  double number = 5.0;
		  CalculatorResponse expCalculatorResponse=new CalculatorResponse();
		  expCalculatorResponse.setAnswer("120");
		  expCalculatorResponse.setDetails("Factorial of 5! = 120");
		  when(calculatorService.getFactorial(number)).thenReturn(expCalculatorResponse);	  
		  mockMvc.perform(get("/calculatorapi/v1/factorial/{number}",number)
				  .contentType(MediaType.APPLICATION_JSON))
		  		  .andExpect(status().isOk())
		  		  .andExpect(content().json("{\"answer\":\"120\",\"details\":\"Factorial of 5! = 120\"}")); 
		  }
	  
	  @Test 
	  public void testMinMax() throws Exception 
	  { 
		  ArrayList<Integer> list =new ArrayList<Integer>(List.of(10, -5, 7, 15, -7, -6, 16, 19, -15, 9));
		  MinMaxRequest minMaxRequest = new MinMaxRequest(list);
		  MinMaxResponse response = new MinMaxResponse();
		  response.setMax(19);
		  response.setMin(-15);
		  when(calculatorService.getMinMax(any())).thenReturn(response);
	  	  mockMvc.perform(post("/calculatorapi/v1/min-max")
	  			  .contentType(MediaType.APPLICATION_JSON)
	  			  .content(new ObjectMapper().writeValueAsString(minMaxRequest)))
	  	  		  .andExpect(status().isOk())
	  	  		  .andExpect(content().json("{\"min\":-15,\"max\":19}")); 
	  	  }
	  
	 }

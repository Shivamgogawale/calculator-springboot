package com.calculator.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.calculator.request.MinMaxRequest;
import com.calculator.response.CalculatorResponse;
import com.calculator.response.MinMaxResponse;
import com.calculator.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CalculatorService calculatorService;
	
	@Mock
	private CalculatorResponse calculatorResponse;
	
	@Test
	public void testgetAddition() throws Exception
	{
		when(calculatorService.getAddition(5, 3)).thenReturn(8.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("8");
		when(calculatorResponse.getDetails()).thenReturn("5 + 3 = 8");
		
		mockMvc.perform(get("/calculatorapi/v1/addition")
						.param("number1","5")
						.param("number2", "3")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect( content().json("{\"answer\":\"8\",\"details\":\"5 + 3 = 8\"}"));
	}
	
	@Test
	public void testgetSubstraction() throws Exception
	{
		when(calculatorService.getSubstraction(5, 3)).thenReturn(2.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("2");
		when(calculatorResponse.getDetails()).thenReturn("5 - 3 = 2");
		
		mockMvc.perform(get("/calculatorapi/v1/substraction")
				.param("number1", "5")
				.param("number2", "3")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"answer\":\"2\",\"details\":\"5 - 3 = 2\"}"));
	}
	
	@Test
	public void testgetMultiplication() throws Exception
	{
		when(calculatorService.getMultiplication(5, 3)).thenReturn(15.0);
		
		when(calculatorResponse.getAnswer()).thenReturn("15");
		when(calculatorResponse.getDetails()).thenReturn("5 * 3 = 15");
		
		mockMvc.perform(get("/calculatorapi/v1/multiplication")
				.param("number1", "5")
				.param("number2", "3")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"answer\":\"15\",\"details\":\"5 * 3 = 15\"}"));
	}
	
	@Test
	public void testgetDivision() throws Exception
	{
		when(calculatorService.getDivision(25, 5)).thenReturn(5.0);
		when(calculatorResponse.getAnswer()).thenReturn("5");
		when(calculatorResponse.getDetails()).thenReturn("25 / 5 = 5");
		
		mockMvc.perform(get("/calculatorapi/v1/division")
				.param("number1", "25")
				.param("number2", "5")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json("{\"answer\":\"5\",\"details\":\"25 / 5 = 5\"}"));
	}
	
	@Test
	public void testgetDivisionwithzero() throws Exception
	{
		when(calculatorService.getDivision(25, 0)).thenReturn(5.0);
		when(calculatorResponse.getAnswer()).thenReturn("undifined");
		when(calculatorResponse.getDetails()).thenReturn("Number Should not be Zero");
		
		mockMvc.perform(get("/calculatorapi/v1/division")
				.param("number1", "25")
				.param("number2", "0")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json("{\"answer\":\"undifined\",\"details\":\"Number Should not be Zero\"}"));
	}
	
	@Test
	public void testgetSquare() throws Exception
	{
		String number1="5";
		when(calculatorService.getSquare(number1)).thenReturn(25.0);
		when(calculatorResponse.getAnswer()).thenReturn("25");
		when(calculatorResponse.getDetails()).thenReturn("square of 5 = 25");
		
		mockMvc.perform(get("/calculatorapi/v1/square/{number}",number1)
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().json("{\"answer\":\"25\",\"details\":\"Square of 5 = 25\"}"));
	}
	
	@Test
	public void testgetSquareRoot() throws Exception
	{
		String number="25";
		when(calculatorService.getSquareRoot(number)).thenReturn(5.0);
		when(calculatorResponse.getAnswer()).thenReturn("5");
		when(calculatorResponse.getDetails()).thenReturn("Squareroot of 25 = 5");
		
		
		mockMvc.perform(get("/calculatorapi/v1/squareroot/{number}",number)
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"5\",\"details\":\"Squareroot of 25 = 5\"}"));
		
		
	}
	
	@Test
	public void testFactorial() throws Exception
	{
		String number="5";
		when(calculatorService.getFactorial(number)).thenReturn(120.0);
		when(calculatorResponse.getAnswer()).thenReturn("120");
		when(calculatorResponse.getDetails()).thenReturn("5! = 120");
		
		mockMvc.perform(get("/calculatorapi/v1/factorial/{number}",number)
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(content().json("{\"answer\":\"120\",\"details\":\"5! = 120\"}"));		
	}
	
	@Test
	public void testMinMax() throws Exception
	{
		ArrayList<Integer> list=new ArrayList<Integer>(List.of(10, -5, 7, 15, -7, -6, 16, 19, -15, 9));
		MinMaxRequest minMaxRequest=new MinMaxRequest(list);
		MinMaxResponse minMaxResponse=new MinMaxResponse();
		
		minMaxResponse.setMax(19);
		minMaxResponse.setMin(-15);
		
		mockMvc.perform(post("/calculatorapi/v1/min-max")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(minMaxRequest)))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"min\":-15,\"max\":19}"));
	}
	
	
	
	
}

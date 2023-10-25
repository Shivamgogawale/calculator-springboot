package com.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CalculatorServiceTest {
	
	@InjectMocks
	private CalculatorServiceImpl calculatorServiceImpl;
	
	@Mock
	private CalculatorService calculatorService;
	
	private MockMvc mockmvc;
	
	@BeforeEach
	public void setup()
	{
		mockmvc = MockMvcBuilders.standaloneSetup(calculatorServiceImpl).build();
	}
	
	@Test
	public void testAddition() throws Exception
	{
		double actualreault=calculatorServiceImpl.getAddition(5.3,2.3);
		
		assertEquals(7.6, actualreault,0.0001);
	}

	
	@Test
	public void testSubstraction() throws Exception {
		double actualresult = calculatorServiceImpl.getSubstraction(5, 3);
		assertEquals(2.0, actualresult, 0.001);
	}
	
	@Test
	public void testDivision() throws Exception
	{
		double actualresult=calculatorServiceImpl.getDivision(6, 3);
		assertEquals(2.0,actualresult,0.001);
	}
	
	@Test
	public void testMultipication() throws Exception
	{
		double actualresult=calculatorServiceImpl.getMultiplication(3, 6);
		assertEquals(18.0, actualresult,0.01);
	}
	
	@Test
	public void testsquare() throws Exception
	{
		double actualresult=calculatorServiceImpl.getSquare("5");
		assertEquals(25,actualresult,0.01);
	}
	
	@Test
	public void testSquareroot() throws Exception
	{
		double actualresult=calculatorServiceImpl.getSquareRoot("25");
		assertEquals(5,actualresult, 0.001);
	}

	@Test
	public void testFactorial() throws Exception
	{
		double actualresult=calculatorServiceImpl.getFactorial("5");
		assertEquals(120, actualresult,0.01);
	}
}

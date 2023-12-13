package com.calculator.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class CalculatorResponse implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String answer;
	
	String details;


	
}

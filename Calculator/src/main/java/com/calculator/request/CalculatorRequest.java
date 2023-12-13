package com.calculator.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CalculatorRequest {

	@JsonProperty(value = "number1")
	double number1;
	
	@JsonProperty(value = "number2")
	double number2;


	
}

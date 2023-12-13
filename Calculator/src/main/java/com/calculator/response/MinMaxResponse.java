package com.calculator.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class MinMaxResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int min;
	
	int max;

}

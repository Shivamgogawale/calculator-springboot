package com.calculator.response;

import java.io.Serializable;

public class MinMaxResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int min;
	
	int max;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	
}

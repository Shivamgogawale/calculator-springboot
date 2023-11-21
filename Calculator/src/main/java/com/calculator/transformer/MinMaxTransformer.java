package com.calculator.transformer;

import org.springframework.stereotype.Component;

import com.calculator.jpa.MinMaxData;
import com.calculator.response.MinMaxResponse;

@Component("minMaxTransformer")
public class MinMaxTransformer {

	public MinMaxResponse transformToObject(MinMaxData minMaxData)
	{
		MinMaxResponse minMaxResponse=new MinMaxResponse();
		minMaxResponse.setMin(minMaxData.getMinimum());
		minMaxResponse.setMax(minMaxData.getMaximum());
		return minMaxResponse; 		
	}
}

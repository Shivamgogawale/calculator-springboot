package com.calculator.request;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinMaxRequest {

	@JsonProperty(value = "numbers")
	ArrayList<Integer> list;

	
	
}

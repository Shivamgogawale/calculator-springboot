package com.calculator.request;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class MinMaxRequest {

	@JsonProperty(value = "numbers")
	ArrayList<Integer> list;

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}

	public MinMaxRequest(ArrayList<Integer> list) {
		super();
		this.list = list;
	}

	public MinMaxRequest() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MinMaxRequest [list=");
		builder.append(list);
		builder.append("]");
		return builder.toString();
	}
	
	
}

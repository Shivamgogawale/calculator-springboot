package com.calculator.response;

public class CalculatorResponse {

	String answer;
	
	String details;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CalculatorResponse [answer=");
		builder.append(answer);
		builder.append(", details=");
		builder.append(details);
		builder.append("]");
		return builder.toString();
	}
	
	
}

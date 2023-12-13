package com.calculator.jpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "calculatordata")
public class CalculatorData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "number1")
	private double number1;
	
	@Column(name = "number2")
	private double number2;
	
	@Column(name = "operation")
	private String operation;
	
	@Column(name = "result")
	private double result;
	
	@Column(name = "timestamp")
	private LocalDateTime timeStamp;
	
}

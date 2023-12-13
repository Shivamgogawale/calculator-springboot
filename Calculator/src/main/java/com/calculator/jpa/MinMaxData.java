package com.calculator.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.calculator.request.MinMaxRequest;

import lombok.Data;

@Data
@Entity
@Table(name = "minmaxdata")
public class MinMaxData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	
	@Column(name = "minimum")
	private Integer Minimum;
	
	@Column(name = "maximum")
	private Integer Maximum;
	
	@Column(name = "timestamp")
	private LocalDateTime timestamp;
	
}

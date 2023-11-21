package com.calculator.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "minmaxdata")
public class MinMaxData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="request")
	private List request;
	
	@Column(name = "minimum")
	private Integer Minimum;
	
	@Column(name = "maximum")
	private Integer Maximum;
	
	@Column(name = "timestamp")
	private LocalDateTime timestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getMinimum() {
		return Minimum;
	}

	public void setMinimum(Integer minimum) {
		Minimum = minimum;
	}

	public Integer getMaximum() {
		return Maximum;
	}

	public void setMaximum(Integer maximum) {
		Maximum = maximum;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List getRequest() {
		return request;
	}

	public void setRequest(List request) {
		this.request = request;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MinMaxData [id=");
		builder.append(id);
		builder.append(", request=");
		builder.append(request);
		builder.append(", Minimum=");
		builder.append(Minimum);
		builder.append(", Maximum=");
		builder.append(Maximum);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

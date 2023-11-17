package com.calculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculator.jpa.CalculatorData;

public interface CalculatorRepository extends JpaRepository<CalculatorData,Integer>{

}

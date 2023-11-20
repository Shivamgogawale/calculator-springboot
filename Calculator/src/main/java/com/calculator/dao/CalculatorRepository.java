package com.calculator.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculator.jpa.CalculatorData;
import com.calculator.jpa.MinMaxData;

public interface CalculatorRepository extends JpaRepository<CalculatorData,Integer>{


}
interface MinMaxRepository extends JpaRepository<MinMaxData,Integer>{

	
}
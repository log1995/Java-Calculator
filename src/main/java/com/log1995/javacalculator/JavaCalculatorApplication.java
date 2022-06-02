package com.log1995.javacalculator;

import com.log1995.javacalculator.controller.CalculatorController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCalculatorApplication {

	public static void main(String[] args) {
		CalculatorController calculatorController = new CalculatorController();
		calculatorController.start();
	}

}

package com.log1995.javacalculator.controller;

import com.log1995.javacalculator.console.CalculatorConsole;
import com.log1995.javacalculator.service.CalculatorService;

import java.util.Map;

public class CalculatorController {

    CalculatorConsole calculatorConsole = new CalculatorConsole();
    CalculatorService calculatorService = new CalculatorService();


    public void start() {

        while(true){
            String num = calculatorConsole.inputNum();
            Map<String, String> resultData;
            switch(num){
                case "1":
                    resultData = calculatorService.getData();
                    calculatorConsole.printRepository(resultData);
                break;
                case "2":
                    String formula = calculatorConsole.inputFormula();
                    String result = calculatorService.calculateFormula(formula);
                    calculatorConsole.printResult(result);
                break;
            }

            System.out.println();

        }




    }


}

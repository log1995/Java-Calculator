package com.log1995.javacalculator.controller;

import com.log1995.javacalculator.console.CalculatorConsole;
import com.log1995.javacalculator.exception.InvalidFormulaException;
import com.log1995.javacalculator.service.CalculatorService;

import java.util.Map;

public class CalculatorController {

    CalculatorConsole calculatorConsole = new CalculatorConsole();
    CalculatorService calculatorService = new CalculatorService();

    private static final String LOOKUP = "1";
    private static final String CALCULATE = "2";
    private static final String EXIT = "3";

    public void start() {

        while(true){
            String num = calculatorConsole.inputNum();
            Map<String, String> resultData;
            switch(num){
                case LOOKUP:
                    resultData = calculatorService.getData();
                    calculatorConsole.printRepository(resultData);
                    break;
                case CALCULATE:
                    String formula = calculatorConsole.inputFormula();
                    String result;
                    try{
                        result = calculatorService.calculateFormula(formula);
                    }catch (InvalidFormulaException e){
                        System.out.println(e.getMessage());
                        continue;
                    }
                    calculatorConsole.printResult(result);
                    break;
                case EXIT:
                    calculatorConsole.printEndMessage();
                    return;
                default:
                    calculatorConsole.printErrorMessage();
                    break;
            }

            System.out.println();

        }




    }


}

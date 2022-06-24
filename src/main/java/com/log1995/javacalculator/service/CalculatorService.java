package com.log1995.javacalculator.service;


import com.log1995.javacalculator.exception.InvalidFormulaException;
import com.log1995.javacalculator.repository.CalculatorRepository;

import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;


public class CalculatorService {

    private CalculatorRepository calculatorRepository = new CalculatorRepository();
    private Operator operator;

    private static Stack<String> formulaStack = new Stack<>();
    private static final String msg = "수식을 잘못 입력하였습니다. 다시 입력해주세요.\n";

    public String calculateFormula(String formula){

        String[] formulaArr = formula.split("\\s+");
        checkFormula(formulaArr);

        formulaStack.push(formulaArr[0]);
        double resultNum = 0;
        String result;
        int len = formulaArr.length;

        for(int i = 1; i < len; i += 2){
            formulaStack.push(formulaArr[i]);
            formulaStack.push(formulaArr[i + 1]);

            operator = Operator.initOperator(formulaArr[i]);
            int priority = operator.getPriority();

            if(priority == 1){
                double second = Double.parseDouble(formulaStack.pop());
                formulaStack.pop();
                double first = Double.parseDouble(formulaStack.pop());
                resultNum = operator.calculate(first, second);
                formulaStack.push(String.valueOf(resultNum));
            }
        }

        if(formulaStack.size() != 1){
            int stackSize = formulaStack.size();
            for(int i = 1; i < stackSize; i += 2){
                double second = Double.parseDouble(formulaStack.pop());
                operator = Operator.initOperator(formulaStack.pop());
                double first = Double.parseDouble(formulaStack.pop());
                resultNum = operator.calculate(first, second);
                formulaStack.push(String.valueOf(resultNum));
            }
        }

        result = formulaStack.pop();
        calculatorRepository.saveResult(formula, result);
        return result;
    }

    public void checkFormula(String[] formula){
        String numRegex = "^[0-9]*$";
        String operRegex = "[*/+-]";
        int length = formula.length;

        for(int i = 0; i < length; i++){
            if((i % 2 == 0 && Pattern.matches(numRegex, formula[i])) || i % 2 == 1 && Pattern.matches(operRegex, formula[i])){
                continue;
            }else throw new InvalidFormulaException(msg);
        }


    }

    public Map<String, String> getData(){
        return calculatorRepository.getRepositoryData();
    }

}
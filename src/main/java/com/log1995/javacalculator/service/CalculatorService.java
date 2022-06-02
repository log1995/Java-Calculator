package com.log1995.javacalculator.service;


import com.log1995.javacalculator.repository.CalculatorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CalculatorService {

    private CalculatorRepository calculatorRepository = new CalculatorRepository();

    public String calculateFormula(String formula){

        String[] formulaArr = formula.split("\\s+");
        ArrayList<String> formulaList = new ArrayList<>();

        for(String s : formulaArr){
            formulaList.add(s);
        }

        calculate(formulaList, "*", "/");
        calculate(formulaList, "+", "-");

        String result = formulaList.get(0);
        calculatorRepository.saveResult(formula, result);
        return result;

    }

    public void calculate(List<String> list, String a, String b){

        for(int i = 1; i <list.size(); i += 2){
            String oper = list.get(i);

            if(oper.equals(a) || oper.equals(b)) {
                double second = Double.parseDouble(list.remove(i + 1));
                list.remove(i);
                double first = Double.parseDouble(list.remove(i - 1));

                if(oper.equals("*")){
                    list.add(i - 1, String.valueOf(first * second));
                }else if(oper.equals("/")){
                    list.add(i - 1, String.valueOf(first / second));
                }else if(oper.equals("+")){
                    list.add(i - 1, String.valueOf(first + second));
                }else if(oper.equals("-")){
                    list.add(i - 1, String.valueOf(first - second));
                }
                i -= 2;
            }
        }
    }

    public Map<String, String> getData(){
        return calculatorRepository.getRepositoryData();
    }

}

package com.log1995.javacalculator.console;

import com.log1995.javacalculator.io.Input;
import com.log1995.javacalculator.io.Output;

import java.util.Map;
import java.util.Scanner;

public class CalculatorConsole implements Input, Output {

    private Scanner sc = new Scanner(System.in);

    @Override
    public String inputNum() {
        System.out.print("1. 조회\n" + "2. 계산\n\n" + "선택 = ");
        return sc.nextLine();
    }

    @Override
    public String inputFormula() {
        System.out.print("수식 입력 : ");
        return sc.nextLine();
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printRepository(Map<String, String> resultData) {

        for (String formula : resultData.keySet()) {
            String result = resultData.get(formula);
            System.out.println(formula + " = " + result);
        }

    }
}

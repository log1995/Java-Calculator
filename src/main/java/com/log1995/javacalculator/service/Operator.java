package com.log1995.javacalculator.service;


import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", 0, (first, second) -> (first + second)),
    MINUS("-", 0, (first, second) -> (first - second)),
    MULTIPLE("*", 1, (first, second) -> (first * second)),
    DIVIDE("/", 1, (first, second) -> (first / second));

    private final String operator;
    private final int priority;
    private final BinaryOperator<Double> binaryOperator;

    Operator(String operator, int priority, BinaryOperator<Double> binaryOperator ){
        this.operator = operator;
        this.priority = priority;
        this.binaryOperator = binaryOperator;
    }

    public String getOperator(){
        return this.operator;
    }

    public int getPriority(){
        return this.priority;
    }

    public static Operator initOperator(String oper){
        Operator operator = null;
        for(Operator op : Operator.values()){
            if(op.getOperator().equals(oper)) {
                operator = op;
                break;
            }
        }
        return operator;
    }

    public Double calculate(double first, double second) {
        return binaryOperator.apply(first, second);
    }
}

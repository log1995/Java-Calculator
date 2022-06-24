package com.log1995.javacalculator.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorRepository {

    private Map<String, String> resultRepository = new LinkedHashMap<>();

    public void saveResult(String formula, String result){
        resultRepository.put(formula, result);
    }

    public Map<String, String> getRepositoryData(){
        return resultRepository;
    }

}

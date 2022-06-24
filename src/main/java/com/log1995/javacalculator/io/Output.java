package com.log1995.javacalculator.io;

import java.util.Map;

public interface Output {

    void printResult(String result);
    void printRepository(Map<String, String> resultData);
    void printEndMessage();
    void printErrorMessage();

}

package org.example;


import org.example.util.*;

public interface DataContextHelper extends RandomUtil {

    static String someId() {
        return RandomUtil.getSomeId();
    }

    static String defaultSomeTime() {
        return TimeUtil.nowUTCString();
    }

    static String nextSomeCode(){
        return SomeCodeUtil.nextSomeCode();
    }

    static String getSomeCodeInitial(){
        return SomeCodeUtil.getInitialValue();
    }

    static void resetSomeCodeSequence(){
        SomeCodeUtil.resetToInitialValueFromFile();
    }

    static String getSomeCodeFromListOf10(){
        return SomeCodeUtil.list10();
    }

    static String getSomeCodeFromListOf20(){
        return SomeCodeUtil.list20();
    }

    static String getRandomSomeCode(){
        return FakerUtil.someCodeWithPattern();
    }

    static String getRandomSomeCode(String pattern){
        return FakerUtil.someCodeWithPattern(pattern);
    }
}

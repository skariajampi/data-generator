package org.example;


import org.example.util.FakerUtil;
import org.example.util.RandomUtil;
import org.example.util.TimeUtil;

public interface DataContextHelper extends RandomUtil {

    static String someId(){
        return RandomUtil.getSomeId();
    }

    static String defaultSomeTime(){
        return TimeUtil.nowUTCString();
    }

    static String defaultSomeValue(){
        return FakerUtil.defaultFaker().bothify("##_????? ???? ????");
    }


}

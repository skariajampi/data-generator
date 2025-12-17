package org.example.util;

import net.datafaker.Faker;

import java.util.Locale;

public interface FakerUtil {
    String LOCAL_EN_GB = "en-GB";
    String SOME_DATA_PATTERN = "??##???";

    static Faker defaultFaker(){
        return new Faker(new Locale(LOCAL_EN_GB));
    }
}

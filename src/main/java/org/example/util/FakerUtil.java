package org.example.util;

import net.datafaker.Faker;

import java.util.Locale;

public interface FakerUtil {
    String LOCAL_EN_GB = "en-GB";
    String SOME_CODE_PATTERN = "??##???";
    Faker faker = new Faker(new Locale(LOCAL_EN_GB));

    static String someCodeWithPattern() {
        return someCodeWithPattern(SOME_CODE_PATTERN);
    }

    static String someCodeWithPattern(String pattern) {
        return faker.bothify(pattern, true);
    }

}

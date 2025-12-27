package org.example.util;

import net.datafaker.providers.base.BaseFaker;
import org.example.provider.SomeCodeFaker;

public interface SomeCodeUtil {

    SomeCodeFaker SOME_CODE_FAKER = new SomeCodeFaker();
    SomeCodeProvider SOME_CODE_PROVIDER = getSomeCodeProvider();

    private static SomeCodeProvider getSomeCodeProvider(){
        return BaseFaker.getProvider(
                SomeCodeProvider.class,
                f -> new SomeCodeProvider(
                        f,
                        new StatefulSequence(new PatternBasedAlnumSequenceGenerator(), "AA11AA1")
                ),
                SOME_CODE_FAKER
        );
    }

    // Get next code using YAML-based sequence
    static String nextSomeCode() {
        return SOME_CODE_PROVIDER.nextCode();
    }

    // Peek at current value
    /*static String peekSomeCode() {
        return SOME_CODE_PROVIDER.peek();
    }*/

    // Reset sequence to YAML initial value
    static void resetToInitialValueFromFile() {
        SOME_CODE_PROVIDER.resetToInitialValueFromFile();
    }

    static void resetSomeCodeSequence(StatefulSequence newSequence) {
        SOME_CODE_PROVIDER.resetSequence(newSequence);
    }

    // Get the initial value from YAML
    static String getInitialValue() {
        return SOME_CODE_PROVIDER.getInitialValueFromFile();
    }

    // Get list values from YAML
    static String list10() {
        return SOME_CODE_PROVIDER.list10();
    }

    static String list20() {
        return SOME_CODE_PROVIDER.list20();
    }
}

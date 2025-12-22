package org.example.provider;

import net.datafaker.Faker;
import net.datafaker.providers.base.BaseFaker;
import org.example.util.PatternBasedAlnumSequenceGenerator;
import org.example.util.SequenceGenerator;
import org.example.util.SomeCodeProvider;
import org.example.util.StatefulSequence;

public class SomeCodeFaker extends BaseFaker {

    public SomeCodeProvider someCodeFromFile(String initial) {
        SequenceGenerator gen = new PatternBasedAlnumSequenceGenerator();
        StatefulSequence seq = new StatefulSequence(gen, initial);
        return getProvider(SomeCodeProvider.class, faker -> new SomeCodeProvider(faker, seq), this);
    }

    public static void main(String[] args) {

        SomeCodeFaker faker = new SomeCodeFaker();
        SomeCodeProvider provider = faker.getProvider(
                SomeCodeProvider.class,
                f -> new SomeCodeProvider(
                        f,
                        new StatefulSequence(new PatternBasedAlnumSequenceGenerator(), "AA11AA1")
                ),
                faker
        );
        String code = provider.nextCode();
        System.out.println(">" + code + "<");

        String code2 = provider.nextCode();
        System.out.println(">" + code2 + "<");

        String code3 = provider.nextCode();
        System.out.println(">" + code3 + "<");
        String code4 = provider.nextCode();
        System.out.println(">" + code4 + "<");

    }
}
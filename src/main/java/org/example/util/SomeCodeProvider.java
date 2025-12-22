package org.example.util;

import net.datafaker.Faker;
import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

import java.nio.file.Paths;
import java.util.Locale;

public class SomeCodeProvider extends AbstractProvider<BaseProviders> {
    private static final String KEY = "some-code";
    private StatefulSequence sequence;

    public SomeCodeProvider(BaseProviders faker, StatefulSequence sequence) {
        super(faker);
        faker.addPath(Locale.ENGLISH, Paths.get(this.getClass().getClassLoader().getResource(KEY + ".yml").getPath()).toAbsolutePath());
        this.sequence = sequence;
        this.sequence.reset(resolve(KEY + ".some-code-initial"));
    }

    public String nextCode() {
        return sequence.next();
    }

    // For reset functionality
    public void resetSequence(StatefulSequence newSequence) {
        this.sequence = newSequence;
    }

    public String list10() { return resolve(KEY + ".list-10"); }
    public String list20() { return resolve(KEY + ".list-20"); }
}
package org.example.util;

import java.util.concurrent.atomic.AtomicReference;

public final class StatefulSequence {
    private final SequenceGenerator generator;
    private final AtomicReference<String> current;

    public StatefulSequence(SequenceGenerator generator, String initial) {
        this.generator = generator;
        this.current = new AtomicReference<>(initial);
    }

    public String next() {
        return current.updateAndGet(generator::next);
    }

    public void reset(String value) { current.set(value); }
    public String peek() { return current.get(); }
}
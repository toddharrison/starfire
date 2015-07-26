package com.gfe.starfire.util;

import java.util.Arrays;
import java.util.Random;

public class Chooser<T> {
    private final Option<T>[] options;
    private int totalWeight;

    @SafeVarargs
    public Chooser(final Option<T>... options) {
        this.options = options;
        Arrays.stream(options).forEach(option -> totalWeight += option.weight);
    }

    public T choose(final Random random) {
        Option<T> selectedOption = null;
        int value = random.nextInt(totalWeight);
        for (final Option<T> option : options) {
            value -= option.weight;
            if (value <= 0) {
                selectedOption = option;
                break;
            }
        }
        return selectedOption.t;
    }

    public static class Option<T> {
        public T t;
        public int weight;

        public Option(final T t, final int weight) {
            this.t = t;
            this.weight = weight;
        }
    }
}

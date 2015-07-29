package com.gfe.util;

import org.junit.Test;

public class GrowthTest {
    @Test
    public void test() {
        final long time = 365 * 24;

        final double br = 0.0189;
        final double dr = 0.0079;

        final long pop = 10_000_000;
        System.out.println(pop * (br - dr) / time);
    }
}

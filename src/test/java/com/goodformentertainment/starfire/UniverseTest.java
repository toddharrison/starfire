package com.goodformentertainment.starfire;

import org.junit.Test;

import com.gfe.starfire.model.Universe;
import com.gfe.starfire.model.system.StarSystem;

public class UniverseTest {
    @Test
    public void test() {
        final Universe universe = new Universe();

        final StarSystem ss1 = new StarSystem();
        universe.getSystems().add(ss1);
    }
}

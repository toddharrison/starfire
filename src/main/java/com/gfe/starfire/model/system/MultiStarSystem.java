package com.gfe.starfire.model.system;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.system.feature.Star;

public class MultiStarSystem extends StarSystem {
    private final Set<Star> companionStars;
    // public Set<StarSystem> companionSystems = new HashSet<>();

    public MultiStarSystem(final Star star, final Star... companions) {
        super(star);
        companionStars = new HashSet<>(Arrays.asList(companions));
    }

    @Override
    public String toString() {
        return star.toString() + " " + companionStars.toString();
    }
}

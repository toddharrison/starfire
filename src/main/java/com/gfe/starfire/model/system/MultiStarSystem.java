package com.gfe.starfire.model.system;

import java.util.Arrays;
import java.util.List;

import com.gfe.starfire.model.system.feature.Star;

public class MultiStarSystem extends StarSystem {
    private final List<Star> companionStars;
    // public Set<StarSystem> companionSystems = new HashSet<>();

    public MultiStarSystem(final Star star, final Star... companions) {
        super(star);
        companionStars = Arrays.asList(companions);
        for (final Star companion : companionStars) {
            companion.system = this;
        }
    }

    @Override
    public String toString() {
        return star.toString() + " " + companionStars.toString();
    }
}

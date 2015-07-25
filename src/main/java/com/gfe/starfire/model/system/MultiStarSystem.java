package com.gfe.starfire.model.system;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.system.feature.Star;

public class MultiStarSystem extends StarSystem {
    public Set<Star> companionStars = new HashSet<>();
    public Set<StarSystem> companionSystems = new HashSet<>();
}

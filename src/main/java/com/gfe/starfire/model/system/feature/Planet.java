package com.gfe.starfire.model.system.feature;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.entity.ground.AGroundEntity;
import com.gfe.starfire.model.entity.ground.GroundLocation;
import com.gfe.starfire.model.population.Population;
import com.gfe.starfire.model.population.PopulationLocation;

public class Planet extends AFeature implements PopulationLocation, GroundLocation {
    private final Star star;
    public Set<Moon> moons = new HashSet<>();
    private final Set<AGroundEntity> groundEntities;
    private Population population;

    public Planet(final Star star) {
        this.star = star;
        groundEntities = new HashSet<>();
    }

    @Override
    public Set<AGroundEntity> getGroundEntities() {
        return groundEntities;
    }

    @Override
    public Population getPopulation() {
        return population;
    }

    @Override
    public int getMaxPopulation() {
        return 0;
    }
}

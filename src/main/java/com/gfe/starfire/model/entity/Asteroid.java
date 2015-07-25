package com.gfe.starfire.model.entity;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.entity.ground.AGroundEntity;
import com.gfe.starfire.model.entity.ground.GroundLocation;
import com.gfe.starfire.model.population.Population;
import com.gfe.starfire.model.population.PopulationLocation;

public class Asteroid extends AEntity implements PopulationLocation, GroundLocation {
    private final Set<AGroundEntity> groundEntities;
    private Population population;

    public Asteroid(final EntityLocation location) {
        super(location);
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

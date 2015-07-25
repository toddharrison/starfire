package com.gfe.starfire.model.system.feature;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.entity.ground.AGroundEntity;
import com.gfe.starfire.model.entity.ground.GroundLocation;
import com.gfe.starfire.model.population.Population;
import com.gfe.starfire.model.population.PopulationLocation;

public class Moon extends AFeature implements PopulationLocation, GroundLocation {
    private final Set<AGroundEntity> groundEntities;
    private final Planet planet;
    private Population population;

    public Moon(final Planet planet) {
        this.planet = planet;
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
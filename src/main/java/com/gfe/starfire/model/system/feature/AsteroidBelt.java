package com.gfe.starfire.model.system.feature;

import com.gfe.starfire.model.population.Population;
import com.gfe.starfire.model.population.PopulationLocation;

public class AsteroidBelt extends AFeature implements PopulationLocation {
    public Star star;

    private Population population;

    @Override
    public Population getPopulation() {
        return population;
    }

    @Override
    public int getMaxPopulation() {
        return 0;
    }
}

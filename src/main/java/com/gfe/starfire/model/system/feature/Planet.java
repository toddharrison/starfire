package com.gfe.starfire.model.system.feature;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.entity.ground.AGroundEntity;
import com.gfe.starfire.model.entity.ground.GroundLocation;
import com.gfe.starfire.model.population.Population;
import com.gfe.starfire.model.population.PopulationLocation;

public class Planet extends AFeature implements PopulationLocation, GroundLocation {
    public Set<Moon> moons = new HashSet<>();

    private final Set<AGroundEntity> groundEntities;
    private final Type type;
    private final int habitabilityIndex;
    private final int resourceExploitationIndex;
    private Star star;
    private Population population;

    public Planet(final Type type, final int habitabilityIndex,
            final int resourceExploitationIndex) {
        this.type = type;
        this.habitabilityIndex = habitabilityIndex;
        this.resourceExploitationIndex = resourceExploitationIndex;
        groundEntities = new HashSet<>();
    }

    public Star getStar() {
        return star;
    }

    public void setStar(final Star star) {
        this.star = star;
    }

    public Type getType() {
        return type;
    }

    public int getHabitabilityIndex() {
        return habitabilityIndex;
    }

    public int getResourceExploitationIndex() {
        return resourceExploitationIndex;
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

    @Override
    public String toString() {
        return type.toString() + "(" + habitabilityIndex + " / " + resourceExploitationIndex + ")";
    }

    public enum Type {
        H("Hostile"), V("Vulcan"), T("Terrestrial"), ST("Super-Terrestrial"), B("Barren"), G(
                "Gas Giant"), I("Ice Giant"), F("Frozen");

        private final String name;

        private Type(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

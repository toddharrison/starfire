package com.gfe.starfire.simple;

import com.gfe.util.Graph;
import com.gfe.util.SingleEdgeGraph;

public class Universe {
    public static final void main(final String[] args) {
        final Race race = new Race("Human");

        final Population pop = race.createPopulation(1_000_000_000);
        System.out.println(pop.industry().produce());
    }

    private final Graph<StarSystem> systems;

    public Universe() {
        systems = new SingleEdgeGraph<>();
    }
}

class StarSystem {
    public Player owner;
    public Population population;
    public int ships;
}

class Player {
    public String name;
    public Race race;
}

class Race {
    public final long MAX_POPULATION_SIZE = 10_000_000_000l;
    public final double MAX_POPULATION_GROWTH_RATE = 0.03;
    public final double WORK_FORCE_PARTICIPATION = 0.65;
    public final long LABOR_PRODUCTIVITY = 50;
    public final double WORK_DURATION = 8.0 / 24.0;
    public final double TAX_RATE = 0.15;
    public final double CRIME_RATE = 0.05;

    private final String name;

    public Race(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Population createPopulation(final long size) {
        return new Population(this, size);
    }
}

class Population {
    private static final int scaleFactor = 2;

    private final Race race;
    private final Industry industry;

    private long size;

    protected Population(final Race race, final long size) {
        this.race = race;
        this.size = size;
        industry = new Industry(this);
    }

    public Race getRace() {
        return race;
    }

    public long size() {
        return size;
    }

    public Industry industry() {
        return industry;
    }

    public double growthRate() {
        double rate = 0.0;
        if (size > 2) {
            final double x = size / (double) race.MAX_POPULATION_SIZE;
            rate = (-Math.pow(x, scaleFactor * 2.0) + 1.0) * race.MAX_POPULATION_GROWTH_RATE;
        }
        return rate;
    }

    public void grow() {
        // newPopulation = (initialPopulation * Math.pow(1 + growthRate, time / ratePeriod));
        size *= 1 + growthRate();
    }
}

class Industry {
    private static final double PERIOD = 24.0 * 30.0;

    private final Population pop;

    protected Industry(final Population pop) {
        this.pop = pop;
    }

    public long produce() {
        long size = pop.size();
        size *= pop.getRace().WORK_FORCE_PARTICIPATION;

        final long effort = (long) (size * pop.getRace().WORK_DURATION * PERIOD);
        final long production = effort * pop.getRace().LABOR_PRODUCTIVITY;
        final long crime = (long) (production * pop.getRace().CRIME_RATE);
        return (long) ((production - crime) * pop.getRace().TAX_RATE / 1_000_000);
    }
}

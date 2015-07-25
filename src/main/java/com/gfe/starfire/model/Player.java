package com.gfe.starfire.model;

public class Player {
    private final String name;
    private final Empire empire;

    public Player(final String name, final Empire empire) {
        this.name = name;
        this.empire = empire;
    }

    public String getName() {
        return name;
    }

    public Empire getEmpire() {
        return empire;
    }
}

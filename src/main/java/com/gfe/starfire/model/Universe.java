package com.gfe.starfire.model;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.system.ASystem;

public class Universe {
    private long time;
    private final Set<ASystem> systems = new HashSet<>();
    private final Set<Player> players = new HashSet<>();
    private final Set<Empire> empires = new HashSet<>();

    public Set<ASystem> getSystems() {
        return systems;
    }
}

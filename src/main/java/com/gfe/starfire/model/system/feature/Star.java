package com.gfe.starfire.model.system.feature;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.system.ASystem;

public class Star extends AFeature {
    public ASystem system;
    public Set<Planet> planets = new HashSet<>();
}

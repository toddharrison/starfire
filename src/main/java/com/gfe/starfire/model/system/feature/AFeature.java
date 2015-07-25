package com.gfe.starfire.model.system.feature;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.entity.AEntity;
import com.gfe.starfire.model.entity.EntityLocation;

public abstract class AFeature implements EntityLocation {
    private final Set<AEntity> entities;

    public AFeature() {
        entities = new HashSet<>();
    }

    @Override
    public Set<AEntity> getEntities() {
        return entities;
    }
}

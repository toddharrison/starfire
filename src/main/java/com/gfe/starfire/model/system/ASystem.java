package com.gfe.starfire.model.system;

import java.util.HashSet;
import java.util.Set;

import com.gfe.starfire.model.entity.AEntity;
import com.gfe.starfire.model.entity.EntityLocation;
import com.gfe.starfire.model.system.feature.WarpPoint;

public abstract class ASystem implements EntityLocation {
    public Set<WarpPoint> warpPoints = new HashSet<>();
    private final Set<AEntity> entities;

    public ASystem() {
        entities = new HashSet<>();
    }

    @Override
    public Set<AEntity> getEntities() {
        return entities;
    }
}

package com.gfe.starfire.model.entity;

import com.gfe.starfire.model.Empire;

public abstract class AEntity {
    private Empire empire;
    private EntityLocation location;

    public AEntity(final EntityLocation location) {
        this(null, location);
    }

    public AEntity(final Empire empire, final EntityLocation location) {
        this.empire = empire;
        this.location = location;
    }

    public Empire getEmpire() {
        return empire;
    }

    public void setEmpire(final Empire empire) {
        this.empire = empire;
    }

    public EntityLocation getLocation() {
        return location;
    }

    public void setLocation(final EntityLocation location) {
        this.location = location;
    }
}

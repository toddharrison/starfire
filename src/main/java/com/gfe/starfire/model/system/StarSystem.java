package com.gfe.starfire.model.system;

import com.gfe.starfire.model.system.feature.Star;

public class StarSystem extends ASystem {
    protected final Star star;

    public StarSystem(final Star star) {
        this.star = star;
        this.star.system = this;
    }

    @Override
    public String toString() {
        return star.toString();
    }
}

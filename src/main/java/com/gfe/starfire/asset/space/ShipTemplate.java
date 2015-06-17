package com.gfe.starfire.asset.space;

import static com.gfe.starfire.asset.space.ComponentType.*;

import com.gfe.starfire.component.ATemplate;
import com.gfe.starfire.component.Component;

public class ShipTemplate extends ATemplate<ShipType> {
	public ShipTemplate(final ShipType type) {
		super(type);
	}
	
	public Ship create(final String name) {
		return new Ship(name, this);
	}
	
	@Override
	public ShipTemplate add(final Component component) {
		if (component == H) {
			throw new IllegalArgumentException();
		} else {
			super.add(component);
		}
		return this;
	}
	
	@Override
	public ShipTemplate insert(final int componentIndex, final Component component) {
		if (component == H) {
			throw new IllegalArgumentException();
		} else {
			super.insert(componentIndex, component);
		}
		return this;
	}
}

package com.gfe.starfire.component;

import com.gfe.starfire.combat.Damage;
import com.gfe.starfire.combat.IDamageable;

public class Component {
	private final String name;
	private final int size;
	private final ZoneType zone;
	private final IDamageable damageable;
	
	public Component(final String name, final int size, final ZoneType zone,
			final IDamageable damageable) {
		this.name = name;
		this.size = size;
		this.zone = zone;
		this.damageable = damageable;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return size;
	}
	
	public ZoneType getZone() {
		return zone;
	}
	
	public boolean isDestroyedBy(final Damage damage) {
		return damageable.isDestroyed(damage);
	}
}

package com.gfe.starfire.asset.space;

import static com.gfe.starfire.component.ZoneType.*;

import com.gfe.starfire.combat.IDamageable;
import com.gfe.starfire.component.Component;

public class ComponentType {
	// @formatter:off
	public static final Component A = new Component("Armor", 1, SURFACE, IDamageable::energySkip);
	public static final Component B = new Component("Bulkhead", 1, INTERNAL, IDamageable::energySkip);
	public static final Component D = new Component("Point Defense", 2, INTERNAL, IDamageable::standard);
	public static final Component E = new Component("Energy Beam", 6, INTERNAL, IDamageable::standard);
	public static final Component F = new Component("Force Beam", 5, INTERNAL, IDamageable::standard);
	public static final Component H = new Component("Cargo Hold", 1, INTERNAL, IDamageable::energySkip);
	public static final Component I = new Component("Inertialess Engine", 1, INTERNAL, IDamageable::standard);
	public static final Component L = new Component("Laser Beam", 4, INTERNAL, IDamageable::standard);
	public static final Component M1 = new Component("Multiplex Tracking", 1, INTERNAL, IDamageable::standard);
	public static final Component Mg = new Component("Magazine", 1, INTERNAL, IDamageable::standard);
	public static final Component Pt = new Component("Plasma Torpedo Launcher", 6, INTERNAL, IDamageable::standard);
	public static final Component Q = new Component("Crew Quarters", 1, INTERNAL, IDamageable::standard);
	public static final Component R = new Component("Missile Launcher", 4, INTERNAL, IDamageable::standard);
	public static final Component S = new Component("Shield", 1, EXTERNAL, IDamageable::laserSkipEnergyResist);
	public static final Component Y = new Component("Combat Sensors", 1, INTERNAL, IDamageable::standard);
	public static final Component Z = new Component("Datalink", 0, EXPOSED, IDamageable::fragile);
	// @formatter:on
}

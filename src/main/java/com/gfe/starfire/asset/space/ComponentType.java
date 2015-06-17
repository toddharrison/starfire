package com.gfe.starfire.asset.space;

import static com.gfe.starfire.component.ZoneType.*;

import com.gfe.starfire.combat.IDamageable;
import com.gfe.starfire.component.Component;

public class ComponentType {
	// @formatter:off
	public static final Component A = new Component("Armor", "A", 1, SURFACE, IDamageable::energySkip);
	public static final Component B = new Component("Bulkhead", "B", 1, INTERNAL, IDamageable::energySkip);
	public static final Component D = new Component("Point Defense", "D", 2, INTERNAL, IDamageable::standard);
	public static final Component E = new Component("Energy Beam", "E", 6, INTERNAL, IDamageable::standard);
	public static final Component F = new Component("Force Beam", "F", 5, INTERNAL, IDamageable::standard);
	public static final Component G = new Component("Sprint Missile Launcher", "G", 3, INTERNAL, IDamageable::standard);
	public static final Component H = new Component("Cargo Hold", "H", 1, INTERNAL, IDamageable::energySkip);
	public static final Component I = new Component("Inertialess Engine", "I", 1, INTERNAL, IDamageable::standard);
	public static final Component L = new Component("Laser Beam", "L", 4, INTERNAL, IDamageable::standard);
	public static final Component M1 = new Component("Multiplex Tracking", "M1", 1, INTERNAL, IDamageable::standard);
	public static final Component Mg = new Component("Magazine", "Mg", 1, INTERNAL, IDamageable::standard);
	public static final Component Pt = new Component("Plasma Torpedo Launcher", "Pt", 6, INTERNAL, IDamageable::standard);
	public static final Component Q = new Component("Crew Quarters", "Q", 1, INTERNAL, IDamageable::standard);
	public static final Component R = new Component("Missile Launcher", "R", 4, INTERNAL, IDamageable::standard);
	public static final Component S = new Component("Shield", "S", 1, EXTERNAL, IDamageable::laserSkipEnergyResist);
	public static final Component X = new Component("Science Instruments", "X", 1, INTERNAL, IDamageable::standard);
	public static final Component Y = new Component("Combat Sensors", "Y", 1, INTERNAL, IDamageable::standard);
	public static final Component Z = new Component("Datalink", "Z", 0, EXPOSED, IDamageable::fragile);
	// @formatter:on
}

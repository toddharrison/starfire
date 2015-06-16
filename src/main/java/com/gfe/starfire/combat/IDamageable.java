package com.gfe.starfire.combat;

@FunctionalInterface
public interface IDamageable {
	boolean isDestroyed(Damage damage);
	
	public static boolean fragile(final Damage damage) {
		return damage.getAmount() > 0;
	}
	
	public static boolean standard(final Damage damage) {
		boolean destroyed = false;
		final int amount = damage.getAmount();
		if (amount > 0) {
			damage.setAmount(amount - 1);
			destroyed = true;
		}
		return destroyed;
	}
	
	public static boolean energySkip(final Damage damage) {
		boolean destroyed = false;
		if (damage.getType() != Damage.Type.ENERGY) {
			destroyed = standard(damage);
		}
		return destroyed;
	}
	
	public static boolean laserSkipEnergyResist(final Damage damage) {
		boolean destroyed = false;
		if (damage.getType() == Damage.Type.ENERGY) {
			final int amount = damage.getAmount();
			if (amount > 1) {
				damage.setAmount(amount - 2);
				destroyed = true;
			} else {
				damage.setAmount(0);
			}
		} else if (damage.getType() != Damage.Type.LASER) {
			destroyed = standard(damage);
		}
		return destroyed;
	}
}

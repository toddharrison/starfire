package com.gfe.starfire.component;

import java.util.BitSet;

import com.gfe.starfire.combat.Damage;

public abstract class AContainer<T extends ATemplate<? extends IContainerType>> {
	private final T template;
	private final BitSet destroyed;
	
	public AContainer(final T template) {
		this.template = template;
		destroyed = new BitSet();
	}
	
	public T getTemplate() {
		return template;
	}
	
	public boolean isDestroyed(final int componentIndex) {
		if (componentIndex >= template.getComponentCount()) {
			throw new IndexOutOfBoundsException();
		}
		return destroyed.get(componentIndex);
	}
	
	public boolean apply(final Damage damage) {
		final boolean applied = false;
		final int componentCount = template.getComponentCount();
		for (int i = 0; i < componentCount; i++) {
			if (damage.getAmount() < 1) {
				break;
			}
			if (!destroyed.get(i) && template.getComponent(i).isDestroyedBy(damage)) {
				destroyed.set(i);
			}
		}
		return applied;
	}
	
	@Override
	public String toString() {
		return template.toString(destroyed);
	}
}

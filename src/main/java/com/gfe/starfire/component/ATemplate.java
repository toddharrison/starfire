package com.gfe.starfire.component;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public abstract class ATemplate<T extends IContainerType> {
	private final T type;
	private final List<Component> components;
	
	public ATemplate(final T type) {
		this.type = type;
		components = new ArrayList<>();
	}
	
	public T getType() {
		return type;
	}
	
	public int getComponentCount() {
		return components.size();
	}
	
	public Component getComponent(final int componentIndex) {
		return components.get(componentIndex);
	}
	
	public ATemplate<T> add(final Component component) {
		boolean added = false;
		if (this.getEmptySpace() >= component.getSize()) {
			Component previousComponent = null;
			if (!components.isEmpty()) {
				previousComponent = components.get(components.size() - 1);
			}
			if (previousComponent == null
					|| previousComponent.getZone().compareTo(component.getZone()) <= 0) {
				added = components.add(component);
			}
		}
		if (!added) {
			throw new IllegalArgumentException();
		}
		return this;
	}
	
	public ATemplate<T> insert(final int componentIndex, final Component component) {
		boolean inserted = false;
		if (componentIndex < 0 || componentIndex > components.size()) {
			throw new IndexOutOfBoundsException();
		} else {
			if (this.getEmptySpace() >= component.getSize()) {
				Component previousComponent = null;
				if (componentIndex > 0) {
					previousComponent = components.get(componentIndex - 1);
				}
				Component nextComponent = null;
				if (componentIndex < components.size()) {
					nextComponent = components.get(componentIndex);
				}
				if ((previousComponent == null || previousComponent.getZone()
						.compareTo(component.getZone()) <= 0)
						&& (nextComponent == null || nextComponent.getZone().compareTo(component.getZone()) >= 0)) {
					components.add(componentIndex, component);
					inserted = true;
				}
			}
		}
		if (!inserted) {
			throw new IllegalArgumentException();
		}
		return this;
	}
	
	public int getUsedSpace() {
		return components.stream().mapToInt(Component::getSize).sum();
	}
	
	public int getEmptySpace() {
		return type.getSize() - getUsedSpace();
	}
	
	@Override
	public String toString() {
		return components.stream().map(Component::getCode).reduce("", (s1, s2) -> s1 + s2);
	}
	
	public String toString(final BitSet destroyed) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < components.size(); i++) {
			if (destroyed.get(i)) {
				sb.append("/");
			} else {
				sb.append(components.get(i).getCode());
			}
		}
		return sb.toString();
	}
}

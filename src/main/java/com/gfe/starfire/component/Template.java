package com.gfe.starfire.component;

import java.util.ArrayList;
import java.util.List;

public class Template<T extends IContainerType> {
	private final T type;
	private final List<Component> components;
	
	public Template(final T type) {
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
}

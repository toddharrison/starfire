package com.gfe.starfire.asset.space;

import com.gfe.starfire.component.IContainerType;

public enum BaseType implements IContainerType {
	// @formatter:off
	BS1("Base 1", 30),
	BS2("Base 2", 50);
	// @formatter:on
	
	private final String name;
	private final int size;
	
	private BaseType(final String name, final int size) {
		this.name = name;
		this.size = size;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getCode() {
		return name();
	}
	
	@Override
	public int getSize() {
		return size;
	}
}

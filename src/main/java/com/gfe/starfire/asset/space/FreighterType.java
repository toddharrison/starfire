package com.gfe.starfire.asset.space;

import com.gfe.starfire.component.IContainerType;

public enum FreighterType implements IContainerType {
	// @formatter:off
	FT1("Freighter 1", 12, 2, 6),
	FT2("Freighter 2", 16, 2, 6);
	// @formatter:on
	
	private final String name;
	private final int size;
	private final int turnMode;
	private final int maxSpeed;
	
	private FreighterType(final String name, final int size, final int turnMode, final int maxSpeed) {
		this.name = name;
		this.size = size;
		this.turnMode = turnMode;
		this.maxSpeed = maxSpeed;
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
	
	public int getTurnMode() {
		return turnMode;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
}

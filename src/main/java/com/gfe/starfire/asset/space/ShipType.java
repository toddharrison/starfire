package com.gfe.starfire.asset.space;

import com.gfe.starfire.component.IContainerType;

public enum ShipType implements IContainerType {
	// @formatter:off
	ES("Escort", 0, 0, 0),
	CT("Corvette", 16, 2, 6),
	FG("Frigate", 0, 0, 0),
	DD("Destroyer", 30, 3, 5),
	CL("Light Cruiser", 45, 3, 4),
	CA("Heavy Crusier", 60, 3, 4),
	BC("Battlecruiser", 0, 0, 0),
	BB("Battleship", 0, 0, 0),
	SD("Superdreadnought", 0, 0, 0);
	// @formatter:on
	
	private final String name;
	private final int size;
	private final int turnMode;
	private final int maxSpeed;
	
	private ShipType(final String name, final int size, final int turnMode, final int maxSpeed) {
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

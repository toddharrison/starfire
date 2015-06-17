package com.gfe.starfire.asset.space;

import com.gfe.starfire.asset.ISpaceAsset;
import com.gfe.starfire.component.AContainer;

public class Ship extends AContainer<ShipTemplate> implements ISpaceAsset {
	private final String name;
	
	public Ship(final String name, final ShipTemplate template) {
		super(template);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		final ShipTemplate template = getTemplate();
		final StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(" - ");
		sb.append(template.getType().getCode());
		sb.append("\n");
		sb.append("[");
		sb.append(template.getType().getTurnMode());
		sb.append("] ");
		sb.append(super.toString());
		sb.append(" [");
		// TODO incorrect
		sb.append(template.getType().getMaxSpeed());
		sb.append("]");
		return sb.toString();
	}
}

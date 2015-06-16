package com.gfe.starfire.asset.space;

import com.gfe.starfire.asset.ISpaceAsset;
import com.gfe.starfire.component.AContainer;
import com.gfe.starfire.component.Template;

public class Ship extends AContainer<ShipType> implements ISpaceAsset {
	private final String name;
	
	public Ship(final String name, final Template<ShipType> template) {
		super(template);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}

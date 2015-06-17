package com.gfe.starfire.asset.space;

import com.gfe.starfire.asset.ISpaceAsset;
import com.gfe.starfire.component.AContainer;

public class Freighter extends AContainer<FreighterTemplate> implements ISpaceAsset {
	private final String name;
	
	public Freighter(final String name, final FreighterTemplate template) {
		super(template);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}

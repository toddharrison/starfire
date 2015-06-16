package com.gfe.starfire.asset.space;

import com.gfe.starfire.asset.ISpaceAsset;
import com.gfe.starfire.component.AContainer;
import com.gfe.starfire.component.Template;

public class Freighter extends AContainer<FreighterType> implements ISpaceAsset {
	private final String name;
	
	public Freighter(final String name, final Template<FreighterType> template) {
		super(template);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}

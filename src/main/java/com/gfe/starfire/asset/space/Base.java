package com.gfe.starfire.asset.space;

import com.gfe.starfire.asset.ISpaceAsset;
import com.gfe.starfire.component.AContainer;

public class Base extends AContainer<BaseTemplate> implements ISpaceAsset {
	private final String name;
	
	public Base(final String name, final BaseTemplate template) {
		super(template);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}

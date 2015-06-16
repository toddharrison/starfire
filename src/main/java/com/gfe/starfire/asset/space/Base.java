package com.gfe.starfire.asset.space;

import com.gfe.starfire.asset.ISpaceAsset;
import com.gfe.starfire.component.AContainer;
import com.gfe.starfire.component.Template;

public class Base extends AContainer<BaseType> implements ISpaceAsset {
	private final String name;
	
	public Base(final String name, final Template<BaseType> template) {
		super(template);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
}

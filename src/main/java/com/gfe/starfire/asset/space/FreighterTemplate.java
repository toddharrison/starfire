package com.gfe.starfire.asset.space;

import com.gfe.starfire.component.ATemplate;

public class FreighterTemplate extends ATemplate<FreighterType> {
	public FreighterTemplate(final FreighterType type) {
		super(type);
	}
	
	public Freighter create(final String name) {
		return new Freighter(name, this);
	}
}

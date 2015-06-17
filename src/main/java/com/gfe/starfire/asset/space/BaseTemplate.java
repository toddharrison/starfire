package com.gfe.starfire.asset.space;

import com.gfe.starfire.component.ATemplate;

public class BaseTemplate extends ATemplate<BaseType> {
	public BaseTemplate(final BaseType type) {
		super(type);
	}
	
	public Base create(final String name) {
		return new Base(name, this);
	}
}

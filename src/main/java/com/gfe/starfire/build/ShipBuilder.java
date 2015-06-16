package com.gfe.starfire.build;

import com.gfe.starfire.asset.space.ShipType;
import com.gfe.starfire.component.Template;

public class ShipBuilder implements IBuilder<ShipType> {
	@Override
	public Template<ShipType> build() {
		final Template<ShipType> template = new Template<>(ShipType.CT);
		return template;
	}
}

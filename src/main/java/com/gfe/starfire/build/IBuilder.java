package com.gfe.starfire.build;

import com.gfe.starfire.component.IContainerType;
import com.gfe.starfire.component.Template;

public interface IBuilder<T extends IContainerType> {
	Template<T> build();
}

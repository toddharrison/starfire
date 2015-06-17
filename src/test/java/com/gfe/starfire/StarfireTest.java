package com.gfe.starfire;

import static com.gfe.starfire.asset.space.ComponentType.*;

import org.junit.Test;

import com.gfe.starfire.asset.space.Ship;
import com.gfe.starfire.asset.space.ShipTemplate;
import com.gfe.starfire.asset.space.ShipType;

public class StarfireTest {
	@Test
	public void test() {
		final ShipTemplate template = new ShipTemplate(ShipType.CT);
		
		template.add(S).add(A).add(A).add(Z).add(I).add(I).add(Q).add(L).add(I).add(L);
		template.insert(0, S);
		
		System.out.println(template.getType().getSize() + " : " + template.getEmptySpace());
		
		final Ship hood = template.create("Hood");
		final Ship intrepid = template.create("Intrepid");
		
		System.out.println(hood);
		System.out.println(intrepid);
	}
}

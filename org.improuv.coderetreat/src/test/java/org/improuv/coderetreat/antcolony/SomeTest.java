package org.improuv.coderetreat.antcolony;

import static org.junit.Assert.*;

import org.improuv.coderetreat.antcolony.World;
import org.junit.Test;

public class SomeTest {

	@Test
	public void emptyWorldHasNoBreadcrumbs() throws Exception {
		World world = World.init();
		assertFalse(world.hasBreadcrumbs());
	}
	
	@Test
	public void initializedWorldHasAtLeastOnePileOfBreadcrumbs() {
		World world = World.init();
		assertTrue(world.hasBreadcrumbs());
	}
}

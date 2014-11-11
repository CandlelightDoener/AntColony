package org.improuv.coderetreat.antcolony;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.improuv.coderetreat.antcolony.World;
import org.junit.Ignore;
import org.junit.Test;

public class SomeTest {

	@Ignore("no one cares about this yet")
	@Test
	public void emptyWorld_hasNoBreadcrumbPiles() throws Exception {
		World world = World.empty();
		assertFalse(world.hasBreadcrumbPiles());
	}
	
	@Ignore("no one cares about this yet")
	@Test
	public void initializedWorld_hasAtLeastOnePileOfBreadcrumbs() {
		World world = World.init();
		assertTrue(world.hasBreadcrumbPiles());
	}
	
	@Test
	public void whenTheWorldTurns_anAntMoves() throws Exception {
		World world = World.empty();
		Ant ant = mock(Ant.class);
		world.addOneAnt(ant);
		world.turn();
		verify(ant).move();
	}
	
	@Test
	public void whenAnAntMoves_itChangesLocation() throws Exception {
		Ant ant = new Ant(mock(TripAdvisor.class));
		
		Location before = ant.getLocation();
		ant.move();
		Location after = ant.getLocation();
		
		assertThat(before, is(not(after)));
	}
	
	@Test
	public void aAntWithoutGoal_randomWalks() throws Exception {
		TripAdvisor tripAdvisor = mock(TripAdvisor.class);
		Ant ant = new Ant(tripAdvisor);
		ant.move();
		verify(tripAdvisor).randomWalk();
	}
	
	@Test
	public void anAntWhoKnowsAPile_goesThere() throws Exception {
		TripAdvisor tripAdvisor = mock(TripAdvisor.class);
		Ant ant = new Ant(tripAdvisor);
		BreadcrumbPile pile = new BreadcrumbPile();
		ant.setBreadcrumbPile(pile);
		ant.move();
		verify(tripAdvisor).goTowards(pile.getLocation());
	}
}

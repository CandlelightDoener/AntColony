package org.improuv.coderetreat.antcolony;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.improuv.coderetreat.antcolony.World;
import org.junit.Ignore;
import org.junit.Test;

public class SomeTest {

	private Random rand = new Random(1234);
	
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
		Ant ant = new Ant(new TripAdvisor());
		
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
		pile.setLocation(random());
		ant.setBreadcrumbPile(pile);
		ant.move();
		verify(tripAdvisor).goTowards(pile.getLocation());
	}

	private Location random() {
		return Location.randomLocation(rand);
	}
	
	@Test
	public void anAntCanReachANeighbouringPile_inOneMove() throws Exception {
		TripAdvisor tripAdvisor = new TripAdvisor();
		Ant ant = new Ant(tripAdvisor);
		
		Location antLocation = random();
		ant.setLocation(antLocation);
		
		BreadcrumbPile pile = new BreadcrumbPile();
		Location pileLocation = random();
		pile.setLocation(pileLocation);
		ant.setBreadcrumbPile(pile);

		ant.move();
		assertThat(ant.getLocation(), is(pile.getLocation()));
	}
	
	@Test
	public void onATwoDimensionalGrid_oneLocation_hasEightAdjacentLocations() throws Exception {
		Location center = new Location(1,1);
		assertTrue(center.isAdjacentTo(new Location(0,0)));
		assertTrue(center.isAdjacentTo(new Location(0,1)));
		assertTrue(center.isAdjacentTo(new Location(0,2)));
		assertTrue(center.isAdjacentTo(new Location(1,0)));
		assertTrue(center.isAdjacentTo(new Location(1,2)));
		assertTrue(center.isAdjacentTo(new Location(2,0)));
		assertTrue(center.isAdjacentTo(new Location(2,1)));
		assertTrue(center.isAdjacentTo(new Location(2,2)));
		
		assertFalse(center.isAdjacentTo(new Location(1,3)));
	}
	
	@Ignore("we're not here yet since we don't know what distinct means")
	@Test
	public void anAnt_withADistantPile_isAtSomeIntermediateLocation_afterMoving() throws Exception {
		
	}
}

package org.improuv.coderetreat.antcolony;

import java.util.Random;

public class TripAdvisor {

	public Location randomWalk() {
		return Location.randomLocation(new Random());
	}

	public Location goFromTo(Location from, Location to) {
		if(from.isAdjacentTo(to))
			return to;
		return Location.randomLocation(new Random());
	}
}

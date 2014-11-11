package org.improuv.coderetreat.antcolony;

import java.util.Random;

public class TripAdvisor {

	public Location randomWalk() {
		return Location.randomLocation(new Random());
	}

	public Location proceed(Location from, Location to) {
		//careful: there is a bug when to == to!!
		if(from.isAdjacentTo(to))
			return to;
		
		return from.towards(to);
	}
}

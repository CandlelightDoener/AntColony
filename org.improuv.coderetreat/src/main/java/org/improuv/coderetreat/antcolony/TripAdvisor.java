package org.improuv.coderetreat.antcolony;

import java.util.Random;

public class TripAdvisor {

	public Location randomWalk() {
		return Location.randomLocation(new Random());
	}

	public Location goTowards(Location location) {
		return location;
	}

}

package org.improuv.coderetreat.antcolony;

import java.util.Random;

public class Location {
	
	private final int x;
	private final int y;
	
	public static Location randomLocation(Random rand) {
		return new Location(rand.nextInt(), rand.nextInt());
	}

	public static Location farAwayFrom(Location other) {
		return new Location(other.x + 5, other.y + 5);
	}
	
	public static Location closeTo(Location other) {
		return new Location(other.x, other.y + 1);
	}

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isAdjacentTo(Location other) {
		if(Math.abs(other.x - x) <2 && Math.abs(other.y - y) < 2)
			return true;
		return false;
	}
}

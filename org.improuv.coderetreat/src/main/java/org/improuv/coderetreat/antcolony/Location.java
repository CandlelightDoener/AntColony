package org.improuv.coderetreat.antcolony;

import java.util.Random;

public class Location {
	
	private int x;
	private int y;
	
	public static Location randomLocation(Random rand) {
		return new Location(rand.nextInt(), rand.nextInt());
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

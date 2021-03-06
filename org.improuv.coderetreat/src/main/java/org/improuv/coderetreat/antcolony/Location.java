package org.improuv.coderetreat.antcolony;

import java.util.Random;

import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Location {
	
	private final int x;
	private final int y;
	
	//don't use for tests. FIXME: this stupid method shouldn't be there. The only callers are default initializators in Ant - and these shouldn't be there also!
	public static Location randomLocation() {
		return new Location(new Random().nextInt(), new Random().nextInt());
	}
	
	//use for tests.
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
	
	//FIXME: this is basically some movement-strategy and doesn't belong here. I put it here because I didn't want to expose the x+y of the Location.
	public Location towards(Location other) {
		if(x < other.x) {
			return new Location(x+1, y);
		} else if(x > other.x) {
			return new Location(x-1, y);
		} else if(y < other.y) {
			return new Location(x, y+1);
		} else if(y > other.y) {
			return new Location(x, y-1);
		} else {
			return new Location(x, y);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override //FIXME make lombok work with unit tests on eclipse and use it instead!
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	//FIXME this is a debug helper (I forgot a test for Location.equals) .. shouldn't be in production code
	public String toString() {
		return x+","+y;
	}
	
	
}

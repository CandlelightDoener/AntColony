package org.improuv.coderetreat.antcolony;

public class Ant {

	private TripAdvisor tripAdvisor;
	private Location pileLocation;
	private Location location;

	public Ant() {
		this.tripAdvisor = new TripAdvisor();
	}
	
	public Ant(TripAdvisor tripAdvisor) {
		this.tripAdvisor = tripAdvisor;
	}

	public Ant(Location location) {
		this.location = location;
		this.tripAdvisor = new TripAdvisor();
	}
	
	public void move() {
		if(pileLocation != null)
			location = tripAdvisor.goTowards(pileLocation);
		else
			location = tripAdvisor.randomWalk();
	}

	public Location getLocation() {
		return location;
	}

	public void setBreadcrumbPile(BreadcrumbPile pile) {
		pileLocation = pile.getLocation();
	}

	public void setLocation(Location antLocation) {
		this.location = antLocation;
	}

}

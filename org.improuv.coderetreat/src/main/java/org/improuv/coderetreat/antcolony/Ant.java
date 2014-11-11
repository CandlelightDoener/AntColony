package org.improuv.coderetreat.antcolony;

public class Ant {

	private TripAdvisor tripAdvisor;
	private Location pileLocation;

	public Ant(TripAdvisor tripAdvisor) {
		this.tripAdvisor = tripAdvisor;
	}

	public void move() {
		if(pileLocation != null)
			tripAdvisor.goTowards(pileLocation);
		else
			tripAdvisor.randomWalk();
	}

	public Location getLocation() {
		return new Location();
	}

	public void setBreadcrumbPile(BreadcrumbPile pile) {
		pileLocation = pile.getLocation();
	}

	public void setLocation(Location antLocation) {
		// TODO Auto-generated method stub
		
	}

}

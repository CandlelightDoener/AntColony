package org.improuv.coderetreat.antcolony;

public class Ant {

	// FIXME most of these members have a default value because of the confusing amount of constructors.
	// TODO why did they evolve?
	
	private TripAdvisor tripAdvisor = new TripAdvisor();
	private Location colony = Location.randomLocation();
	private Location pileLocation;
	private Location location = Location.randomLocation();
	private boolean hasBreadcrumb;

	// FIXME This is meanwhile a confusing amount of constructors and a static factory methods
	
	public static Ant withCloseByPile(Location antLocation) {
		Ant ant = new Ant(new TripAdvisor(), antLocation);
		ant.setBreadcrumbPile(new BreadcrumbPile(Location.closeTo(antLocation)));
		
		return ant;
	}
	
	public Ant() {}
	
	public Ant(TripAdvisor tripAdvisor) {
		this.tripAdvisor = tripAdvisor;
	}

	public Ant(Location location) {
		this.location = location;
	}

	public Ant(TripAdvisor advisor, Location location) {
		this.location = location;
		this.tripAdvisor = advisor;
	}
	
	public void move() {
		if(pileLocation != null)
			location = tripAdvisor.proceed(location, pileLocation);
		else
			location = tripAdvisor.randomWalk();
		
		if(isOnAPile()) {
			hasBreadcrumb = true;
		}
	}

	private boolean isOnAPile() {
		
		//FIXME Attention, this is a defect: an ant might just walk onto a pile by accident, even without previous knowledge of that pile. We would need to ask a global map if there is a pile!
		if(pileLocation == null)
			return false;
		
		return location.equals(pileLocation);
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

	public boolean hasBreadcrumb() {
		return hasBreadcrumb;
	}

	public void setColony(Location colony) {
		this.colony = colony;
	}

}

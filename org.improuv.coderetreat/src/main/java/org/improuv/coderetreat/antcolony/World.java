package org.improuv.coderetreat.antcolony;

public class World {

	private boolean hasBreadCrumbPile;
	private Ant ant;

	public boolean hasBreadcrumbPiles() {
		return hasBreadCrumbPile;
	}

	private World() {
	}
	
	public static World init() {
		World world = new World();
		world.addBreadcrumbPile();
		return world;
	}

	private void addBreadcrumbPile() {
		hasBreadCrumbPile = true;
	}

	public static World empty() {
		return new World();
	}

	public void addOneAnt(Ant ant) {
		this.ant = ant;
	}

	public void turn() {
		ant.move();
	}
}

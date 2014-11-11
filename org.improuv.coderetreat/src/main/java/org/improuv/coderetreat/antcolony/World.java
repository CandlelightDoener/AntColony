package org.improuv.coderetreat.antcolony;

public class World {

	public boolean hasBreadcrumbs() {
		return false;
	}

	private World() {
	}
	
	public static World init() {
		return new World();
	}

}

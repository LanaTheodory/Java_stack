package com.ObjectMaster;

public class Samurai extends Object {
	private int health = 200;
	static int counter = 0;
	
	public Samurai() {
		counter++;
	}
	
	public int deathBlow(Object Human) {
		Human.health = 0;
		this.health -= (this.health/2);
		return this.health;
	}
	
	public int meditate() {
		this.health += (this.health/2);
		return this.health;
	}

}

package com.ObjectMaster;



public class Wizard extends Object{
	int health = 50;
	int intelligence = 8;
	
	public int heal(Object Human) {
		
		Human.health = 100;
		
		return Human.health;
	}
	
	public int fireball(Object Human) {
		Human.health -= this.intelligence*3;
		return Human.health;
	}

}

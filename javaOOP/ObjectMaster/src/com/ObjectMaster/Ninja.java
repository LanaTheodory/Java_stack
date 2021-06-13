package com.ObjectMaster;

public class Ninja extends Object {
	int stealth = 10;
	
	public int steal(Object Human) {
		int amount = this.stealth;
		Human.health -= amount ;
		this.health += amount;
		
		return amount;
	}
	
	public void runAway() {
		this.health -= 10;
		
	}

}

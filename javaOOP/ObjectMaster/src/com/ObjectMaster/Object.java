package com.ObjectMaster;

public class Object {
	 int strength = 3;
	 int stealth = 3;
	 int intelligence = 3;
	 int health = 100;
	
    public int attack(Object Human){
    	
    	return Human.health -= this.strength;
    	
		
		
	}

}

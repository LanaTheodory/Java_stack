package com.ObjectMaster;

public class ObjectTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object human1 = new Object();
		Object human2 = new Object();
		Ninja ninja1 = new Ninja();
		Samurai samurai1 = new Samurai();
		Wizard wizard1 = new Wizard();
		
		
		human1.attack(human2);
		int v = human1.attack(human2);
		
		int x = ninja1.steal(human1);
		ninja1.runAway();
		
		System.out.println(v);
		System.out.println(samurai1.deathBlow(human1));
		System.out.println("samurai" + samurai1. meditate());
		System.out.println("wizard heal" + wizard1.heal(human2));
		System.out.println("wizard fireball" + wizard1.fireball(human2));
	}

}

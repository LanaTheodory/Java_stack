package com.phone;

public class PhoneTest {
	public static void main(String[] args) {
		IPhone x = new IPhone("12S" , 54 , "jawwal" , "zzzzzzz");
		Galaxy S12 = new Galaxy("22S" , 43 , "wataneyeh" , "ringggg");
		
		x.displayInfo();
		System.out.println(x.ring());
		System.out.println(x.unlock());
		
		S12.displayInfo();
		System.out.println(S12.ring());
		System.out.println(S12.unlock());
		
		

		
		
	}

}

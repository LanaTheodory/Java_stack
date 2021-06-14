package com.phone;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    
    public String ring() {
        return this.getRingTone();
    }
    public String unlock() {
    	return "facial recognition";
    }
   
    public void displayInfo() {
   	 System.out.println("Galaxy" +" "+	this.getVersionNumber() +" " +  this.getBatteryPercentage()+" "+ this.getCarrier());            
  
    }
}

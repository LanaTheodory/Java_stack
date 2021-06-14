package com.phone;

public class IPhone extends Phone implements Ringable {
	
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
 
    public String ring(){
        
        return this.getRingTone();
    }
   
    public String unlock() {
    	return "finger print";
    
    
    }
   
    public void displayInfo() {
    	 System.out.println("iphone" + " " + this.getVersionNumber() +" " +  this.getBatteryPercentage()+" "+ this.getCarrier() +" "+ this.getRingTone());            
    }
}


package com.bankaccount;

import java.util.Random;

public class BankAccount {
	private
	 long accountNumber;
	 double checkingBalance = 0;
	 double SavingsBalance = 0;
	 static int numOfAccounts = 0;
	 static long amountOfMoney= 0;
	 
	 public BankAccount(){
		 long x =  rand();
		 this.accountNumber = x;
		 numOfAccounts++;
	 }
	 
	 
	 public double getCheckingBalance() {
		return checkingBalance;
	}



	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance += checkingBalance;
		amountOfMoney += checkingBalance;
		
	}



	public double getSavingsBalance() {
		return SavingsBalance;
	}



	public void setSavingsBalance(double savingsBalance) {
		SavingsBalance += savingsBalance;
		amountOfMoney += savingsBalance;
	}


	public void withdrawChecking(int value) {
		if(checkingBalance > value){
			checkingBalance  -= value;
			amountOfMoney -= value; 
		}
		
		
	}
	
	public void balanceAmount() {
		System.out.println("checking account balance: " + this.checkingBalance );
		System.out.println("saving account balance: " + this.SavingsBalance );
	}
	

	private long rand(){
	
		 Random randx = new Random();
		 long num = randx.nextInt(999999999) + 1000000000;
		 
		 
		 return num;
		 
	 }

}

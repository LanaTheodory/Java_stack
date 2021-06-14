package com.calculator;

public class Calculator implements java.io.Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static double setOperandOne(double num) {
		return num;
	} 
	
	public static String setOperation(String operator) {
		return operator;
	}
	
	public static double setOperandTwo(double num) {
		return num;
	}
	
	public static double performOperation(double num1 , String operator , double num2 ) {
	
		double x = setOperandOne(num1);
		String o = setOperation(operator);
		double y = setOperandTwo(num2);
		double result = 0;
		if( o == "+") {
			 result = x + y;
			
		}
		if( o == "-") {
			 result = x - y;
			
		}
		return result;
		}
	
	public static double getResults(double num1 , String operator , double num2) {
		return  performOperation( num1 , operator , num2 );
		
		
	}
		
	}



package org.ukdaga.practise;

public class FizBuzz {

	//protected static String FIZZ = "fizz";
	//protected static String BUZZ = "buzz";
	//protected static String FIZBUZZ = FIZZ + BUZZ;
	
	public static String getValue (int number)
	{
		//Code #1
		if(number<1)
			throw new RuntimeException("Not Allowed");
		
		//Code #2 Removal #1
	/*	if(number == 1)
			return "1";*/

		//Code #8
		if(number%15==0)
			return "fizzbuzz";
		
		//Removal #2
		//Code #3
		/*if(number == 3)
			return "fizz";*/
		
		//Code #6
		if(number%3==0)
			return "fizz";
		
		//Removal #3 Code #4
		/*else if (number == 5)
			return "buzz";*/
		
		//code #7
		else if(number% 5==0)
			return "buzz";
		
		//Removal #4 Code #5
		/*else if (number == 15)
			return "fizzbuzz";*/

		
		//Code #1
		return String.valueOf(number); 
		
		//Initial
		//return null;
	}
}

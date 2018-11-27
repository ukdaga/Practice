package org.ukdaga.practise;

import java.util.Arrays;
import java.util.List;

public class TravellerFund {
	
	public static void main (String args[])
	{
		System.out.println(requiredAmountAtStart ( Arrays.asList(new Integer[]{4,2,-3})));
	}

	    /*
	     * Complete the 'requiredAmountAtStart' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts INTEGER_ARRAY netSaving as parameter.
	     */

	    public static int requiredAmountAtStart(List<Integer> netSaving) {

	        int sum = 0 ;
	        int min = netSaving.get(0) ;
	        for ( Integer i : netSaving)
	        {
	            sum = sum + i;
	            if (sum < min)
	                min = sum;
	        }
	        
	        if (min <0)  
	        return Math.abs(min)+1;
	        
	        else if (min > 0)
	        return 0;
	        
	        else 
	        return 1;
	    }

	



}

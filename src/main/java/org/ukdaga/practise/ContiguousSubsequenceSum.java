package org.ukdaga.practise;

import java.util.Arrays;
import java.util.List;

public class ContiguousSubsequenceSum {
	
	public static void main (String args[])
	{
		System.out.println(countSubSequence ( Arrays.asList(new Integer[]{6,2,4,1,5,0}), 6));
	}

			// 6 , 8 , 12 , 13 , 18 , 18
			// 0 , 2 , 6 , 7 , 12 , 12
			// -6 , -4 , 0 , 1 , 6 , 6 
			// -12 , -10 , -6 , -5 , 0 , 0
	
	
	//4 2 3 3 -4 -5 6    -elements
	//4 6 9 6 2 -3 3     
	static int instances = 0;
	static int countSubSequence(List<Integer> inputSeq, int targetSum) {
		
		Integer[] sumTill = new Integer[inputSeq.size()];
		int count=0 , sum=0, max=inputSeq.get(0);
		
		for (int i : inputSeq)
		{
			sum= sum+i;
			sumTill[count++] = sum;
			
			if(max<sum)
				max=sum;			
		}
		
		int runs =  max/targetSum+1;
		for (int i = 0 ; i < runs ; i++)
		{
			sumTill = reduceSum(targetSum, sumTill);
		}
		
		int x = instances;
		instances=0;
		return x;
    }


	private static Integer[] reduceSum(int targetSum, Integer[] sumTill) {
		for ( int i = 0 ; i < sumTill.length ; i ++ )
		{
			if(sumTill[i] == 0) instances++;
			sumTill[i] = sumTill[i] - targetSum;
		}
		return sumTill;
	}
	
}


package org.ukdaga.practise;

public class MaxSubsequenceNoConsecutive 
{ 
	/*Function to return max sum such that no two elements 
	are adjacent */
	int FindMaxSum(int arr[], int n) 
	{ 
		int incl = arr[0]; 
		int excl = 0; 
		int excl_new; 
		int i; 

		System.out.println("|Current element : "+arr[0]);
		for (i = 1; i < n; i++) 
		{ 
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl; 
			System.out.print("|Current element : "+arr[i]+" |Old inclusive : "+incl+" |Old exclusive : "+excl);

			/* current max including i */
			incl = excl + arr[i]; 
			System.out.print("|New inclusive : "+incl+" |New exclusive : "+excl_new);
			excl = excl_new; 
			
			System.out.println();
		} 

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		MaxSubsequenceNoConsecutive sum = new MaxSubsequenceNoConsecutive(); 
		int arr[] = new int[]{200,90,80,90,80,10, 12, 10, 5}; 
		System.out.println(sum.FindMaxSum(arr, arr.length)); 
	} 
} 

// This code has been contributed by Mayank Jaiswal 
//start , next
/*200 , 90
280 , 90
280 , 180 
360 , 180
360 , 190
372 , 200
377*/
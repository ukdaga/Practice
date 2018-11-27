package org.ukdaga.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContiguousSubsequenceSum2 {

	public static void main (String args[])
	{
		System.out.println(countSubSequence ((new int[]{6,2,4,1,5,0}), 6));
	}

	// 6 , 8 , 12 , 13 , 18 , 18
	// 0 , 2 , 6 , 7 , 12 , 12
	// -6 , -4 , 0 , 1 , 6 , 6 
	// -12 , -10 , -6 , -5 , 0 , 0


	//4 2 3 3 -4 -5 6    -elements
	//4 6 9 6 2 -3 3     
	// Utility function to insert <key, value> pair into the Multimap
	
	
	static int netCount = 0;
	private static<K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
	{
		// if the key is seen for the first time, initialize the list
		if (!hashMap.containsKey(key)) {
			hashMap.put(key, new ArrayList<>());
		}

		hashMap.get(key).add(value);
	}

	// Utility function to print a subarray A[i, j]
	public static void printSubarray(int[] A, int i, int j)
	{
		System.out.print("[" + i + ".." + j + "] -- { ");
		for (int k = i; k <= j; k++) {
			System.out.print(A[k] + " ");
		}

		System.out.println("}");
	}

	// Function to find subarrays with given sum in an array
	public static int countSubSequence(int[] A, int sum)
	{
		// create a map for storing end index of all subarrays with
		// sum of elements so far
		Map<Integer, List<Integer>> hashMap = new HashMap<>();

		// To handle the case when the subarray with given sum starts
		// from 0th index
		insert(hashMap, 0, -1);

		int sum_so_far = 0;

		// traverse the given array
		for (int index = 0; index < A.length; index++)
		{
			// sum of elements so far
			sum_so_far += A[index];

			// check if there exists at-least one sub-array with given sum
			if (hashMap.containsKey(sum_so_far - sum))
			{
				netCount++;
				List<Integer> list = hashMap.get(sum_so_far - sum);
				for (Integer value: list) {
					printSubarray(A, value + 1, index);
				}
			}

			// insert (sum so far, current index) pair into the map
			insert(hashMap, sum_so_far, index);
			
		}
		
		return netCount;
	}

}


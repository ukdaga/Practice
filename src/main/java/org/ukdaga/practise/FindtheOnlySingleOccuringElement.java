package org.ukdaga.practise;

public class FindtheOnlySingleOccuringElement {

	
	public static void main (String args[])
	{
		int arr[] = new int [] { 1,1,4,4,6,6,7,8,8};
		int x = findSingleElement(arr);
		//System.out.println("Single occuring element is "+x);
		
		findSingleElementRecursive(arr, 0 ,  arr.length-1);
		
	}

	
	//  1,1,2,3,3
	
	/*1,1,2,2,3,3,7
	
	1122 337
	
	11 22   33 7
	
	. . . 7
	*//*
	 checkSingle (leftList, RightList)
	 {
	  
	  //leftList empty RightList 1 element
	   
	  //leftlist 1 element rightlist empty
	  
	  //both list 1 element
	  
	  //recursive call again
	 
	 }
	*/
	
	private static void findSingleElementRecursive (int arr[] , int start , int end)
	{
		if(end<start)
		{
			return;
		}		
		print(arr, start , end);
		System.out.println();
		int size = end - start +1;

		if(end==start)
		{
			System.out.println ("The element is "+arr[start]);
			return;
		}
		 
		if (size ==2 )
		{
			return ;
		}
		
		else
		{
			int	middle = start + size/2;
			findSingleElementRecursive(arr, start, middle);
			findSingleElementRecursive(arr, middle+1, end);
		}
	}
	
	private static void print(int[] arr, int start, int end) {
		for (int i = start ; i <=end ; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}


	private static int findSingleElement(int[] arr) {
		
		int index = -1;
		
		for (int i = 0 ; i < arr.length ; i= i +2 )
		{
			if(i+1 < arr.length && arr[i]!=arr[i+1])
			{
				index=i;
			}
		}
		
		if (index==-1)
			index=arr.length-1;
		
		return arr[index];
	}
}

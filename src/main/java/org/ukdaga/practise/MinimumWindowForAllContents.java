/*******************************************************************************
* Copyright (c) 2019, MasterCard International Incorporated and/or its
* affiliates. All rights reserved.
*
* TO THE EXTENT PERMITTED BY LAW, THE SOFTWARE IS PROVIDED "AS IS", WITHOUT 
* WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
* WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
* NON INFRINGEMENT. TO THE EXTENT PERMITTED BY LAW, IN NO EVENT SHALL
* MASTERCARD OR ITS AFFILIATES BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
* IN THE SOFTWARE.
******************************************************************************/
package org.ukdaga.practise;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowForAllContents {

	public static void main(String args[])
	{
		int [] range = findMinimumWindow ("RahulSubramaniam" , "aa");
		System.out.println("Minimum Window Range is from indexes : "+range[0]+" to "+range[1]);
	}

	private static int[] findMinimumWindow(String main, String search) {
		
		char [] mainArray = main.toCharArray();
		char [] searchArray = search.toCharArray();
		int [] minRange = new int[]{ 0, main.length()-1 , main.length()};
		
		
		for (int i = 0; i < main.length(); i++)
		{
			for (int j = i+1 ; j <main.length(); j++ )
			{
				Map<Character, Integer> windowMap= createCharacterMap (mainArray, i , j);
				boolean windowFound = compareWithSearchString (searchArray , search.length() , windowMap );
				if(windowFound && (j-i+1)< minRange[2])
				{
					minRange[0]=i;
					minRange[1]=j;
					minRange[2]=j-i+1;
				}
			}
		}
		return minRange;
	}

	private static boolean compareWithSearchString(char[] searchArray, int length, Map<Character, Integer> windowMap) 
	{
		for (int i = 0; i< length ; i++)
		{
			Integer count = windowMap.get(searchArray[i]);
			if(count!= null && count>0)
				{windowMap.put(searchArray[i], count-1);}
			else
				return false;
		}
		return true;
	}

	private static Map<Character, Integer> createCharacterMap(char[] mainArray, int i, int j) {
		Map<Character, Integer> windowMap= new HashMap<>();
		for (int x = i ; x<=j ; x++)
		{
			windowMap.putIfAbsent(mainArray[x], 0);
			windowMap.put(mainArray[x], windowMap.get(mainArray[x])+1);
		}
		return windowMap;
	}
}

/*******************************************************************************
* Copyright (c) 2018, MasterCard International Incorporated and/or its
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

public class ParenthesisProblem {

	static int calls = 0;

	public static void main (String args[])
	{	
		calls = 0;
		callParenthesis ("(", 4 , 1 , 0 );
		System.out.println("Calls made "+calls);
	}

	private static void callParenthesis(String str, int n, int openBraces , int closedBraces) {

		calls = calls +1;

		if(closedBraces==n/2)
		{
			System.out.println(str);
			return;
		}
		if(openBraces>closedBraces)
		{
			callParenthesis (new String(str.concat(")")), n, openBraces , closedBraces+1 );
		}
		if(openBraces<n/2)
		{
			callParenthesis (new String(str.concat("(")), n, openBraces+1 , closedBraces );
		}

	}

}

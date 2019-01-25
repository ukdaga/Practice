package org.ukdaga.practise;
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

class Parent  {	
	public  void print() {
	System.out.println("Parent");	
	}
	}

	class Child extends Parent  {
		
	public void print() {		System.out.println("Child");
	}
	Child c = (Child) new Parent();
	
	Child c1 =  new Child ();
	Parent p1 = new Parent();
	

	public void m1()
	{
		c1 = (Child)(p1); // downcasting // needs check
		p1 = (c1);  // upcasting is free
	}
	
	}

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

import org.junit.Test;

public class ThreadTest {
	
	@Test
	public void testThread()
	{
		Lock lock = new Lock();
		
		for (int i = 0; i < 100 ; i++)
		{
			Thread t = new Thread(lock, String.valueOf(i));
			t.start();
		}
		
		System.out.println("end");
	}
	
	class Lock implements Runnable {
		
		int counter = 0;

		@Override
		public void run() {
			increment();
		}
		private synchronized void increment ()
		{
			System.out.println("Thread number: "+Thread.currentThread().getName()+" increment call");
			counter ++;
			printVal();
			try {
				Thread.currentThread().sleep(3000L);
			} catch (InterruptedException e) {}
			finally
			{
				System.out.println("Thread number: "+Thread.currentThread().getName()+" execution complete");
			}
			if(counter==4)
			{
				System.out.println("Thread number: "+Thread.currentThread().getName()+" is failing at runtime");
				notifyAll();
				throw new RuntimeException("Thread "+Thread.currentThread().getName()+" is failing at runtime");
			}
		}
		
		private void decrement ()
		{
			counter --;
		}
		
		private void printVal()
		{
			System.out.println("Thread number: "+Thread.currentThread().getName()+" printing value "+counter);
		}
	}

}

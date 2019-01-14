package org.ukdaga.practise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizBuzzTest {
	
	@Test(expected = RuntimeException.class)
	public void FizBuzzBelowOneReturnException()
	{
		FizBuzz.getValue(-1);
	}
	
	@Test
	public void FizBuzzForOneReturnOne()
	{
		assertEquals(FizBuzz.getValue(1), "1");
	}
	
	@Test
	public void FizzBuzzForNumberNotDivisibleByThreeFiveFifteenReturnSame()
	{
		assertEquals(FizBuzz.getValue(11), "11");
	}
	
	@Test
	public void FizBuzzForThreeReturnfizz()
	{
		assertEquals(FizBuzz.getValue(3), "fizz");
	}
	
	@Test
	public void FizBuzzForFiveReturnBuzz()
	{
		assertEquals(FizBuzz.getValue(5), "buzz");
	}
	
	
	@Test
	public void FizBuzzForFifteenReturnFizzBuzz()
	{
		assertEquals(FizBuzz.getValue(15), "fizzbuzz");
	}
	
	@Test 
	public void FizzBuzzForThreeMultipleReturnFizz()
	{
		assertEquals(FizBuzz.getValue(9), "fizz");
	}
	
	@Test 
	public void FizzBuzzForFiveMultipleReturnBuzz()
	{
		assertEquals(FizBuzz.getValue(10), "buzz");
	}
	
	@Test
	public void FizzBuzzForFifteenMultipleReturnFizBuzz()
	{
		assertEquals(FizBuzz.getValue(30), "fizzbuzz");
	}


}

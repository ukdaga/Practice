package org.ukdaga.practise;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	//Fails for compilation error
	/*@Test
	public void CalculateWithNoArguementsReturnZero()
	{
		assertEquals(StringCalculatorKata.addNumbers(), 0);
	}*/

	@Test
	public void CalculateWithOneArguementEmptyStringReturnZero()
	{
		assertEquals(StringCalculatorKata.addNumbers(""), 0);
	}
	
	//Removed test at point3
	/*@Test(expected = RuntimeException.class)
	public void CalculateWithThreeArguementsReturnException()
	{
		StringCalculatorKata.addNumbers("1,2,3");
	}*/
	
	@Test
	public void CalculateWithThreeArguementsReturnTrueValue()
	{
		assertEquals(StringCalculatorKata.addNumbers("1,2,3") , 6);
	}
	
	@Test(expected = NumberFormatException.class)
	public void CalculateWithTwoArguementsWithIncorrectNumberFormat()
	{
		assertEquals(StringCalculatorKata.addNumbers("1,n"),1);
	}
	
	@Test
	public void CalculateWithOneArguementZeroDigitReturnZero()
	{
		assertEquals(StringCalculatorKata.addNumbers("0"), 0);
	}
	
	@Test
	public void CalculateWithOneArguementTwoZerosReturnZero()
	{
		assertEquals(StringCalculatorKata.addNumbers("00"), 0);
	}
	
	@Test
	public void CalculateWithOneArguement1ReturnZero()
	{
		assertEquals(StringCalculatorKata.addNumbers("1"), 1);
	}
	
	@Test
	public void CalculateWithTwoArguementsReturnTrueValue()
	{
		assertEquals(StringCalculatorKata.addNumbers("0,1"), 1);
	}
	
	@Test
	public void CalculateWithTwoArguements12ReturnTrueValue()
	{
		assertEquals(StringCalculatorKata.addNumbers("1,2"), 3);
	}
	
	@Test(expected = RuntimeException.class)
	public void CalculateWithTwoArguementsOneNullReturnException()
	{
		StringCalculatorKata.addNumbers("1,null");
	}
	
	@Test
	public void CalculateWithTwoArguementsWithLineSeparatorReturnTrueValue()
	{
		assertEquals(StringCalculatorKata.addNumbers("1\n3,2"),6);
	}
	
	@Test(expected = NumberFormatException.class)
	public void CalculateWithTwoArguementsWithIncorrectLineSeparatorReturnException()
	{
		assertEquals(StringCalculatorKata.addNumbers("1\n\3,2"),6);
	}
	
	//Failed due to compilation error
	/*@Test(expected = RuntimeException.class)
	public void CalculateWithIncorrectDatatype()
	{
		StringCalculatorKata.addNumbers(2);
	}*/
	
	@Test(expected = NumberFormatException.class)
	public void CalculateWithTwoArguementsWithIncorrectCustomtDelimiterFormatReturnException()
	{
		assertEquals(StringCalculatorKata.addNumbers("///;\n1;2"),3);
	}
	
	@Test
	public void CalculateWithTwoArguementsWithCustomtDelimiterReturnTrueValue()
	{
		assertEquals(StringCalculatorKata.addNumbers("//;\n1;2"),3);
	}
	
	@Test(expected = NumberFormatException.class)
	public void CalculateWithTwoArguementsWithIncorrectDelimiterReturnException()
	{
		assertEquals(StringCalculatorKata.addNumbers("//;\n1,2"),3);
	}
	
	@Test
	public void CalculateWithTwoArguementsWithCustomtDelimiterHavingEmptyStringReturnTrueValues()
	{
		assertEquals(StringCalculatorKata.addNumbers("//;\n1;;2"),3);
	}
	
	
	
}

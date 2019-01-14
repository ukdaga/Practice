package org.ukdaga.practise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorKata {
	
	public static int addNumbers(String number)
	{
		int sum = 0;
		/*String[] list = number.split(",");*/
		String[] list = null;
		Pattern datePatt = Pattern.compile("//(.*)\\n(.*)");

		Matcher m = datePatt.matcher(number);
		if (m.matches()) {
			String delimiter =m.group(1);
			String sequence = m.group(2);
			list = sequence.split(delimiter);
		}
		else
		{
			list = number.split(",|\\n");
		}

		//Commented at Point3.
		/*if(list.length>2)
			throw new RuntimeException();*/

		if(number.length()==0)
			return sum;

		/*if(list.length==1)
		{
			if(list[0].length()==0)
				return 0;
			if("0".equals(list[0]))
			    return 0;
			if("1".equals(list[0]))
				return 1;
		}*/

		/*if(list.length==2)
		{
			if("0".equals(list[0]) && "1".equals(list[1]))
				return 1;
		}*/

		for (String x : list)
		{
			if("null".equals(x))
			{
				throw new RuntimeException();
			}
			sum = sum + Integer.parseInt(x);
		}
		return sum;

		/*return 0;*/
	}

}

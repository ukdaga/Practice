package org.ukdaga.practise;

public class ShortestCardinalPath {

	public static void main (String args[])
	{
		System.out.println(printShortestPath (4, "LMRMLM"));
	}

	private static String printShortestPath(int i, String moves) {

		int x=0, y=0;
		int angle=90;

		for (char move : moves.toCharArray())
		{
			if(move=='M')
			{
				angle=angle%360;
				switch(angle)
				{
				case 90: y++; break;
				case 180: x--; break;
				case 270: y--; break;
				case 0: x++; break;
				default:break;
				}					
			}
			else if (move=='L')
			{
				angle = angle+90;

			}
			else if (move=='R')
			{
				angle = angle-90;
			}
		}


		StringBuilder remains = new StringBuilder();
		StringBuilder initials = new StringBuilder();

		int absX = Math.abs(x);
		int absY = Math.abs(y);
		int absDiff = Math.abs(absX-absY);


		if(absX>absY)
		{
			absX = absX-absDiff;
			for(int c = 1 ; c<=absDiff ; c++)
				remains.append(x>0? "6" : "8");
		}
		else if(absY>absX)
		{
			absY = absY-absDiff;
			for(int c = 1 ; c<=absDiff ; c++)
				remains.append(y>0 ? "5" : "7");
		}

		if(x>0)
		{
			if(y>0)
			{
				for(int c= 1; c<=absY; c++)
					initials.append("1");
			}
			else if(y<0)
			{
				for(int c= 1; c<=absY; c++)
					initials.append("2");
			}

		}
		else if(x<0)
		{
			if(y>0)
			{
				for(int c= 1; c<=absY; c++)
					initials.append("4");
			}
			else if(y<0)
			{
				for(int c= 1; c<=absY; c++)
					initials.append("3");
			}
		}

		return initials.append(remains).append("0").toString();

	}

}

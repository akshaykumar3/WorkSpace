import java.util.ArrayList;


public class DayCalculator 
{
	private static ArrayList<String> days = new ArrayList<String>();
	private static final int year = 2014;
	
	private static final int MOD = 7;
	private static final int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args)
	{
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");
		days.add("Sunday");
		int d = 31, m = 12, y = 2013;
		printDay(d, m, y);
	}

	private static void printDay(int d, int m, int y) 
	{
		int c = 0;
		int count = 365 * (year - y);
		if(year > y)
			count += 5;
		System.out.println(++c+" "+count);
		count += (year - y)/4 ;
		System.out.println(++c+" "+count);
		for(int i = 0; i < m - 1; i++)
		{
			count -= months[i];
			System.out.println(++c+" "+count);
		}
		if(m > 2)
		{
			if(y % 4 == 0)
			{
				count --;
				System.out.println(++c+" "+count);
			}
		}
		count -= d;
		System.out.println("Number of days being: "+count);
		count = count % MOD;
		System.out.println(d+"/"+m+"/"+y+" was: "+days.get(count));
	}
}


public class DayOfWeek {

	public static void main(String[] args) {
		int date = dow(1963, 8, 23);
		System.out.println("The date is "+date);
	}

	/*
	 * Sunday = 0
	 * Monday = 1
	 * Tuesday = 2
	 * Wednesday = 3
	 * Thursday = 4
	 * Friday = 5
	 * Saturday = 6
	 */
	private static int dow(int y, int m, int d) {
		int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
		// y -= m < 3;
		if(m < 3)
			y--;
		return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
	}
}

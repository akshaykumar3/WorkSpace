import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		int t=1;
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, -1 * t);
		System.out.println(calendar.getTime());
	}
}

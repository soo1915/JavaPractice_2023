package sec02;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(month);
	}

}

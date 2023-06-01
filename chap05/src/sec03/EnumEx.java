package sec03;

import java.util.Calendar;

public class EnumEx {

	public static void main(String[] args) {
		Week today;
		
		today = Week.수요일;
		System.out.println(today);

		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		
		switch(week) {
		case 1 :
			today = Week.일요일; break;
		case 2 :
			today = Week.월요일; break;
		case 3 :
			today = Week.화요일; break;
		case 4 :
			today = Week.수요일; break;
		case 5 :
			today = Week.목요일; break;
		case 6 :
			today = Week.금요일; break;
		case 7 :
			today = Week.토요일; break;
		}
		
		System.out.println("오늘 요일 : " + today);
		
		if (today == Week.수요일) {
			System.out.println("수요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부합니다. ");
		}
	}

}

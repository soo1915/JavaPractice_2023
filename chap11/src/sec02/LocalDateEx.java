package sec02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateEx {

	public static void main(String[] args) {

		String cd = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		System.out.println(cd);
		LocalTime ct = LocalTime.now();
		System.out.println(ct);
		LocalDateTime cdt = LocalDateTime.now();
		System.out.println(cdt);
		
		String str = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);
		System.out.println(str);
	}

}

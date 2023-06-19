package swing0619;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ex1 {

	public static void main(String[] args) {
		Ex1 ex = new Ex1();
		String str = ex.getCurrentTime();
		System.out.println(str);
	}

	public String getCurrentTime() {
		
		return LocalDate.now()+" " + LocalTime.now().toString().substring(0, 8);
	}
}

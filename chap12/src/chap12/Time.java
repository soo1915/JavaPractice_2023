package chap12;

import java.time.LocalDate;
import java.time.LocalTime;

public class Time extends Thread {

	@Override
	public void run() {
		while (true) {
			String str = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);
			System.out.println(str);		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
}

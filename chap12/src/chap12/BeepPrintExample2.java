package chap12;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) {
		// 스레드 생성, 실행
		
		//Runnable beepTask = new BeepTask();
		Thread thread = new BeepThread();
		thread.start();
		
		for (int i = 0; i< 5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500); } catch (Exception e) {}
		}

	}

}

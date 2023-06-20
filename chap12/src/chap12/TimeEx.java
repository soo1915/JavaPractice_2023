package chap12;

public class TimeEx {

	public static void main(String[] args) {
		// 시계 스레드 생성, 실행
		Thread time = new Time();
		time.start();
		
		
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
				System.out.println("작업 중");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

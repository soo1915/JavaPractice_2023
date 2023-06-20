package chap12;

public class TaskEx {

	public static void main(String[] args) {
		
//		Runnable task = new Task();
		
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("task2");
				
			}
			
		});
		
		th.start(); // 스레드 실행 요청 (Task 클래스의 run 메소드를 실행한다) 
	}

}

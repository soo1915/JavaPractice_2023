package sec01.exam03;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc ;
		rc = new Television();
		execute(new Television(), 7);
		Searchable se = (Searchable) rc;
		se.search("www.naver.com");
		
	//			
	}
	
	public static void execute(RemoteControl remote, int num) {
		remote.turnOn();
		remote.setVolume(num);
		remote.turnOff();
		
	}

}

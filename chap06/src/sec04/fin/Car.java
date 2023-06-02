package sec04.fin;

public class Car {
	int gas;
	
	boolean isLeftGas() {
		if(gas > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	void run() {
		while (true) {
			if(gas > 0) {
				System.out.println("달림");
				gas -= 1;
			} else {
				System.out.println("멈춤");
				return;
			}
			
		}
	}
	
}

package sec04.practice;

public class Car {
	int gas;
	
	void setCar(int gas) {
		this.gas = gas;
	}
	
	boolean isLeftGas() {
		if(gas > 0) {
			return true;
		} else {
			return false;			
		}
	

	}
	
	void run() {
		while(isLeftGas()) {
			System.out.println("달립니다");			
			gas -= 1;
		} 
		
	}
}

package sec04;

public class Car {
	int gas;
	int speed;
	
	void setGas(int gas) {
		this.gas = gas;
		
	}
	
	boolean isLeftGas() {
		if(gas==0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	void run() {
		while(true) {
			if(gas > 0) {			
				for(int i = gas*10; i>0; i-=10) {
					speed = i;
					System.out.print("달립니다.(gas 잔량 : " + gas);
					System.out.println(", 시속 : " + speed + "km/h)");
					this.gas -= 1;
				}
				
			} else {
				System.out.print("멈춥니다.(gas 잔량 : " + gas);
				System.out.println(", 시속 : " + (speed-10) + "km/h)");
				return;
			}
		}
	}
	
	int getSpeed() {
		return speed;
	}
	
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	
	
}

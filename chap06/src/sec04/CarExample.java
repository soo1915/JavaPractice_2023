package sec04;

import java.util.Scanner;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		Car myCar = new Car();
		System.out.println("가스값 입력 > ");
		int inputGas = Integer.parseInt(scanner.nextLine());
		myCar.setGas(inputGas);
		
		boolean gasState = myCar.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		
		if (myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		}else {
			System.out.println("gas를 주입하세요.");
		}
	
	}

}

package sec04;

public class CalculatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator myCalc = new Calculator(5,6) ;
		myCalc.powerOn();
		
		int result1 = myCalc.plus();
		System.out.println("result1 : " + result1);
		myCalc.setX(10);
		myCalc.setY(3);

		System.out.println("x = " + myCalc.getX());
		Calculator myCalc2 = new Calculator(10, 4);
		double result2 = myCalc2.divide();
		System.out.println("Result2 : " + result2);
		
		myCalc.powerOff();
	}

}

package main;

import chap07.ExeTimeCalculator;
import chap07.ImpeCalculator;
import chap07.RecCalculator;

public class Main2 {

	public static void main(String[] args) {
		ExeTimeCalculator ecal = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ecal.factorial(4));
		
		System.out.println();
		
		ExeTimeCalculator ecal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ecal2.factorial(4));
	}

}

package main;

import chap07.ImpeCalculator;
import chap07.RecCalculator;

public class Main1 {

	public static void main(String[] args) {
		ImpeCalculator ical = new ImpeCalculator();
		long res = ical.factorial(4);
		System.out.println(res);
		
		System.out.println();
		
		RecCalculator rcal = new RecCalculator();
		long res2 = rcal.factorial(4);
		System.out.println(res2);
	}

}

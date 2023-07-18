package com.example.sp5_ch2;

public class Ex1 {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.setFormat("%s 안녕");
		System.out.println(greeter.greet("스프링"));

	}

}

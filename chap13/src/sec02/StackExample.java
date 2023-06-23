package sec02;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));

		Coin coin1 = coinBox.peek();
		System.out.println("꺼내온 동전 : " +coin1.getValue() + "원");
		System.out.println("---------------------------------------");
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " +coin.getValue() + "원");
		}
	}

}

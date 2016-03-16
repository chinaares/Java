package com.java8.LambadExp.test1;

public class LambdaChild {

	// With Anonymous class.
	IsFunctional isFunc = new IsFunctional() {
		@Override
		public void testMetod(String data) {
			System.out.println("Printing " + data + " from Anonymous class.");
		}
	};

	// With lambda expression.
	IsFunctional func = (demoData) -> {
		System.out.println("Printing " + demoData + " from Lambda expression.");
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

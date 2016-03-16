package com.java8.LambadExp.test1;

@FunctionalInterface
interface IsFunctional {
	void testMetod(String data);

	// Functional interface can have more than one static or default methods.
	default void cdf() {
		System.out.println("This is default in Functional Interface.");
	}
	
	static void staticMethod() {
		System.out.println("This is static method in Functional Interface.");
	}

	// And also can override methods of java.lang.Object
	@Override
	public String toString();
}
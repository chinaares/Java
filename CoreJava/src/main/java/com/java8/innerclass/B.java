package com.java8.innerclass;

public class B {

	public static void main(String[] args) {

		A a = new A();
		System.out.println(a.i);

		A.B b = a.new B();

		A.B b1 = new A().new B();

		System.out.println(b.i);

		System.out.println(new A.BB().i);

	}
}

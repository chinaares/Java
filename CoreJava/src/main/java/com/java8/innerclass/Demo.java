package com.java8.innerclass;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List names = new ArrayList();

		List names1 = new ArrayList();

		names.add("Mahesh");
		names.add("Suresh");
		names.add("Ramesh");
		names.add("Naresh");
		names.add("Kalpesh");

		names.forEach(System.out::println);
		names.forEach(names1::add);
		names1.forEach(System.out::println);
		names.forEach(names1::remove);
		names1.forEach(System.out::println);

		// Demo a=new Demo();

		// names1 = (names :: add);

	}

	public static void say() {
		System.out.println("hello");
	}

}

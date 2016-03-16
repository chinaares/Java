package com.java8.lambad;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Foo1 {
	void bar(List<String> arg);
}

@FunctionalInterface
interface Foo2 {
	void bar(List arg);
}

@FunctionalInterface
interface Foo3 {
	List bar(List arg);
}

@FunctionalInterface
interface Foo extends Foo1, Foo2 {
	void bar(List arg);
}

public class FunctionalInterfaceDemo {

	public static void getFoo1(List list, Foo1 foo1) {
		foo1.bar(list);
	}
	
	public static List<String> getFoo3(List list, Foo3 foo3) {
		return foo3.bar(list);
	}
	
	public static void getFoo(List list, Foo foo) {
		foo.bar(list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();
		list.add("Pramoj");
		list.add("Kumar");
		list.add("Prusty");
		list.add("Dipu");

		getFoo1(list, (foo1List) -> {
			System.out.println(foo1List);
			foo1List.forEach(string -> System.out.println("Lambada Exp foreatch --- >>" + string));
		});
		
		// return List by lambad
		List<String> foo3List = getFoo3(list, (listFoo3) -> {
			return listFoo3;
		});

		System.out.println("after return : "+foo3List);
		foo3List.forEach(string -> System.out.println("Lambada Exp foreatch return--- >>" + string));
		
		getFoo(list, (fooList) -> {
			System.out.println(fooList);
			fooList.forEach(string -> System.out.println("Lambada Exp foreatch --- >>" + string));
		});
		
	}

}

package com.java8.lambad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachRemaining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

List<String> list =new ArrayList<String>();
		
		list.add("Pramoj");
		list.add("Kumar");
		list.add("Prusty");
		list.add("Dipu");
		
		
		// using Iterator
		Iterator<String> itr = list.iterator();
		  		
		//itr.forEachRemaining(System.out::println);
		//itr.forEachRemaining(string->System.out.println("***- >>"+string));
		
		Iterable<String> itrerable=(Iterable<String>) list.iterator();
		itrerable.forEach(System.out::println);
	}

}

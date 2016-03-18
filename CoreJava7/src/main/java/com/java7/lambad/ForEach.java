package com.java7.lambad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {
		
		List<String> list =new ArrayList<String>();
		
		list.add("Pramoj");
		list.add("Kumar");
		list.add("Prusty");
		list.add("Dipu");
		
		//for each before jdk 8
		
		for (String string : list) {
			System.out.println("noramal for each ---"+string);
		}
		
		// for eatch using lambad exp in java8
		/*list.forEach(string->System.out.println("Lambada Exp foreatch --- >>"+string));
		
		List<String> list2=null;
		for (String string : list2) {
			System.out.println(string);
		}
		list2.forEach(string->System.out.println(string));*/
	
		
	}
}

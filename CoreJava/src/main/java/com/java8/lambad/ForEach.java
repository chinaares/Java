package com.java8.lambad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.ItalicAction;

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
		
		// using Iterator
		Iterator<String> itr = list.iterator();
		  
		while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.println("--->>"+element);
	      }
		
		itr.forEachRemaining(System.out::println);
		itr.forEachRemaining(string->System.out.println("***- >>"+string));
		
		// for eatch using lambad exp in java8
		list.forEach(string->System.out.println("Lambada Exp foreatch --- >>"+string));
		
		
		
	}
}

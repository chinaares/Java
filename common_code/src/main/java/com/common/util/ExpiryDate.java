package com.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExpiryDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Date d= new Date();
		System.out.println(d);*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 5); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
	}

}

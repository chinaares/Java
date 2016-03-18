package com.problem;

import java.util.HashMap;
import java.util.Map;


public class CountNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int list[]={1,0,1,0,0,0,1};
		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i : list) {
			try {
				map.put(i, (Integer) map.get(i)+1 );
			} catch (NullPointerException e) {
				map.put(i,1);
			}
		}
		
	}

}

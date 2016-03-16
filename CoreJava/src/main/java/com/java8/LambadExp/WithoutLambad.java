package com.java8.LambadExp;

public class WithoutLambad {

	public static void main(String[] args) {
		WithoutLambad withoutLambad= new WithoutLambad();
		int sum=withoutLambad.operate(10, 5, new MathOperationImpl());
		
		System.out.println("10 + 5 = " + sum);
		
		//System.out.println(withoutLambad.sayMsg("hello", new MathOperationImpl()));
	}
	
	private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	   }
	
	/*private String sayMsg(String s,MathOperation mathOperation){
	      return mathOperation.sayMessage(s);
	   }*/
}

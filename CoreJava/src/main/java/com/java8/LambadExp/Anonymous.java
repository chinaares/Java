package com.java8.LambadExp;

public class Anonymous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Anonymous anonymous= new Anonymous();
		
		 //invoke doSomeWork using Annonymous class
		MathOperation mathOperation = anonymous.operate(new MathOperation() {
			@Override
			public int operation(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}			

        });

		int sum=mathOperation.operation(10, 5);
		System.out.println("10 + 5 = " + sum);
		//System.out.println(mathOperation.sayMessage("Hello"));
	}
	
	private MathOperation operate(MathOperation mathOperation){
	      return mathOperation;
	   }

}

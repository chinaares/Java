package com.java8.LambadExp.test1;

@FunctionalInterface
interface IsTypeOne {
	// #1 Only abstract method of IsTypeOne
	public void hasOne();
}

@FunctionalInterface
interface IsTypeTwo {
	// #1 Only abstract method of IsTypeOne
	public void hasTwo();
}

@FunctionalInterface
interface IsTypeThree {
	public String hasThree(String name);
}

@FunctionalInterface
interface IsTypeFloat {
	public float hasFloat(float no);
}

@FunctionalInterface
interface IsTypeSum {
	public float hasSum(float no1, int no2);
}

@FunctionalInterface
interface IsNumber {
	public Integer checkNumber(String arg) throws NullPointerException, NumberFormatException;
}

public class TestType {
	// #2 Method parameter is of type IsTypeOne
	public void first(IsTypeOne one) {
		// #5 Method that is overridden by Lambda will be called.
		one.hasOne();
	}

	// #6 Method parameter is of type IsTypeTwo
	public void second(IsTypeTwo two) {
		// #9 Method that is overridden by Lambda will be called.
		two.hasTwo();
	}

	public String three(String name, IsTypeThree three) {
		return three.hasThree(name);
	}

	public float getFloatValue(float no, IsTypeFloat isTypeFloat) {
		return isTypeFloat.hasFloat(no);
	}

	public float getSumValue(float no1, int no2, IsTypeSum isTypeSum) {
		return isTypeSum.hasSum(no1, no2);
	}

	public Integer getNumber(String arg, IsNumber isNumber) throws Exception {
		Integer value = 0;
		try {
			value = isNumber.checkNumber(arg);
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println("error ");
			throw new Exception("throw error");
		}
		return value;
	}

	public Integer getNumberWithExp(String arg, IsNumber isNumber) throws Exception {
		Integer value = 0;
		value = isNumber.checkNumber(arg);
		return value;
	}

	public void invoke() throws NumberFormatException, Exception {
		// #3 Here labmda type is "IsTypeOne", because first() has parameter of
		// type "IsTypeOne"
		// #4 Body {...} of lambda is body part of Overridden hasOne method.
		first(() -> {
			System.out.println("Invoking first.");
		});
		// #7 Here labmda type is "IsTypeTwo", because second() has parameter of
		// type "IsTypeTwo"
		// #8 Body {...} of lambda is body part of Overridden hasTwo method.
		second(() -> {
			System.out.println("Invoking second.");
		});

		String s1 = three("pramoj", name -> name);
		String s2 = three("pramoj kumar", name -> {
			return name;
		});
		String s3 = three("pramoj kumar Prusty", (String name) -> {
			return name;
		});

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		IsTypeFloat IsTypeFloat = no -> no * 2;
		float floatValue1 = getFloatValue(10, IsTypeFloat);
		float floatValue2 = getFloatValue(10, no -> {
			return (float) 3.1415;
		});

		float floatValue3 = getSumValue(10, 10, (no1, no2) -> {
			return no1 + no2;
		});

		System.out.println(floatValue1);
		System.out.println(floatValue2);
		System.out.println(floatValue3);

		
		Integer num2 = getNumberWithExp("", (arg) -> {
			
			Integer value = 0;
			try {
				value = new Integer(arg);
			} catch (Exception e) {
				// TODO: handle exception
				try {
					throw new Exception("throw error ");
				} catch (Exception e1) {
					System.out.println("error getNumberWithExp");
				}
				
			}
			return value;
		});
		System.out.println(num2);
		
		Integer num = getNumber("", (arg) -> {
			return new Integer(arg);
		});
		System.out.println(num);

	}

	public static void main(String[] args) throws NumberFormatException, Exception {
		TestType testType = new TestType();
		testType.invoke();
	}
}
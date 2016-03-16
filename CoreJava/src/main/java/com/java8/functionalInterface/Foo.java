package com.java8.functionalInterface;

import java.util.List;

@FunctionalInterface
public interface Foo extends Foo1,Foo2{
	void bar(List<String> arg);
}

package com.java8.lambad;

import java.util.Collection;

/*
 Background :
 1) Functional Interface :
 In one line of description, Interface with only abstract method are reffered as Functional Interface.
 However, A functional interface can have more than one static or default methods, and also can Override some methods from java.lang.Object
 Luckily you do not need to verify the Functional Interface, Compiler will do it for you.
 But you can specify @FunctionalInterface anotation to reduce it's workload.
 Below is an example of Functional interface.
 */
interface Demointerface {

    // Only abstract method.
    void abc(Collection collection);

    // Functional interface can have more than one static or default methods.
    default void cdf() {
        System.out.println("This is default in Functional Interface.");
    }

    // And also can override methods of java.lang.Object
    @Override
    public String toString();
}

/*
 Some frequently used and popular Functional Interfaces are,
 java.awt.event.ActionListener;
 java.lang.Runnable
 java.util.concurrent.Callable
 java.security.PrivilegedAction
 java.util.Comparator
 java.io.FileFilter
 java.beans.PropertyChangeListener
 Note :
 A new package in Java 8 is added that contains functional interfaces that are commonly used for lambda expression and method reference :
 java.util.function
 http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
    
 2) Verticle problem :
 The main problem with Anonymous classes are the syntax.
 For doing some simple operation we need to write additional syntactical code each time (However this is not true in some cases, described later in this article).
 The problem of bulky syntex is reffered as "Verticle problem" by Java people.
 For example : consider the ActionListener interface
 button.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent e) { 
        // Do some operation.
    }
 });
 Above code uses additional code lines each time when you write the anonymous ActionListener class, Just to avoide writing extra class implementing ActionListener interface.
 What is Lambda Expression ?
 Lambda expressions are anonymous methods, aimed at mainly addressing the "vertical problem" by 
 replacing the machinery of anonymous inner classes with a lighter-weight mechanism in applicable cases.
 How to use ?
 Example : 
 */
@FunctionalInterface
interface IsFunctional {
    void testMetod(String data);
}

class LambdaChild {
    // With Anonymous class.
    IsFunctional isFunc = new IsFunctional() {
        
        @Override
        public void testMetod(String data) {
            System.out.println("Printing " + data + " from Anonymous class.");
        }
    };
        
    // With lambda expression.
    IsFunctional func = ( demoData ) -> {
        System.out.println("Printing " + demoData + " from Lambda expression.");
    };
}
/*
 Lambda expressions are implementation of only abstract method of interface that is being implemented or instanciated anonymously.
 
 In above example, first one is the traditional way by creating anonymous inner class that will implement IsFunctional interface and Override testMethod().
 Second one is brand new Lambda, with light syntax and no additional typing overhead.
 
 The statements between {...} are body part of Overridden method and (...) are arguments passed to the method.
 
 Side note : I can see a suggestion in my NetBeans IDE 8.0 "Use Lambda Expression" where anobymous class is written in above example.
 
Syntax of Lambda :
 Lambda expresssion syntax can be devided into three parts.
 Arrow (->) token
 Argument List :
     A lambda expression can contain zero or more arguments.
     // No argument.
     () -> { System.out.println("No argument"); }
     // Single argument.
     (int arg) -> { System.out.println("Single integer argument : " + arg); }
     // More than one arguments.
     ( int arg1, String arg2 ) -> { System.out.println("Two arguments : " + arg1 + " and " + arg2); }
    
     You can eliminate the argument type while passing it to lambda expressions, those are inferred types.
     i.e. ( int a ) and ( a ) both are same.
        
     More than one arguments are seperated by comma (,) operator.
     
     You can also eliminate "()" if there is only argument to avoid Horizontal Problem.
     Example : ( arg ) -> {...} can be written as arg -> {...} 
    
     You can not use inferred and declared types together, Following is invalid. 
     Example : ( int arg1, arg2 ) // This is invalid
     Body :
     Body can be a singel expression or a statement block.
        
     If a body contains only single expression than expression will be simply evaluated and returned.
     Example : () -> System.out.println("No argument"); 
     If a body is statement of block, than it will be evaluated same as a method body, that will be called and 
     a hidden return statement at the end block that will return control to caller after execution of block.
     So, branching statements ( continue and break ) are illegal and return is not necessary to write.
     Example :   () -> {
                    System.out.println("Bad lambda");
                    break ; // this statement is not allowed here.
                 }
 Type of Lambdas :
 Example :
*/
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

class TestType {
    // #2 Method parameter is of type IsTypeOne
    public void first( IsTypeOne one ){
        //#5 Method that is overridden by Lambda will be called.
        one.hasOne();
    }
    
    //#6 Method parameter is of type IsTypeTwo
    public void second( IsTypeTwo two ){
        //#9 Method that is overridden by Lambda will be called.
        two.hasTwo();
    }
    
    public void invoke() {
        //#3 Here labmda type is "IsTypeOne", because first() has parameter of type "IsTypeOne"
        //#4 Body {...} of lambda is body part of Overridden hasOne method.
        first(() ->  { System.out.println("Invoking first."); });
        
        //#7 Here labmda type is "IsTypeTwo", because second() has parameter of type "IsTypeTwo"
        //#8 Body {...} of lambda is body part of Overridden hasTwo method.
        second(() -> { System.out.println("Invoking second."); });
    }
}
/*
Explanation of above example :
    #1 IsTypeOne and IsTypeTwo are two different functional interfaces with only abstract method hasOne and hasTwo respectively.
    #2 Parameter type of first() method in TestType class is IsTypeOne
    #3 first() method is called from invoke() method having lambda as argument, So lambda is of type IsTypeOne.
    #4 Lambda expression is Overriding hasOne() of IsTypeOne interface as anonymous method.
    #5 Method Overridden by lambda expression will be called.
    #6 Parameter type of second() method in TestType class is IsTypeTwo
    #7 second() method is called from invoke() method having lambda as argument, So lambda is of type IsTypeTwo.
    #8 Lambda expression is Overriding hasTwo() of IsTypeTwo interface as anonymous method.
    #9 Method Overridden by lambda expression will be called.
The compiler is responsible for inferring the type of each lambda expression. 
It uses the type expected in the context in which the expression appears; 
this type is called the target type. 
In above example, target type of first() at #3 is IsTypeOne, so Compiler will use lambda type as IsTypeOne.
and target type of second() at #7 is IsTypeTwo, so Compiler will use lambda type as IsTypeTwo.
A lambda expression can only appear in a context whose target type is a functional interface.
A lambda expression can be assigned to a Reference which is of target type T if all of the following conditions hold:
     T is a functional interface type
     The lambda expression has the same number of parameters as T's method, and those parameters' types are the same
     Each expression returned by the lambda body is compatible with T's method's return type
     Each exception thrown by the lambda body is allowed by T's method's throws clause
When to use ?
Lambda is replacement of Anonymous class ? NO, Lambdas are anonymous functions which are designed to eliminate overhead (Constructor and Bulkey code) of Anonymous class where it is not requird.
Anonymous class : 
    If you want to declare constructor, some variables and going to write additional methods that will not be part of Interface, Then use Anonymous class.
    
Lambda Expression :
    If you want to implement only method of functional interface, than use Lambda expressions or you want to pass that to other code.
This was some part of lambda expression with examples, It is a quite large that can not be covered in detail in one article.
Hope this article will be helpful, don't forget to post your suggestions and feedback.
Useful links :
Project Lambda : http://openjdk.java.net/projects/lambda/
Lambda FAQ : http://www.lambdafaq.org/
You can always clone the executable code of article posted on Java By Examples from github.com 
Repository URL : https://github.com/ksarsecha/java8_in.git
*/

public class DemoLambda {

    public static void main(String[] args) {
        LambdaChild lambda = new LambdaChild();
        lambda.func.testMetod("Demo data");
        lambda.isFunc.testMetod("Demo data");
        new TestType().invoke();
    }
}

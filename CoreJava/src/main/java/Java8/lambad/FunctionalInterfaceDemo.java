package Java8.lambad;

import java.util.ArrayList;
import java.util.List;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list =new ArrayList<String>();		
		list.add("Pramoj");
		list.add("Kumar");
		list.add("Prusty");
		list.add("Dipu");
		
		Foo1 foo1=(List list)->{list.forEach(string->System.out.println("Lambada Exp foreatch --- >>"+string));};
	}

}


@FunctionalInterface
interface Foo1 {
	void bar(List<String> arg);
}

@FunctionalInterface
interface Foo2 {
	void bar(List arg);
}
@FunctionalInterface
interface Foo extends Foo1, Foo2 {
	void bar(List arg);
}

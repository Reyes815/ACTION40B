package sample;
import java.util.ArrayList;
import java.util.List;

public class TestJava {

    /**
    *@param args
	*/
	public static void main(final String[] args) {
		boolean flag = true;
		NoneParam buh = () -> {
		    System.out.println("This is a lambda");
		};
		buh.display();
		Subtract buh2 = (a, b) -> a - b;
		System.out.print("Difference: ");
		System.out.println(buh2.subtraction(5, 2));
		FunctionInter buh3 = (x) -> System.out.println(x*2);
		buh3.absFunction(4);
		ArrayList<String> buh4 = new ArrayList<String>();
		buh4.add("Juan");
		buh4.add("Viktor");
		buh4.add("Vicky");
		buh4.stream()
		.filter(x -> x.startsWith("V"))
		.map(x -> x.toUpperCase())
		.forEach(x -> System.out.print(x + " "));
		
		List<Animals> buh5 = new ArrayList<Animals>();
		buh5.add(new Animals("fish", false, true));
		buh5.add(new Animals("Kangaroo", true, false));
		buh5.add(new Animals("rabbit", true, false));
		buh5.add(new Animals("turtle", false, true));
		System.out.println();
		print(buh5, new CheckIfHopper());
	}
	
	private static void print(List<Animals> animals, CheckTrait checker) {
	    animals.forEach(x -> {
	        if (checker.test(x)) {
	            System.out.println(x + " ");
	        }
	    });
	}

}

@FunctionalInterface
interface NoneParam {
    void display();
}

interface Subtract {
    int subtraction(int x, int y);
}

interface FunctionInter {
    void absFunction(int x);
}





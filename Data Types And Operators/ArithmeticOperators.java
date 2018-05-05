package operators;
public class ArithmeticOperators {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int result = x + y;
 
        System.out.println("x ="+ x +"\ny = " + y);
        System.out.println("x + y = " + result);
 
        result = x - y;
 
        System.out.println("x - y = " + result);
 
        result = x * y;
 
        System.out.println("x * y = " + result);
 
        result = y / x;
 
        System.out.println("y / x = " + result);
 
        result = x % 3;
 
        System.out.println("x % 3 = " + result);

	String greeting = "\"+\" operator can be " + "used to concatanate strings";
	System.out.println(greeting);
 
    }
}

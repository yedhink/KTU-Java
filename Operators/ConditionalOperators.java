package operators;
public class ConditionalOperators {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
 
        System.out.println("x ="+ x +"\ny = " + y);
        if ((x > 8) && (y > 8)) {
            System.out.println("Both x and y are greater than 8");
        }
 
        if ((x > 10) || (y > 10)) {
            System.out.println("Either x or y is greater than 10");
        }

	int result = (x > 10) ? x : y;
 
        System.out.println("result 1 is: " + result);
 
        result = (y > 10) ? x : y;
 
        System.out.println("result 2 is: " + result);
 
    }
}

package operators;
public class UnaryOperators {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
 
        int result = +x;
        System.out.println("x ="+ x +"\ny = " + y);
 
        System.out.println("+x = " + result);
 
        result = -y;
 
        System.out.println("-y = " + result);
 
        result = ++x;
 
        System.out.println("++x = " + result);
 
        result = --y;
 
        System.out.println("--y = " + result);
 
        boolean ok = false;
 
        System.out.println("intially ok = false\nok = "+ok);
 
        System.out.println("!ok = "+!ok);

	System.out.println("++x = "+ (++x));
 
        System.out.println("x++ = " + (x++));
 
        System.out.println("x = "+x);
 
        System.out.println("--y = "+ (--y));
 
        System.out.println("y-- = "+ (y--));
 
        System.out.println("y = "+y);
    }
}

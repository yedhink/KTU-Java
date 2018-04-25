package MATH.modulesix;
import MATH.modulesix.RecursiveParser;
import java.lang.*;
import java.io.*;
import java.util.*;
/*  
 *  Operators currently usable:-
 *  1) +
 *  2) -
 *  3) *
 *  4) /
 *  5) ^(raise to or power function)
 *  6) sqrt(value) , eg:- sqrt(2)
 *  7) sin(), cos(), tan()
 *  8) e , exponential eg:- e^(x^2) :- e raise to x square
 *  8) ( and ) for precedence
 *  
 *  Input Format for f(x) , an example:-
 *  	Enter f(x) = 1/(1+x^2)
 *  
 *
 *
 *  TRAPEZOIDAL METHOD:-
 *	    a
 *	    (f(x)dx = h/2 [ (f(x)+f(xn)) + 2 * (f(x1)+f(x2)+f(x3)+...f(x[n-1])) ] 
 *	    )
 *	    b
 *	    exmaple:-
 *	      x : 0  0.2  0.4  0.6  0.8  1  1.2  1.4  1.6  1.8  2
 *	    f(x): ?   ?    ?    ?    ?   ?   ?    ?    ?    ?   ?
 *	    if x is given like above in question then choose first value as a and lastvalue as b
 *	    i.e :- a=x0 and b=xn
 *	    h = (b-a)/n , where n = count(x)
 */
public class NumericIntegration {
		private static float a,b,n;
		private static String formule , eachFOfX, choice;
		private static List<String> valueOfX = new ArrayList<String>();
		private static double secondExp = 0.0000 , firstPlusLast= 0.0000 , thirdExp= 0.0000;
		private static float h;
		private static int i = 0;
	public static void trapezoidalIntegration() throws IOException {
		// create character stream object to read from console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter f(x) = ");
		formule = br.readLine();
		System.out.print("Enter a = ");
		a = Float.parseFloat(br.readLine()); // readline() returns String by default
		System.out.print("Enter b = ");
		b = Float.parseFloat(br.readLine());
		System.out.print("Is the value of n given?(y/n) :- ");
		choice = br.readLine();
		if(choice.equals("y") || choice.equals("Y")){ 
			System.out.print("Enter n = ");
			n = Float.parseFloat(br.readLine());
			h = (b-a)/n;
		}
		else{
			System.out.print("Enter h = ");
			h = Float.parseFloat(br.readLine());
			n = (b-a)/h;
		}
		
		// add values of x from x0 to xn to a List
		for (i=0;i<=(int)(n);i++) {
			valueOfX.add(String.format("%s",a+(i*h)));
		}
		// convert list to array of String[]
		String[] list = new String[valueOfX.size()];
		valueOfX.toArray(list);
		
		// store f(x)
		eachFOfX = formule;

		// iterate through each value of X
		for(String eachXValue : valueOfX) {
			System.out.println("eachXValue: "+eachXValue+" a: "+a+" b: "+b);
			
			// replace exponential e with its value
			eachFOfX = eachFOfX.replace("e",String.valueOf("2.71828"));
			
			// create ( f(x1)+f(x2)+f(x3)+...f(x[n-1]) )
			if (!eachXValue.equals(String.valueOf(a)) && !eachXValue.equals(String.valueOf(b)) ){ 
				eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
				secondExp = secondExp + (double)RecursiveParser.eval(eachFOfX);
			}
			// create ( f(x0) + f(xn) )
			else{
				eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
				firstPlusLast = firstPlusLast + (double)RecursiveParser.eval(eachFOfX);
			}
			System.out.println("firstExp: "+firstPlusLast);
			System.out.println("secondExp: "+secondExp);
			// restore value of f(x) to orginal formula after replacing
			eachFOfX = formule;
		}
		secondExp = 2 * secondExp;
		System.out.println("First: "+firstPlusLast+" second: "+secondExp);
		double finalTrapezoidalIntergralValue = h/2*(firstPlusLast + secondExp);
		System.out.println("Final answer: "+finalTrapezoidalIntergralValue);
	}
	public static void simpsonsIntegration() throws IOException {
		// create character stream object to read from console
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter f(x) = ");
		formule = br.readLine();
		System.out.print("Enter a = ");
		a = Float.parseFloat(br.readLine()); // readline() returns String by default
		System.out.print("Enter b = ");
		b = Float.parseFloat(br.readLine());
		System.out.print("Is the value of n given?(y/n) :- ");
		choice = br.readLine();
		if(choice.equals("y") || choice.equals("Y")){ 
			System.out.print("Enter n = ");
			n = Float.parseFloat(br.readLine());
			h = (b-a)/n;
		}
		else{
			System.out.print("Enter h = ");
			h = Float.parseFloat(br.readLine());
			n = (b-a)/h;
		}
		
		// add values of x from x0 to xn to a List
		for (i=0;i<=(int)(n);i++) {
			valueOfX.add(String.format("%s",a+(i*h)));
		}
		// convert list to array of String[]
		String[] list = new String[valueOfX.size()];
		valueOfX.toArray(list);
		
		// store f(x)
		eachFOfX = formule;
		i=0;
		// iterate through each value of X
		for(String eachXValue : valueOfX) {
			System.out.println("eachXValue: "+eachXValue+" a: "+a+" b: "+b);
			
			// replace exponential e with its value
			eachFOfX = eachFOfX.replace("e",String.valueOf("2.71828"));
			
			eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
			if( i == 0 || i ==  (n) ){
				firstPlusLast = firstPlusLast + (double)RecursiveParser.eval(eachFOfX);
			}
			else if( (i) % 2 != 0 ){
				secondExp = secondExp + (double)RecursiveParser.eval(eachFOfX);
			}
			else if( (i) % 2 == 0 ){
				thirdExp = thirdExp + (double)RecursiveParser.eval(eachFOfX);
			}
			++i;
			System.out.println("firstExp: "+firstPlusLast);
			System.out.println("secondExp: "+secondExp);
			System.out.println("thirdExp: "+thirdExp);
			
			// restore value of f(x) to orginal formula after replacing
			eachFOfX = formule;
		}
		secondExp = 4 * secondExp;
		thirdExp = 2 * thirdExp;
		System.out.println("First: "+firstPlusLast+" second: "+secondExp+" third: "+thirdExp);
		double finalSimpsonsIntergralValue = h/3*(firstPlusLast + secondExp + thirdExp);
		System.out.println("Final answer: "+finalSimpsonsIntergralValue);
	}
	public static void main(String args[]){}
}

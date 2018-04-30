/*
 * @name        Numeric Intergrations
 * @package     MATH.modulesix
 * @file        NumericIntegration.java
 * @author      Yedhin Kizhakkethara
 * @email       yedhin1998@gmail.com
 * @link        https://github.com/yedhink/KTU-Java
 * @copyright   Copyright (c) 2018 ikigai, All Rights Reserved.
 * @license     MIT
 * @create      23-04-2018
 */
package math.modulesix;
import  math.modulesix.RecursiveParser;
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
 *	    then either h or n will be given in question.
 *	    h = (b-a)/n , where n = count(x)
 *
 *  SIMPSONS METHOD:-
 *	    a
 *	    (f(x)dx = h/3 [ (f(x)+f(xn)) + 4 * (f(x1)+f(x3)+f(x5)+...f(x[n-1])) + 2 * (f(x2)+f(x4)+f(x6)+...f(x[n-2])) ] 
 *	    )
 *	    b
 *	    exmaple:-
 *	      x : 0  0.2  0.4  0.6  0.8  1  1.2  1.4  1.6  1.8  2
 *	    f(x): ?   ?    ?    ?    ?   ?   ?    ?    ?    ?   ?
 *	    if x is given like above in question then choose first value as a and lastvalue as b
 *	    i.e :- a=x0 and b=xn
 *	    then either h or n will be given in question.
 *	    h = (b-a)/n , where n = count(x)
 */
public class NumericIntegration {
		private static float a,b,n;
		private static String formule , eachFOfX, choice;
		private static List<String> valueOfX;
		private static List<String> listFOfX; 
		private static double secondExp , firstPlusLast , thirdExp , evaluated;
		private static float h;
		private static int i = 0;
		private static boolean debug;
		private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void trapezoidalIntegration() throws IOException {
		secondExp = 0.0000 ; firstPlusLast= 0.0000 ; thirdExp= 0.0000; evaluated= 0.0000;
		debug = false;
		System.out.print("Enter f(x) = ");
		formule = br.readLine();
		System.out.print("Enter a = ");
		a = Float.parseFloat(br.readLine()); // readline() returns String by default
		System.out.print("Enter b = ");
		b = Float.parseFloat(br.readLine());
		System.out.print("Is the value of n given?(y/n) :- ");
		choice = br.readLine();
		if(choice.equalsIgnoreCase("y")){ 
			System.out.print("Enter n = ");
			n = Float.parseFloat(br.readLine());
			h = (b-a)/n;
		}
		else{
			System.out.print("Enter h = ");
			h = Float.parseFloat(br.readLine());
			n = (b-a)/h;
		}
		
		System.out.print("1) I want all steps to be shown in output\n2) I only want final integral value\nChoice = ");
		if(br.readLine().equals("1")){
			debug = true;
		}

		valueOfX = new ArrayList<String>();

		// add values of x from x0 to xn to a List
		for (i=0;i<=(int)(n);i++) {
			valueOfX.add(String.format("%s",a+(i*h)));
		}

		// convert list to array of String[]
		String[] list = new String[valueOfX.size()];
		valueOfX.toArray(list);
		
		// store f(x)
		eachFOfX = formule;
		if(debug){
			listFOfX = new ArrayList<String>();
			System.out.printf("a : %f\nb : %f\nn : %f\nh : %f\nx : ",a,b,n,h);
		}

		// iterate through each value of X
		for(String eachXValue : valueOfX) {
			if(debug) System.out.print(eachXValue+"  ");
			
			// replace exponential e with its value
			eachFOfX = eachFOfX.replace("e",String.valueOf("2.71828"));
			
			eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
			evaluated = (double)RecursiveParser.eval(eachFOfX);
			if(debug) listFOfX.add(String.valueOf(evaluated));
			
			// create ( f(x1)+f(x2)+f(x3)+...f(x[n-1]) )
			if (!eachXValue.equals(String.valueOf(a)) && !eachXValue.equals(String.valueOf(b)) ){ 
				secondExp = secondExp + evaluated;
			}
			// create ( f(x0) + f(xn) )
			else{
				firstPlusLast = firstPlusLast + evaluated;
			}
			// restore value of f(x) to orginal formula after replacing
			eachFOfX = formule;
		}
		if(debug){
			list = new String[listFOfX.size()];
			listFOfX.toArray(list);
			System.out.print("\nf(x) : ");
			for ( String fx : listFOfX){
				System.out.printf("%s  ", fx);
			}
			System.out.printf("\nh/2 : %f\nf(x0) + f(xn) : %f\nf(x1)+f(x2)+f(x3)+...f(x[n-1] : %f\n",(h/2),firstPlusLast,secondExp);
		}
		double finalTrapezoidalIntergralValue = h/2*(firstPlusLast + (2 * secondExp));
		System.out.println("Final answer: "+finalTrapezoidalIntergralValue);
	}
	public static void simpsonsIntegration() throws IOException {
		secondExp = 0.0000 ; firstPlusLast= 0.0000 ; thirdExp= 0.0000; evaluated= 0.0000;
		debug = false;
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
		
		
		System.out.print("1) I want all steps to be shown in output\n2) I only want final integral value\nChoice = ");
		if(br.readLine().equals("1")){
			debug = true;
		}

		valueOfX = new ArrayList<String>();

		// add values of x from x0 to xn to a List
		for (i=0;i<=(int)(n);i++) {
			valueOfX.add(String.format("%s",a+(i*h)));
		}

		// convert list to array of String[]
		String[] list = new String[valueOfX.size()];
		valueOfX.toArray(list);
		
		// store f(x) inital value
		eachFOfX = formule;
		
		if(debug){
			listFOfX = new ArrayList<String>();
			System.out.printf("a : %f\nb : %f\nn : %f\nh : %f\nx : ",a,b,n,h);
		}

		i=0;
		// iterate through each value of X
		for(String eachXValue : valueOfX) {
			if(debug) System.out.print(eachXValue+"  ");
			
			// replace exponential e with its value
			eachFOfX = eachFOfX.replace("e",String.valueOf("2.71828"));
			
			eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
			evaluated = (double)RecursiveParser.eval(eachFOfX);
			if(debug) listFOfX.add(String.valueOf(evaluated));

			if( i == 0 || i ==  (n) ){
				firstPlusLast = firstPlusLast + evaluated;
			}
			else if( (i) % 2 != 0 ){
				secondExp = secondExp + evaluated;
			}
			else if( (i) % 2 == 0 ){
				thirdExp = thirdExp + evaluated;
			}
			++i;
			
			// restore value of f(x) to orginal formula after replacing
			eachFOfX = formule;
		}
		if(debug){
			list = new String[listFOfX.size()];
			listFOfX.toArray(list);
			System.out.print("\nf(x) : ");
			for ( String fx : listFOfX){
				System.out.printf("%s  ", fx);
			}
			System.out.printf("\nh/3 : %f\nf(x0) + f(xn) : %f\nf(x1)+f(x3)+f(x5)+...f(x[n-1] : %f\nf(x2)+f(x4)+f(x6)+...f(x[n-2] : %f\n",(h/3),firstPlusLast,secondExp,thirdExp);
		}
		double finalSimpsonsIntergralValue = h/3*(firstPlusLast + (4*secondExp) + (2*thirdExp));
		System.out.println("Final answer: "+finalSimpsonsIntergralValue);
	}
	public static void main(String args[]){}
}

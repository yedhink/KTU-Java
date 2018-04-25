package MATH.modulesix;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
/*  a
 *  (f(x)dx = h/2 [ (f(x)+f(xn)) + 2 (f(x1)+f(x2)+f(x3)+...f(x[n-1])) ] 
 *  )
 *  b	
 *   x : 0 0.2 0.4 0.6 0.8 1 1.2 1.4 1.6 1.8 2
 * f(x): ?  ?   ?   ?   ?  ?  ?   ?   ?   ?  ?
 * if x is given like above in question then choose first value as a and lastvalue as b
 * i.e :- a=x0 and b=xn
 * h = (b-a)/n , where n = count(x)
 */
class NumericIntegration {
        public static void main(String args[]) throws ScriptException,IOException {
		float a,b,n;
		String formule , eachFOfX;
		List<String> valueOfX = new ArrayList<String>();
		double secondExp = 0.0000 , firstPlusLast= 0.0000;
		float h;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		//System.out.println(engine.eval("1/(1+1)"));	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter f(x) = ");
		formule = br.readLine();
		System.out.print("Enter a = ");
		a = Float.parseFloat(br.readLine());
		System.out.print("Enter b = ");
		b = Float.parseFloat(br.readLine());
		System.out.print("Enter n = ");
		n = Float.parseFloat(br.readLine());
		h = (b-a)/n;

		//System.out.println("check "+(a+1)+" "+(b+1)+" "+h);
		for (int i=0;i<=(int)(n);i++) {
			//System.out.println("i = "+i);
			valueOfX.add(String.format("%s",a+(i*h)));
		}
		String[] list = new String[valueOfX.size()];
		valueOfX.toArray(list);
		eachFOfX = formule;
                for(String eachXValue : valueOfX) {
			System.out.println("eachXValue: "+eachXValue+" a: "+a+" b: "+b);
			eachFOfX = formule;
			if (!eachXValue.equals(String.valueOf(a)) && !eachXValue.equals(String.valueOf(b)) ){ 
				eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
				secondExp = secondExp + (double)engine.eval(eachFOfX);
			}
			else{
				eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
				firstPlusLast = firstPlusLast + (double)engine.eval(eachFOfX);
			}
			System.out.println("firstExp: "+firstPlusLast);
			System.out.println("secondExp: "+secondExp);
		}
		secondExp = 2 * secondExp;
		System.out.println("First: "+firstPlusLast+" second: "+secondExp);
		double finalTrapezoidalIntergralValue = h/2*(firstPlusLast + secondExp);
		System.out.println(finalTrapezoidalIntergralValue);
        }
}

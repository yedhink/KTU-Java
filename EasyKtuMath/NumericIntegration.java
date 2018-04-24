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
		int value = 1;
		String formule , eachFOfX;
		List<String> valueOfX = new ArrayList<String>();
		double secondExp = 0.0000 ;
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
		for (int i=0;i<=(int)n;i++) {
			//System.out.println("i = "+i);
			valueOfX.add(String.format("%s",a+(i*h)));
		}
		String[] list = new String[valueOfX.size()];
		valueOfX.toArray(list);
		eachFOfX = formule;
                for(String eachXValue : valueOfX) {
			//System.out.println("eachXValue: "+eachXValue);
			eachFOfX = formule;
			eachFOfX = eachFOfX.replace("x",String.valueOf(eachXValue));
			secondExp = secondExp + (double)engine.eval(eachFOfX);
			//System.out.println("secondExp: "+secondExp);
		}
		System.out.println("sec "+secondExp);
                double even=0.0,odd=0.0;
                for(int i=1;i<=5;++i){
                        System.out.println("value "+i+"= "+Math.pow(Math.cos(i*Math.PI/12.0),0.5));
                                even=even+Math.pow(Math.sin(i*Math.PI/12.0),0.5);
                }
                double firstPlusLast = Math.pow(Math.sin(0*Math.PI/12.0),0.5) + Math.pow(Math.sin(6*Math.PI/12.0),0.5);
                double result = Math.PI/(2*12.0)*(firstPlusLast + (2.0*(even)));
                System.out.println("\nresult="+result);
        }
}

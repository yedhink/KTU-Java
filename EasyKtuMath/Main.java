package MATH.modulesix;
import MATH.modulesix.NumericIntegration;
import java.io.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// create character stream object
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1)Trapezoidal Integration\n2)Simpsons Integration");
		
		// Enter which Method of Integration you want
		System.out.print("Enter choice = ");
		int choice = Integer.parseInt(br.readLine());
		switch(choice){
			case 1: NumericIntegration.trapezoidalIntegration();break;
			case 2: NumericIntegration.simpsonsIntegration();break;
		}
	}	
}

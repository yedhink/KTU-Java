package MATH.modulesix;
import MATH.modulesix.NumericIntegration;
import java.io.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// create character stream object
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		String proceed = "n";
		System.out.println("1)Trapezoidal Integration\n2)Simpsons Integration");

		// Enter which Method of Integration you want
		do{
			System.out.print("Enter choice = ");
			choice = Integer.parseInt(br.readLine());
			switch(choice){
				case 1: NumericIntegration.trapezoidalIntegration();break;
				case 2: NumericIntegration.simpsonsIntegration();break;
			}
			System.out.print("Continue?(y/n) :- ");
		}while(br.readLine().equalsIgnoreCase("y"));
	}	
}

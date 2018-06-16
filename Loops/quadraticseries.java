import java.util.*;
import java.io.*;

class quadraticseries{
	public static void main(String args[]){
		int sum;

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		 for(int i=0;i<t;i++){
	            int a = in.nextInt();
        	    int b = in.nextInt();
	            int n = in.nextInt();
			
		    sum = 0;
		    for(int j=1;j<=n;j++)
		    {		
			   
			    sum = a+ Math.pow(b,j);
			    System.out.print(sum+" ");
        		}
		 }

	        in.close();
	}
}

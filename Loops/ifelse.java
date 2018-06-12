/* Check this problem out :
 * https://www.hackerrank.com/challenges/java-if-else/problem
 */

package loops;
import java.util.Scanner;

public class ifelse {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.print("Enter an integer value, n = ");
		int n=sc.nextInt();
		String ans="";
		if(n%2==1){
			ans = "Weird";
		}
		else{
			if(n>20){
				ans = "Not Weird";
			}
			else if(n>=2&&n<5){
				ans = "Not Weird";
			}

			else if(n>=6&&n<=20){
				ans = "Weird";
			}
			else if(n==0){
				ans = "Such Weird. Much Wow";
			}
		}
		System.out.println(ans);
		sc.close(); 
	}
}


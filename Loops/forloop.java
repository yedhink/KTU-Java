/* Multiplication Table Of A Number*/

package loops;
import java.util.Scanner;

public class forloop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	System.out.print("Enter Number Whose Multiplication Table Is To Be Displayed = ");
        int N = in.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(N+" x "+ i +" = "+N*i);
        }
	in.close(); // make this a practice (._.)
    }
}


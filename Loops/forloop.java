/* Multiplication Table*/

package loops;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class forloop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i=0;
        for(i=1;i<=10;i++){
        
            System.out.println(N+" x "+ i +" = "+N*i);
        }
    }
}


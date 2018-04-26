package CHARSEQ;
import java.util.Scanner;
import java.lang.*;

// why the name csb.java though? Cause i created this program long back when i kinda found it funny to read the reversed names of my
// classmates, who were in the csb. We used to say these names out loud during classHour. weird me eh? \(o-o)/

// our interface
interface classHour{
	String revName(String value);
		
}

// implement me master...
public class csb implements classHour{
	public String revName(String value){
		char[] charArr = value.toCharArray();
		char temp;
		int i = value.length()-1,j=0;
		while(j < (value.length()/2) ){
			temp = charArr[i];
			charArr[i] =  charArr[j];
			charArr[j] = temp;
			--i;
			++j;
		}
		value = new String(charArr);
		return value;
	}
}

class charset{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		csb stud = new csb();
		System.out.print("Enter Name :");
		System.out.println("Reversed name is "+stud.revName(input.next()));
		input.close();
	}
}


package CHARSEQ;
import java.util.Scanner;
import java.lang.*;

interface classHour{
	String revName(String value);
		
}

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


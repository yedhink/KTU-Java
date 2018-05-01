/*
 * @name        Basics of Interfaces
 * @package     CHARSEQ
 * @file        csb.java
 * @author      Yedhin Kizhakkethara
 * @email       yedhin1998@gmail.com
 * @link        https://github.com/yedhink/KTU-Java
 * @copyright   Copyright (c) 2018 ikigai, All Rights Reserved.
 * @license     MIT
 * @create      23-04-2018
 */
package classexamples;
import java.util.Scanner;
import java.lang.*;

// why the name csb.java though? Cause i created this program long back when i kinda found it funny to read the reversed names 
// of my classmates, who were in my class "csb". We used to call these names out loud during classHour. weird us eh? \(o-o)/

// our interface
interface classHour{
	String revName(String value);
}

// implement me master...
class charset implements classHour{
	public String revName(String value){
		char[] charArr = value.toCharArray();
		char temp;
		int i = value.length()-1,j=0;
		// Method to reverse
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

public class csb{
	public static String getReversed(String value){
		charset getRev = new charset();
		return getRev.revName(value);
	}
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		charset stud = new charset();
		System.out.print("Enter Name :");
		System.out.println("Reversed name is "+stud.revName(input.next()));
		input.close();
	}
}


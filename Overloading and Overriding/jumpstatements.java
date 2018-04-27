/*
 * @name        Basics of JumpStatements, Overloading etc 
 * @file        jumpstatements.java
 * @author      Yedhin Kizhakkethara
 * @email       yedhin1998@gmail.com
 * @link        https://github.com/yedhink/KTU-Java
 * @copyright   Copyright (c) 2018 ikigai, All Rights Reserved.
 * @license     MIT
 * @create      23-04-2018
 */
import java.io.*;
import java.io.File;

// Learn the basics of JumpStatements, Overloading, The "this" keyword, File Handling,
// and Exception Handling using try-catch block

class test{
	int k=7;
	String word;
	// Constructor without params
	test(){
		k=1;
		word  = "constructor without parameters";
		System.out.println((word)+" has k = "+(this.k));
	}
	// Constructor with params
	test(String word,int k){
		this.word=word;
		System.out.println((word)+" has this.k = "+ this.k +" and passed arg k = "+k);
	}
}

class jumpstatements{
	public static void main(String args[]) throws FileNotFoundException, InterruptedException, IOException{
		// creating a character stream to read from file
		File file = new File("wordsDictionary.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		// creating a character stream to read from console
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the word to search for in Dictionary:- ");
		String word = input.readLine();
		
		// overloading
		test obj1 = new test();
		test obj2 = new test(word,word.length());

		String fileword;
		boolean flag = false;
		try{
			int i = 0;
			// reading each line as a String from the file
			while( (fileword = br.readLine()) != null){
				++i;
				if( (flag = fileword.equalsIgnoreCase(word)) == true ){
					System.out.printf("Word present at line %d in file\n",i);
					break; // jumps out of the loop
				}
				// Uncomment to understand how continue jump statement works. Results would vary for though.
				/*if( i%2 == 0 )
					continue;
				*/	
			}
			if(flag == false)
				System.out.println("No such word in Dictionary");
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
		finally {
			System.out.println("All done. Cheers!");
		}
		input.close();
		br.close();
	}
}

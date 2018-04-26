import java.io.*;
import java.io.File;

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
			while( (fileword = br.readLine()) != null){
				++i;
				if( (flag = fileword.equalsIgnoreCase(word)) == true ){
					System.out.printf("Word present at line %d in file\n",i);
					break;
				}
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

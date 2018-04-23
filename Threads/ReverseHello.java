package multithreadingexamples;
import java.util.*;
class thread extends Thread {
	String hello = "";
	String[] words;
	thread(String hello){
		words = hello.split(" ");
		for(int i=words.length-1; i>=0; --i){
			this.hello+=words[i]+" ";
		}
		// do below statement inorder to reverse each word in the sentence
		//this.hello = new StringBuffer(hello).reverse().toString();
	}
	public void run() {
		// inorder to print array of strings
		//System.out.println(Arrays.toString(words));
		System.out.println(this.hello);
	}
}
public class ReverseHello {
	public static void main(String[] args) throws InterruptedException {
		thread[] t = new thread[50];
		for (int i=0; i<50; ++i) {
			t[i] = new thread("Hello from Thread <"+(i+1)+">!");
			t[i].start();
			t[i].join();
		}
	}
}

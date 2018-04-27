/*
 * @name        Synchronization example 
 * @package     multithreadingexamples
 * @file        SharedCounter.java
 * @author      Yedhin Kizhakkethara
 * @email       yedhin1998@gmail.com
 * @link        https://github.com/yedhink/KTU-Java
 * @copyright   Copyright (c) 2018 ikigai, All Rights Reserved.
 * @license     MIT
 * @create      23-04-2018
 */
package multithreadingexamples;
public class SharedCounter {
	public static int count = 0;
	public static synchronized void incrementCount(){
		++count;	
	}
	public static void main(String[] args) throws Exception{
		for (int i=0; i<10; ++i) {
			Thread t = new Thread( new Runnable() {
				public void run(){
					for (int j=0; j<10; ++j) {
						incrementCount();
					}
				}
			});
			t.start();
			t.join();
		}
		System.out.println(count);
	}	
}

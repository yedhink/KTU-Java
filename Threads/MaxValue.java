/*
 * @name        Find maximum value in an array of int
 * @package     multithreadingexamples
 * @file        MaxValue.java
 * @author      Yedhin Kizhakkethara
 * @email       yedhin1998@gmail.com
 * @link        https://github.com/yedhink/KTU-Java
 * @copyright   Copyright (c) 2018 ikigai, All Rights Reserved.
 * @license     MIT
 * @create      23-04-2018
 */
// Find the max value in an array of integers using 4 threads
package threads.examples;
import java.util.*;
class Largest extends Thread {
	int[] arr;
	int lo,hi;
    long large;
	Largest(int[] arr, int lo, int hi, long large){
		this.arr = arr;
		this.lo = lo;
		this.hi = hi;
		this.large = large;
	}
 	public void run(){
		for (int i=lo; i<hi; ++i) {
			if (arr[i] > large) {
				large = arr[i];
			}
		}
	}
	public long getLargestInThread(){
		return large;
	}
}

public class MaxValue {
	public static void main(String[] args) throws InterruptedException{
		int[] arr = new int[1000*1000];
		long maximum = 0;
		Random rnd = new Random();
		for (int i =0; i<arr.length; ++i) {
			arr[i] = rnd.nextInt();
			//System.out.println(arr[i]);
		}
		maximum = arr[0];
        // lets make use of 4 threads to complete the task
		Largest[] t = new Largest[4];
		for (int i=0; i<4; ++i) {
			t[i] = new Largest(arr, i*arr.length/4, (i+1)*arr.length/4, maximum);
			t[i].start();
			t[i].join();
			maximum = t[i].getLargestInThread();
		}
		System.out.println("Maximum value in array is "+maximum);
	}
}

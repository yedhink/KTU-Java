package threads;
public class BasicThreadsBySync {
	
	// Initializing count as zero
	public static int count = 0;
	
	public static synchronized void countMethod() {
		++count;
	}

	public static void main(String[] args) {
		
		// Thread 1
		Thread t1 = new Thread ( new Runnable() {
			public void run() {
				for ( int i=0; i<10000; ++i){
					// Statement to be clarified.
					// System.out.println(count++);
					// Simply count++ without print statement yields Final count as a random value 
					// count++;
					countMethod();
				}
			}
		});
		
		// Thread 2
		Thread t2 = new Thread ( new Runnable() {
			public void run() {
				for ( int i=0; i<10000; ++i){
					// Statement to be clarified.
					// System.out.println(count++);
					// Simply count++ without print statement yields Final count as a random value 
					// count++;
					countMethod();
				}
			}
		});
		
		t1.start();
		t2.start();
	    
		// Wait till completion of both threads	
		try{
			t1.join();
			t2.join();
		}
		catch(Exception e){
			System.out.println(e);
		}

		// Final Count
		System.out.println("Final count : "+count);
	}
}

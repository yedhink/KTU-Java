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

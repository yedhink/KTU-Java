package threads;
class thread implements Runnable {
	public void run(){
		for (int i = 0; i<10 ; ++i) {
			System.out.println(Thread.currentThread().getId() + " shows "+i);
			try {
				Thread.sleep(100);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

public class BasicThreadsByRunnable {
	public static void main(String[] args) {
		Thread obj1 = new Thread(new thread());
		Thread obj2 = new Thread(new thread());
		Thread obj3 = new Thread(new thread());
		obj1.start(); 	
		obj2.start();
		obj3.start();
	}
}

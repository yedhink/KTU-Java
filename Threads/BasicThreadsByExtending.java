package classExamples;
class thread extends Thread {
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

public class BasicThreadsByExtending {
	public static void main(String[] args) {
		thread obj1 = new thread();
		thread obj2 = new thread();
		thread obj3 = new thread();
		obj1.start();
		obj2.start();
		obj3.start();
	}	
}

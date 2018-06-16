package threads;
public class BasicThreadsByMainOnly {
	public static void main(String[] args) {
		Thread obj1 = new Thread (new Runnable(){
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
		);//runnable method ends here
		obj1.start();
	}
}

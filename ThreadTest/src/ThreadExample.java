import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ThreadExample {
	
	public static void main(String[] args) throws IOException {
		//fn1();
		fn2();
	}
	
	public static void fn1() {
		System.out.println(Thread.currentThread().getName());
	    for(int i=0; i<10; i++){
	      new Thread("" + i){
	        public void run(){
	          System.out.println("Thread: " + getName() + " running");
	        }
	      }.start();
	    }
	}
	
	public static void fn2() {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 1; i++) {
		    exec.submit(new Runnable() {
		                    public void run() {
		                        new Thread();
		                        try {
		                        	Date date = new Date();
		                        	long time = date.getTime();
		                        	System.out.println(String.valueOf(time));
									Thread.sleep(5000, 0);
									date = new Date();
									long time1 = date.getTime();
									System.out.println(String.valueOf(time1));
									System.out.println(String.valueOf(time1 - time));
								} catch (InterruptedException e) {
									System.out.println(e.getLocalizedMessage());
								}
		                    }
		                });        
		}

		exec.shutdown();
		try {
			exec.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}

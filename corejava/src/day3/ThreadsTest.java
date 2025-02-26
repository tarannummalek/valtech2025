package day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreadsTest {

	@Test
	void test() {
	
		Runnable r=new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread()+" "+i);
				}
			}
		};
//		new Thread(r).start();
//		new Thread(r).start();
//		new Thread(r).start();
//		new Thread(r).start();
//		new Thread(r).start();
		Runnable t=()-> {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread()+" "+i);
				}
			
			
		
		};
		new Thread(t).start();
		new Thread(t).start();
	}

}

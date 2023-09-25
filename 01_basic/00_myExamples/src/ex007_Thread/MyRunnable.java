package ex007_Thread;
// http://hochulshin.com/java-multithreading-thread-thread-implementation/

import java.util.concurrent.TimeUnit;

public class MyRunnable {
    public void run() {
        System.out.println("Main thread starts here..");

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("TICK TICK " + i);
                try {
                    TimeUnit.MICROSECONDS.sleep((long) Math.random() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println("Main thread ends here...");
    }
}

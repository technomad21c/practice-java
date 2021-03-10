package ex007_Thread;
// http://hochulshin.com/java-multithreading-executor-basic/
// http://hochulshin.com/java-multithreading-thread-thread-implementation/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyExecutor {
    public void run() {
        System.out.println("Main sthread starts here");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
    }
}

class MyThread implements Runnable {
    private static int count = 0;
    private int id;

    @Override
    public void run() {
        for (int i=0; i < 5; i++) {
            System.out.println("<" + id + ">TICK TICK " + i);
            try {
                TimeUnit.MICROSECONDS.sleep((long)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MyThread() {
        this.id = ++count;
    }
}

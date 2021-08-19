package com.technomad.mythread;
// source: https://dzone.com/articles/schedulers-in-java-and-spring


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread is stared");
        SpringApplication.run(Application.class);

//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println("Thread [" + Thread.currentThread().getName() + "] is executing the task");
//            try {
//                Thread.sleep(1000);
//            } catch(InterruptedException e) {
//                System.out.println("sleeping thread get interrupted");
//            }
//        }, 5, 2, TimeUnit.SECONDS);
    }
}

package com.technomad.mythread.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Configuration
@EnableScheduling
public class ScheduledConfig implements SchedulingConfigurer {
    TaskScheduler taskScheduler;
    private ScheduledFuture<?> job1;
    private ScheduledFuture<?> job2;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix("scheduler-thread");
        threadPoolTaskScheduler.initialize();
        executeTask1(threadPoolTaskScheduler);
        executeTask2(threadPoolTaskScheduler);
        this.taskScheduler = threadPoolTaskScheduler;
        scheduledTaskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
    }

//    @Scheduled(fixedRate = 5000)
    public void executeTask1(TaskScheduler scheduler) {
        job1 = scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " The Task1 executed at " + new Date());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                String cronExp = "0/5 * * * * ?";// Can be pulled from a db .
                return new CronTrigger(cronExp).nextExecutionTime(triggerContext);
            }
        });
    }

//    @Scheduled(fixedRate = 1000)
    public void executeTask2(TaskScheduler scheduler) {
        job2=scheduler.schedule(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" The Task2 executed at "+ new Date());
            }
        }, new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                String cronExp="0/1 * * * * ?";//Can be pulled from a db . This will run every minute
                return new CronTrigger(cronExp).nextExecutionTime(triggerContext);
            }
        });
    }

}
package ru.szhernovy.jobvacancy.view;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by admin on 20.11.2016.
 */
public class Simple {
    private final static Logger Log = LoggerFactory.getLogger(Simple.class);

    public static void main(String[] args) {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = null;
        try {
            sched = sf.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();
        // compute a time that is on the next round minute
        Date runTime = evenMinuteDate(new Date());

// Trigger the job to run on the next round minute
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(runTime)
                .build();
        // Tell quartz to schedule the job using our trigger
        try {
            sched.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(90L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sched.shutdown(true);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

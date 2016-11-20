package ru.szhernovy.jobvacancy.view;/**
 * Created by szhernovoy on 14.11.2016.
 */


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class JobSheduler implements Job{

    private static Logger log = LoggerFactory.getLogger(JobSheduler.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
/*
    public Executor(){
    //   String path = this.getClass().getClassLoader().getResource("vacancy.properties").getPath();
    }

    public static void main(String[] args) {

        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

        Scheduler sched = null;
        try {
            sched = schedFact.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        try {
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        // Trigger the job to run now, and then every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        try {
            sched.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

*/

}

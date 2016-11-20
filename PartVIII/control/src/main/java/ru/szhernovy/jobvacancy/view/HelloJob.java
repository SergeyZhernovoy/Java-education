package ru.szhernovy.jobvacancy.view;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Date;

/**
 * Created by admin on 20.11.2016.
 */
public class HelloJob implements Job {
    private final static Logger Log = LoggerFactory.getLogger(HelloJob.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Log.info("Hello World! - " + new Date());
     //   System.out.println("Hello World! - " + new Date());
    }
}

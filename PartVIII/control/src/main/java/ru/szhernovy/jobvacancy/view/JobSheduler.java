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

}

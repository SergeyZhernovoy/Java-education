package ru.szhernovy.jobvacancy.view;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovy.jobvacancy.controller.DBManager;
import ru.szhernovy.jobvacancy.controller.HTMLParser;

import java.util.Date;
import java.util.Properties;


public class JobSheduler implements Job {

    private static Logger log = LoggerFactory.getLogger(JobSheduler.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DBManager dbManager = new DBManager((Properties) jobExecutionContext.getJobDetail().getJobDataMap().get("prop"));
        HTMLParser htmlParser = new HTMLParser(dbManager);
        dbManager.setTimeLoad(htmlParser.mainLoop());
        dbManager.close();
        JobKey jobKey =  jobExecutionContext.getJobDetail().getKey();
        log.info("Download vacancies: " + jobKey + " executing at " + new Date());
    }
}

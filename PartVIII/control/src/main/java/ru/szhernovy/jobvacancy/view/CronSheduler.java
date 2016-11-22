package ru.szhernovy.jobvacancy.view;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by admin on 22.11.2016.
 */
public class CronSheduler {
    private final static Logger log = LoggerFactory.getLogger(CronSheduler.class);

    public void start() throws Exception {

        log.info("------- Initializing -------------------");
        // First we must get a reference to a scheduler
        Scheduler scheduler =  StdSchedulerFactory.getDefaultScheduler();
        log.info("------- Initialization Complete --------");

        log.info("------- Scheduling Jobs ----------------");

        JobDetail job = newJob(JobSheduler.class).withIdentity("job1", "group1").build();
        setProperties(job);

        CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule(String.format("0/%s * * * * ?",job.getJobDataMap().get("interval"))))
                .build();

        Date ft = scheduler.scheduleJob(job, trigger);
        log.info(job.getKey() + " has been scheduled to run at: " + ft + " and repeat based on expression: "
                + trigger.getCronExpression());

        log.info("------- Starting Scheduler ----------------");

        scheduler.start();

        log.info("------- Started Scheduler -----------------");

        log.info("------- Waiting five minutes... ------------");
        try {
            // wait five minutes to show jobs
            Thread.sleep(300L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }

        log.info("------- Shutting Down ---------------------");

        scheduler.shutdown(true);

        log.info("------- Shutdown Complete -----------------");

        SchedulerMetaData metaData = scheduler.getMetaData();
        log.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");

    }

    public void setProperties(JobDetail job){
        JobDataMap jobDataMap = job.getJobDataMap();
        Properties properties = getProperties();
        jobDataMap.put("prop",properties);
        jobDataMap.put("interval",properties.getProperty("interval"));
    }

    /**
     * load properties from file
     * @param
     * @return
     */
    public Properties getProperties() {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(this.getClass().getClassLoader().getResource("vacancy.properties").getPath())) {
            properties.load(fileInputStream);
            log.info("get parametres connection", properties);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(),e);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return properties;
    }



    public static void main(String[] args) throws Exception {

        CronSheduler cronSheduler = new CronSheduler();
        cronSheduler.start();
    }

}

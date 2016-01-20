package com.self.learn.job;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class TaskJob {
    private static final Logger LOG = LoggerFactory.getLogger(TaskJob.class);

//    @Autowired
    private Scheduler scheduler;
//    @Scheduled(cron = "${jobOne}")
    public void jobOne() {
        LOG.info("==========================jobOne");
    }

    //    @Scheduled(fixedRate = 1000 * 3)
//    @Scheduled(cron = "${jobTwo}")
    public void jobTwo() {
        LOG.info("==========================jobTwo");
    }

    public void resetJob(String cronExpression) {
//        scheduler.rescheduleJob();
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
